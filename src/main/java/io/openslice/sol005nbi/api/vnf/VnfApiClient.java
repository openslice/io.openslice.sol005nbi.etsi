package io.openslice.sol005nbi.api.vnf;

import org.springframework.stereotype.Component;

import io.openslice.sol005nbi.etsi.ApiClient;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-20T00:01:04.793+02:00[Europe/Athens]")
@Component
public class VnfApiClient extends ApiClient {

	private String basePath = "/vnfpkgm/v1";

	public VnfApiClient() {
		setBasePath(basePath);
	}
}
