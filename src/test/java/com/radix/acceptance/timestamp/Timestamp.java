package com.radix.acceptance.timestamp;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.radix.regression.Util;
import com.radixdlt.client.application.RadixApplicationAPI;
import com.radixdlt.client.application.identity.RadixIdentities;
import com.radixdlt.client.application.identity.RadixIdentity;
import com.radixdlt.client.application.translate.FeeMapper;
import com.radixdlt.client.application.translate.PowFeeMapper;
import com.radixdlt.client.atommodel.message.MessageParticle;
import com.radixdlt.client.core.RadixEnv;
import com.radixdlt.client.core.RadixUniverse;
import com.radixdlt.client.core.atoms.Atom;
import com.radixdlt.client.core.atoms.AtomStatus;
import com.radixdlt.client.core.atoms.AtomStatusEvent;
import com.radixdlt.client.core.atoms.ParticleGroup;
import com.radixdlt.client.core.atoms.particles.SpunParticle;
import com.radixdlt.client.core.network.HttpClients;
import com.radixdlt.client.core.network.RadixNode;
import com.radixdlt.client.core.network.jsonrpc.RadixJsonRpcClient;
import com.radixdlt.client.core.network.jsonrpc.RadixJsonRpcClient.JsonRpcResponse;
import com.radixdlt.client.core.network.jsonrpc.RadixJsonRpcClient.Notification;
import com.radixdlt.client.core.network.jsonrpc.RadixJsonRpcClient.NotificationType;
import com.radixdlt.client.core.network.websocket.WebSocketClient;
import com.radixdlt.client.core.network.websocket.WebSocketStatus;
import com.radixdlt.client.core.pow.ProofOfWorkBuilder;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.reactivex.Single;
import io.reactivex.functions.Cancellable;
import io.reactivex.observers.TestObserver;
import org.json.JSONObject;
import org.radix.serialization2.DsonOutput;
import org.radix.serialization2.client.GsonJson;
import org.radix.serialization2.client.Serialize;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Timestamp {
    private RadixUniverse universe = RadixUniverse.create(RadixEnv.getBootstrapConfig());

    private RadixIdentity identity;

    private WebSocketClient webSocketClient;
    private RadixJsonRpcClient jsonRpcClient;

	private TestObserver<AtomStatusEvent> observer;
    private TestObserver<RadixJsonRpcClient.JsonRpcResponse> observer2;

    private FeeMapper feeMapper = new PowFeeMapper(Atom::getHash,
            new ProofOfWorkBuilder());


    @After
    public void after() {
        this.jsonRpcClient = null;

        if(this.observer != null) {
            this.observer.dispose();
            this.observer = null;
        }


        if(this.observer2 != null) {
            this.observer2.dispose();
            this.observer2 = null;
        }


        this.webSocketClient.close();
        this.webSocketClient.getState()
                .doOnNext(System.out::println)
                .filter(WebSocketStatus.DISCONNECTED::equals)
                .firstOrError()
                .blockingGet();
        this.webSocketClient = null;
    }


    @Given("^that I have access to a suitable Radix network$")
    public void thatIHaveAccessToASuitableRadixNetwork() throws Throwable {
        setupWebSocket();

        this.identity = RadixIdentities.createNew();

        this.jsonRpcClient = new RadixJsonRpcClient(this.webSocketClient);
    }

    @When("^I submit an atom with particle groups which have some arbitrary metadata$")
    public void iSubmitAValidAtomWithSomeArbitraryMetadata() throws Throwable {
        // Construct atom
        Map<String, String> metaData = new HashMap<>();
        metaData.put("test", "123");
        metaData.put("test2", "456");

        Atom atom = constructTestAtom(metaData);

        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();

        this.observer = TestObserver.create();
        final String subscriberId = UUID.randomUUID().toString();
        this.jsonRpcClient.observeAtomStatusNotifications(subscriberId)
            .doOnNext(n -> {
                if (n.getType() == NotificationType.START) {
                    this.jsonRpcClient.sendGetAtomStatusNotifications(subscriberId, signedAtom.getAid()).blockingAwait();
                    this.jsonRpcClient.pushAtom(signedAtom).blockingAwait();
                }
            })
            .filter(n -> n.getType().equals(NotificationType.EVENT))
            .map(Notification::getEvent)
            .subscribe(this.observer);
    }

    @When("^I submit a valid atom with arbitrary metadata containing a valid timestamp$")
    public void iSubmitAValidAtomWithArbitraryMetadataContainingAValidTimestamp() throws Throwable {
        // Construct atom
        Map<String, String> metaData = new HashMap<>();
        metaData.put("test", "123");
        metaData.put("test2", "456");
        metaData.put("timestamp", String.valueOf(System.currentTimeMillis()));

        Atom atom = constructTestAtom(metaData);

        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();

		this.observer = TestObserver.create(Util.loggingObserver("Valid Timestamp"));
		final String subscriberId = UUID.randomUUID().toString();
        this.jsonRpcClient.observeAtomStatusNotifications(subscriberId)
            .doOnNext(n -> {
                if (n.getType() == NotificationType.START) {
                    this.jsonRpcClient.sendGetAtomStatusNotifications(subscriberId, signedAtom.getAid()).blockingAwait();
                    this.jsonRpcClient.pushAtom(signedAtom).blockingAwait();
                }
            })
            .filter(n -> n.getType().equals(NotificationType.EVENT))
            .map(Notification::getEvent)
            .subscribe(this.observer);
    }

    @When("^I submit a valid atom with arbitrary metadata containing an invalid timestamp$")
    public void iSubmitAValidAtomWithArbitraryMetadataContainingAnInvalidTimestamp() throws Throwable {
        // Construct atom
        Map<String, String> metaData = new HashMap<>();
        metaData.put("test", "123");
        metaData.put("test2", "456");
        metaData.put("timestamp", "invalid");

        Atom atom = constructTestAtom(metaData);

        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();

		this.observer = TestObserver.create(Util.loggingObserver("Invalid Timestamp"));
        final String subscriberId = UUID.randomUUID().toString();
        this.jsonRpcClient.observeAtomStatusNotifications(subscriberId)
            .doOnNext(n -> {
                if (n.getType() == NotificationType.START) {
                    this.jsonRpcClient.sendGetAtomStatusNotifications(subscriberId, signedAtom.getAid()).blockingAwait();
                    this.jsonRpcClient.pushAtom(signedAtom).blockingAwait();
                }
            })
            .filter(n -> n.getType().equals(NotificationType.EVENT))
            .map(Notification::getEvent)
            .subscribe(this.observer);
    }

    @When("^I submit a valid atom with arbitrary metadata without a valid timestamp$")
    public void iSubmitAValidAtomWithArbitraryMetadataWithoutAValidTimestamp() throws Throwable {
        // Construct atom
        Map<String, String> metaData = new HashMap<>();
        metaData.put("test", "123");
        metaData.put("test2", "456");

        Atom atom = constructTestAtom(metaData);

        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();

        this.observer = TestObserver.create();
        final String subscriberId = UUID.randomUUID().toString();
        this.jsonRpcClient.observeAtomStatusNotifications(subscriberId)
            .doOnNext(n -> {
                if (n.getType() == NotificationType.START) {
                    this.jsonRpcClient.sendGetAtomStatusNotifications(subscriberId, signedAtom.getAid()).blockingAwait();
                    this.jsonRpcClient.pushAtom(signedAtom).blockingAwait();
                }
            })
            .filter(n -> n.getType().equals(NotificationType.EVENT))
            .map(Notification::getEvent)
            .subscribe(this.observer);
    }

    @When("^I submit a valid atom with no metadata$")
    public void iSubmitAValidAtomWithNoMetadata() throws Throwable {
        // Construct atom
        Atom atom = constructTestAtom(new HashMap<>());

        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();

        this.observer = TestObserver.create();
        final String subscriberId = UUID.randomUUID().toString();
        this.jsonRpcClient.observeAtomStatusNotifications(subscriberId)
            .doOnNext(n -> {
                if (n.getType() == NotificationType.START) {
                    this.jsonRpcClient.sendGetAtomStatusNotifications(subscriberId, signedAtom.getAid()).blockingAwait();
                    this.jsonRpcClient.pushAtom(signedAtom).blockingAwait();
                }
            })
            .filter(n -> n.getType().equals(NotificationType.EVENT))
            .map(Notification::getEvent)
            .subscribe(this.observer);
    }


    @When("^I submit an atom with particle groups which have metadata exceeding the max allowed atom size 65536 bytes$")
    public void iSubmitAValidAtomWithMetadataExceedingMaxAtomSizeBytes() throws Throwable {
        // Construct atom
        Map<String, String> metaData = new HashMap<>();
        metaData.put("timestamp", String.valueOf(System.currentTimeMillis()));
        metaData.put("super big test", generateStringOfLength(655360));

        Atom atom = constructTestAtom(metaData);

        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();

        this.observer = TestObserver.create();
        final String subscriberId = UUID.randomUUID().toString();
        this.jsonRpcClient.observeAtomStatusNotifications(subscriberId)
            .doOnNext(n -> {
                if (n.getType() == NotificationType.START) {
                    this.jsonRpcClient.sendGetAtomStatusNotifications(subscriberId, signedAtom.getAid()).blockingAwait();
                    this.jsonRpcClient.pushAtom(signedAtom).blockingAwait();
                }
            })
            .filter(n -> n.getType().equals(NotificationType.EVENT))
            .map(Notification::getEvent)
            .subscribe(this.observer);
    }

    @When("^I submit an atom with particle groups which have invalid json in the metadata field$")
    public void iSubmitAnAtomWithInvalidJsonInTheMetadataField() throws Throwable {
        String validMetaData = "ThisIsCompletelyNormalAndValid";
        String invalidMetaData = "This will break \" the json },:";

        // Construct atom
        Map<String, String> metaData = new HashMap<>();
        metaData.put("test", validMetaData);

        Atom atom = constructTestAtom(metaData);


        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();


        this.observer2 = TestObserver.create();


        // Create the request manually
        JSONObject jsonAtomTemp = Serialize.getInstance().toJsonObject(signedAtom, DsonOutput.Output.API);
        JsonElement jsonAtom = GsonJson.getInstance().toGson(jsonAtomTemp);

        final String subscriberId = UUID.randomUUID().toString();
        JsonObject params = new JsonObject();
        params.addProperty("subscriberId", subscriberId);
        params.add("atom", jsonAtom);

        final String uuid = UUID.randomUUID().toString();

        final JsonObject requestObject = new JsonObject();
        requestObject.addProperty("id", uuid);
        requestObject.addProperty("method", "Universe.submitAtomAndSubscribe");
        requestObject.add("params", params);


        // Break the json
        String brokenJson = GsonJson.getInstance().stringFromGson(requestObject)
                .replaceAll(validMetaData, invalidMetaData);


        // Submit and listen for results
        final JsonParser parser = new JsonParser();
        Single.<JsonRpcResponse>create(emitter -> {
            Cancellable c = this.webSocketClient.addListener(msg -> {
                JsonObject response = parser.parse(msg).getAsJsonObject();
                emitter.onSuccess(new RadixJsonRpcClient.JsonRpcResponse(!response.has("error"), response));
            });
            emitter.setCancellable(c);
        }).subscribe(this.observer2);
        assert(this.webSocketClient.sendMessage(brokenJson));
    }

    @When("^I submit an atom with particle groups which have the metadata field as something other than a map$")
    public void iSubmitAnAtomWithTheMetadataFieldAsSomethingOtherThanAMap() throws Throwable {
        // Construct atom
        Map<String, String> metaData = new HashMap<>();
        metaData.put("test", "123456");

        Atom atom = constructTestAtom(metaData);

        // Sign and submit
        Atom signedAtom = this.identity.addSignature(atom).blockingGet();


        this.observer2 = TestObserver.create();

        JSONObject jsonAtomTemp = Serialize.getInstance().toJsonObject(signedAtom, DsonOutput.Output.API);

        // Replace metadata map with a string
        jsonAtomTemp.getJSONArray("particleGroups").getJSONObject(0).put("metaData", "bad data");
        JsonElement jsonAtom = GsonJson.getInstance().toGson(jsonAtomTemp);

        final String subscriberId = UUID.randomUUID().toString();
        JsonObject params = new JsonObject();
        params.addProperty("subscriberId", subscriberId);
        params.add("atom", jsonAtom);


        this.jsonRpcClient.jsonRpcCall("Universe.submitAtomAndSubscribe", params).subscribe(this.observer2);
    }


    @Then("^I should observe the atom being accepted$")
    public void iShouldObserveTheAtomBeingAccepted() throws Throwable {
		this.observer.awaitCount(1);
        this.observer.assertValue(notification -> notification.getAtomStatus() == AtomStatus.STORED);
        this.observer.dispose();
    }

    @Then("^I should observe the atom being rejected$")
    public void iShouldObserveTheAtomBeingRejected() throws Throwable {
		this.observer.awaitCount(1);
        this.observer.assertValue(notification -> notification.getAtomStatus() == AtomStatus.EVICTED_FAILED_CM_VERIFICATION);
        this.observer.dispose();
    }

    @Then("^I should get a deserialization error$")
    public void iShouldGetADeserializationError() throws Throwable {
        this.observer2.awaitTerminalEvent(5, TimeUnit.SECONDS);
        this.observer2.assertNoErrors();
        this.observer2.assertComplete();
        this.observer2.assertValueAt(0, val -> !val.isSuccess());
        this.observer2.assertValueAt(0, val -> val.getError().getAsJsonObject().get("code").getAsInt() == -32000);
    }

    private void setupWebSocket() {
        this.identity = RadixIdentities.createNew();
        RadixApplicationAPI api = RadixApplicationAPI.create(RadixEnv.getBootstrapConfig(), this.identity);
        api.discoverNodes();
        RadixNode node = api.getNetworkState()
            .filter(state -> !state.getNodes().isEmpty())
            .map(state -> state.getNodes().iterator().next())
            .blockingFirst();

        this.webSocketClient = new WebSocketClient(listener ->
            HttpClients.getSslAllTrustingClient().newWebSocket(node.getWebSocketEndpoint(), listener)
        );
        this.webSocketClient.connect();
        this.webSocketClient.getState()
                .filter(WebSocketStatus.CONNECTED::equals)
                .blockingFirst();
    }

    private String generateStringOfLength(int length) {
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

    private Atom constructTestAtom(Map<String, String> metaData) {
        List<ParticleGroup> particleGroups = new ArrayList<>();

        // Add content
        MessageParticle messageParticle = new MessageParticle.MessageParticleBuilder()
            .payload("test".getBytes())
            .metaData("application", "message")
            .from(universe.getAddressFrom(this.identity.getPublicKey()))
            .to(universe.getAddressFrom(this.identity.getPublicKey()))
            .build();

        particleGroups.add(ParticleGroup.of(SpunParticle.up(messageParticle)));

        Map<String, String> atomMetaData = new HashMap<>();
        atomMetaData.putAll(metaData);
        atomMetaData.putAll(feeMapper.map(Atom.create(particleGroups, atomMetaData), universe, this.identity.getPublicKey()).getFirst());

        return Atom.create(particleGroups, atomMetaData);
    }
}
