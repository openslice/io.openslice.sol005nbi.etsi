package io.openslice.sol005nbi.api.nslcm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
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

import io.openslice.sol005nbi.model.nslcm.Body;
import io.openslice.sol005nbi.model.nslcm.Body1;
import io.openslice.sol005nbi.model.nslcm.Body2;
import io.openslice.sol005nbi.model.nslcm.Body3;
import io.openslice.sol005nbi.model.nslcm.Body4;
import io.openslice.sol005nbi.model.nslcm.Body5;
import io.openslice.sol005nbi.model.nslcm.Body6;
import io.openslice.sol005nbi.model.nslcm.Body7;
import io.openslice.sol005nbi.model.nslcm.InlineResponse200;
import io.openslice.sol005nbi.model.nslcm.InlineResponse2002;
import io.openslice.sol005nbi.model.nslcm.InlineResponse2003;
import io.openslice.sol005nbi.model.nslcm.InlineResponse2004;
import io.openslice.sol005nbi.model.nslcm.InlineResponse2011;
import io.openslice.sol005nbi.model.nslcm.NsInstancesNsInstance;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
@Component
public class NslcmDefaultApi {
    private NslcmClient apiClient;

    public NslcmDefaultApi() {
        this(new NslcmClient());
    }

    @Autowired
    public NslcmDefaultApi(NslcmClient apiClient) {
        this.apiClient = apiClient;
    }

