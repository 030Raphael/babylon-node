/*
 * Engine State API - Babylon (Anemone)
 * This API provides a complete view of the current ledger state, operating at a relatively low level (i.e. returning Entities' data and type information in a generic way, without interpreting specifics of different native or custom components).  It mirrors how the Radix Engine views the ledger state in its \"System\" layer, and thus can be useful for Scrypto developers, who need to inspect how the Engine models and stores their application's state, or how an interface / authentication scheme of another component looks like. 
 *
 * The version of the OpenAPI document: v0.0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.radixdlt.api.engine_state.generated.api;

import com.radixdlt.api.engine_state.generated.client.ApiClient;
import com.radixdlt.api.engine_state.generated.client.ApiException;
import com.radixdlt.api.engine_state.generated.client.ApiResponse;
import com.radixdlt.api.engine_state.generated.client.Pair;

import com.radixdlt.api.engine_state.generated.models.BlueprintInfoRequest;
import com.radixdlt.api.engine_state.generated.models.BlueprintInfoResponse;
import com.radixdlt.api.engine_state.generated.models.EntitySchemaEntryRequest;
import com.radixdlt.api.engine_state.generated.models.EntitySchemaEntryResponse;
import com.radixdlt.api.engine_state.generated.models.ErrorResponse;

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
public class TypesApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public TypesApi() {
    this(new ApiClient());
  }

  public TypesApi(ApiClient apiClient) {
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
   * @param blueprintInfoRequest  (required)
   * @return BlueprintInfoResponse
   * @throws ApiException if fails to make API call
   */
  public BlueprintInfoResponse blueprintInfoPost(BlueprintInfoRequest blueprintInfoRequest) throws ApiException {
    ApiResponse<BlueprintInfoResponse> localVarResponse = blueprintInfoPostWithHttpInfo(blueprintInfoRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Blueprint Info
   * Returns all externally-relevant information about a particular blueprint.
   * @param blueprintInfoRequest  (required)
   * @return ApiResponse&lt;BlueprintInfoResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<BlueprintInfoResponse> blueprintInfoPostWithHttpInfo(BlueprintInfoRequest blueprintInfoRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = blueprintInfoPostRequestBuilder(blueprintInfoRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("blueprintInfoPost", localVarResponse);
        }
        return new ApiResponse<BlueprintInfoResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<BlueprintInfoResponse>() {}) // closes the InputStream
          
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

  private HttpRequest.Builder blueprintInfoPostRequestBuilder(BlueprintInfoRequest blueprintInfoRequest) throws ApiException {
    // verify the required parameter 'blueprintInfoRequest' is set
    if (blueprintInfoRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'blueprintInfoRequest' when calling blueprintInfoPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/blueprint/info";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(blueprintInfoRequest);
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
   * Get Schema
   * Reads the contents of a specific schema associated with an entity. 
   * @param entitySchemaEntryRequest  (required)
   * @return EntitySchemaEntryResponse
   * @throws ApiException if fails to make API call
   */
  public EntitySchemaEntryResponse entitySchemaEntryPost(EntitySchemaEntryRequest entitySchemaEntryRequest) throws ApiException {
    ApiResponse<EntitySchemaEntryResponse> localVarResponse = entitySchemaEntryPostWithHttpInfo(entitySchemaEntryRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Schema
   * Reads the contents of a specific schema associated with an entity. 
   * @param entitySchemaEntryRequest  (required)
   * @return ApiResponse&lt;EntitySchemaEntryResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<EntitySchemaEntryResponse> entitySchemaEntryPostWithHttpInfo(EntitySchemaEntryRequest entitySchemaEntryRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = entitySchemaEntryPostRequestBuilder(entitySchemaEntryRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("entitySchemaEntryPost", localVarResponse);
        }
        return new ApiResponse<EntitySchemaEntryResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<EntitySchemaEntryResponse>() {}) // closes the InputStream
          
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

  private HttpRequest.Builder entitySchemaEntryPostRequestBuilder(EntitySchemaEntryRequest entitySchemaEntryRequest) throws ApiException {
    // verify the required parameter 'entitySchemaEntryRequest' is set
    if (entitySchemaEntryRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'entitySchemaEntryRequest' when calling entitySchemaEntryPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/entity/schema/entry";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(entitySchemaEntryRequest);
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
