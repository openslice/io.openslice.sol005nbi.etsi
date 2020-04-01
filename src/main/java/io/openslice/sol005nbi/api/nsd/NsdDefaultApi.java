package io.openslice.sol005nbi.api.nsd;


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

import io.openslice.sol005nbi.model.nsd.Body;
import io.openslice.sol005nbi.model.nsd.Body1;
import io.openslice.sol005nbi.model.nsd.Body2;
import io.openslice.sol005nbi.model.nsd.Body3;
import io.openslice.sol005nbi.model.nsd.Body4;
import io.openslice.sol005nbi.model.nsd.InlineResponse200;
import io.openslice.sol005nbi.model.nsd.InlineResponse2001;
import io.openslice.sol005nbi.model.nsd.InlineResponse2002;
import io.openslice.sol005nbi.model.nsd.InlineResponse2003;
import io.openslice.sol005nbi.model.nsd.InlineResponse201;
import io.openslice.sol005nbi.model.nsd.InlineResponse2011;
import io.openslice.sol005nbi.model.nsd.InlineResponse2012;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-31T22:46:27.985+03:00[Europe/Athens]")
@Component
public class NsdDefaultApi {
    private NsdApiClient apiClient;

    public NsdDefaultApi() {
        this(new NsdApiClient());
    }

