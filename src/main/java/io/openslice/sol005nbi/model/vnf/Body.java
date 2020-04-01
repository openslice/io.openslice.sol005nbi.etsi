/*
 * SOL005 - VNF Package Management Interface
 * SOL005 - VNF Package Management Interface IMPORTANT: Please note that this file might be not aligned to the current version of the ETSI Group Specification it refers to and has not been approved by the ETSI NFV ISG. In case of discrepancies the published ETSI Group Specification takes precedence. Please report bugs to https://forge.etsi.org/bugzilla/buglist.cgi?component=Nfv-Openapis 
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.openslice.sol005nbi.model.vnf;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * IndividualVNF package resource creation parameters, as defined in clause 9.5.2.2 
 */
@Schema(description = "IndividualVNF package resource creation parameters, as defined in clause 9.5.2.2 ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-20T00:01:04.793+02:00[Europe/Athens]")
public class Body {
  @JsonProperty("CreateVnfPkgInfoRequest")
  private VnfPackagesCreateVnfPkgInfoRequest createVnfPkgInfoRequest = null;

  public Body createVnfPkgInfoRequest(VnfPackagesCreateVnfPkgInfoRequest createVnfPkgInfoRequest) {
    this.createVnfPkgInfoRequest = createVnfPkgInfoRequest;
    return this;
  }

   /**
   * Get createVnfPkgInfoRequest
   * @return createVnfPkgInfoRequest
  **/
  @Schema(required = true, description = "")
  public VnfPackagesCreateVnfPkgInfoRequest getCreateVnfPkgInfoRequest() {
    return createVnfPkgInfoRequest;
  }

  public void setCreateVnfPkgInfoRequest(VnfPackagesCreateVnfPkgInfoRequest createVnfPkgInfoRequest) {
    this.createVnfPkgInfoRequest = createVnfPkgInfoRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body body = (Body) o;
    return Objects.equals(this.createVnfPkgInfoRequest, body.createVnfPkgInfoRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createVnfPkgInfoRequest);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body {\n");
    
    sb.append("    createVnfPkgInfoRequest: ").append(toIndentedString(createVnfPkgInfoRequest)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
