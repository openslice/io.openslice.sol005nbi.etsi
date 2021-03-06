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
 * This type represents the target NS Scale level for each NS scaling aspect of the current deployment flavor. 
 */
@Schema(description = "This type represents the target NS Scale level for each NS scaling aspect of the current deployment flavor. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesNsInstanceNsScaleStatus {
  @JsonProperty("nsScalingAspectId")
  private String nsScalingAspectId = null;

  @JsonProperty("nsScaleLevelId")
  private String nsScaleLevelId = null;

  public NsInstancesNsInstanceNsScaleStatus nsScalingAspectId(String nsScalingAspectId) {
    this.nsScalingAspectId = nsScalingAspectId;
    return this;
  }

   /**
   * An identifier that is unique within a NS descriptor. Representation: string of variable length. 
   * @return nsScalingAspectId
  **/
  @Schema(required = true, description = "An identifier that is unique within a NS descriptor. Representation: string of variable length. ")
  public String getNsScalingAspectId() {
    return nsScalingAspectId;
  }

  public void setNsScalingAspectId(String nsScalingAspectId) {
    this.nsScalingAspectId = nsScalingAspectId;
  }

  public NsInstancesNsInstanceNsScaleStatus nsScaleLevelId(String nsScaleLevelId) {
    this.nsScaleLevelId = nsScaleLevelId;
    return this;
  }

   /**
   * An identifier that is unique within a NS descriptor. Representation: string of variable length. 
   * @return nsScaleLevelId
  **/
  @Schema(required = true, description = "An identifier that is unique within a NS descriptor. Representation: string of variable length. ")
  public String getNsScaleLevelId() {
    return nsScaleLevelId;
  }

  public void setNsScaleLevelId(String nsScaleLevelId) {
    this.nsScaleLevelId = nsScaleLevelId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesNsInstanceNsScaleStatus nsInstancesNsInstanceNsScaleStatus = (NsInstancesNsInstanceNsScaleStatus) o;
    return Objects.equals(this.nsScalingAspectId, nsInstancesNsInstanceNsScaleStatus.nsScalingAspectId) &&
        Objects.equals(this.nsScaleLevelId, nsInstancesNsInstanceNsScaleStatus.nsScaleLevelId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nsScalingAspectId, nsScaleLevelId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesNsInstanceNsScaleStatus {\n");
    
    sb.append("    nsScalingAspectId: ").append(toIndentedString(nsScalingAspectId)).append("\n");
    sb.append("    nsScaleLevelId: ").append(toIndentedString(nsScaleLevelId)).append("\n");
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
