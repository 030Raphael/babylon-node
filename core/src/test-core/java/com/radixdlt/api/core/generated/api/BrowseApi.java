/*
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.radixdlt.api.core.generated.api;

import com.radixdlt.api.core.generated.client.ApiClient;
import com.radixdlt.api.core.generated.client.ApiException;
import com.radixdlt.api.core.generated.client.ApiResponse;
import com.radixdlt.api.core.generated.client.Pair;

import com.radixdlt.api.core.generated.models.BasicErrorResponse;
import com.radixdlt.api.core.generated.models.BrowseBlueprintInfoRequest;
import com.radixdlt.api.core.generated.models.BrowseBlueprintInfoResponse;
import com.radixdlt.api.core.generated.models.BrowseEntityInfoRequest;
import com.radixdlt.api.core.generated.models.BrowseEntityInfoResponse;
import com.radixdlt.api.core.generated.models.BrowseEntityIteratorRequest;
import com.radixdlt.api.core.generated.models.BrowseEntityIteratorResponse;
import com.radixdlt.api.core.generated.models.BrowseKeyValueStoreEntryRequest;
import com.radixdlt.api.core.generated.models.BrowseKeyValueStoreEntryResponse;
import com.radixdlt.api.core.generated.models.BrowseKeyValueStoreIteratorRequest;
import com.radixdlt.api.core.generated.models.BrowseKeyValueStoreIteratorResponse;
import com.radixdlt.api.core.generated.models.BrowseObjectCollectionEntryRequest;
import com.radixdlt.api.core.generated.models.BrowseObjectCollectionEntryResponse;
import com.radixdlt.api.core.generated.models.BrowseObjectCollectionIteratorRequest;
import com.radixdlt.api.core.generated.models.BrowseObjectCollectionIteratorResponse;
import com.radixdlt.api.core.generated.models.BrowseObjectFieldRequest;
import com.radixdlt.api.core.generated.models.BrowseObjectFieldResponse;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class BrowseApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public BrowseApi() {
    this(new ApiClient());
  }

  public BrowseApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Get Blueprint Info
   * Returns all externally-relevant information about a particular blueprint.
   * @param browseBlueprintInfoRequest  (required)
   * @return BrowseBlueprintInfoResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseBlueprintInfoResponse browseBlueprintInfoPost(BrowseBlueprintInfoRequest browseBlueprintInfoRequest) throws ApiException {
    ApiResponse<BrowseBlueprintInfoResponse> localVarResponse = browseBlueprintInfoPostWithHttpInfo(browseBlueprintInfoRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Blueprint Info
   * Returns all externally-relevant information about a particular blueprint.
   * @param browseBlueprintInfoRequest  (required)
   * @return ApiResponse&lt;BrowseBlueprintInfoResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseBlueprintInfoResponse> browseBlueprintInfoPostWithHttpInfo(BrowseBlueprintInfoRequest browseBlueprintInfoRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseBlueprintInfoPostRequestBuilder(browseBlueprintInfoRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseBlueprintInfoPost", localVarResponse);
        }
        return new ApiResponse<BrowseBlueprintInfoResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseBlueprintInfoResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseBlueprintInfoPostRequestBuilder(BrowseBlueprintInfoRequest browseBlueprintInfoRequest) throws ApiException {
    // verify the required parameter 'browseBlueprintInfoRequest' is set
    if (browseBlueprintInfoRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseBlueprintInfoRequest' when calling browseBlueprintInfoPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/blueprint/info";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseBlueprintInfoRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get Entity Info
   * Resolves basic information about an entity: its type, attached modules, fields/collections and blueprint. 
   * @param browseEntityInfoRequest  (required)
   * @return BrowseEntityInfoResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseEntityInfoResponse browseEntityInfoPost(BrowseEntityInfoRequest browseEntityInfoRequest) throws ApiException {
    ApiResponse<BrowseEntityInfoResponse> localVarResponse = browseEntityInfoPostWithHttpInfo(browseEntityInfoRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Entity Info
   * Resolves basic information about an entity: its type, attached modules, fields/collections and blueprint. 
   * @param browseEntityInfoRequest  (required)
   * @return ApiResponse&lt;BrowseEntityInfoResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseEntityInfoResponse> browseEntityInfoPostWithHttpInfo(BrowseEntityInfoRequest browseEntityInfoRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseEntityInfoPostRequestBuilder(browseEntityInfoRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseEntityInfoPost", localVarResponse);
        }
        return new ApiResponse<BrowseEntityInfoResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseEntityInfoResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseEntityInfoPostRequestBuilder(BrowseEntityInfoRequest browseEntityInfoRequest) throws ApiException {
    // verify the required parameter 'browseEntityInfoRequest' is set
    if (browseEntityInfoRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseEntityInfoRequest' when calling browseEntityInfoPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/entity/info";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseEntityInfoRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * List Entities
   * Lists addresses of all entities, in an iterator-like paged fashion
   * @param browseEntityIteratorRequest  (required)
   * @return BrowseEntityIteratorResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseEntityIteratorResponse browseEntityIteratorPost(BrowseEntityIteratorRequest browseEntityIteratorRequest) throws ApiException {
    ApiResponse<BrowseEntityIteratorResponse> localVarResponse = browseEntityIteratorPostWithHttpInfo(browseEntityIteratorRequest);
    return localVarResponse.getData();
  }

  /**
   * List Entities
   * Lists addresses of all entities, in an iterator-like paged fashion
   * @param browseEntityIteratorRequest  (required)
   * @return ApiResponse&lt;BrowseEntityIteratorResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseEntityIteratorResponse> browseEntityIteratorPostWithHttpInfo(BrowseEntityIteratorRequest browseEntityIteratorRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseEntityIteratorPostRequestBuilder(browseEntityIteratorRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseEntityIteratorPost", localVarResponse);
        }
        return new ApiResponse<BrowseEntityIteratorResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseEntityIteratorResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseEntityIteratorPostRequestBuilder(BrowseEntityIteratorRequest browseEntityIteratorRequest) throws ApiException {
    // verify the required parameter 'browseEntityIteratorRequest' is set
    if (browseEntityIteratorRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseEntityIteratorRequest' when calling browseEntityIteratorPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/entity/iterator";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseEntityIteratorRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get Key-Value Store Entry
   * Reads the current value of a specific entry from a Key-Value Store. 
   * @param browseKeyValueStoreEntryRequest  (required)
   * @return BrowseKeyValueStoreEntryResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseKeyValueStoreEntryResponse browseKvStoreEntryPost(BrowseKeyValueStoreEntryRequest browseKeyValueStoreEntryRequest) throws ApiException {
    ApiResponse<BrowseKeyValueStoreEntryResponse> localVarResponse = browseKvStoreEntryPostWithHttpInfo(browseKeyValueStoreEntryRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Key-Value Store Entry
   * Reads the current value of a specific entry from a Key-Value Store. 
   * @param browseKeyValueStoreEntryRequest  (required)
   * @return ApiResponse&lt;BrowseKeyValueStoreEntryResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseKeyValueStoreEntryResponse> browseKvStoreEntryPostWithHttpInfo(BrowseKeyValueStoreEntryRequest browseKeyValueStoreEntryRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseKvStoreEntryPostRequestBuilder(browseKeyValueStoreEntryRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseKvStoreEntryPost", localVarResponse);
        }
        return new ApiResponse<BrowseKeyValueStoreEntryResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseKeyValueStoreEntryResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseKvStoreEntryPostRequestBuilder(BrowseKeyValueStoreEntryRequest browseKeyValueStoreEntryRequest) throws ApiException {
    // verify the required parameter 'browseKeyValueStoreEntryRequest' is set
    if (browseKeyValueStoreEntryRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseKeyValueStoreEntryRequest' when calling browseKvStoreEntryPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/kv_store/entry";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseKeyValueStoreEntryRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * List Key-Value Store
   * Lists keys of all entries from a particular Key-Value Store, in an iterator-like paged fashion
   * @param browseKeyValueStoreIteratorRequest  (required)
   * @return BrowseKeyValueStoreIteratorResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseKeyValueStoreIteratorResponse browseKvStoreIteratorPost(BrowseKeyValueStoreIteratorRequest browseKeyValueStoreIteratorRequest) throws ApiException {
    ApiResponse<BrowseKeyValueStoreIteratorResponse> localVarResponse = browseKvStoreIteratorPostWithHttpInfo(browseKeyValueStoreIteratorRequest);
    return localVarResponse.getData();
  }

  /**
   * List Key-Value Store
   * Lists keys of all entries from a particular Key-Value Store, in an iterator-like paged fashion
   * @param browseKeyValueStoreIteratorRequest  (required)
   * @return ApiResponse&lt;BrowseKeyValueStoreIteratorResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseKeyValueStoreIteratorResponse> browseKvStoreIteratorPostWithHttpInfo(BrowseKeyValueStoreIteratorRequest browseKeyValueStoreIteratorRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseKvStoreIteratorPostRequestBuilder(browseKeyValueStoreIteratorRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseKvStoreIteratorPost", localVarResponse);
        }
        return new ApiResponse<BrowseKeyValueStoreIteratorResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseKeyValueStoreIteratorResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseKvStoreIteratorPostRequestBuilder(BrowseKeyValueStoreIteratorRequest browseKeyValueStoreIteratorRequest) throws ApiException {
    // verify the required parameter 'browseKeyValueStoreIteratorRequest' is set
    if (browseKeyValueStoreIteratorRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseKeyValueStoreIteratorRequest' when calling browseKvStoreIteratorPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/kv_store/iterator";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseKeyValueStoreIteratorRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get Object Collection Entry
   * Reads the current value of a specific entry from an Object&#39;s Collection. 
   * @param browseObjectCollectionEntryRequest  (required)
   * @return BrowseObjectCollectionEntryResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseObjectCollectionEntryResponse browseObjectCollectionEntryPost(BrowseObjectCollectionEntryRequest browseObjectCollectionEntryRequest) throws ApiException {
    ApiResponse<BrowseObjectCollectionEntryResponse> localVarResponse = browseObjectCollectionEntryPostWithHttpInfo(browseObjectCollectionEntryRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Object Collection Entry
   * Reads the current value of a specific entry from an Object&#39;s Collection. 
   * @param browseObjectCollectionEntryRequest  (required)
   * @return ApiResponse&lt;BrowseObjectCollectionEntryResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseObjectCollectionEntryResponse> browseObjectCollectionEntryPostWithHttpInfo(BrowseObjectCollectionEntryRequest browseObjectCollectionEntryRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseObjectCollectionEntryPostRequestBuilder(browseObjectCollectionEntryRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseObjectCollectionEntryPost", localVarResponse);
        }
        return new ApiResponse<BrowseObjectCollectionEntryResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseObjectCollectionEntryResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseObjectCollectionEntryPostRequestBuilder(BrowseObjectCollectionEntryRequest browseObjectCollectionEntryRequest) throws ApiException {
    // verify the required parameter 'browseObjectCollectionEntryRequest' is set
    if (browseObjectCollectionEntryRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseObjectCollectionEntryRequest' when calling browseObjectCollectionEntryPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/object/collection/entry";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseObjectCollectionEntryRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * List Object Collection
   * Lists keys of all entries from a particular object&#39;s collection, in an iterator-like paged fashion
   * @param browseObjectCollectionIteratorRequest  (required)
   * @return BrowseObjectCollectionIteratorResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseObjectCollectionIteratorResponse browseObjectCollectionIteratorPost(BrowseObjectCollectionIteratorRequest browseObjectCollectionIteratorRequest) throws ApiException {
    ApiResponse<BrowseObjectCollectionIteratorResponse> localVarResponse = browseObjectCollectionIteratorPostWithHttpInfo(browseObjectCollectionIteratorRequest);
    return localVarResponse.getData();
  }

  /**
   * List Object Collection
   * Lists keys of all entries from a particular object&#39;s collection, in an iterator-like paged fashion
   * @param browseObjectCollectionIteratorRequest  (required)
   * @return ApiResponse&lt;BrowseObjectCollectionIteratorResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseObjectCollectionIteratorResponse> browseObjectCollectionIteratorPostWithHttpInfo(BrowseObjectCollectionIteratorRequest browseObjectCollectionIteratorRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseObjectCollectionIteratorPostRequestBuilder(browseObjectCollectionIteratorRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseObjectCollectionIteratorPost", localVarResponse);
        }
        return new ApiResponse<BrowseObjectCollectionIteratorResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseObjectCollectionIteratorResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseObjectCollectionIteratorPostRequestBuilder(BrowseObjectCollectionIteratorRequest browseObjectCollectionIteratorRequest) throws ApiException {
    // verify the required parameter 'browseObjectCollectionIteratorRequest' is set
    if (browseObjectCollectionIteratorRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseObjectCollectionIteratorRequest' when calling browseObjectCollectionIteratorPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/object/collection/iterator";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseObjectCollectionIteratorRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Get Object Field
   * Reads the current value of an object&#39;s field, given an entity address, a module (&#x60;Main&#x60; by default) and either a field index or its human-readable name (if applicable). 
   * @param browseObjectFieldRequest  (required)
   * @return BrowseObjectFieldResponse
   * @throws ApiException if fails to make API call
   */
  public BrowseObjectFieldResponse browseObjectFieldPost(BrowseObjectFieldRequest browseObjectFieldRequest) throws ApiException {
    ApiResponse<BrowseObjectFieldResponse> localVarResponse = browseObjectFieldPostWithHttpInfo(browseObjectFieldRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Object Field
   * Reads the current value of an object&#39;s field, given an entity address, a module (&#x60;Main&#x60; by default) and either a field index or its human-readable name (if applicable). 
   * @param browseObjectFieldRequest  (required)
   * @return ApiResponse&lt;BrowseObjectFieldResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BrowseObjectFieldResponse> browseObjectFieldPostWithHttpInfo(BrowseObjectFieldRequest browseObjectFieldRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = browseObjectFieldPostRequestBuilder(browseObjectFieldRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("browseObjectFieldPost", localVarResponse);
        }
        return new ApiResponse<BrowseObjectFieldResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BrowseObjectFieldResponse>() {}) // closes the InputStream
          
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder browseObjectFieldPostRequestBuilder(BrowseObjectFieldRequest browseObjectFieldRequest) throws ApiException {
    // verify the required parameter 'browseObjectFieldRequest' is set
    if (browseObjectFieldRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'browseObjectFieldRequest' when calling browseObjectFieldPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/browse/object/field";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(browseObjectFieldRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
}
