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

package com.radixdlt.api.common;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.server.handlers.RequestLimitingHandler;
import io.undertow.util.StatusCodes;
import java.util.Map;

public abstract class ApiBase {
  private final Undertow undertowServer;

  public ApiBase(
      String apiBindAddress,
      int apiPort,
      Map<HandlerRoute, HttpHandler> handlers,
      int maximumConcurrentRequests,
      int maxQueueSize) {
    var handler =
        new RequestLimitingHandler(
            maximumConcurrentRequests, maxQueueSize, configureRoutes(handlers));

    this.undertowServer =
        Undertow.builder().addHttpListener(apiPort, apiBindAddress).setHandler(handler).build();
  }

  public void start() {
    undertowServer.start();
  }

  public void stop() {
    undertowServer.stop();
  }

  private static void fallbackHandler(HttpServerExchange exchange) {
    exchange.setStatusCode(StatusCodes.NOT_FOUND);
    exchange.getResponseSender().send("No API route found at this path");
  }

  private static void invalidMethodHandler(HttpServerExchange exchange) {
    exchange.setStatusCode(StatusCodes.NOT_ACCEPTABLE);
    exchange
        .getResponseSender()
        .send("Invalid method " + exchange.getRequestMethod() + " for the route at this path");
  }

  private static HttpHandler configureRoutes(Map<HandlerRoute, HttpHandler> allRouteHandlers) {
    // The true flag enables query parameters to be rewriting to path parameters
    var combinedApiHandler = Handlers.routing(true);
    allRouteHandlers.forEach((route, h) -> combinedApiHandler.add(route.method(), route.path(), h));
    combinedApiHandler.setFallbackHandler(ApiBase::fallbackHandler);
    combinedApiHandler.setInvalidMethodHandler(ApiBase::invalidMethodHandler);

    // NB - the Core API and System API have already caught/handled exceptions in the
    //      CoreJsonRpcHandler, and SystemGetJsonHandler, so we don't need to override a default
    // error handler here.
    //      The default undertow handler should be sufficient in any edge cases:
    //
    // https://github.com/undertow-io/undertow-docs/blob/master/src/main/asciidoc/error-handling.asciidoc
    return combinedApiHandler;
  }
}
