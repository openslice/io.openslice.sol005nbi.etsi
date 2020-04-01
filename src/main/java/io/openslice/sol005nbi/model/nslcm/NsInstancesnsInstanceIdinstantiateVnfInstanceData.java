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
 * This type specifies an existing VNF instance to be used in the NS instance and if needed, the VNF Profile to use for this VNF instance. It shall comply with the provisions defined in Table 6.5.3.19-1. 
 */
@Schema(description = "This type specifies an existing VNF instance to be used in the NS instance and if needed, the VNF Profile to use for this VNF instance. It shall comply with the provisions defined in Table 6.5.3.19-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesnsInstanceIdinstantiateVnfInstanceData {
  @JsonProperty("vnfInstanceId")
  private String vnfInstanceId = null;

  @JsonProperty("vnfProfileId")
  private String vnfProfileId = null;

  public NsInstancesnsInstanceIdinstantiateVnfInstanceData vnfInstanceId(String vnfInstanceId) {
    this.vnfInstanceId = vnfInstanceId;
    return this;
  }

   /**
   * An identifier with the intention of being globally unique. 
   * @return vnfInstanceId
  **/
  @Schema(required = true, description = "An identifier with the intention of being globally unique. ")
  public String getVnfInstanceId() {
    return vnfInstanceId;
  }

  public void setVnfInstanceId(String vnfInstanceId) {
    this.vnfInstanceId = vnfInstanceId;
  }

  public NsInstancesnsInstanceIdinstantiateVnfInstanceData vnfProfileId(String vnfProfileId) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesnsInstanceIdinstantiateVnfInstanceData nsInstancesnsInstanceIdinstantiateVnfInstanceData = (NsInstancesnsInstanceIdinstantiateVnfInstanceData) o;
    return Objects.equals(this.vnfInstanceId, nsInstancesnsInstanceIdinstantiateVnfInstanceData.vnfInstanceId) &&
        Objects.equals(this.vnfProfileId, nsInstancesnsInstanceIdinstantiateVnfInstanceData.vnfProfileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfInstanceId, vnfProfileId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesnsInstanceIdinstantiateVnfInstanceData {\n");
    
    sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
    sb.append("    vnfProfileId: ").append(toIndentedString(vnfProfileId)).append("\n");
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
