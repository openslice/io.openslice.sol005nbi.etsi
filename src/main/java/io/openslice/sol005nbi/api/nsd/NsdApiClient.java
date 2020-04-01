package io.openslice.sol005nbi.api.nsd;

import org.springframework.stereotype.Component;

import io.openslice.sol005nbi.etsi.ApiClient;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-31T22:46:27.985+03:00[Europe/Athens]")
@Component
public class NsdApiClient extends ApiClient {
  
    
    protected String basePath = "/nsd/v1";

    public NsdApiClient() {
		setBasePath(basePath);
	}
}
