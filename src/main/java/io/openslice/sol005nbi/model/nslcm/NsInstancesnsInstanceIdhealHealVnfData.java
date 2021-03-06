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
 * This type represents the information to heal a VNF that is part of an NS.  The NFVO shall then invoke the HealVNF operation towards the appropriate VNFM.  It shall comply with the provisions defined in Table 6.5.3.44-1. 
 */
@Schema(description = "This type represents the information to heal a VNF that is part of an NS.  The NFVO shall then invoke the HealVNF operation towards the appropriate VNFM.  It shall comply with the provisions defined in Table 6.5.3.44-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesnsInstanceIdhealHealVnfData {
  @JsonProperty("vnfInstanceId")
  private String vnfInstanceId = null;

  @JsonProperty("cause")
  private String cause = null;

  @JsonProperty("additionalParams")
  private Object additionalParams = null;

  public NsInstancesnsInstanceIdhealHealVnfData vnfInstanceId(String vnfInstanceId) {
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

  public NsInstancesnsInstanceIdhealHealVnfData cause(String cause) {
    this.cause = cause;
    return this;
  }

   /**
   * Indicates the reason why a healing procedure is required. 
   * @return cause
  **/
  @Schema(description = "Indicates the reason why a healing procedure is required. ")
  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause;
  }

  public NsInstancesnsInstanceIdhealHealVnfData additionalParams(Object additionalParams) {
    this.additionalParams = additionalParams;
    return this;
  }

   /**
   * This type represents a list of key-value pairs. The order of the pairs in the list is not significant. In JSON, a set of key- value pairs is represented as an object. It shall comply with the provisions defined in clause 4 of IETF RFC 7159. 
   * @return additionalParams
  **/
  @Schema(description = "This type represents a list of key-value pairs. The order of the pairs in the list is not significant. In JSON, a set of key- value pairs is represented as an object. It shall comply with the provisions defined in clause 4 of IETF RFC 7159. ")
  public Object getAdditionalParams() {
    return additionalParams;
  }

  public void setAdditionalParams(Object additionalParams) {
    this.additionalParams = additionalParams;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesnsInstanceIdhealHealVnfData nsInstancesnsInstanceIdhealHealVnfData = (NsInstancesnsInstanceIdhealHealVnfData) o;
    return Objects.equals(this.vnfInstanceId, nsInstancesnsInstanceIdhealHealVnfData.vnfInstanceId) &&
        Objects.equals(this.cause, nsInstancesnsInstanceIdhealHealVnfData.cause) &&
        Objects.equals(this.additionalParams, nsInstancesnsInstanceIdhealHealVnfData.additionalParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfInstanceId, cause, additionalParams);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesnsInstanceIdhealHealVnfData {\n");
    
    sb.append("    vnfInstanceId: ").append(toIndentedString(vnfInstanceId)).append("\n");
    sb.append("    cause: ").append(toIndentedString(cause)).append("\n");
    sb.append("    additionalParams: ").append(toIndentedString(additionalParams)).append("\n");
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
