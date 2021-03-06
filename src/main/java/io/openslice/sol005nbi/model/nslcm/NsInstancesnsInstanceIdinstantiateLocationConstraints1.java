/*
 * SOL005 - NS Lifecycle Management Interface
 * SOL005 - NS Lifecycle Management Interface IMPORTANT: Please note that this file might be not aligned to the current version of the ETSI Group Specification it refers to and has not been approved by the ETSI NFV ISG. In case of discrepancies the published ETSI Group Specification takes precedence. Please report bugs to https://forge.etsi.org/bugzilla/buglist.cgi?component=Nfv-Openapis 
 *
 * OpenAPI spec version: 1.3.0-impl:etsi.org:ETSI_NFV_OpenAPI:1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.openslice.sol005nbi.model.nslcm;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * This type represents the association of location constraints to a VNF instance to be created according to a specific VNF profile. It shall comply with the provisions defined in Table 6.5.3.20-1. 
 */
@Schema(description = "This type represents the association of location constraints to a VNF instance to be created according to a specific VNF profile. It shall comply with the provisions defined in Table 6.5.3.20-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesnsInstanceIdinstantiateLocationConstraints1 {
  @JsonProperty("vnfProfileId")
  private String vnfProfileId = null;

  @JsonProperty("locationConstraints")
  private NsInstancesnsInstanceIdinstantiateLocationConstraints locationConstraints = null;

  public NsInstancesnsInstanceIdinstantiateLocationConstraints1 vnfProfileId(String vnfProfileId) {
    this.vnfProfileId = vnfProfileId;
    return this;
  }

   /**
   * An identifier that is unique within a NS descriptor. Representation: string of variable length. 
   * @return vnfProfileId
  **/
  @Schema(required = true, description = "An identifier that is unique within a NS descriptor. Representation: string of variable length. ")
  public String getVnfProfileId() {
    return vnfProfileId;
  }

  public void setVnfProfileId(String vnfProfileId) {
    this.vnfProfileId = vnfProfileId;
  }

  public NsInstancesnsInstanceIdinstantiateLocationConstraints1 locationConstraints(NsInstancesnsInstanceIdinstantiateLocationConstraints locationConstraints) {
    this.locationConstraints = locationConstraints;
    return this;
  }

   /**
   * Get locationConstraints
   * @return locationConstraints
  **/
  @Schema(description = "")
  public NsInstancesnsInstanceIdinstantiateLocationConstraints getLocationConstraints() {
    return locationConstraints;
  }

  public void setLocationConstraints(NsInstancesnsInstanceIdinstantiateLocationConstraints locationConstraints) {
    this.locationConstraints = locationConstraints;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesnsInstanceIdinstantiateLocationConstraints1 nsInstancesnsInstanceIdinstantiateLocationConstraints1 = (NsInstancesnsInstanceIdinstantiateLocationConstraints1) o;
    return Objects.equals(this.vnfProfileId, nsInstancesnsInstanceIdinstantiateLocationConstraints1.vnfProfileId) &&
        Objects.equals(this.locationConstraints, nsInstancesnsInstanceIdinstantiateLocationConstraints1.locationConstraints);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfProfileId, locationConstraints);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesnsInstanceIdinstantiateLocationConstraints1 {\n");
    
    sb.append("    vnfProfileId: ").append(toIndentedString(vnfProfileId)).append("\n");
    sb.append("    locationConstraints: ").append(toIndentedString(locationConstraints)).append("\n");
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
