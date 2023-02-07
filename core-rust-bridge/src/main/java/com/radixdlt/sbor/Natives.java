/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

package com.radixdlt.sbor;

import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;
import com.radixdlt.exceptions.StateManagerRuntimeError;
import com.radixdlt.exceptions.StateManagerRuntimeException;
import com.radixdlt.lang.Functions;
import com.radixdlt.lang.Result;
import com.radixdlt.sbor.codec.Codec;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class Natives {

  public static class Builder1 {

    private final Functions.Func1<byte[], byte[]> callable;

    private Builder1(Functions.Func1<byte[], byte[]> callable) {
      this.callable = callable;
    }

    @SuppressWarnings("unchecked")
    public <P1, R> Call1<P1, R> build(TypeToken<Call1<P1, R>> typeCapture) {
      ParameterizedType callType = (ParameterizedType) typeCapture.getType();
      Type[] types = callType.getActualTypeArguments();
      Codec<P1> p1Codec = StateManagerSbor.resolveCodec((TypeToken<P1>) TypeToken.of(types[0]));
      Codec<Result<R, StateManagerRuntimeError>> wrapperCodec =
          StateManagerSbor.resolveCodec(
              new TypeToken<Result<R, StateManagerRuntimeError>>() {}.where(
                  new TypeParameter<>() {}, (TypeToken<R>) TypeToken.of(types[1])));
      return new Call1<>(this.callable, p1Codec, wrapperCodec);
    }
  }

  public static Builder1 builder(Functions.Func1<byte[], byte[]> staticMethod) {
    return new Builder1(staticMethod);
  }

  public static <I> Builder1 builder(I instance, Functions.Func2<I, byte[], byte[]> method) {
    return builder(param1 -> method.apply(instance, param1));
  }

  public static class Call1<P1, R> {

    private final Functions.Func1<byte[], byte[]> callable;
    private final Codec<P1> p1Codec;
    private final Codec<Result<R, StateManagerRuntimeError>> wrapperCodec;

    public Call1(
        Functions.Func1<byte[], byte[]> callable,
        Codec<P1> p1Codec,
        Codec<Result<R, StateManagerRuntimeError>> wrapperCodec) {
      this.callable = callable;
      this.p1Codec = p1Codec;
      this.wrapperCodec = wrapperCodec;
    }

    public R call(P1 p1) {
      final byte[] encodedP1 = StateManagerSbor.encode(p1, p1Codec);
      final byte[] encodedWrapper = callable.apply(encodedP1);
      final Result<R, StateManagerRuntimeError> wrapper =
          StateManagerSbor.decode(encodedWrapper, wrapperCodec);
      return wrapper.unwrap(StateManagerRuntimeException::new);
    }
  }
}
