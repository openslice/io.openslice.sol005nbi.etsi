package io.openslice.sol005nbi.etsi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONObject;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import io.openslice.sol005nbi.api.nslcm.NslcmDefaultApi;
import io.openslice.sol005nbi.api.vnf.VnfPkgmApi;
import io.openslice.sol005nbi.model.nsd.InlineResponse2001;
import io.openslice.sol005nbi.model.nslcm.NsInstancesNsInstance;
import io.openslice.sol005nbi.model.vnf.CreateVnfPkgInfoRequestBody;
import io.openslice.sol005nbi.model.vnf.VnfPackagesCreateVnfPkgInfoRequest;
import io.openslice.sol005nbi.model.vnf.VnfPackagesVnfPkgInfo;

public class OSMClientTest {
	

	private static final transient Logger logger = (Logger) LoggerFactory.getLogger( OSMClientTest.class);

	Logger root = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
	
//	public static void main(String args[]) {
//        	org.apache.log4j.BasicConfigurator.configure();
//        	
//		
//		OSMClientTest obj = new OSMClientTest();
//		obj.runMe("");
//		
//	}
	
	

    @Test
	public void runMe(){
		
		
	    GenericSOL005Client osm7Client = new GenericSOL005Client("https://10.10.10.37:9999",
	    		"ctranoris",
	    		"ctranoris",
	    		"ctranoris_project", 
	    		"https://10.10.10.37:9999/osm/admin/v1/tokens/",
	    		"/vnfpkgm/v1");


	//{vnf: [ {member-vnf-index: "1", vdu:[ {id: mgmtVM, interface: [{name: mgmtVM-eth0, floating-ip-required: True }]} ] } ], vld: [ {name: mgmtnet, vim-network-name: OSMFIVE_selfservice01} ] }    
	    
		
	    io.openslice.sol005nbi.api.vnf.VnfApiClient apiClientVnfPkgmApi = new io.openslice.sol005nbi.api.vnf.VnfApiClient();
	    apiClientVnfPkgmApi.setBasePath("https://10.10.10.37:9999/osm/" + apiClientVnfPkgmApi.getBasePath() ) ;
	    io.openslice.sol005nbi.auth.OAuth bAuth2 = (io.openslice.sol005nbi.auth.OAuth) apiClientVnfPkgmApi.getAuthentication( "bearerAuth" );
	    bAuth2.setAccessToken( osm7Client.getManoAuthorizationTokenID() );
	    
		VnfPkgmApi vnfPkgmApi = new VnfPkgmApi(apiClientVnfPkgmApi);
		
		
	    System.out.println("*********VNFDs***************");
	    	    
	    
	    for (VnfPackagesVnfPkgInfo v : vnfPkgmApi.vnfPackagesGet("application/json", null, null, null, null, null, null) )  {
			System.out.println("=== LIST VNFDs POJO object response: " + v.toString());				
		}
	    
//	    CreateVnfPkgInfoRequestBody body = new CreateVnfPkgInfoRequestBody();
//	    VnfPackagesCreateVnfPkgInfoRequest createVnfPkgInfoRequest = new VnfPackagesCreateVnfPkgInfoRequest();
//		body.createVnfPkgInfoRequest(createVnfPkgInfoRequest );
//		VnfPackagesVnfPkgInfo resultvnf = vnfPkgmApi.vnfPackagesPost(body, "application/json", "application/json", null);
//	    String vnfPkgId = resultvnf.getVnfdId();
//	    if ( vnfPkgId == null) {
//	    	 vnfPkgId = resultvnf.getId(); 
//	    }
//		File file = new File("src/test/resources/cirros_vnf.tar.gz");
//		byte[] fileContent;
//		try {
//			fileContent = Files.readAllBytes(file.toPath());
//			vnfPkgmApi.vnfPackagesVnfPkgIdPackageContentPut("application/json", vnfPkgId, file, fileContent, "application/zip", null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    

	    io.openslice.sol005nbi.api.nsd.NsdApiClient apiClientNsdApi = new io.openslice.sol005nbi.api.nsd.NsdApiClient();
	    apiClientNsdApi.setBasePath("https://10.10.10.37:9999/osm/" + apiClientNsdApi.getBasePath() ) ;
	    io.openslice.sol005nbi.auth.OAuth bAuth2nsd = (io.openslice.sol005nbi.auth.OAuth) apiClientNsdApi.getAuthentication( "bearerAuth" );
	    bAuth2nsd.setAccessToken( osm7Client.getManoAuthorizationTokenID() );
	    
	    io.openslice.sol005nbi.api.nsd.NsdDefaultApi defaultApitNsdApi = new io.openslice.sol005nbi.api.nsd.NsdDefaultApi( apiClientNsdApi );
		
		
	    System.out.println("*********NSDs***************");
	    	    
	    
	    for (InlineResponse2001 v : defaultApitNsdApi.nsDescriptorsGet( "", "application/json", null, null, null, null, null, null, null) )  {
			System.out.println("=== LIST NSDs POJO object response: " + v.toString());				
		}
	    
	    System.out.println("*********getNsInstances***************");

	    io.openslice.sol005nbi.api.nslcm.NslcmClient apiClientns = new io.openslice.sol005nbi.api.nslcm.NslcmClient();
	    apiClientns.setBasePath("https://10.10.10.37:9999/osm/" + apiClientns.getBasePath() ) ;	    
	    io.openslice.sol005nbi.auth.OAuth boAuth2 = (io.openslice.sol005nbi.auth.OAuth) apiClientns.getAuthentication( "bearerAuth" );
	    boAuth2.setAccessToken( osm7Client.getManoAuthorizationTokenID() );
	    NslcmDefaultApi defaultApi = new NslcmDefaultApi( apiClientns );
	    

	    for (NsInstancesNsInstance ir :  defaultApi.nsInstancesGet("1.0", "application/json", null, null, null, null, null, null, null)) {
			System.out.println("=== LIST getNsInstance POJO object response: " + ir.toString());				
			
		}
	    
	    
	    
	    //try to instantiate


		String nsd_id = "0b6853fc-8219-4580-9697-bf4a8f0a08f9";//"cirros_2vnf_nsd";
		NSCreateInstanceRequestPayload nscreateinstancerequestpayload = new NSCreateInstanceRequestPayload();
		nscreateinstancerequestpayload.setNsName( "test-genericsol005");
		nscreateinstancerequestpayload.setVimAccountId("c224eb48-419e-4097-8a1d-11ec1bba087f");
		nscreateinstancerequestpayload.setWimAccountId(false);
		nscreateinstancerequestpayload.setNsdId(nsd_id );

		NSInstantiateInstanceRequestPayload.VnF vnf_tmp = nscreateinstancerequestpayload.new VnF();  
		vnf_tmp.setVimAccount("c224eb48-419e-4097-8a1d-11ec1bba087f");
		
		Integer count = 0;
		
		
		
		
			//NSInstantiateInstanceRequestPayload.Vld vld_tmp = nscreateinstancerequestpayload.new Vld();  
			//vld_tmp.setName("cirros_2vnf_nsd_vld1");
			
//			IpProfileParamsBuilder ipprofileparamsbuilder = new IpProfileParamsBuilder();			
//			ipprofileparamsbuilder.setIpVersion(IpVersion.Ipv4);
//			ipprofileparamsbuilder.setSubnetAddress(new IpPrefix(new Ipv4Prefix("192.168.100.0/24")));
//			ipprofileparamsbuilder.setGatewayAddress(new IpAddress(new Ipv4Address("0.0.0.0")));
//			List<DnsServer> dnsserverlist = new ArrayList<DnsServer>();
//			DnsServerBuilder dnsserverbuilder = new DnsServerBuilder();
//			dnsserverbuilder.setAddress(new IpAddress(new Ipv4Address("8.8.8.8")));			
//			dnsserverlist.add(dnsserverbuilder.build());			
//			ipprofileparamsbuilder.setDnsServer(dnsserverlist);
//			IpProfileParams ipprofileparams_tmp = ipprofileparamsbuilder.build();
//			vld_tmp.setIpProfile(ipprofileparams_tmp);
			
			//vld_tmp.setVimNetworkName("OSMFIVE_selfservice01");
			//LinkedHashMap<String,String> tmp=new LinkedHashMap<>();
			//tmp.put("c224eb48-419e-4097-8a1d-11ec1bba087f","OSMFIVE_selfservice01");			
//			tmp.put("8571aa95-4c17-4d87-a865-c98126dd0241","OSMFIVE_selfservice01");
			//vld_tmp.setVimNetworkName(tmp);
			//nscreateinstancerequestpayload.getVld().add(vld_tmp);
			
		System.out.println("NS Instance creation payload : " + nscreateinstancerequestpayload.toJSON());
		ResponseEntity<String> ns_instance_creation_entity = osm7Client.createNSInstance(nscreateinstancerequestpayload.toJSON());
		
		//String	test_payload="{\"nsName\":\"test\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\",\"nsdId\":\""+nsd_id+"\",\"vnf\":[{\"member-vnf-index\":\"1\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\", \"vdu\":[ {\"id\": \"mgmtVM\", \"interface\": [{\"name\": \"mgmtVM-eth0\", \"floating-ip-required\": true }]} ]},{\"member-vnf-index\":\"2\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\"}],\"vld\": [ {\"name\": \"mgmtnet\", \"vim-network-name\": \"OSMFIVE_selfservice01\"}]}";			
		//String	test_payload="{\"nsName\":\"test\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\",\"nsdId\":\""+nsd_id+"\",\"vnf\":[{\"member-vnf-index\":\"1\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\"},{\"member-vnf-index\":\"2\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\"}],\"vld\": [ {\"name\": \"mgmtnet\", \"vim-network-name\": \"OSMFIVE_selfservice01\"}]}";	
		//System.out.println("NS Instance creation payload : " + test_payload);
		//ResponseEntity<String> ns_instance_creation_entity = osm7Client.createNSInstance(test_payload);
		// The NS Instance ID is set

		// NS instance creation
		if (ns_instance_creation_entity == null || ns_instance_creation_entity.getStatusCode().is4xxClientError()
				|| ns_instance_creation_entity.getStatusCode().is5xxServerError()) {
			// NS instance creation failed
			System.out.println("NS Instance creation failed with response: "+ ns_instance_creation_entity.getBody().toString());
		} else {
			// String nsr_id =
			JSONObject ns_instance_creation_entity_json_obj = new JSONObject(ns_instance_creation_entity.getBody());
			System.out.println("NS creation succeded with "+ns_instance_creation_entity.getBody());
			String nsd_instance_id = ns_instance_creation_entity_json_obj.getString("id");
			// Instantiate NS Instance
			NSInstantiateInstanceRequestPayload nsrequestpayload = new NSInstantiateInstanceRequestPayload();
			nsrequestpayload.setNsName("test");
			nsrequestpayload.setVimAccountId("c224eb48-419e-4097-8a1d-11ec1bba087f");
			nsrequestpayload.setWimAccountId(false);
			nsrequestpayload.setNsdId(nsd_id);
			count = 0;
			
		
			System.out.println("NS Instantiation payload : " + nsrequestpayload.toJSON());

			
			//String test_payload={"nsName":"test","vimAccountId":"4efd8bf4-5292-4634-87b7-7b3d49108b36","nsdId":"acc18b58-1b82-40e8-8c35-2bfcc8293cdf","vnf":[{"member-vnf-index":"1","vimAccountId":"4efd8bf4-5292-4634-87b7-7b3d49108b36", vdu:[ {id: mgmtVM, interface: [{name: "mgmtVM-eth0", floating-ip-required: true }]} ], vld: [ {name: mgmtnet, vim-network-name: "OSMFIVE_selfservice01"} ]},{"member-vnf-index":"2","vimAccountId":"4efd8bf4-5292-4634-87b7-7b3d49108b36"}]};
			//String test_payload="{\"nsName\":\"test\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\",\"nsdId\":\"acc18b58-1b82-40e8-8c35-2bfcc8293cdf\",\"vnf\":[{\"member-vnf-index\":\"1\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\", vdu:[ {id: mgmtVM, interface: [{name: \"mgmtVM-eth0\", floating-ip-required: true }]} ], vld: [ {name: mgmtnet, vim-network-name: \"OSMFIVE_selfservice01\"} ]},{\"member-vnf-index\":\"2\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\"}]}";
			//String test_payload="{\"nsName\":\"test\",\"vimAccountId\":\"4efd8bf4-5292-4634-87b7-7b3d49108b36\",\"nsdId\":\""+nsd_id+"\"}";
			//ResponseEntity<String> instantiate_ns_instance_entity = osm7Client.instantiateNSInstance(nsd_instance_id, test_payload);
			// Here we need the feedback
			ResponseEntity<String> instantiate_ns_instance_entity = osm7Client.instantiateNSInstance(nsd_instance_id, nsrequestpayload.toJSON());
			if (instantiate_ns_instance_entity == null || instantiate_ns_instance_entity.getStatusCode().is4xxClientError() || instantiate_ns_instance_entity.getStatusCode().is5xxServerError()) {
				System.out.println("NS Instantiation failed. Status Code:"
						+ instantiate_ns_instance_entity.getStatusCode().toString() + ", Payload:"
						+ ns_instance_creation_entity.getBody().toString());
			} else {
				// NS Instantiation starts
				System.out.println("NS Instantiation of NS with id" + nsd_instance_id + " started.");
				// Save the changes to DeploymentDescriptor
			}
		}
	    
	    
	}
}