    public NslcmClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(NslcmClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Retrieve API version information
     * The GET method reads API version information. This method shall follow the provisions specified in table 4.6.3.3.3.2-1 for request and response data structures, and response codes. URI query parameters are not supported. 
     * <p><b>200</b> - API version information was read successfully. The response body shall contain 4.4 API version information, as defined in clause 4.4.1.13. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>413</b> - 413 PAYLOAD TOO LARGE If the payload body of a request is larger than the amount of data the API producer is willing or able to process, it shall respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for closing the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>414</b> - 414 URI TOO LONG If the request URI of a request is longer than the API producer is willing or able to process, it shall respond with this response code. This condition can e.g. be caused by passing long queries in the request URI of a GET request. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>416</b> - 416 RANGE NOT SATISFIABLE 
     * <p><b>422</b> - 422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. 
     * <p><b>429</b> - 429 TOO MANY REQUESTS If the API consumer has sent too many requests in a defined period of time and the API producer is able to detect that condition (\&quot;rate limiting\&quot;), the API producer shall respond with this response code, following the provisions in IETF RFC 6585 [17] for the use of the \&quot;Retry-After\&quot; HTTP header. The \&quot;ProblemDetails\&quot; structure shall be provided and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. The period of time and allowed number of requests are configured within the API producer by means outside the scope of the present document. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param version Version of the API requested to use when responding to this request. 
     * @return InlineResponse200
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse200 apiVersionsGet(String version) throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/api_versions").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse200> returnType = new ParameterizedTypeReference<InlineResponse200>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Query multiple NS instances.
     * Query NS Instances. The GET method queries information about multiple NS instances. This method shall support the URI query parameters, request and response data structures, and response codes, as specified in the Tables 6.4.2.3.2-1 and 6.4.2.3.2-2. 
     * <p><b>200</b> - 200 OK Shall be returned when information about zero or more NS instances has been queried successfully. The response body shall contain in an array the representations of zero or more NS instances, as defined in clause 6.5.2.8. If the \&quot;filter\&quot; URI parameter or one of the \&quot;all_fields\&quot;, \&quot;fields\&quot; (if supported), \&quot;exclude_fields\&quot; (if supported) or \&quot;exclude_default\&quot; URI parameters was supplied in the request, the data in the response body shall have been transformed according to the rules specified in clauses 5.2.2 and 5.3.2 of ETSI GS NFV-SOL 013 [16], respectively. If the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 [16] for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV-SOL 013 [16]. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>416</b> - 416 RANGE NOT SATISFIABLE 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param filter Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV-SOL 013. The NFVO shall support receiving this parameter as part of the URI query string. The OSS/BSS may supply this parameter. All attribute names that appear in the NsInstance and in data types referenced from it shall be supported by the NFVO in the filter expression. 
     * @param allFields Include all complex attributes in the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO shall support this parameter. 
     * @param fields \&quot;Complex attributes to be included into the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO should support this parameter.\&quot;           
     * @param excludeFields \&quot;Complex attributes to be excluded from the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO should support this parameter.\&quot; 
     * @param excludeDefault \&quot;Indicates to exclude the following complex attributes from the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO shall support this parameter. The following attributes shall be excluded from the NsInstance structure in the response body if this parameter is provided, or none of the parameters \&quot;all_fields,\&quot; \&quot;fields\&quot;, \&quot;exclude_fields\&quot;, \&quot;exclude_default\&quot; are provided: - vnfInstances - pnfInfo - virtualLinkInfo - vnffgInfo - sapInfo - nsScaleStatus - additionalAffinityOrAntiAffinityRules\&quot; 
     * @param nextpageOpaqueMarker Marker to obtain the next page of a paged response. Shall be supported by the NFVO if the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource. 
     * @return List&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<NsInstancesNsInstance> nsInstancesGet(String version, String accept, String authorization, String filter, String allFields, String fields, String excludeFields, String excludeDefault, String nextpageOpaqueMarker) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesGet");
        }
        String path = UriComponentsBuilder.fromPath("/ns_instances").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "all_fields", allFields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fields", fields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exclude_fields", excludeFields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exclude_default", excludeDefault));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextpage_opaque_marker", nextpageOpaqueMarker));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<NsInstancesNsInstance>> returnType = new ParameterizedTypeReference<List<NsInstancesNsInstance>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, headeraccept, contentType, authNames, returnType);
    }
    /**
     * Delete NS instance resource.
     * Delete NS Identifier This method deletes an individual NS instance resource. As the result of successfully executing this method, the \&quot;Individual NS instance\&quot; resource shall not exist any longer. A notification of type \&quot;NsIdentifierDeletionNotification\&quot; shall be triggered as part of successfully executing this method as defined in clause 6.5.2.7. 
     * <p><b>204</b> - 204 No Content Shall be returned when the \&quot;Individual NS instance\&quot; resource and the associated NS identifier have been deleted successfully. The response body shall be empty. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>412</b> - 412 PRECONDITION FAILED Error: A precondition given in an HTTP request header is not fulfilled. Typically, this is due to an ETag mismatch, indicating that the resource was modified by another entity. The response body should contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsInstanceId Identifier of the NS instance. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsInstancesNsInstanceIdDelete(String nsInstanceId, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsInstanceId' is set
        if (nsInstanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsInstanceId' when calling nsInstancesNsInstanceIdDelete");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesNsInstanceIdDelete");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsInstanceId", nsInstanceId);
        String path = UriComponentsBuilder.fromPath("/ns_instances/{nsInstanceId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read an individual NS instance resource.
     * The GET method retrieves information about a NS instance by  reading an individual NS instance resource.    
     * <p><b>200</b> - 200 OK Shall be returned when information about an individual NS instance has been read successfully. The response body shall contain a representation of the NS instance, as defined in clause 6.5.2.10. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>416</b> - 416 RANGE NOT SATISFIABLE 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsInstanceId Identifier of the NS instance. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse201
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public NsInstancesNsInstance nsInstancesNsInstanceIdGet(String nsInstanceId, String version, String accept, String contentType, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsInstanceId' is set
        if (nsInstanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsInstanceId' when calling nsInstancesNsInstanceIdGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesNsInstanceIdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesNsInstanceIdGet");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsInstancesNsInstanceIdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsInstanceId", nsInstanceId);
        String path = UriComponentsBuilder.fromPath("/ns_instances/{nsInstanceId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<NsInstancesNsInstance> returnType = new ParameterizedTypeReference<NsInstancesNsInstance>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Heal a NS instance.
     * The POST method requests to heal an NS instance. This method shall follow the provisions specified in the Tables 6.4.7.3.1-1 and 6.4.7.3.1-2 for URI query parameters, request and response data structures, and response codes. The steps and conditions that apply as the result of successfully executing this method are specified in clause 6.4.1.2. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body Parameters for the heal NS operation, as defined in clause 6.5.2.13.

     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param nsInstanceId Identifier of the NS instance to be healed. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsInstancesNsInstanceIdHealPost(Body4 body, String accept, String contentType, String version, String nsInstanceId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsInstancesNsInstanceIdHealPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesNsInstanceIdHealPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsInstancesNsInstanceIdHealPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesNsInstanceIdHealPost");
        }
        // verify the required parameter 'nsInstanceId' is set
        if (nsInstanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsInstanceId' when calling nsInstancesNsInstanceIdHealPost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsInstanceId", nsInstanceId);
        String path = UriComponentsBuilder.fromPath("/ns_instances/{nsInstanceId}/heal").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Instantiate a NS.
     * The POST method requests to instantiate a NS instance resource. The steps and conditions that apply as the result of successfully executing this method are specified in clause 6.4.1.2. In addition, once the NFVO has successfully completed the underlying NS LCM operation occurrence, it shall set the \&quot;nsState\&quot; attribute to the value \&quot;INSTANTIATED\&quot; in the representation of the \&quot;Individual NS instance\&quot; resource. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>416</b> - 416 RANGE NOT SATISFIABLE 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body Parameters for the instantiate NS operation, as defined in clause 6.5.2.11.

     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param nsInstanceId Identifier of the NS instance to be instantiated. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsInstancesNsInstanceIdInstantiatePost(Body1 body, String accept, String contentType, String version, String nsInstanceId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsInstancesNsInstanceIdInstantiatePost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesNsInstanceIdInstantiatePost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsInstancesNsInstanceIdInstantiatePost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesNsInstanceIdInstantiatePost");
        }
        // verify the required parameter 'nsInstanceId' is set
        if (nsInstanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsInstanceId' when calling nsInstancesNsInstanceIdInstantiatePost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsInstanceId", nsInstanceId);
        String path = UriComponentsBuilder.fromPath("/ns_instances/{nsInstanceId}/instantiate").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Scale a NS instance.
     * The POST method requests to scale a NS instance resource. The steps and conditions that apply as the result of successfully executing this method are specified in clause 6.4.1.2. In addition, once the NFVO has successfully completed the underlying NS LCM operation occurrence, it shall reflect the result of scaling the NS instance by updating the \&quot;nsScaleStatus\&quot; attribute in the representation of the \&quot;Individual NS instance\&quot; resource. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body Parameters for the scale NS operation, as defined in clause 6.5.2.14.

     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param nsInstanceId Identifier of the NS instance to be scaled. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsInstancesNsInstanceIdScalePost(Body2 body, String accept, String contentType, String version, String nsInstanceId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsInstancesNsInstanceIdScalePost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesNsInstanceIdScalePost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsInstancesNsInstanceIdScalePost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesNsInstanceIdScalePost");
        }
        // verify the required parameter 'nsInstanceId' is set
        if (nsInstanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsInstanceId' when calling nsInstancesNsInstanceIdScalePost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsInstanceId", nsInstanceId);
        String path = UriComponentsBuilder.fromPath("/ns_instances/{nsInstanceId}/scale").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Terminate a NS instance.
     * Terminate NS task.   The POST method terminates an NS instance. This method shall follow the provisions specified in the Tables 6.4.8.3.1-1 and 6.4.8.3.1-2 for URI query parameters, request and response data structures, and response codes. The steps and conditions that apply as the result of successfully executing this method are specified in clause 6.4.1.2. In addition, once the NFVO has successfully completed the underlying NS LCM operation occurrence, it shall set the \&quot;nsState\&quot; attribute in the representation of the \&quot;Individual NS instance\&quot; resource to the value \&quot;NOT_INSTANTIATED\&quot;. This method can only be used with an NS instance in the INSTANTIATED state. Terminating an NS instance does not delete the NS instance identifier, but rather transitions the NS into the NOT_INSTANTIATED state. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body The terminate NS request parameters, as defined in  clause 6.5.2.15.

     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param nsInstanceId The identifier of the NS instance to be terminated. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsInstancesNsInstanceIdTerminatePost(Body5 body, String accept, String contentType, String version, String nsInstanceId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsInstancesNsInstanceIdTerminatePost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesNsInstanceIdTerminatePost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsInstancesNsInstanceIdTerminatePost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesNsInstanceIdTerminatePost");
        }
        // verify the required parameter 'nsInstanceId' is set
        if (nsInstanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsInstanceId' when calling nsInstancesNsInstanceIdTerminatePost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsInstanceId", nsInstanceId);
        String path = UriComponentsBuilder.fromPath("/ns_instances/{nsInstanceId}/terminate").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Updates a NS instance.
     * The POST method updates an NS instance. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body Parameters for the update NS operation, as defined in clause 6.5.2.12.

     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param nsInstanceId Identifier of the NS instance to be updated. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsInstancesNsInstanceIdUpdatePost(Body3 body, String accept, String contentType, String version, String nsInstanceId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsInstancesNsInstanceIdUpdatePost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesNsInstanceIdUpdatePost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsInstancesNsInstanceIdUpdatePost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesNsInstanceIdUpdatePost");
        }
        // verify the required parameter 'nsInstanceId' is set
        if (nsInstanceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsInstanceId' when calling nsInstancesNsInstanceIdUpdatePost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsInstanceId", nsInstanceId);
        String path = UriComponentsBuilder.fromPath("/ns_instances/{nsInstanceId}/update").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Create a NS instance resource.
     * The POST method creates a new NS instance resource. As the result of successfully executing this method, a new \&quot;Individual NS instance\&quot; resource as defined in clause 6.4.3 shall have been created, and the value of the \&quot;instantiationState\&quot; attribute in the representation of that resource shall be \&quot;NOT_INSTANTIATED\&quot;. A notification of type NsIdentifierCreationNotification shall be triggered as part of successfully executing this method as defined in clause 6.5.2.6. 
     * <p><b>201</b> - 201 Created Shall be returned when a new \&quot;Individual NS instance\&quot; resource and the associated NS instance identifier has been created successfully. The response body shall contain a representation of the created NS instance, as defined in clause 6.5.2.10. The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the created NS instance. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>416</b> - 416 RANGE NOT SATISFIABLE 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body The NS creation parameters, as defined in clause 6.5.2.7.

     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse201
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public NsInstancesNsInstance nsInstancesPost(Body body, String version, String accept, String contentType, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsInstancesPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsInstancesPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsInstancesPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsInstancesPost");
        }
        String path = UriComponentsBuilder.fromPath("/ns_instances").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<NsInstancesNsInstance> returnType = new ParameterizedTypeReference<NsInstancesNsInstance>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Query multiple NS LCM operation occurrences.
     * Get Operation Status. Shall be returned upon the following error: The operation cannot be executed currently, due to a conflict with the state of the resource. Typically, this is due to the fact that the NS instance resource is in NOT_INSTANTIATED state, or that another lifecycle management operation is ongoing. The response body shall contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute shall convey more information about the error 
     * <p><b>200</b> - 200 OK Shall be returned when status information for zero or more NS lifecycle management operation occurrences has been queried successfully. The response body shall contain in an array the status information about zero or more NS lifecycle operation occurrences, as defined in clause 6.5.2.3. If the \&quot;filter\&quot; URI parameter or one of the \&quot;all_fields\&quot;, \&quot;fields\&quot;, \&quot;exclude_fields\&quot; or \&quot;exclude_default\&quot; URI parameters was supplied in the request and is supported, the data in the response body shall have been transformed according to the rules specified in clauses 5.2.2 and 5.3.2 of ETSI GS NFV-SOL 013 [16], respectively. If the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 [16] for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV-SOL 013 [16]. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param filter Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV SOL 013[16]. The NFVO shall support receiving this parameter as part of the URI query string. The OSS/BSS may supply this parameter. All attribute names that appear in the NsLcmOpOcc and in data types referenced from it shall be supported by the NFVO in the filter expression. 
     * @param fields Complex attributes to be included into the response. See clause 5.3 of ETSI GS NFV SOL 013 for details. The NFVO should support this parameter. 
     * @param excludeFields Complex attributes to be excluded from the response. See clause 5.3 of ETSI GS NFV SOL 013 for details. The NFVO should support this parameter. 
     * @param excludeDefault Indicates to exclude the following complex attributes from the response. See clause 5.3 of ETSI GS NFV SOL 013 for details. The NFVO shall support this parameter. The following attributes shall be excluded from the NsLcmOpOcc structure in the response body if this parameter is provided: - operationParams - changedVnfInfo - error - resourceChanges 
     * @param nextpageOpaqueMarker Marker to obtain the next page of a paged response. Shall be supported by the NFVO if the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV SOL 013 for this resource. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return List&lt;InlineResponse2002&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2002> nsLcmOpOccsGet(String accept, String version, String filter, String fields, String excludeFields, String excludeDefault, String nextpageOpaqueMarker, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsLcmOpOccsGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsLcmOpOccsGet");
        }
        String path = UriComponentsBuilder.fromPath("/ns_lcm_op_occs").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "fields", fields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exclude_fields", excludeFields));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "exclude_default", excludeDefault));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextpage_opaque_marker", nextpageOpaqueMarker));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse2002>> returnType = new ParameterizedTypeReference<List<InlineResponse2002>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, headeraccept, contentType, authNames, returnType);
    }
    /**
     * Continue a NS lifecycle management operation occurrence.
     * The POST method initiates continuing an NS lifecycle operation if that operation has experienced a temporary failure, i.e. the related \&quot;NS LCM operation occurrence\&quot; is in \&quot;FAILED_TEMP\&quot; state. This method shall follow the provisions specified in the Tables 6.4.13.3.1-1 and 6.4.13.3.1-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsLcmOpOccId Identifier of a NS lifecycle management operation occurrence to be continued. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request triggering an NS LCM operation. It can also be retrieved from the \&quot;nsLcmOpOccId\&quot; attribute in the NsLcmOperationOccurrenceNotification. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsLcmOpOccsNsLcmOpOccIdContinuePost(String nsLcmOpOccId, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsLcmOpOccId' is set
        if (nsLcmOpOccId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsLcmOpOccId' when calling nsLcmOpOccsNsLcmOpOccIdContinuePost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsLcmOpOccsNsLcmOpOccIdContinuePost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsLcmOpOccId", nsLcmOpOccId);
        String path = UriComponentsBuilder.fromPath("/ns_lcm_op_occs/{nsLcmOpOccId}/continue").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read an individual NS LCM operation occurrence resource.
     * The API consumer can use this method to retrieve status information about a NS lifecycle management operation occurrence by reading an individual \&quot;NS LCM operation occurrence\&quot; resource. This method shall follow the provisions specified in the Tables 6.4.10.3.2-1 and 6.4.10.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Shall be returned when information about an NS LCM operation occurrence has been read successfully. The response body shall contain status information about an NS lifecycle management operation occurrence (see clause 6.5.2.3). 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>416</b> - 416 RANGE NOT SATISFIABLE 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsLcmOpOccId Identifier of a NS lifecycle management operation occurrence. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return InlineResponse2003
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2003 nsLcmOpOccsNsLcmOpOccIdGet(String nsLcmOpOccId, String accept, String contentType, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsLcmOpOccId' is set
        if (nsLcmOpOccId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsLcmOpOccId' when calling nsLcmOpOccsNsLcmOpOccIdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsLcmOpOccsNsLcmOpOccIdGet");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsLcmOpOccsNsLcmOpOccIdGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsLcmOpOccsNsLcmOpOccIdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsLcmOpOccId", nsLcmOpOccId);
        String path = UriComponentsBuilder.fromPath("/ns_lcm_op_occs/{nsLcmOpOccId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2003> returnType = new ParameterizedTypeReference<InlineResponse2003>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Retry a NS lifecycle management operation occurrence.
     * The POST method initiates retrying a NS lifecycle management operation  if that operation has experienced a temporary failure, i.e. the related \&quot;NS LCM operation occurrence\&quot; is in \&quot;FAILED_TEMP\&quot; state. This method shall follow the provisions specified in the  Tables 6.4.11.3.1-1 and 6.4.11.3.1-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsLcmOpOccId Identifier of a NS lifecycle management operation occurrence to be retried. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request triggering a NS LCM operation. It can also be retrieved from the \&quot;nsLcmOpOccId\&quot; attribute in the NsLcmOperationOccurrenceNotification. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsLcmOpOccsNsLcmOpOccIdRetryPost(String nsLcmOpOccId, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsLcmOpOccId' is set
        if (nsLcmOpOccId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsLcmOpOccId' when calling nsLcmOpOccsNsLcmOpOccIdRetryPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsLcmOpOccsNsLcmOpOccIdRetryPost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsLcmOpOccId", nsLcmOpOccId);
        String path = UriComponentsBuilder.fromPath("/ns_lcm_op_occs/{nsLcmOpOccId}/retry").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Rollback a NS lifecycle management operation occurrence.
     * The POST method initiates rolling back a NS lifecycle operation  if that operation has experienced a temporary failure, i.e. the related \&quot;NS LCM operation occurrence\&quot; is in \&quot;FAILED_TEMP\&quot; state. This method shall follow the provisions specified in the  Tables 6.4.12.3.1-1 and 6.4.12.3.1-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsLcmOpOccId Identifier of a NS lifecycle management operation occurrence to be rolled back. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request triggering a NS LCM operation. It can also be retrieved from the \&quot;nsLcmOpOccId\&quot; attribute in the NsLcmOperationOccurrenceNotification. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsLcmOpOccsNsLcmOpOccIdRollbackPost(String nsLcmOpOccId, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsLcmOpOccId' is set
        if (nsLcmOpOccId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsLcmOpOccId' when calling nsLcmOpOccsNsLcmOpOccIdRollbackPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsLcmOpOccsNsLcmOpOccIdRollbackPost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsLcmOpOccId", nsLcmOpOccId);
        String path = UriComponentsBuilder.fromPath("/ns_lcm_op_occs/{nsLcmOpOccId}/rollback").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Cancel a NS lifecycle management operation occurrence.
     * The POST method initiates cancelling an ongoing NS lifecycle management operation while it is being executed or rolled back, i.e. the related \&quot;NS LCM operation occurrence\&quot; is either in \&quot;PROCESSING\&quot; or \&quot;ROLLING_BACK\&quot; state. This method shall follow the provisions specified in the Tables 6.4.15.3.1-1 and 6.4.15.3.1-2 for URI query parameters, request and response data structures, and response codes. Before returning the \&quot;202 Accepted\&quot; response, the NFVO shall update the \&quot;isCancelPending\&quot; and \&quot;cancelMode\&quot; attributes in the representation of the parent resource according to the provisions in clause 6.5.2.3. In case of success of processing the asynchronous request: 1) If the request has been processed in \&quot;PROCESSING\&quot; or \&quot;ROLLING_BACK\&quot; state, the \&quot;operationState\&quot; attribute in the representation of the parent resource shall be changed to \&quot;FAILED_TEMP\&quot;. In both cases, the NFVO shall update the \&quot;isCancelPending\&quot; and \&quot;cancelMode\&quot; attributes in the representation of the parent resource according to the provisions in clause 6.5.2.3 to reflect the new status, and the applicable \&quot;result\&quot; notification according to clause 6.6.2.2 shall be emitted to indicate that the execution of the underlying NS LCM operation occurrence has temporarily failed. Due to race conditions, the processing of the actual operation that is to be cancelled may eventually still succeed, in which case the \&quot;operationState\&quot; attribute in the representation of the parent resource shall represent the result of that operation, rather than the result of the cancellation.        
     * <p><b>202</b> - 202 ACCEPTED 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body The POST request to this resource shall include a CancelMode structure in the payload body to choose between &quot;graceful&quot; and &quot;forceful&quot; cancellation.

     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param nsLcmOpOccId Identifier of a NS lifecycle management operation occurrence to be canceled. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request triggering a NS LCM operation. It can also be retrieved from the \&quot;nsLcmOpOccId\&quot; attribute in the NsLcmOperationOccurrenceNotification. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost(Body6 body, String accept, String contentType, String version, String nsLcmOpOccId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost");
        }
        // verify the required parameter 'nsLcmOpOccId' is set
        if (nsLcmOpOccId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsLcmOpOccId' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdCancelPost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsLcmOpOccId", nsLcmOpOccId);
        String path = UriComponentsBuilder.fromPath("/nslcm/v1/ns_lcm_op_occs/{nsLcmOpOccId}/cancel").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Mark a NS lifecycle management operation occurrence as failed.
     * The POST method marks a NS lifecycle management operation  occurrence as \&quot;finally failed\&quot; if that operation occurrence is in \&quot;FAILED_TEMP\&quot; state. 
     * <p><b>200</b> - 200 OK Shall be returned when the state of the NS lifecycle management operation occurrence has been changed successfully. The response shall include a representation of the \&quot;Individual NS lifecycle management operation occurrence\&quot; resource. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsLcmOpOccId Identifier of a NS lifecycle management operation occurrence to be marked as \&quot;failed\&quot;. This identifier can be retrieved from the resource referenced by  he \&quot;Location\&quot; HTTP header in the response to a POST request triggering a NS LCM operation.  It can also be retrieved from the \&quot;nsLcmOpOccId\&quot; attribute in the NsLcmOperationOccurrenceNotification. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @return InlineResponse2003
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2003 nslcmV1NsLcmOpOccsNsLcmOpOccIdFailPost(String nsLcmOpOccId, String accept, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsLcmOpOccId' is set
        if (nsLcmOpOccId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsLcmOpOccId' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdFailPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdFailPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nslcmV1NsLcmOpOccsNsLcmOpOccIdFailPost");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsLcmOpOccId", nsLcmOpOccId);
        String path = UriComponentsBuilder.fromPath("/nslcm/v1/ns_lcm_op_occs/{nsLcmOpOccId}/fail").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2003> returnType = new ParameterizedTypeReference<InlineResponse2003>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, contentType, authNames, returnType);
    }
    /**
     * Query multiple subscriptions.
     * Query Subscription Information. The GET method queries the list of active subscriptions of the functional block that invokes the method. It can be used e.g. for resynchronization after error situations. 
     * <p><b>200</b> - 200 OK Shall be returned when the list of subscriptions has been queried successfully. The response body shall contain in an array the representations of all active subscriptions of the functional block that invokes the method, i.e. zero or more representations of lifecycle change notification subscriptions as defined in clause 6.5.2.4. If the \&quot;filter\&quot; URI parameter was supplied in the request, the data in the response body shall have been transformed according to the rules specified in clause 5.2.2 of ETSI GS NFV-SOL 013 [16]. If the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 [16] for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV-SOL 013 [16]. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param filter Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV SOL 013. The NFVO shall support receiving this parameter as part of the URI query string. The OSS/BSS may supply this parameter. All attribute names that appear in the LccnSubscription and in data types  referenced from it shall be supported by the NFVO in the filter expression. 
     * @param nextpageOpaqueMarker Marker to obtain the next page of a paged response. Shall be supported by the NFVO if the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV SOL 013 for this resource. 
     * @return List&lt;InlineResponse2004&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2004> subscriptionsGet(String version, String accept, String authorization, String filter, String nextpageOpaqueMarker) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling subscriptionsGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling subscriptionsGet");
        }
        String path = UriComponentsBuilder.fromPath("/subscriptions").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "filter", filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "nextpage_opaque_marker", nextpageOpaqueMarker));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse2004>> returnType = new ParameterizedTypeReference<List<InlineResponse2004>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, headeraccept, contentType, authNames, returnType);
    }
    /**
     * Subscribe to NS lifecycle change notifications.
     * The POST method creates a new subscription. This method shall support the URI query parameters, request and response data structures, and response codes, as specified in the Tables 6.4.16.3.1-1 and 6.4.16.3.1-2. Creation of two subscription resources with the same callbackURI and the same filter can result in performance degradation and will provide duplicates of notifications to the OSS, and might make sense only in very rare use cases. Consequently, the NFVO may either allow creating a subscription resource if another subscription resource with the same filter and callbackUri already exists (in which case it shall return the \&quot;201 Created\&quot; response code), or may decide to not create a duplicate subscription resource (in which case it shall return a \&quot;303 See Other\&quot; response code referencing the existing subscription resource with the same filter and callbackUri). 
     * <p><b>201</b> - 201 Created Shall be returned when the subscription has been created successfully. The response body shall contain a representation of the created \&quot;Individual subscription\&quot; resource. The HTTP response shall include a \&quot;Location:\&quot; HTTP header that points to the created \&quot;Individual subscription\&quot; resource.            
     * <p><b>303</b> - 303 SEE OTHER 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>422</b> - 422 UNPROCESSABLE ENTITY If the payload body of a request contains syntactically correct data (e.g. well-formed JSON) but the data cannot be processed (e.g. because it fails validation against a schema), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. This error response code is only applicable for methods that have a request body. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body Details of the subscription to be created, as defined in clause 6.5.2.2.

     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse2011
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2011 subscriptionsPost(Body7 body, String version, String accept, String contentType, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling subscriptionsPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling subscriptionsPost");
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
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType headercontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2011> returnType = new ParameterizedTypeReference<InlineResponse2011>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, headeraccept, headercontentType, authNames, returnType);
    }
    /**
     * Terminate a subscription.
     * The DELETE method terminates an individual subscription. This method shall support the URI query parameters, request and response data structures, and response codes, as specified in the Tables 6.4.17.3.5-1 and 6.4.17.3.5-2. As the result of successfully executing this method, the \&quot;Individual subscription\&quot; resource shall not exist any longer. This means that no notifications for that subscription shall be sent to the formerly-subscribed API consumer. NOTE: Due to race conditions, some notifications might still be received by the formerly-subscribed API consumer for a certain time period after the deletion. 
     * <p><b>204</b> - 204 NO CONTENT Shall be returned when the \&quot;Individual subscription\&quot; resource has been deleted successfully. The response body shall be empty. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param subscriptionId Identifier of this subscription. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void subscriptionsSubscriptionIdDelete(String subscriptionId, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling subscriptionsSubscriptionIdDelete");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling subscriptionsSubscriptionIdDelete");
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
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Read an individual subscription resource.
     * The GET method retrieves information about a subscription by reading an individual subscription resource. This method shall support the URI query parameters, request and response data structures, and response codes, as specified in the Tables 6.4.17.3.2-1 and 6.4.17.3.2-2 
     * <p><b>200</b> - 200 OK Shall be returned when information about an individual subscription has been read successfully. The response body shall contain a representation of the \&quot;Individual subscription\&quot; resource.            
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param subscriptionId Identifier of this subscription. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse2011
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2011 subscriptionsSubscriptionIdGet(String subscriptionId, String version, String accept, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'subscriptionId' is set
        if (subscriptionId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'subscriptionId' when calling subscriptionsSubscriptionIdGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling subscriptionsSubscriptionIdGet");
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
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> headeraccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2011> returnType = new ParameterizedTypeReference<InlineResponse2011>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, headeraccept, contentType, authNames, returnType);
    }
}
