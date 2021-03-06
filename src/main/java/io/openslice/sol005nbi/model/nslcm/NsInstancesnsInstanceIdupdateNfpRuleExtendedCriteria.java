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
 * The Mask data type identifies the value to be matched for a sequence of bits at a particular location in a frame. It shall comply with the provisions defined in Table 6.5.3.41-1. 
 */
@Schema(description = "The Mask data type identifies the value to be matched for a sequence of bits at a particular location in a frame. It shall comply with the provisions defined in Table 6.5.3.41-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria {
  @JsonProperty("startingPoint")
  private Integer startingPoint = null;

  @JsonProperty("length")
  private Integer length = null;

  @JsonProperty("value")
  private String value = null;

  public NsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria startingPoint(Integer startingPoint) {
    this.startingPoint = startingPoint;
    return this;
  }

   /**
   * Indicates the offset between the last bit of the source mac address and the first bit of the sequence of bits to be matched. 
   * @return startingPoint
  **/
  @Schema(required = true, description = "Indicates the offset between the last bit of the source mac address and the first bit of the sequence of bits to be matched. ")
  public Integer getStartingPoint() {
    return startingPoint;
  }

  public void setStartingPoint(Integer startingPoint) {
    this.startingPoint = startingPoint;
  }

  public NsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria length(Integer length) {
    this.length = length;
    return this;
  }

   /**
   * Indicates the number of bits to be matched. 
   * @return length
  **/
  @Schema(required = true, description = "Indicates the number of bits to be matched. ")
  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public NsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria value(String value) {
    this.value = value;
    return this;
  }

   /**
   * Provide the sequence of bit values to be matched. 
   * @return value
  **/
  @Schema(required = true, description = "Provide the sequence of bit values to be matched. ")
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria nsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria = (NsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria) o;
    return Objects.equals(this.startingPoint, nsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria.startingPoint) &&
        Objects.equals(this.length, nsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria.length) &&
        Objects.equals(this.value, nsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startingPoint, length, value);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesnsInstanceIdupdateNfpRuleExtendedCriteria {\n");
    
    sb.append("    startingPoint: ").append(toIndentedString(startingPoint)).append("\n");
    sb.append("    length: ").append(toIndentedString(length)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
