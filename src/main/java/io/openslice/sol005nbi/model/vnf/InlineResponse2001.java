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
 * InlineResponse2001
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-20T00:01:04.793+02:00[Europe/Athens]")
public class InlineResponse2001 {
  @JsonProperty("PkgmSubscription")
  private SubscriptionsPkgmSubscription pkgmSubscription = null;

  public InlineResponse2001 pkgmSubscription(SubscriptionsPkgmSubscription pkgmSubscription) {
    this.pkgmSubscription = pkgmSubscription;
    return this;
  }

   /**
   * Get pkgmSubscription
   * @return pkgmSubscription
  **/
  @Schema(description = "")
  public SubscriptionsPkgmSubscription getPkgmSubscription() {
    return pkgmSubscription;
  }

  public void setPkgmSubscription(SubscriptionsPkgmSubscription pkgmSubscription) {
    this.pkgmSubscription = pkgmSubscription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(this.pkgmSubscription, inlineResponse2001.pkgmSubscription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pkgmSubscription);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    pkgmSubscription: ").append(toIndentedString(pkgmSubscription)).append("\n");
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