    @Autowired
    public NsdDefaultApi(NsdApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public NsdApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(NsdApiClient apiClient) {
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
     * Query information about multiple NS descriptor resources.
     * The GET method queries information about multiple NS descriptor resources. 
     * <p><b>200</b> - 200 OK Shall be returned when information about zero or more NS descriptors has been queried successfully. The response body shall contain in an array the representations of zero or more NS descriptors, as defined in clause 5.5.2.2. If the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV-SOL 013. 
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
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param filter Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV-SOL 013. The NFVO shall support receiving this filtering parameter as part of the URI query string. The OSS/BSS may supply this parameter. All attribute names that appear in the NsdInfo and in data types referenced from it shall be supported by the NFVO in the filter expression. 
     * @param allFields Include all complex attributes in the response. See clause 5.3 of ETSI GS NFV SOL 013 for details. The NFVO shall support this parameter. 
     * @param fields Complex attributes to be included into the response. See clause 5.3 of ETSI GS NFV SOL 013 for details. The NFVO should support this parameter. 
     * @param excludeFields Complex attributes to be excluded from the response. See clause 5.3 of ETSI GS NFV SOL 013 for details. The NFVO should support this parameter. 
     * @param excludeDefault Indicates to exclude the following complex attributes from the response. See clause 5.3 of ETSI GS NFV SOL 013 for details. The VNFM shall support this parameter. The following attributes shall be excluded from the NsdInfo structure in the response body if this parameter is provided, or none of the parameters \&quot;all_fields,\&quot; \&quot;fields\&quot;, \&quot;exclude_fields\&quot;, \&quot;exclude_default\&quot; are provided:   - userDefinedData   - onboardingFailureDetails 
     * @param nextpageOpaqueMarker Marker to obtain the next page of a paged response. Shall be supported by the NFVO if the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource. 
     * @return List&lt;InlineResponse2001&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2001> nsDescriptorsGet(String version, String accept, String authorization, String filter, String allFields, String fields, String excludeFields, String excludeDefault, String nextpageOpaqueMarker) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsDescriptorsGet");
        }
        String path = UriComponentsBuilder.fromPath("/ns_descriptors").build().toUriString();
        
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse2001>> returnType = new ParameterizedTypeReference<List<InlineResponse2001>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Delete an individual NS descriptor resource.
     * The DELETE method deletes an individual NS descriptor resource. An individual NS descriptor resource can only be deleted when there is no NS instance using it (i.e. usageState &#x3D; NOT_IN_USE) and has been disabled already (i.e. operationalState &#x3D; DISABLED). Otherwise, the DELETE method shall fail. 
     * <p><b>204</b> - 204 NO CONTENT Shall be returned when the operation has completed successfully. The response body shall be empty. 
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
     * @param nsdInfoId Identifier of the individual NS descriptor resource. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsDescriptorsNsdInfoIdDelete(String nsdInfoId, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsdInfoId' is set
        if (nsdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsdInfoId' when calling nsDescriptorsNsdInfoIdDelete");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsNsdInfoIdDelete");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsdInfoId", nsdInfoId);
        String path = UriComponentsBuilder.fromPath("/ns_descriptors/{nsdInfoId}").buildAndExpand(uriVariables).toUriString();
        
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
     * Read information about an individual NS descriptor resource.
     * The GET method reads information about an individual NS descriptor. 
     * <p><b>200</b> - 200 OK Shall be returned when information about the individual NS descriptor has been read successfully. The response body shall contain a representation of the individual NS descriptor, as defined in clause 5.5.2.2. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsdInfoId Identifier of the individual NS descriptor resource. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse201
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse201 nsDescriptorsNsdInfoIdGet(String nsdInfoId, String version, String accept, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsdInfoId' is set
        if (nsdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsdInfoId' when calling nsDescriptorsNsdInfoIdGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsNsdInfoIdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsDescriptorsNsdInfoIdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsdInfoId", nsdInfoId);
        String path = UriComponentsBuilder.fromPath("/ns_descriptors/{nsdInfoId}").buildAndExpand(uriVariables).toUriString();
        
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse201> returnType = new ParameterizedTypeReference<InlineResponse201>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Fetch the content of the manifest in an NSD archive.
     * The GET method reads the content of the manifest file within an NSD archive. This method shall follow the provisions specified in the Tables 5.4.4b.3.2-1 and 5.4.4b.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Shall be returned when the content of the manifest file has been read successfully. If the \&quot;include_signatures\&quot; URI query parameter was absent in the request, or if the manifest file has all security-related information embedded (i.e. there is no separate certificate file), the payload body shall contain a copy of the manifest file of the NSD archive, and the \&quot;Content-Type\&quot; HTTP header shall be set to \&quot;text/plain\&quot;. If the \&quot;include_signatures\&quot; URI query parameter was present in the related request and the manifest file does not have all the security-related information embedded (i.e. there is a separate certificate file), the \&quot;Content-Type\&quot; HTTP header shall be set to \&quot;application/zip\&quot; and the payload body shall contain a ZIP archive which includes: - a copy of the manifest file of the NSD archive; - a copy of the related individual certificate file. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param nsdInfoId Identifier of the individual NS descriptor. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new NS descriptor resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param includeSignatures If this parameter is provided, the NFVO shall return the manifest and related security information (signature and certificate) either in a single text file if the signature and certificate are included in the manifest file, or in a zip file containing the manifest and the certificate file, if this is provided as a separate file in the NSD archive. If this parameter is not given, the NFVO shall provide only a copy of the manifest file, as onboarded. If the security information is included in the onboarded manifest, it shall also be included in the returned copy. This URI query parameter is a flag, i.e. it shall have no value. The NFVO shall support this parameter. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsDescriptorsNsdInfoIdManifestGet(String nsdInfoId, String version, String accept, String authorization, String includeSignatures) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsdInfoId' is set
        if (nsdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsdInfoId' when calling nsDescriptorsNsdInfoIdManifestGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsNsdInfoIdManifestGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsDescriptorsNsdInfoIdManifestGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsdInfoId", nsdInfoId);
        String path = UriComponentsBuilder.fromPath("/ns_descriptors/{nsdInfoId}/manifest").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_signatures", includeSignatures));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Fetch the content of a NSD.
     * The GET method fetches the content of the NSD archive. The NSD archive is implemented as a single zip file. The content of the NSD archive is provided as onboarded, i.e. depending on the security option used, the CSAR wrapped in a ZIP archive together with an external signature is returned, as defined in clause 5.1 of ETSI GS NFV-SOL 007. NOTE: Information about the applicable security option can be         obtained by evaluating the \&quot;archiveSecurityOption\&quot;         attribute in the \&quot;nsdInfo\&quot; structure.  This method shall follow the provisions specified in the T ables 5.4.4.3.2-1 and 5.4.4.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Shall be returned when the content of the NSD has been read successfully. The payload body shall contain a copy of the ZIP file that contains the NSD file structure. The \&quot;Content-Type\&quot; HTTP header shall be set to \&quot;application/zip\&quot;. 
     * <p><b>206</b> - 206 PARTIAL CONTENT 
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
     * @param nsdInfoId The nsdInfoId parameter
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param range The request may contain a \&quot;Range\&quot; HTTP header to obtain single range of bytes from the NSD archive. This can be used to continue an aborted transmission. If the Range header is present in the request and the NFVO does not support responding to range requests with a 206 response, it shall return a 200 OK response instead as defined below. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsDescriptorsNsdInfoIdNsdContentGet(String nsdInfoId, String version, String accept, String authorization, String range) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsdInfoId' is set
        if (nsdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsdInfoId' when calling nsDescriptorsNsdInfoIdNsdContentGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsNsdInfoIdNsdContentGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsDescriptorsNsdInfoIdNsdContentGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsdInfoId", nsdInfoId);
        String path = UriComponentsBuilder.fromPath("/ns_descriptors/{nsdInfoId}/nsd_content").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (range != null)
            headerParams.add("Range", apiClient.parameterToString(range));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Upload the content of a NSD.
     * The PUT method is used to upload the content of an NSD archive. The NSD to be uploaded is implemented as a single ZIP file as defined in clause 5.4.4.3.2. The \&quot;Content-Type\&quot; HTTP header in the PUT request shall be set to \&quot;application/zip\&quot;. This method shall follow the provisions specified in the Tables 5.4.4.3.3-1 and 5.4.4.3.3-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>202</b> - 202 ACCEPTED Shall be returned when the NSD archive has been accepted for uploading, but the processing has not been completed. It is expected to take some time for processing (asynchronous mode). The response body shall be empty. The API consumer can track the uploading progress by receiving the \&quot;NsdOnBoardingNotification\&quot; and \&quot;NsdOnBoardingFailureNotification\&quot; from the NFVO or by reading the status of the individual NS descriptor resource using the GET method. 
     * <p><b>204</b> - 204 NO CONTENT The NSD content successfully uploaded and validated (synchronous mode). The response body shall be empty. 
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
     * @param nsdInfoId The nsdInfoId parameter
     * @param version Version of the API requested to use when responding to this request. 
     * @param contentType The payload body contains a ZIP file that represents the NSD archive, as specified above. The request shall set the \&quot;Content-Type\&quot; HTTP header to \&quot;application/zip\&quot;. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsDescriptorsNsdInfoIdNsdContentPut(String nsdInfoId, String version, String contentType, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsdInfoId' is set
        if (nsdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsdInfoId' when calling nsDescriptorsNsdInfoIdNsdContentPut");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsNsdInfoIdNsdContentPut");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsDescriptorsNsdInfoIdNsdContentPut");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsdInfoId", nsdInfoId);
        String path = UriComponentsBuilder.fromPath("/ns_descriptors/{nsdInfoId}/nsd_content").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, hcontentType, authNames, returnType);
    }
    /**
     * 
     * The GET method reads the content of the NSD within an NSD archive. The NSD can be implemented as a single file or as a collection of multiple files. If the NSD is implemented in the form of multiple files, a ZIP file embedding these files shall be returned. If the NSD is implemented as a single file, either that file or a ZIP file embedding that file shall be returned. The selection of the format is controlled by the \&quot;Accept\&quot; HTTP header passed in the GET request: • If the \&quot;Accept\&quot; header contains only \&quot;text/plain\&quot; and the NSD is implemented as a single file,     the file shall be returned; otherwise, an error message shall be returned. • If the \&quot;Accept\&quot; header contains only \&quot;application/zip\&quot;, the single file or     the multiple files that make up the NSD shall be returned embedded in a ZIP file. • If the \&quot;Accept\&quot; header contains both \&quot;text/plain\&quot; and \&quot;application/zip\&quot;, it is up     to the NFVO to choose the format to return for a single-file NSD; for a multi-file NSD,     a ZIP file shall be returned. The default format of the ZIP file shall be the one specified in ETSI GS NFV-SOL 007 where only the YAML files representing the NSD, and information necessary to navigate the ZIP file and to identify the file that is the entry point for parsing the NSD and (if requested) further security information are included. This means that the content of the ZIP archive shall contain the following files from the NSD archive: • TOSCA.meta (if available in the NSD archive); • the main service template (either as referenced from TOSCA.meta or available as a     file with the extension \&quot;.yml\&quot; or \&quot;.yaml\&quot; from the root of the archive); • every component of the NSD referenced (recursively) from the main service template; • the related security information, if the \&quot;include_signatures\&quot; URI parameter is provided, as follows: - the manifest file; - the singleton certificate file in the root of the NSD archive (if available in the NSD archive); - the signing certificates of the individual files included in the ZIP archive     (if available in the NSD archive); - the signatures of the individual files (if available in the NSD archive). This method shall follow the provisions specified in the Tables 5.4.4a.3.2-1 and 5.4.4a.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Shall be returned when the content of the NSD has been read successfully. The payload body shall contain a copy of the file representing the NSD or a ZIP file that contains the file or multiple files representing the NSD, as specified above. The \&quot;Content-Type\&quot; HTTP header shall be set according to the format of the returned file. It shall be set to \&quot;text/plain\&quot; for a YAML file. 
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
     * @param nsdInfoId The nsdInfoId parameter
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept The request shall contain the appropriate entries in the \&quot;Accept\&quot; HTTP header as defined above. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param includeSignatures If this parameter is provided, the NFVO shall include in the ZIP file the security information as specified above. This URI query parameter is a flag, i.e. it shall have no value. The NFVO shall support this parameter. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void nsDescriptorsNsdInfoIdNsdGet(String nsdInfoId, String version, String accept, String authorization, String includeSignatures) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'nsdInfoId' is set
        if (nsdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsdInfoId' when calling nsDescriptorsNsdInfoIdNsdGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsNsdInfoIdNsdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsDescriptorsNsdInfoIdNsdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsdInfoId", nsdInfoId);
        String path = UriComponentsBuilder.fromPath("/ns_descriptors/{nsdInfoId}/nsd").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_signatures", includeSignatures));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Modify the operational state and/or the user defined data of an individual NS descriptor resource.
     * The PATCH method modifies the operational state and/or user defined data of an individual NS descriptor resource. This method can be used to: 1) Enable a previously disabled individual NS descriptor resource, allowing again its use for instantiation of new network service with this descriptor. The usage state (i.e. \&quot;IN_USE/NOT_IN_USE\&quot;) shall not change as a result. 2) Disable a previously enabled individual NS descriptor resource, preventing any further use for instantiation of new network service(s) with this descriptor. The usage state (i.e. \&quot;IN_USE/NOT_IN_USE\&quot;) shall not change as a result. 3) Modify the user defined data of an individual NS descriptor resource. 
     * <p><b>200</b> - 200 OK Shall be returned when the operation has been accepted and completed successfully. The response body shall contain attribute modifications for an &#x27;Individual NS Descriptor&#x27; resource (see clause 5.5.2.6). 
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
     * @param body The body parameter
     * @param version Version of the API requested to use when responding to this request. 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231. 
     * @param nsdInfoId Identifier of the individual NS descriptor resource. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return Body1
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Body1 nsDescriptorsNsdInfoIdPatch(Body1 body, String version, String contentType, String nsdInfoId, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsDescriptorsNsdInfoIdPatch");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsNsdInfoIdPatch");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsDescriptorsNsdInfoIdPatch");
        }
        // verify the required parameter 'nsdInfoId' is set
        if (nsdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'nsdInfoId' when calling nsDescriptorsNsdInfoIdPatch");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("nsdInfoId", nsdInfoId);
        String path = UriComponentsBuilder.fromPath("/ns_descriptors/{nsdInfoId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Body1> returnType = new ParameterizedTypeReference<Body1>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, accept, hcontentType, authNames, returnType);
    }
    /**
     * Create a new NS descriptor resource.
     * The POST method is used to create a new NS descriptor resource. 
     * <p><b>201</b> - 201 CREATED Shall be returned when a new \&quot;Individual NS descriptor\&quot; resource and the associated NS descriptor identifier has been created successfully. The response body shall contain a representation of the created NS descriptor  resource, as defined in clause 5.5.2.2. The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the created NS descriptor resource. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body The body parameter
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231. 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse201
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse201 nsDescriptorsPost(Body body, String version, String accept, String contentType, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling nsDescriptorsPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling nsDescriptorsPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling nsDescriptorsPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling nsDescriptorsPost");
        }
        String path = UriComponentsBuilder.fromPath("/ns_descriptors").build().toUriString();
        
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse201> returnType = new ParameterizedTypeReference<InlineResponse201>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, haccept, hcontentType, authNames, returnType);
    }
    /**
     * Query information about multiple PNF descriptor resources.
     * \&quot;The GET method queries information about multiple PNF descriptor resources.\&quot; 
     * <p><b>200</b> - 200 OK Shall be returned when information about zero or more PNF descriptors has been queried successfully. The response body shall contain in an array the representations of zero or more PNF descriptors, as defined in clause 5.5.2.5. If the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV-SOL 013. 
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
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param filter Attribute-based filtering expression according to clause 5.2 of ETSI GS NFV-SOL 013. The NFVO shall support receiving this filtering parameter as part of the URI query string. The OSS/BSS may supply this parameter. All attribute names that appear in the PnfdInfo and in data types referenced from it shall be supported by the NFVO in the filter expression. 
     * @param allFields Include all complex attributes in the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO shall support this parameter. 
     * @param fields Complex attributes to be included into the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO should support this parameter. 
     * @param excludeFields Complex attributes to be excluded from the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO should support this parameter. 
     * @param excludeDefault Indicates to exclude the following complex attributes from the response. See clause 5.3 of ETSI GS NFV-SOL 013 for details. The NFVO shall support this parameter. The following attributes shall be excluded from the PnfdInfo structure in the response body if this parameter is provided, or none of the parameters \&quot;all_fields,\&quot; \&quot;fields\&quot;, \&quot;exclude_fields\&quot;, \&quot;exclude_default\&quot; are provided: - userDefinedData - onboardingFailureDetails 
     * @param nextpageOpaqueMarker Marker to obtain the next page of a paged response. Shall be supported by the NFVO if the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV SOL 013 for this resource. 
     * @return List&lt;InlineResponse2002&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2002> pnfDescriptorsGet(String version, String authorization, String filter, String allFields, String fields, String excludeFields, String excludeDefault, String nextpageOpaqueMarker) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling pnfDescriptorsGet");
        }
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors").build().toUriString();
        
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

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse2002>> returnType = new ParameterizedTypeReference<List<InlineResponse2002>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete an individual PNF descriptor resource.
     * The DELETE method deletes an individual PNF descriptor resource. An individual PNF descriptor resource can only be deleted when t here is no NS instance using it or there is NSD referencing it. To delete all PNFD versions identified by a particular value of the \&quot;pnfdInvariantId\&quot; attribute, the procedure is to first use t he GET method with filter \&quot;pnfdInvariantId\&quot; towards the PNF descriptors resource to find all versions of the PNFD. Then, he API consumer uses the DELETE method described in this clause to delete each PNFD version individually. This method shall follow the provisions specified in the Tables 5.4.6.3.5-1 and 5.4.6.3.5-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>204</b> - 204 NO CONTENT Shall be returned when the operation has completed successfully. The response body shall be empty. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param pnfdInfoId Identifier of the individual PNF descriptor resource. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void pnfDescriptorsPnfdInfoIdDelete(String pnfdInfoId) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'pnfdInfoId' is set
        if (pnfdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pnfdInfoId' when calling pnfDescriptorsPnfdInfoIdDelete");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("pnfdInfoId", pnfdInfoId);
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors/{pnfdInfoId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

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
     * Read an individual PNFD resource.
     * The GET method reads information about an individual PNF descriptor. 
     * <p><b>200</b> - 200 OK Shall be returned when information about the individual PNFD descriptor has been read successfully. The response body shall contain a representation of the individual PNF descriptor, as defined in clause 5.5.2.5. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param pnfdInfoId Identifier of the individual PNF descriptor resource. 
     * @param accept Content-Types that are acceptable for the response. This header field shall be present if the response is expected to have a non-empty message body. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Details are specified in clause 4.5.3 of GS NFV-SOL 005. 
     * @return InlineResponse2011
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2011 pnfDescriptorsPnfdInfoIdGet(String pnfdInfoId, String accept, String version, String authorization) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'pnfdInfoId' is set
        if (pnfdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pnfdInfoId' when calling pnfDescriptorsPnfdInfoIdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling pnfDescriptorsPnfdInfoIdGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling pnfDescriptorsPnfdInfoIdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("pnfdInfoId", pnfdInfoId);
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors/{pnfdInfoId}").buildAndExpand(uriVariables).toUriString();
        
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2011> returnType = new ParameterizedTypeReference<InlineResponse2011>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
            }
    /**
     * 
     * The GET method reads the content of the manifest file within a PNFD archive. This method shall follow the provisions specified in the Tables 5.4.7b.3.2-1 and 5.4.7b.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - Shall be returned when the content of the manifest file has been read successfully. If the \&quot;include_signatures\&quot; URI query parameter was absent in the request, or if the manifest file has all security-related information embedded (i.e. there is no separate certificate file), the payload body shall contain a copy of the manifest file of the PNFD archive, and the \&quot;Content-Type\&quot; HTTP header shall be set to \&quot;text/plain\&quot;. If the \&quot;include_signatures\&quot; URI query parameter was present in the related request and the manifest file does not have all the security-related information embedded (i.e. there is a separate certificate file), the \&quot;Content-Type\&quot; HTTP header shall be set to \&quot;application/zip\&quot; and the payload body shall contain a ZIP archive which includes: - a copy of the manifest file of the PNFD archive; - a copy of the related individual certificate file. 
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
     * @param pnfdInfoId Identifier of the individual PNF descriptor. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new PNF descriptor resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @param includeSignatures If this parameter is provided, the NFVO shall return the manifest and related security information (signature and certificate) either in a single text file if the signature and certificate are included in the manifest file, or in a zip file containing the manifest and the certificate file, if this is provided as a separate file in the PNFD archive. If this parameter is not given, the NFVO shall provide only a copy of the manifest file, as onboarded. If the security information is included in the onboarded manifest, it shall also be included in the returned copy. This URI query parameter is a flag, i.e. it shall have no value. The NFVO shall support this parameter. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void pnfDescriptorsPnfdInfoIdManifestGet(String pnfdInfoId, String version, String accept, String authorization, String includeSignatures) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'pnfdInfoId' is set
        if (pnfdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pnfdInfoId' when calling pnfDescriptorsPnfdInfoIdManifestGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling pnfDescriptorsPnfdInfoIdManifestGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling pnfDescriptorsPnfdInfoIdManifestGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("pnfdInfoId", pnfdInfoId);
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors/{pnfdInfoId}/manifest").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_signatures", includeSignatures));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Modify the user defined data of an individual PNF descriptor resource.
     * The PATCH method modifies the user defined data of an individual PNF descriptor resource. 
     * <p><b>200</b> - 200 OK Shall be returned when the operation has been accepted and completed successfully. The response body shall contain attribute modifications for an &#x27;Individual PNF Descriptor&#x27; resource (see clause 5.5.2.4). 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>412</b> - 412 PRECONDITION FAILED Error: A precondition given in an HTTP request header is not fulfilled. Typically, this is due to an ETag mismatch, indicating that the resource was modified by another entity. The response body should contain a ProblemDetails structure, in which the \&quot;detail\&quot; attribute should convey more information about the error. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body The body parameter
     * @param accept Content-Types that are acceptable for the response. This header field shall be present if the response is expected to have a non-empty message body. 
     * @param contentType The MIME type of the body of the request. This header field shall be present if the request has a non-empty message body. 
     * @param pnfdInfoId Identifier of the individual PNF descriptor resource. 
     * @return Body3
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Body3 pnfDescriptorsPnfdInfoIdPatch(Body3 body, String accept, String contentType, String pnfdInfoId) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling pnfDescriptorsPnfdInfoIdPatch");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling pnfDescriptorsPnfdInfoIdPatch");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling pnfDescriptorsPnfdInfoIdPatch");
        }
        // verify the required parameter 'pnfdInfoId' is set
        if (pnfdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pnfdInfoId' when calling pnfDescriptorsPnfdInfoIdPatch");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("pnfdInfoId", pnfdInfoId);
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors/{pnfdInfoId}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (contentType != null)
            headerParams.add("Content-Type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Body3> returnType = new ParameterizedTypeReference<Body3>() {};
        return apiClient.invokeAPI(path, HttpMethod.PATCH, queryParams, postBody, headerParams, formParams, haccept, hcontentType, authNames, returnType);
    }
    /**
     * Fetch the content of a PNFD.
     * The GET method fetches the content of the PNFD archive. The content of the PNFD archive is provided as onboarded, i.e. depending on the security option used, the CSAR or the CSAR wrapped in a ZIP archive together with an external signature is returned, as defined in clause 5.1 of ETSI GS NFV-SOL 004. NOTE: Information about the applicable security option can be obtained by evaluating the \&quot;archiveSecurityOption\&quot; attribute in the \&quot;pnfdInfo\&quot; structure. This method shall follow the provisions specified in the Tables 5.4.7.3.2-1 and 5.4.7.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Shall be returned when the content of the PNFD archive has been read successfully. The payload body shall contain a copy of the PNFD archive The \&quot;Content-Type\&quot; HTTP header shall be set to \&quot;application/zip\&quot;. 
     * <p><b>206</b> - 206 PARTIAL CONTENT If the NFVO supports range requests, this response shall be returned when a single consecutive byte range from the content of the PNFD archive has been read successfully according to the request. The response body shall contain the requested part of the PNFD archive. The \&quot;Content-Range\&quot; HTTP header shall be provided according to IETF RFC 7233. The \&quot;Content-Type\&quot; HTTP header shall be set as defined above for the \&quot;200 OK\&quot; response. 
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
     * @param pnfdInfoId Identifier of the individual PNF descriptor. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new PNF descriptor resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @param range The request may contain a \&quot;Range\&quot; HTTP header to obtain single range of bytes from the PNFD archive. This can be used to continue an aborted transmission. If the NFVO does not support range requests, the NFVO shall ignore the \&quot;Range\&quot; header, process the GET request, and return the whole PNFD archive with a 200 OK response (rather than returning a 4xx error status code). 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void pnfDescriptorsPnfdInfoIdPnfdContentGet(String pnfdInfoId, String version, String accept, String authorization, String range) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'pnfdInfoId' is set
        if (pnfdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pnfdInfoId' when calling pnfDescriptorsPnfdInfoIdPnfdContentGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling pnfDescriptorsPnfdInfoIdPnfdContentGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling pnfDescriptorsPnfdInfoIdPnfdContentGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("pnfdInfoId", pnfdInfoId);
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors/{pnfdInfoId}/pnfd_content").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (range != null)
            headerParams.add("Range", apiClient.parameterToString(range));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Upload the content of a PNFD.
     * The PUT method is used to upload the content of a PNFD archive. This resource represents the content of the individual PNF descriptor, i.e. PNFD content.  The client can use this resource to upload and download the content of the PNFD.         
     * <p><b>202</b> - 202 ACCEPTED Shall be returned when the PNFD archive has been accepted for uploading, but the processing has not been completed. It is expected to take some time for processing (asynchronous mode). The response body shall be empty. The API consumer can track the uploading progress by receiving the \&quot;PnfdOnBoardingNotification\&quot; and \&quot;PnfdOnBoardingFailureNotification\&quot; from the NFVO or by reading the status of the individual PNF descriptor resource using the GET method. 
     * <p><b>204</b> - 204 NO CONTENT Shall be returned when the PNFD archive content has been uploaded and validated successfully. The response body shall be empty. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>409</b> - 409 CONFLICT 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * @param pnfdInfoId Identifier of the individual PNF descriptor. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new PNF descriptor resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @param contentType The request shall set the \&quot;Content-Type\&quot; HTTP header to \&quot;application/zip\&quot;. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void pnfDescriptorsPnfdInfoIdPnfdContentPut(String pnfdInfoId, String version, String accept, String authorization, String contentType) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'pnfdInfoId' is set
        if (pnfdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pnfdInfoId' when calling pnfDescriptorsPnfdInfoIdPnfdContentPut");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling pnfDescriptorsPnfdInfoIdPnfdContentPut");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling pnfDescriptorsPnfdInfoIdPnfdContentPut");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("pnfdInfoId", pnfdInfoId);
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors/{pnfdInfoId}/pnfd_content").buildAndExpand(uriVariables).toUriString();
        
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
            headerParams.add("Content-type", apiClient.parameterToString(contentType));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, haccept, hcontentType, authNames, returnType);
    }
    /**
     * 
     * The GET method reads the content of the PNFD within a PNFD archive. The PNFD can be implemented as a single file or as a collection of multiple files. If the PNFD is implemented in the form of multiple files, a ZIP file embedding these files shall be returned. If the PNFD is implemented as a single file, either that file or a ZIP file embedding that file shall be returned. The selection of the format is controlled by the \&quot;Accept\&quot; HTTP header passed in the GET request: • If the \&quot;Accept\&quot; header contains only \&quot;text/plain\&quot; and the PNFD is     implemented as a single file, the file shall be returned; otherwise,     an error message shall be returned. • If the \&quot;Accept\&quot; header contains only \&quot;application/zip\&quot;, the single     file or the multiple files that make up the PNFD shall be returned     embedded in a ZIP file. • If the \&quot;Accept\&quot; header contains both \&quot;text/plain\&quot; and \&quot;application/zip\&quot;,     it is up to the NFVO to choose the format to return for a single-file PNFD;     for a multi-file PNFD, a ZIP file shall be returned. The default format of the ZIP file shall be the one specified in ETSI GS NFV-SOL 004 where only the YAML files representing the PNFD, and information necessary to navigate the ZIP file and to identify the file that is the entry point for parsing the PNFD and (if requested) further security information are included. This means that the content of the ZIP archive shall contain the following files from the PNFD archive: • TOSCA.meta (if available in the PNFD archive); • the main service template (either as referenced from TOSCA.meta or     available as a file with the extension \&quot;.yml\&quot; or \&quot;.yaml\&quot; from the     root of the archive); • every component of the PNFD referenced (recursively) from the main     service template; • the related security information, if the \&quot;include_signatures\&quot; URI     parameter is provided, as follows:     - the manifest file;     - the singleton certificate file in the root of the PNFD archive         (if available in the PNFD archive);     - the signing certificates of the individual files included in the         ZIP archive (if available in the PNFD archive);     - the signatures of the individual files (if available in the PNFD archive). This method shall follow the provisions specified in the Tables 5.4.7a.3.2-1 and 5.4.7a.3.2-2 for URI query parameters, request and response data structures, and response codes. 
     * <p><b>200</b> - 200 OK Shall be returned when the content of the PNFD has been read successfully. The payload body shall contain a copy of the file representing the PNFD or a ZIP file that contains the file or multiple files representing the PNFD, as specified above. The \&quot;Content-Type\&quot; HTTP header shall be set according to the format of the returned file. It shall be set to \&quot;text/plain\&quot; for a YAML file. 
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
     * @param pnfdInfoId Identifier of the individual PNF descriptor. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new PNF descriptor resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235 
     * @param range The request may contain a \&quot;Range\&quot; HTTP header to obtain single range of bytes from the PNFD archive. This can be used to continue an aborted transmission. If the NFVO does not support range requests, the NFVO shall ignore the \&quot;Range\&quot; header, process the GET request, and return the whole PNFD archive with a 200 OK response (rather than returning a 4xx error status code). 
     * @param includeSignatures If this parameter is provided, the NFVO shall include in the ZIP file the security information as specified above. This URI query parameter is a flag, i.e. it shall have no value. The NFVO shall support this parameter. 
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void pnfDescriptorsPnfdInfoIdPnfdGet(String pnfdInfoId, String version, String accept, String authorization, String range, String includeSignatures) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'pnfdInfoId' is set
        if (pnfdInfoId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'pnfdInfoId' when calling pnfDescriptorsPnfdInfoIdPnfdGet");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling pnfDescriptorsPnfdInfoIdPnfdGet");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling pnfDescriptorsPnfdInfoIdPnfdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("pnfdInfoId", pnfdInfoId);
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors/{pnfdInfoId}/pnfd").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "include_signatures", includeSignatures));
        if (authorization != null)
            headerParams.add("Authorization", apiClient.parameterToString(authorization));
        if (version != null)
            headerParams.add("Version", apiClient.parameterToString(version));
        if (accept != null)
            headerParams.add("Accept", apiClient.parameterToString(accept));
        if (range != null)
            headerParams.add("Range", apiClient.parameterToString(range));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {};
        apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Create a new PNF descriptor resource.
     * The POST method is used to create a new PNF descriptor resource 
     * <p><b>201</b> - 201 CREATED Shall be returned when a new \&quot;Individual PNF descriptor\&quot; resource and the associated PNF descriptor identifier has been created successfully. The response body shall contain a representation of the  created PNF descriptor resource, as defined in clause 5.5.2.5. The HTTP response shall include a \&quot;Location\&quot; HTTP header that contains the resource URI of the created PNF descriptor resource. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param body The body parameter
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231. 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse2011
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2011 pnfDescriptorsPost(Body2 body, String version, String accept, String contentType, String authorization) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling pnfDescriptorsPost");
        }
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'version' when calling pnfDescriptorsPost");
        }
        // verify the required parameter 'accept' is set
        if (accept == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'accept' when calling pnfDescriptorsPost");
        }
        // verify the required parameter 'contentType' is set
        if (contentType == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'contentType' when calling pnfDescriptorsPost");
        }
        String path = UriComponentsBuilder.fromPath("/pnf_descriptors").build().toUriString();
        
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2011> returnType = new ParameterizedTypeReference<InlineResponse2011>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, haccept, hcontentType, authNames, returnType);
    }
    /**
     * Query multiple subscriptions.
     * TThe GET method queries the list of active subscriptions of the functional block that invokes the method. It can be used e.g. for resynchronization after error situations. This method shall support the URI query parameters, request and response data structures, and response codes, as specified in the Tables 5.4.8.3.2-1 and 5.4.8.3.2-2. 
     * <p><b>200</b> - 200 OK Shall be returned when the list of subscriptions has been queried successfully. The response body shall contain in an array the representations of all active subscriptions of the functional block that invokes the method, i.e. zero or more representations of NSD management subscriptions as defined in clause 5.5.2.8. If the \&quot;filter\&quot; URI parameter was supplied in the request, the data in the response body shall have been transformed according to the rules specified in clause 5.2.2 of ETSI GS NFV-SOL 013. If the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV SOL 013 for this resource, inclusion of the Link HTTP header in this response shall follow the provisions in clause 5.4.2.3 of ETSI GS NFV SOL 013. 
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
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @param filter AAttribute filtering expression according to clause 5.2 of ETSI GS NFV SOL 013. The NFVO shall support receiving this parameter as part of the URI query string. the OSS/BSS may supply this parameter. All attribute names that appear in the NsdmSubscription and in data types referenced from it shall be supported by the NFVO in the filter expression. 
     * @param nextpageOpaqueMarker Marker to obtain the next page of a paged response. Shall be supported by the NFVO if the NFVO supports alternative 2 (paging) according to clause 5.4.2.1 of ETSI GS NFV-SOL 013 for this resource. 
     * @return List&lt;InlineResponse2003&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<InlineResponse2003> subscriptionsGet(String version, String accept, String authorization, String filter, String nextpageOpaqueMarker) throws RestClientException {
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<InlineResponse2003>> returnType = new ParameterizedTypeReference<List<InlineResponse2003>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
    /**
     * Subscribe to NSD and PNFD change notifications.
     * The POST method creates a new subscription. This method shall support the URI query parameters, request and response data structures, and response codes, as specified in the Tables 5.4.8.3.1-1 and 5.4.8.3.1-2. Creation of two subscription resources with the same callback URI and the same filter can result in performance degradation and will provide duplicates of notifications to the OSS, and might make sense only in very rare use cases. Consequently, the NFVO may either allow creating a subscription resource if another subscription resource with the same filter and callback URI already exists (in which case it shall return the \&quot;201 Created\&quot; response code), or may decide to not create a duplicate subscription resource (in which case it shall return a \&quot;303 See Other\&quot; response code referencing the existing subscription resource with the same filter and callbackUricallback URI). 
     * <p><b>201</b> - 201 CREATED Shall be returned when the subscription has been created successfully. A representation of the created \&quot;Individual subscription\&quot; resource shall be returned in the response body, as defined in clause 5.5.2.8. The HTTP response shall include a \&quot;Location:\&quot; HTTP header that points to the created \&quot;Individual subscription\&quot; resource. 
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
     * @param body The body parameter
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. Reference: IETF RFC 7231. 
     * @param contentType The MIME type of the body of the request. Reference: IETF RFC 7231. 
     * @param authorization The authorization token for the request. Reference: IETF RFC 7235. 
     * @return InlineResponse2012
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2012 subscriptionsPost(Body4 body, String version, String accept, String contentType, String authorization) throws RestClientException {
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType hcontentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2012> returnType = new ParameterizedTypeReference<InlineResponse2012>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, haccept, hcontentType, authNames, returnType);
    }
    /**
     * Terminate Subscription
     * This resource represents an individual subscription.  It can be used by the client to read and to terminate a subscription to notifications related to NSD management. The DELETE method terminates an individual subscription. This method shall support the URI query parameters, request and  response data structures, and response codes, as specified in the Table 5.4.9.3.3-2.       
     * <p><b>204</b> - 204 NO CONTENT Shall be returned when the \&quot;Individual subscription\&quot; resource has been deleted successfully. The response body shall be empty. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param subscriptionId Identifier of this subscription. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new subscription resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param authorization The authorization token for the request. Details are specified in clause 4.5.3 of GS NFV-SOL 005. 
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
     * This resource represents an individual subscription.  It can be used by the client to read and to terminate a subscription to notifications related to NSD management. The GET method retrieves information about a subscription by reading an individual subscription resource.  This resource represents an individual subscription.  It can be used by the client to read and to terminate a subscription to notifications related to NSD management. 
     * <p><b>200</b> - 200 OK Shall be returned when information about an individual subscription has been read successfully. The response body shall contain a representation of the subscription resource. 
     * <p><b>400</b> - 400 BAD REQUEST 400 code can be returned in the following specified cases, the specific cause has to be proper specified in the \&quot;ProblemDetails\&quot; structure to be returned. If the request is malformed or syntactically incorrect (e.g. if the request URI contains incorrect query parameters or the payload body contains a syntactically incorrect data structure), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the response to a GET request which queries a container resource would be so big that the performance of the API producer is adversely affected, and the API producer does not support paging for the affected resource, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and should include in the \&quot;detail\&quot; attribute more information about the source of the problem. If there is an application error related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. If the request contains a malformed access token, the API producer should respond with this response. The details of the error shall be returned in the WWW Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. The use of this HTTP error response code described above is applicable to the use of the OAuth 2.0 for the authorization of API requests and notifications, as defined in clauses 4.5.3.3 and 4.5.3.4. 
     * <p><b>401</b> - 401 UNAUTHORIZED If the request contains no access token even though one is required, or if the request contains an authorization token that is invalid (e.g. expired or revoked), the API producer should respond with this response. The details of the error shall be returned in the WWW-Authenticate HTTP header, as defined in IETF RFC 6750 and IETF RFC 7235. The ProblemDetails structure may be provided. 
     * <p><b>403</b> - 403 FORBIDDEN If the API consumer is not allowed to perform a particular request to a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided. It should include in the \&quot;detail\&quot; attribute information about the source of the problem, and may indicate how to solve it. 
     * <p><b>404</b> - 404 NOT FOUND If the API producer did not find a current representation for the resource addressed by the URI passed in the request or is not willing to disclose that one exists, it shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be provided, including in the \&quot;detail\&quot; attribute information about the source of the problem, e.g. a wrong resource URI variable. This response code is not appropriate in case the resource addressed by the URI is a container resource which is designed to contain child resources, but does not contain any child resource at the time the request is received. For a GET request to an existing empty container resource, a typical response contains a 200 OK response code and a payload body with an empty array. 
     * <p><b>405</b> - 405 METHOD NOT ALLOWED If a particular HTTP method is not supported for a particular resource, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>406</b> - 406 NOT ACCEPTABLE If the \&quot;Accept\&quot; header does not contain at least one name of a content type that is acceptable to the API producer, the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>500</b> - 500 INTERNAL SERVER ERROR If there is an application error not related to the client&#x27;s input that cannot be easily mapped to any other HTTP response code (\&quot;catch all error\&quot;), the API producer shall respond with this response code. The \&quot;ProblemDetails\&quot; structure shall be provided, and shall include in the \&quot;detail\&quot; attribute more information about the source of the problem. 
     * <p><b>503</b> - 503 SERVICE UNAVAILABLE If the API producer encounters an internal overload situation of itself or of a system it relies on, it should respond with this response code, following the provisions in IETF RFC 7231 for the use of the \&quot;Retry-After\&quot; HTTP header and for the alternative to refuse the connection. The \&quot;ProblemDetails\&quot; structure may be omitted. 
     * <p><b>504</b> - 504 GATEWAY TIMEOUT If the API producer encounters a timeout while waiting for a response from an upstream server (i.e. a server that the API producer communicates with when fulfilling a request), it should respond with this response code. 
     * @param subscriptionId Identifier of this subscription. This identifier can be retrieved from the resource referenced by the \&quot;Location\&quot; HTTP header in the response to a POST request creating a new subscription resource. It can also be retrieved from the \&quot;id\&quot; attribute in the payload body of that response. 
     * @param version Version of the API requested to use when responding to this request. 
     * @param accept Content-Types that are acceptable for the response. This header field shall be present if the response is expected to have a non-empty message body. 
     * @param authorization The authorization token for the request. Details are specified in clause 4.5.3 of GS NFV-SOL 005. 
     * @return InlineResponse2012
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public InlineResponse2012 subscriptionsSubscriptionIdGet(String subscriptionId, String version, String accept, String authorization) throws RestClientException {
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
        final List<MediaType> haccept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<InlineResponse2012> returnType = new ParameterizedTypeReference<InlineResponse2012>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, haccept, contentType, authNames, returnType);
    }
}
