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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * This type describes the information used to scale a VNF instance to a target size. The target size is either expressed as an instantiation level of that DF as defined in the VNFD, or given as a list of scale levels, one per scaling aspect of that DF. Instantiation levels and scaling aspects are declared in the VNFD. The NFVO shall then invoke the ScaleVnfToLevel operation towards the appropriate VNFM.. 
 */
@Schema(description = "This type describes the information used to scale a VNF instance to a target size. The target size is either expressed as an instantiation level of that DF as defined in the VNFD, or given as a list of scale levels, one per scaling aspect of that DF. Instantiation levels and scaling aspects are declared in the VNFD. The NFVO shall then invoke the ScaleVnfToLevel operation towards the appropriate VNFM.. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesnsInstanceIdscaleScaleToLevelData {
  @JsonProperty("vnfInstantiationLevelId")
  private String vnfInstantiationLevelId = null;

  @JsonProperty("vnfScaleInfo")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> vnfScaleInfo = null;

  @JsonProperty("additionalParams")
  private Object additionalParams = null;

  public NsInstancesnsInstanceIdscaleScaleToLevelData vnfInstantiationLevelId(String vnfInstantiationLevelId) {
    this.vnfInstantiationLevelId = vnfInstantiationLevelId;
    return this;
  }

   /**
   * Identifier of the VNF Virtual Link Descriptor (VLD) in the VNFD. 
   * @return vnfInstantiationLevelId
  **/
  @Schema(description = "Identifier of the VNF Virtual Link Descriptor (VLD) in the VNFD. ")
  public String getVnfInstantiationLevelId() {
    return vnfInstantiationLevelId;
  }

  public void setVnfInstantiationLevelId(String vnfInstantiationLevelId) {
    this.vnfInstantiationLevelId = vnfInstantiationLevelId;
  }

  public NsInstancesnsInstanceIdscaleScaleToLevelData vnfScaleInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> vnfScaleInfo) {
    this.vnfScaleInfo = vnfScaleInfo;
    return this;
  }

  public NsInstancesnsInstanceIdscaleScaleToLevelData addVnfScaleInfoItem(NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus vnfScaleInfoItem) {
    if (this.vnfScaleInfo == null) {
      this.vnfScaleInfo = new ArrayList<>();
    }
    this.vnfScaleInfo.add(vnfScaleInfoItem);
    return this;
  }

   /**
   * For each scaling aspect of the current deployment flavor, indicates the target scale level to which the VNF is to be scaled. 
   * @return vnfScaleInfo
  **/
  @Schema(description = "For each scaling aspect of the current deployment flavor, indicates the target scale level to which the VNF is to be scaled. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> getVnfScaleInfo() {
    return vnfScaleInfo;
  }

  public void setVnfScaleInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> vnfScaleInfo) {
    this.vnfScaleInfo = vnfScaleInfo;
  }

  public NsInstancesnsInstanceIdscaleScaleToLevelData additionalParams(Object additionalParams) {
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
    NsInstancesnsInstanceIdscaleScaleToLevelData nsInstancesnsInstanceIdscaleScaleToLevelData = (NsInstancesnsInstanceIdscaleScaleToLevelData) o;
    return Objects.equals(this.vnfInstantiationLevelId, nsInstancesnsInstanceIdscaleScaleToLevelData.vnfInstantiationLevelId) &&
        Objects.equals(this.vnfScaleInfo, nsInstancesnsInstanceIdscaleScaleToLevelData.vnfScaleInfo) &&
        Objects.equals(this.additionalParams, nsInstancesnsInstanceIdscaleScaleToLevelData.additionalParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vnfInstantiationLevelId, vnfScaleInfo, additionalParams);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesnsInstanceIdscaleScaleToLevelData {\n");
    
    sb.append("    vnfInstantiationLevelId: ").append(toIndentedString(vnfInstantiationLevelId)).append("\n");
    sb.append("    vnfScaleInfo: ").append(toIndentedString(vnfScaleInfo)).append("\n");
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
