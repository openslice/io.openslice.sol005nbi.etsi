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
 * Representation of the created subscription resource. The HTTP response shall include a \&quot;Location\&quot; HTTP header that points to the created subscription resource. 
 */
@Schema(description = "Representation of the created subscription resource. The HTTP response shall include a \"Location\" HTTP header that points to the created subscription resource. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-20T00:01:04.793+02:00[Europe/Athens]")
public class Body3 {
  @JsonProperty("PkgmSubscriptionRequest")
  private SubscriptionsPkgmSubscriptionRequest pkgmSubscriptionRequest = null;

  public Body3 pkgmSubscriptionRequest(SubscriptionsPkgmSubscriptionRequest pkgmSubscriptionRequest) {
    this.pkgmSubscriptionRequest = pkgmSubscriptionRequest;
    return this;
  }

   /**
   * Get pkgmSubscriptionRequest
   * @return pkgmSubscriptionRequest
  **/
  @Schema(required = true, description = "")
  public SubscriptionsPkgmSubscriptionRequest getPkgmSubscriptionRequest() {
    return pkgmSubscriptionRequest;
  }

  public void setPkgmSubscriptionRequest(SubscriptionsPkgmSubscriptionRequest pkgmSubscriptionRequest) {
    this.pkgmSubscriptionRequest = pkgmSubscriptionRequest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body3 body3 = (Body3) o;
    return Objects.equals(this.pkgmSubscriptionRequest, body3.pkgmSubscriptionRequest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pkgmSubscriptionRequest);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body3 {\n");
    
    sb.append("    pkgmSubscriptionRequest: ").append(toIndentedString(pkgmSubscriptionRequest)).append("\n");
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
