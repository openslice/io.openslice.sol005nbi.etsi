/*-
 * ========================LICENSE_START=================================
 * io.openslice.sol005nbi.etsi
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

/**
 * @author Ioannis Chatzis
 * 
 * Describes a MANO provider that can be accessed via an API
 *
 */

package io.openslice.sol005nbi.etsi;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.openslice.sol005nbi.OSMClient;
import io.openslice.sol005nbi.api.nsd.NsdApiClient;
import io.openslice.sol005nbi.api.nsd.NsdDefaultApi;
import io.openslice.sol005nbi.api.nslcm.NslcmClient;
import io.openslice.sol005nbi.api.nslcm.NslcmDefaultApi;
import io.openslice.sol005nbi.api.vnf.VnfPkgmApi;
import io.openslice.sol005nbi.model.nsd.CreateΝsDescriptorBody;
import io.openslice.sol005nbi.model.nslcm.InstantiateNsRequest;
import io.openslice.sol005nbi.model.nslcm.CreateNsRequest;
import io.openslice.sol005nbi.model.vnf.CreateVnfPkgInfoRequestBody;
import io.openslice.sol005nbi.model.vnf.VnfPackagesCreateVnfPkgInfoRequest;
import io.openslice.sol005nbi.model.vnf.VnfPackagesVnfPkgInfo;

public class GenericSOL005Client implements OSMClient {

	private static final Logger logger = LogManager.getLogger(GenericSOL005Client.class);

	private CloseableHttpClient httpClient;
	private String manoProjectId;
	private String manoUsername;
	private String manoPassword;
	private HttpComponentsClientHttpRequestFactory requestFactory;
	private String manoApiEndpoint = null;
	private String manoAuthorizationBasicHeader = null;
	private static Double manoAuthorizationTokenTimeout = 1.0;
	private static String manoAuthorizationTokenID = null;

	private VnfPkgmApi vnfPkgmApi;
	NsdDefaultApi defaultApitNsdApi;

	NslcmDefaultApi defaultNslcmDefaultApi;

	private String tokenEndPoint;

	public static void main(String args[]) {
		System.out.println("Make your calls here");
	}

	public GenericSOL005Client(String apiEndpoint, String username, String password, String project_id,
			String atokenEndPoint, String abaseBath) throws HttpStatusCodeException {
		this.setMANOPassword(password);
		this.setMANOUsername(username);
		this.setMANOProjectId(project_id);
		this.setMANOApiEndpoint(apiEndpoint);

		this.tokenEndPoint = atokenEndPoint;//

		OSM7ClientInit();

		io.openslice.sol005nbi.api.vnf.VnfApiClient apiClientVnfPkgmApi = new io.openslice.sol005nbi.api.vnf.VnfApiClient(
				abaseBath);
		apiClientVnfPkgmApi.setBasePath("https://10.10.10.37:9999/osm/" + apiClientVnfPkgmApi.getBasePath());
		io.openslice.sol005nbi.auth.OAuth bAuth2 = (io.openslice.sol005nbi.auth.OAuth) apiClientVnfPkgmApi
				.getAuthentication("bearerAuth");
		bAuth2.setAccessToken(this.getManoAuthorizationTokenID());

		this.vnfPkgmApi = new VnfPkgmApi(apiClientVnfPkgmApi);

		io.openslice.sol005nbi.api.nsd.NsdApiClient apiClientNsdApi = new io.openslice.sol005nbi.api.nsd.NsdApiClient();
		apiClientNsdApi.setBasePath("https://10.10.10.37:9999/osm/" + apiClientNsdApi.getBasePath());
		io.openslice.sol005nbi.auth.OAuth bAuth2nsd = (io.openslice.sol005nbi.auth.OAuth) apiClientNsdApi
				.getAuthentication("bearerAuth");
		bAuth2nsd.setAccessToken(this.getManoAuthorizationTokenID());
		this.defaultApitNsdApi = new io.openslice.sol005nbi.api.nsd.NsdDefaultApi(apiClientNsdApi);

		NslcmClient aNslcmClient = new NslcmClient();
		aNslcmClient.setBasePath("https://10.10.10.37:9999/osm/" + aNslcmClient.getBasePath());
		io.openslice.sol005nbi.auth.OAuth bAuth2nsl = (io.openslice.sol005nbi.auth.OAuth) aNslcmClient
				.getAuthentication("bearerAuth");
		bAuth2nsl.setAccessToken(this.getManoAuthorizationTokenID());

		this.defaultNslcmDefaultApi = new NslcmDefaultApi(aNslcmClient);
	}

