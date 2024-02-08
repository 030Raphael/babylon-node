/*
 * Engine State API
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

import com.radixdlt.api.engine_state.generated.models.ErrorResponse;
import com.radixdlt.api.engine_state.generated.models.ObjectMetadataEntryRequest;
import com.radixdlt.api.engine_state.generated.models.ObjectMetadataEntryResponse;
import com.radixdlt.api.engine_state.generated.models.ObjectMetadataIteratorRequest;
import com.radixdlt.api.engine_state.generated.models.ObjectMetadataIteratorResponse;
import com.radixdlt.api.engine_state.generated.models.ObjectRoleAssignmentRequest;
import com.radixdlt.api.engine_state.generated.models.ObjectRoleAssignmentResponse;

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
public class AttachedModulesApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public AttachedModulesApi() {
    this(new ApiClient());
  }

  public AttachedModulesApi(ApiClient apiClient) {
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
   * Get Metadata Entry
   * Reads the current value of a specific Object&#39;s metadata by key. 
   * @param objectMetadataEntryRequest  (required)
   * @return ObjectMetadataEntryResponse
   * @throws ApiException if fails to make API call
   */
  public ObjectMetadataEntryResponse objectAttachedModulesMetadataEntryPost(ObjectMetadataEntryRequest objectMetadataEntryRequest) throws ApiException {
    ApiResponse<ObjectMetadataEntryResponse> localVarResponse = objectAttachedModulesMetadataEntryPostWithHttpInfo(objectMetadataEntryRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Metadata Entry
   * Reads the current value of a specific Object&#39;s metadata by key. 
   * @param objectMetadataEntryRequest  (required)
   * @return ApiResponse&lt;ObjectMetadataEntryResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ObjectMetadataEntryResponse> objectAttachedModulesMetadataEntryPostWithHttpInfo(ObjectMetadataEntryRequest objectMetadataEntryRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = objectAttachedModulesMetadataEntryPostRequestBuilder(objectMetadataEntryRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("objectAttachedModulesMetadataEntryPost", localVarResponse);
        }
        return new ApiResponse<ObjectMetadataEntryResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ObjectMetadataEntryResponse>() {}) // closes the InputStream
          
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

  private HttpRequest.Builder objectAttachedModulesMetadataEntryPostRequestBuilder(ObjectMetadataEntryRequest objectMetadataEntryRequest) throws ApiException {
    // verify the required parameter 'objectMetadataEntryRequest' is set
    if (objectMetadataEntryRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'objectMetadataEntryRequest' when calling objectAttachedModulesMetadataEntryPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/object/attached_modules/metadata/entry";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(objectMetadataEntryRequest);
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
   * List Object Metadata
   * Lists keys of all metadata entries defined for a particular Object, in an iterator-like paged fashion
   * @param objectMetadataIteratorRequest  (required)
   * @return ObjectMetadataIteratorResponse
   * @throws ApiException if fails to make API call
   */
  public ObjectMetadataIteratorResponse objectAttachedModulesMetadataIteratorPost(ObjectMetadataIteratorRequest objectMetadataIteratorRequest) throws ApiException {
    ApiResponse<ObjectMetadataIteratorResponse> localVarResponse = objectAttachedModulesMetadataIteratorPostWithHttpInfo(objectMetadataIteratorRequest);
    return localVarResponse.getData();
  }

  /**
   * List Object Metadata
   * Lists keys of all metadata entries defined for a particular Object, in an iterator-like paged fashion
   * @param objectMetadataIteratorRequest  (required)
   * @return ApiResponse&lt;ObjectMetadataIteratorResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ObjectMetadataIteratorResponse> objectAttachedModulesMetadataIteratorPostWithHttpInfo(ObjectMetadataIteratorRequest objectMetadataIteratorRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = objectAttachedModulesMetadataIteratorPostRequestBuilder(objectMetadataIteratorRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("objectAttachedModulesMetadataIteratorPost", localVarResponse);
        }
        return new ApiResponse<ObjectMetadataIteratorResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ObjectMetadataIteratorResponse>() {}) // closes the InputStream
          
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

  private HttpRequest.Builder objectAttachedModulesMetadataIteratorPostRequestBuilder(ObjectMetadataIteratorRequest objectMetadataIteratorRequest) throws ApiException {
    // verify the required parameter 'objectMetadataIteratorRequest' is set
    if (objectMetadataIteratorRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'objectMetadataIteratorRequest' when calling objectAttachedModulesMetadataIteratorPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/object/attached_modules/metadata/iterator";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(objectMetadataIteratorRequest);
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
   * Get Role Assignment
   * Reads the current assignment of particular Object&#39;s Access Rules to Roles defined by the Blueprint. 
   * @param objectRoleAssignmentRequest  (required)
   * @return ObjectRoleAssignmentResponse
   * @throws ApiException if fails to make API call
   */
  public ObjectRoleAssignmentResponse objectAttachedModulesRoleAssignmentPost(ObjectRoleAssignmentRequest objectRoleAssignmentRequest) throws ApiException {
    ApiResponse<ObjectRoleAssignmentResponse> localVarResponse = objectAttachedModulesRoleAssignmentPostWithHttpInfo(objectRoleAssignmentRequest);
    return localVarResponse.getData();
  }

  /**
   * Get Role Assignment
   * Reads the current assignment of particular Object&#39;s Access Rules to Roles defined by the Blueprint. 
   * @param objectRoleAssignmentRequest  (required)
   * @return ApiResponse&lt;ObjectRoleAssignmentResponse&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ObjectRoleAssignmentResponse> objectAttachedModulesRoleAssignmentPostWithHttpInfo(ObjectRoleAssignmentRequest objectRoleAssignmentRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = objectAttachedModulesRoleAssignmentPostRequestBuilder(objectRoleAssignmentRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("objectAttachedModulesRoleAssignmentPost", localVarResponse);
        }
        return new ApiResponse<ObjectRoleAssignmentResponse>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ObjectRoleAssignmentResponse>() {}) // closes the InputStream
          
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

  private HttpRequest.Builder objectAttachedModulesRoleAssignmentPostRequestBuilder(ObjectRoleAssignmentRequest objectRoleAssignmentRequest) throws ApiException {
    // verify the required parameter 'objectRoleAssignmentRequest' is set
    if (objectRoleAssignmentRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'objectRoleAssignmentRequest' when calling objectAttachedModulesRoleAssignmentPost");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/object/attached_modules/role_assignment";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(objectRoleAssignmentRequest);
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
