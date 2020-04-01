package io.openslice.sol005nbi.api.vnf;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import io.openslice.sol005nbi.model.vnf.Body;
import io.openslice.sol005nbi.model.vnf.Body1;
import io.openslice.sol005nbi.model.vnf.Body2;
import io.openslice.sol005nbi.model.vnf.Body3;
import io.openslice.sol005nbi.model.vnf.InlineResponse200;
import io.openslice.sol005nbi.model.vnf.InlineResponse2001;
import io.openslice.sol005nbi.model.vnf.VnfPackagesVnfPkgInfo;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-20T00:01:04.793+02:00[Europe/Athens]")
@Component
public class VnfPkgmApi {
    private VnfApiClient apiClient;

    public VnfPkgmApi() {
        this(new VnfApiClient());
    }

    @Autowired
    public VnfPkgmApi(VnfApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public VnfApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(VnfApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Query multiple subscriptions.
     * The GET method queries the list of active subscriptions of the functional block that invokes the method. It can be used e.g. for resynchronization after error situations. This method shall follow the provisions specified in the  Tables 9.4.7.8.2-1 and 9.4.8.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Active subscriptions of the functional block that invokes the method. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param filter Attribute-based filtering parameters according to clause 4.3.2. The NFVO shall support receiving filtering parameters as part of the URI query string. The OSS/BSS may supply filtering parameters. All attribute names that appear in the PkgmSubscription and in data types referenced from it shall be supported in attribute-based filtering parameters             
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return List&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2001> subscriptionsGet(String accept, String filter, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling subscriptionsGet");
        }
        String path = UriComponentsBuilder.fromPath("/subscriptions").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse2001>> returnType = new ParameterizedTypeReference<List<InlineResponse2001>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Subscribe to notifications related to on-boarding and/or changes of VNF packages.
     * The POST method creates a new subscription. This method shall follow the provisions specified in the Tables 9.4.8.3.1-1 and 9.4.8.3.1-2 for URI query parameters, request and response data structures, and response codes. Creation of two subscription resources with the same callbackURI and the same filter can result in performance degradation and will provide duplicates of notifications to the OSS, and might make sense only in very rare use cases. Consequently, the NFVO may either allow creating a subscription resource if another subscription resource with the same filter and callbackUri already exists (in which case it shall return the \&quot;201 Created\&quot; response code), or may decide to not create a duplicate subscription resource (in which case it shall return a \&quot;303 See Other\&quot; response code referencing the existing subscription resource with the same filter and callbackUri). 
     * <p><b>201</b> - 201 Created Representation of the created subscription resource. The HTTP response shall include a \&quot;Location\&quot; HTTP header that points to the created subscription resource. 
     * <p><b>303</b> - See Other A subscription with the same callbackURI and the same filter already exists and the policy of the VNFM is to not create redundant subscriptions. The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the existing subscription resource. The response body shall be empty. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param body The body parameter
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return List&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2001> subscriptionsPost(Body3 body, String accept, String contentType, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling subscriptionsPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling subscriptionsPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling subscriptionsPost");
        }
        String path = UriComponentsBuilder.fromPath("/subscriptions").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse2001>> returnType = new ParameterizedTypeReference<List<InlineResponse2001>>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams,  headerAccept, hcontentType, authNames, returnType);
    }
    /**
     * Terminate a subscription.
     * The DELETE method terminates an individual subscription. 
     * <p><b>204</b> - No Content The subscription resource was deleted successfully. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param subscriptionId Identifier of this subscription. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new subscription resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void subscriptionsSubscriptionIdDelete(String subscriptionId, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling subscriptionsSubscriptionIdDelete");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("subscriptionId", subscriptionId);
        String path = UriComponentsBuilder.fromPath("/subscriptions/{subscriptionId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Read an individual subscription resource.
     * Query Subscription Information The GET method reads an individual subscription. 
     * <p><b>200</b> - 200 OK Representation of the subscription resource. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param subscriptionId Identifier of this subscription. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new subscription resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object subscriptionsSubscriptionIdGet(String subscriptionId, String accept, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling subscriptionsSubscriptionIdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling subscriptionsSubscriptionIdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("subscriptionId", subscriptionId);
        String path = UriComponentsBuilder.fromPath("/subscriptions/{subscriptionId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Query VNF packages information.
     * The GET method queries the information of the VNF packages matching the filter. This method shall follow the provisions specified in the  Tables 9.4.2.3.2-1 and 9.4.2.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Information of the selected VNF packages. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param filter Attribute-based filtering parameters according to clause 4.3.2. The NFVO shall support receiving filtering parameters as part of the URI query string. The OSS/BSS may supply filtering parameters. All attribute names that appear in the VnfPkgInfo and in data types referenced from it shall be supported in attribute-based filtering parameters. 
     * @param allFields Include all complex attributes in the response. See clause 4.3.3 for details. The NFVO shall support this parameter. 
     * @param fields Complex attributes to be included into the response. See clause 4.3.3 for details. The NFVO should support this parameter.          
     * @param excludeFields Complex attributes to be excluded from the response. See clause 4.3.3 for details. The NFVO should support this parameter. 
     * @param excludeDefault Indicates to exclude the following complex attributes from the response. See clause 4.3.3 for details. The NFVO shall support this parameter. The following attributes shall be excluded from the VnfPkgInfo structure in the response body if this parameter is provided, or none of the parameters \&quot;all_fields,\&quot; \&quot;fields\&quot;, \&quot;exclude_fields\&quot;, \&quot;exclude_default\&quot; are provided: - softwareImages - additionalArtifacts - userDefinedData - checksum 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return List&lt;InlineResponse200&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<VnfPackagesVnfPkgInfo> vnfPackagesGet(String accept, String filter, String allFields, String fields, String excludeFields, String excludeDefault, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesGet");
        }
        String path = UriComponentsBuilder.fromPath("/vnf_packages").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_fields", allFields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fields", fields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exclude_fields", excludeFields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exclude_default", excludeDefault));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<VnfPackagesVnfPkgInfo>> returnType = new ParameterizedTypeReference<List<VnfPackagesVnfPkgInfo>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Create a new individual VNF package resource.
     * The POST method creates a new individual VNF package resource. 
     * <p><b>201</b> - 201 Created             An individual VNF package resource has been created successfully. The response body shall contain a representation of the new individual VNF package resource, as defined in clause 9.5.2.4. The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the individual VNF package resource. 
     * @param body The body parameter
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object vnfPackagesPost(Body body, String accept, String contentType, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling vnfPackagesPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling vnfPackagesPost");
        }
        String path = UriComponentsBuilder.fromPath("/vnf_packages").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams,  headerAccept, hcontentType, authNames, returnType);
    }
    /**
     * Fetch individual VNF package artifact.
     * The GET method fetches the content of an artifact within a VNF package. This method shall follow the provisions specified in the  Tables 9.4.7.3.2-1 and 9.4.7.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK  On success, the content of the artifact is returned. The payload body shall contain a copy of the artifact file from the VNF package, as defined by ETSI GS NFV-SOL 004. The \&quot;Content-Type\&quot; HTTP header shall be set according to the content type of the artifact file. If the content type cannot be determined, the header shall be set to the value \&quot;application/octet-stream\&quot;. 
     * <p><b>206</b> - Partial Content. On success, if the NFVO supports range requests, a single consecutive byte range from the content of the VNF package file is returned. The response body shall contain the requested part of the VNF package file. The \&quot;Content-Range\&quot; HTTP header shall be provided according to IETF RFC 7233. The \&quot;Content-Type\&quot; HTTP header shall be set as defined above for the \&quot;200 OK\&quot; response. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>409</b> - Conflict. Error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to any of the following scenarios: - Disable a VNF package resource of hich the operational state is not ENABLED - Enable a VNF package resource of which the operational state is not DISABLED The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error. 
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param vnfPkgId Identifier of the on-boarded VNF package.  The identifier is allocated by the NFVO. This identifier can be retrieved from the \&quot;vnfPkgId\&quot; attribute in the VnfPackageOnboardingNotification or VnfPackageChangeNotification. 
     * @param artifactPath Path of the artifact within the VNF package.  This identifier can be retrieved from the \&quot;artifactPath\&quot; attribute of the applicable \&quot;additionalArtifacts\&quot; entry in the body of the response to a GET request querying the \&quot;Individual VNF package\&quot; or the \&quot;VNF packages\&quot; resource. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @param range The request may contain a \&quot;Range\&quot; HTTP header to obtain single range of bytes from the VNF package file. This can be used to continue an aborted transmission. If the NFVO does not support range requests, it should return the whole file with a 200 OK response instead. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void vnfPackagesVnfPkgIdArtifactsArtifactPathGet(String vnfPkgId, String artifactPath, String accept, String authorization, String range) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdArtifactsArtifactPathGet");
        }
        // verify the required parameter 'artifactPath' is set
        if (artifactPath == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'artifactPath' when calling vnfPackagesVnfPkgIdArtifactsArtifactPathGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesVnfPkgIdArtifactsArtifactPathGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        uriVariables.put("artifactPath", artifactPath);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}/artifacts/{artifactPath}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (range != null)
            headerParams.add("Range", apiClient.parameterToString(range));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Delete an individual VNF package.
     * The DELETE method deletes an individual VNF Package resource. 
     * <p><b>204</b> - 204 No Content The VNF package was deleted successfully. The response body shall be empty. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>409</b> - Conflict. Error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to any of the following scenarios: - Disable a VNF package resource of hich the operational state is not ENABLED - Enable a VNF package resource of which the operational state is not DISABLED The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error. 
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param vnfPkgId Identifier of the VNF package. The identifier is allocated by the NFVO.   
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void vnfPackagesVnfPkgIdDelete(String vnfPkgId, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdDelete");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Read information about an individual VNF package.
     * The GET method reads the information of a VNF package. 
     * <p><b>200</b> - 200 OK Information of the VNF package.             
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param vnfPkgId Identifier of the VNF package. The identifier is allocated by the NFVO.   
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return InlineResponse200
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse200 vnfPackagesVnfPkgIdGet(String vnfPkgId, String accept, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesVnfPkgIdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse200> returnType = new ParameterizedTypeReference<InlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Fetch an on-boarded VNF package.
     * The GET method fetches the content of a VNF package identified by the VNF package identifier allocated by the NFVO. This method shall follow the provisions specified in the Tables 9.4.5.3.2-1 and 9.4.5.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK On success, a copy of the VNF package file is returned. The response body shall include a copy of the VNF package file. The \&quot;Content-Type\&quot; HTTP header shall be set according to the type of the file, i.e. to \&quot;application/zip\&quot; for a VNF Package as defined in ETSI GS NFV-SOL 004 [5]. 
     * <p><b>206</b> - Partial Content. On success, if the NFVO supports range requests, a single consecutive byte range from the content of the NSD file is returned. The response body shall contain the requested part of the NSD file. The \&quot;Content-Range\&quot; HTTP header shall be provided according to IETF RFC 7233 [23]. The \&quot;Content-Type\&quot; HTTP header shall be set as defined above for the \&quot;200 OK\&quot; response.       
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>409</b> - Conflict. Error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to the fact that \&quot;onboardingState\&quot; of the VNF package has a value different from \&quot;ONBOARDED\&quot;. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error. 
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param vnfPkgId Identifier of the on-boarded VNF package. The identifier is allocated by the NFVO. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @param range The request may contain a \&quot;Range\&quot; HTTP header to obtain single range of bytes from the VNF package file. This can be used to continue an aborted transmission.   If the NFVO does not support range requests, it should return the whole file with a 200 OK response instead. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void vnfPackagesVnfPkgIdPackageContentGet(String vnfPkgId, String accept, String authorization, String range) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdPackageContentGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesVnfPkgIdPackageContentGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}/package_content").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (range != null)
            headerParams.add("Range", apiClient.parameterToString(range));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Upload a VNF package by providing the content of the VNF package.
     * The PUT method uploads the content of a VNF package. This method shall follow the provisions specified in the  Tables 9.4.5.3.3-1 and 9.4.5.3.3-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>202</b> - 202 Accepted The VNF package was accepted for uploading, but the processing has not been completed. It is expected to take some time for processing. The response body shall be empty. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>409</b> - Conflict. Error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to the fact that the on boarding state of the VNF package resource is not CREATED . The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param vnfPkgId Identifier of the on-boarded VNF package. The identifier is allocated by the NFVO. 
     * @param file The file parameter
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void vnfPackagesVnfPkgIdPackageContentPut(String accept, String vnfPkgId, File file, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesVnfPkgIdPackageContentPut");
        }
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdPackageContentPut");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}/package_content").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (file != null)
            formParams.add("file", new FileSystemResource(file));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "multipart/form-data"
         };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
    /**
     * Upload a VNF package by providing the address information of the VNF package.
     * The POST method provides the information for the NFVO to get the content of a VNF package. This method shall follow the provisions specified in the  Tables 9.4.6.3.1-1 and 9.4.6.3.1-2 for URI query parameters, request and response data structures, and response codes.         
     * <p><b>202</b> - 202 Accepted The information about the VNF package was received successfully, but the on-boarding has not been completed. It is expected to take some time for processing. The response body shall be empty. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>409</b> - Conflict. Error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to the fact that the on boarding state of the VNF package resource is not CREATED . The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param body The body parameter
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param vnfPkgId Identifier of the VNF package. The identifier is allocated by the NFVO. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void vnfPackagesVnfPkgIdPackageContentUploadFromUriPost(Body2 body, String accept, String contentType, String vnfPkgId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling vnfPackagesVnfPkgIdPackageContentUploadFromUriPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesVnfPkgIdPackageContentUploadFromUriPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling vnfPackagesVnfPkgIdPackageContentUploadFromUriPost");
        }
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdPackageContentUploadFromUriPost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}/package_content/upload_from_uri").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams,  headerAccept, hcontentType, authNames, returnType);
    }
    /**
     * Update information about an individual VNF package.
     * \&quot;The PATCH method updates the information of a VNF package.\&quot; \&quot;This method shall follow the provisions specified in the  Tables 9.4.3.3.4-1 and 9.4.3.3.4-2 for URI query parameters, request and response data structures, and response codes.\&quot; 
     * <p><b>200</b> - 200 OK The operation was completed successfully. The response body shall contain attribute modifications for an \&quot;Individual VNF package\&quot; resource 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>409</b> - Conflict. Error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to any of the following scenarios: - Disable a VNF package resource of hich the operational state is not ENABLED - Enable a VNF package resource of which the operational state is not DISABLED The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error. 
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param body The body parameter
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param vnfPkgId Identifier of the VNF package. The identifier is allocated by the NFVO.   
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return Object
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Object vnfPackagesVnfPkgIdPatch(Body1 body, String contentType, String vnfPkgId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling vnfPackagesVnfPkgIdPatch");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling vnfPackagesVnfPkgIdPatch");
        }
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdPatch");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Object> returnType = new ParameterizedTypeReference<Object>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams,  headerAccept, hcontentType, authNames, returnType);
    }
    /**
     * Read VNFD of an on-boarded VNF package.
     * The GET method reads the content of the VNFD within a VNF package. The VNFD can be implemented as a single file or as a collection of multiple files. If the VNFD is implemented in the form of multiple files, a ZIP file embedding these files shall be returned. If the VNFD is implemented as a single file, either that file or a ZIP file embedding that file shall be returned. The selection of the format is controlled by the \&quot;Accept\&quot; HTTP header passed in the GET request. • If the \&quot;Accept\&quot; header contains only \&quot;text/plain\&quot; and the VNFD is implemented as a single file, the file shall be returned; otherwise, an error message shall be returned. • If the \&quot;Accept\&quot; header contains only \&quot;application/zip\&quot;, the single file or the multiple files that make up the VNFD shall be returned embedded in a ZIP file. • If the \&quot;Accept\&quot; header contains both \&quot;text/plain\&quot; and \&quot;application/zip\&quot;, it is up to the NFVO to choose the format to return for a single-file VNFD; for a multi-file VNFD, a ZIP file shall be returned. The default format of the ZIP file shall be the one specified in ETSI GS NFV-SOL 004 [5] where only the YAML files representing the VNFD, and information necessary to navigate the ZIP file and to identify the file that is the entry point for parsing the VNFD (such as TOSCA-meta or manifest files or naming conventions) are included. This method shall follow the provisions specified in the Tables 9.4.4.3.2-1 and 9.4.4.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK On success, the content of the VNFD is returned. The payload body shall contain a copy of the file representing the VNFD or a ZIP file that contains the file or multiple files representing the VNFD, as specified above. The \&quot;Content-Type\&quot; HTTP header shall be set according to the format of the returned file, i.e. to \&quot;text/plain\&quot; for a YAML file or to \&quot;application/zip\&quot; for a ZIP file. 
     * <p><b>400</b> - Bad Request. Error: Invalid attribute-based filtering parameters. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error.        
     * <p><b>401</b> - Unauthorized If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - Forbidden If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided.  It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - Not Found If the API producer did not find a current representation for the resource addressed by the URI passed in the request, or is not willing to disclose that one exists, it shall respond with this response code.  The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. 
     * <p><b>405</b> - Method Not Allowed If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted in that case. 
     * <p><b>406</b> - If the \&quot;Accept\&quot; header does not contain at least one name of a content type for which the NFVO can provide a representation of the VNFD, the NFVO shall respond with this response code.         
     * <p><b>409</b> - Error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to the fact that \&quot;onboardingState\&quot; of the VNF package has a value different from \&quot;ONBOARDED\&quot;. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error.         
     * <p><b>416</b> - Requested Range Not Satisfiable The byte range passed in the \&quot;Range\&quot; header did not match any available byte range in the VNF package file (e.g. \&quot;access after end of file\&quot;). The response body may contain a ProblemDetails structure. 
     * <p><b>500</b> - Internal Server Error If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond withthis response code. The ProblemDetails structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - Service Unavailable If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 [13] for the use of the Retry-After HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param vnfPkgId Identifier of the on-boarded VNF package. The identifier is allocated by the NFVO. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void vnfPackagesVnfPkgIdVnfdGet(String vnfPkgId, String accept, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'vnfPkgId' is set
        if (vnfPkgId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'vnfPkgId' when calling vnfPackagesVnfPkgIdVnfdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling vnfPackagesVnfPkgIdVnfdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("vnfPkgId", vnfPkgId);
        String path = UriComponentsBuilder.fromPath("/vnf_packages/{vnfPkgId}/vnfd").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headerAccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams,  headerAccept, contentType, authNames, returnType);
    }
}