	public void closeConn() {
		try {
			this.httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.requestFactory.destroy();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void OSM7ClientInit() throws HttpStatusCodeException {
		this.authenticateMANO();

		// use the TrustSelfSignedStrategy to allow Self Signed Certificates
		SSLContext sslContext;
		try {
			sslContext = SSLContextBuilder.create().loadTrustMaterial(new TrustSelfSignedStrategy()).build();
			// we can optionally disable hostname verification.
			// if you don't want to further weaken the security, you don't have to include
			// this.
			HostnameVerifier allowAllHosts = new NoopHostnameVerifier();

			// create an SSL Socket Factory to use the SSLContext with the trust self signed
			// certificate strategy
			// and allow all hosts verifier.
			SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);

			httpClient = HttpClients.custom().setSSLSocketFactory(connectionFactory)
					.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
					.build();
			requestFactory = new HttpComponentsClientHttpRequestFactory();
			requestFactory.setHttpClient(httpClient);

		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResponseEntity<String> getOSMResponse(String reqURL) {
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "application/json");
		headers.add("accept", "application/json");
		headers.add("Authorization", "Bearer " + this.getMANOAuthorizationBasicHeader());
		HttpEntity<String> request = new HttpEntity<String>(headers);
		ResponseEntity<String> entity = null;
		try {
			entity = restTemplate.exchange(this.getMANOApiEndpoint() + reqURL, HttpMethod.GET, request, String.class);
		} catch (final HttpClientErrorException e) {
			entity = ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
			System.out.println(e.getStatusCode());
			System.out.println(e.getResponseBodyAsString());
		}
		return entity;
	}

	public void authenticateMANO() throws HttpStatusCodeException {
//		if(OSM7Client.getManoAuthorizationTokenTimeout()>Instant.now().getEpochSecond()+120)
//		{
//	        System.out.println(OSM7Client.getManoAuthorizationTokenTimeout()+">"+Instant.now().getEpochSecond()+"+120");
//	        this.setÃŽÅ“ÃŽâ€˜ÃŽï¿½ÃŽÅ¸AuthorizationBasicHeader(OSM7Client.getManoAuthorizationTokenID());	
//	        System.out.println("Valid Key, skipping new authentication");
//	        return;
//		}

		// use the TrustSelfSignedStrategy to allow Self Signed Certificates
		SSLContext sslContext;
		try {
			sslContext = SSLContextBuilder.create().loadTrustMaterial(new TrustSelfSignedStrategy()).build();
			// we can optionally disable hostname verification.
			// if you don't want to further weaken the security, you don't have to include
			// this.
			HostnameVerifier allowAllHosts = new NoopHostnameVerifier();

			// create an SSL Socket Factory to use the SSLContext with the trust self signed
			// certificate strategy
			// and allow all hosts verifier.
			SSLConnectionSocketFactory connectionFactory = new SSLConnectionSocketFactory(sslContext, allowAllHosts);

			httpClient = HttpClients.custom().setSSLSocketFactory(connectionFactory)
					.setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
					.build();
			requestFactory = new HttpComponentsClientHttpRequestFactory();

			// Get the token
			requestFactory.setHttpClient(httpClient);
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RestTemplate restTemplate = new RestTemplate(requestFactory);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", "application/json");
		headers.add("accept", "application/json");
		String body = "{\"password\": \"" + this.getMANOPassword() + "\", \"username\": \"" + this.getMANOUsername()
				+ "\", \"project_id\": \"" + this.getMANOProjectId() + "\"}";
		HttpEntity<String> request = new HttpEntity<String>(body, headers);
		System.out.println(request.toString());
		ResponseEntity<String> entity = null;
		entity = restTemplate.exchange(tokenEndPoint, HttpMethod.POST, request, String.class);
		System.out.printf(entity.getHeaders().toString());
		System.out.printf(entity.getBody());
		System.out.printf(entity.toString());

		JSONObject obj = new JSONObject(entity.getBody());
		this.setΜΑΝΟAuthorizationBasicHeader(obj.getString("id"));
		GenericSOL005Client.setManoAuthorizationTokenTimeout(obj.getDouble("expires"));
		GenericSOL005Client.setManoAuthorizationTokenID(obj.getString("id"));
		try {
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getManoAuthorizationTokenID() {
		// TODO Auto-generated method stub
		return GenericSOL005Client.manoAuthorizationTokenID;
	}

	private static void setManoAuthorizationTokenID(String tokenID) {
		// TODO Auto-generated method stub
		GenericSOL005Client.manoAuthorizationTokenID = tokenID;
	}

	public String getMANOApiEndpoint() {
		return manoApiEndpoint;
	}

	public void setMANOApiEndpoint(String apiEndpoint) {
		this.manoApiEndpoint = apiEndpoint;
	}

	/**
	 * @return the project_id
	 */
	public String getMANOProjectId() {
		return manoProjectId;
	}

	/**
	 * @param project_id the project_id to set
	 */
	public void setMANOProjectId(String project_id) {
		this.manoProjectId = project_id;
	}

	/**
	 * @return the username
	 */
	private String getMANOUsername() {
		return manoUsername;
	}

	/**
	 * @param username the username to set
	 */
	public void setMANOUsername(String username) {
		this.manoUsername = username;
	}

	/**
	 * @return the password
	 */
	private String getMANOPassword() {
		return manoPassword;
	}

	/**
	 * @param password the password to set
	 */
	public void setMANOPassword(String password) {
		this.manoPassword = password;
	}

	public String getMANOAuthorizationBasicHeader() {
		return manoAuthorizationBasicHeader;
	}

	public void setΜΑΝΟAuthorizationBasicHeader(String authorizationBasicHeader) {
		this.manoAuthorizationBasicHeader = authorizationBasicHeader;
	}

	/**
	 * @return the manoAuthorizationTokenTimeout
	 */
	public static Double getManoAuthorizationTokenTimeout() {
		return manoAuthorizationTokenTimeout;
	}

	/**
	 * @param manoAuthorizationTokenTimeout the manoAuthorizationTokenTimeout to set
	 */
	public static void setManoAuthorizationTokenTimeout(double manoAuthorizationTokenTimeout) {
		GenericSOL005Client.manoAuthorizationTokenTimeout = manoAuthorizationTokenTimeout;
	}

	@Override
	public ResponseEntity<String> createVNFDPackage() {

		CreateVnfPkgInfoRequestBody body = new CreateVnfPkgInfoRequestBody();
		VnfPackagesCreateVnfPkgInfoRequest createVnfPkgInfoRequest = new VnfPackagesCreateVnfPkgInfoRequest();
		body.createVnfPkgInfoRequest(createVnfPkgInfoRequest);
		ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
		};
		ResponseEntity<String> resultvnf = vnfPkgmApi.vnfPackagesPostResult(body, "application/json",
				"application/json", null, returnType);

		return resultvnf;
	}

	@Override
	public ResponseEntity<String> uploadVNFDPackageContent(String vnfd_id, byte[] allBytes) throws IOException {
		String vnfPkgId = vnfd_id;
		ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
		};
		return vnfPkgmApi.vnfPackagesVnfPkgIdPackageContentPutResult("application/json", vnfPkgId, null, allBytes,
				"application/zip", null, returnType);

	}

	@Override
	public ResponseEntity<String> uploadVNFDPackageContent(String vnfd_id, String pLocation) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> getVNFInstanceInfoNew(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteVNFDPackage(String vnfd_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> createNSDPackage() {

		CreateΝsDescriptorBody body = new CreateΝsDescriptorBody();
		ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
		};
		ResponseEntity<String> resultvnf = defaultApitNsdApi.nsDescriptorsPostResult(body, "1.0", "application/json",
				"application/json", null, returnType);

		return resultvnf;
	}

	@Override
	public ResponseEntity<String> uploadNSDPackageContent(String nsd_id, byte[] allBytes) throws IOException {

		ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
		};
		ResponseEntity<String> result = defaultApitNsdApi.nsDescriptorsNsdInfoIdNsdContentPutResult(nsd_id, "1.0", "application/zip", allBytes, null,
				returnType);
		return result;

	}

	@Override
	public ResponseEntity<String> uploadNSDPackageContent(String nsd_id, String pLocation) throws IOException {
		return null;
	}

	@Override
	public ResponseEntity<String> deleteNSDPackage(String nsd_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> createNSInstance(String json) {

		ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
		};
		CreateNsRequest body = new CreateNsRequest();
		try {
			body = toJsonObj(json, CreateNsRequest.class);
			body.setNsDescription("description");
			//osm needs vimAccountId and wimAccountId" : false... NOT SOL005 supported
			ResponseEntity<String> result = this.defaultNslcmDefaultApi.nsInstancesPostResult(body, "1.0",
					"application/json", "application/json", null, returnType);
			return result;

		} catch (IOException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> instantiateNSInstance(String nsd_instance_id, String json) {

		ParameterizedTypeReference<String> returnType = new ParameterizedTypeReference<String>() {
		};

		InstantiateNsRequest body = new InstantiateNsRequest();
		
		ResponseEntity<String> result = this.defaultNslcmDefaultApi.nsInstancesNsInstanceIdInstantiatePostResult(body,
				"application/json", "application/json", "1.0", nsd_instance_id, null, returnType);

		return result;

	}

	@Override
	public ResponseEntity<String> deleteNSInstanceNew(String instanceId, boolean force) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> terminateNSInstanceNew(String instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getNSInstanceInfo(String instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getNSInstanceContentInfo(String instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getNSLCMDetails(String nsLcmOpOccId) {
		// TODO Auto-generated method stub
		return null;
	}

	static <T> T toJsonObj(String content, Class<T> valueType) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.readValue(content, valueType);
	}

	@Override
	public ResponseEntity<String> actionNSInstance(String ns_instance_id, String payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> getNSLCMDetailsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNSLCMDetailsListByNSID(String nsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> scaleNSInstance(String ns_instance_id, String payload) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> getVIMs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> getVNFDescriptorsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> getNSDescriptorsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> getNSInstancesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONObject getVNFInstanceInfo(String instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
