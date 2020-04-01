package io.openslice.sol005nbi.api.nslcm;

import org.springframework.stereotype.Component;

import io.openslice.sol005nbi.etsi.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
@Component
public class NslcmClient extends ApiClient {
   
    
    private String basePath = "/nslcm/v1";

    public NslcmClient() {
		setBasePath(basePath);
	}

}
