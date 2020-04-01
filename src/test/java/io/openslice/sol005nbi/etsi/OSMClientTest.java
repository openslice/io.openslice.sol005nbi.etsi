package io.openslice.sol005nbi.etsi;

import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import io.openslice.sol005nbi.api.nslcm.NslcmDefaultApi;
import io.openslice.sol005nbi.api.vnf.VnfPkgmApi;
import io.openslice.sol005nbi.model.nsd.InlineResponse2001;
import io.openslice.sol005nbi.model.nslcm.NsInstancesNsInstance;
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
		
		
	    GenericClient osm7Clientent = new GenericClient("https://10.10.10.37:9999","admin","admin","admin");


	//{vnf: [ {member-vnf-index: "1", vdu:[ {id: mgmtVM, interface: [{name: mgmtVM-eth0, floating-ip-required: True }]} ] } ], vld: [ {name: mgmtnet, vim-network-name: OSMFIVE_selfservice01} ] }    
	    
		
	    io.openslice.sol005nbi.api.vnf.VnfApiClient apiClientVnfPkgmApi = new io.openslice.sol005nbi.api.vnf.VnfApiClient();
	    apiClientVnfPkgmApi.setBasePath("https://10.10.10.37:9999/osm/" + apiClientVnfPkgmApi.getBasePath() ) ;
	    io.openslice.sol005nbi.auth.OAuth bAuth2 = (io.openslice.sol005nbi.auth.OAuth) apiClientVnfPkgmApi.getAuthentication( "bearerAuth" );
	    bAuth2.setAccessToken( osm7Clientent.getManoAuthorizationTokenID() );
	    
		VnfPkgmApi vnfPkgmApi = new VnfPkgmApi(apiClientVnfPkgmApi);
		
		
	    System.out.println("*********VNFDs***************");
	    	    
	    
	    for (VnfPackagesVnfPkgInfo v : vnfPkgmApi.vnfPackagesGet("application/json", null, null, null, null, null, null) )  {
			System.out.println("=== LIST VNFDs POJO object response: " + v.toString());				
		}
	    

	    io.openslice.sol005nbi.api.nsd.NsdApiClient apiClientNsdApi = new io.openslice.sol005nbi.api.nsd.NsdApiClient();
	    apiClientNsdApi.setBasePath("https://10.10.10.37:9999/osm/" + apiClientNsdApi.getBasePath() ) ;
	    io.openslice.sol005nbi.auth.OAuth bAuth2nsd = (io.openslice.sol005nbi.auth.OAuth) apiClientNsdApi.getAuthentication( "bearerAuth" );
	    bAuth2nsd.setAccessToken( osm7Clientent.getManoAuthorizationTokenID() );
	    
	    io.openslice.sol005nbi.api.nsd.NsdDefaultApi defaultApitNsdApi = new io.openslice.sol005nbi.api.nsd.NsdDefaultApi( apiClientNsdApi );
		
		
	    System.out.println("*********NSDs***************");
	    	    
	    
	    for (InlineResponse2001 v : defaultApitNsdApi.nsDescriptorsGet( "", "application/json", null, null, null, null, null, null, null) )  {
			System.out.println("=== LIST NSDs POJO object response: " + v.toString());				
		}
	    
	    System.out.println("*********getNsInstances***************");

	    io.openslice.sol005nbi.api.nslcm.NslcmClient apiClientns = new io.openslice.sol005nbi.api.nslcm.NslcmClient();
	    apiClientns.setBasePath("https://10.10.10.37:9999/osm/" + apiClientns.getBasePath() ) ;	    
	    io.openslice.sol005nbi.auth.OAuth boAuth2 = (io.openslice.sol005nbi.auth.OAuth) apiClientns.getAuthentication( "bearerAuth" );
	    boAuth2.setAccessToken( osm7Clientent.getManoAuthorizationTokenID() );
	    NslcmDefaultApi defaultApi = new NslcmDefaultApi( apiClientns );
	    

	    for (NsInstancesNsInstance ir :  defaultApi.nsInstancesGet("1.0", "application/json", null, null, null, null, null, null, null)) {
			System.out.println("=== LIST getNsInstance POJO object response: " + ir.toString());				
			
		}
	}
}
