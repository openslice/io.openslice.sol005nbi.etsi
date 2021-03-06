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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * This type represents a response for Query NS operation.  It shall comply with the provisions defined in Table 6.5.2.10-1. 
 */
@Schema(description = "This type represents a response for Query NS operation.  It shall comply with the provisions defined in Table 6.5.2.10-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesNsInstance {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("nsInstanceName")
  private String nsInstanceName = null;

  @JsonProperty("nsInstanceDescription")
  private String nsInstanceDescription = null;

  @JsonProperty("nsdId")
  private String nsdId = null;

  @JsonProperty("nsdInfoId")
  private String nsdInfoId = null;

  @JsonProperty("flavourId")
  private String flavourId = null;

  @JsonProperty("vnfInstance")
  private List<NsInstancesNsInstanceVnfInstance> vnfInstance = null;

  @JsonProperty("pnfInfo")
  private List<NsInstancesNsInstancePnfInfo> pnfInfo = null;

  @JsonProperty("virtualLinkInfo")
  private List<NsInstancesNsInstanceVirtualLinkInfo> virtualLinkInfo = null;

  @JsonProperty("vnffgInfo")
  private List<NsInstancesNsInstanceVnffgInfo> vnffgInfo = null;

  @JsonProperty("sapInfo")
  private List<NsInstancesNsInstanceSapInfo> sapInfo = null;

  @JsonProperty("nestedNsInstanceId")
  private List<String> nestedNsInstanceId = null;

  /**
   * The state of the NS instance. Permitted values: NOT_INSTANTIATED: The NS instance is terminated or not instantiated. INSTANTIATED: The NS instance is instantiated. 
   */
  public enum NsStateEnum {
    NOT_INSTANTIATED("NOT_INSTANTIATED"),
    INSTANTIATED("INSTANTIATED");

    private String value;

    NsStateEnum(String value) {
      this.value = value;
    }
    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    @JsonCreator
    public static NsStateEnum fromValue(String text) {
      for (NsStateEnum b : NsStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("nsState")
  private NsStateEnum nsState = null;

  @JsonProperty("monitoringParameter")
  private List<NsInstancesNsInstanceMonitoringParameter> monitoringParameter = null;

  @JsonProperty("nsScaleStatus")
  private List<NsInstancesNsInstanceNsScaleStatus> nsScaleStatus = null;

  @JsonProperty("additionalAffinityOrAntiAffinityRule")
  private List<NsInstancesNsInstanceAdditionalAffinityOrAntiAffinityRule> additionalAffinityOrAntiAffinityRule = null;

  @JsonProperty("_links")
  private NsInstancesNsInstanceLinks _links = null;

  public NsInstancesNsInstance id(String id) {
    this.id = id;
    return this;
  }

   /**
   * An identifier with the intention of being globally unique. 
   * @return id
  **/
  @Schema(required = true, description = "An identifier with the intention of being globally unique. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public NsInstancesNsInstance nsInstanceName(String nsInstanceName) {
    this.nsInstanceName = nsInstanceName;
    return this;
  }

   /**
   * Human readable name of the NS instance. 
   * @return nsInstanceName
  **/
  @Schema(required = true, description = "Human readable name of the NS instance. ")
  public String getNsInstanceName() {
    return nsInstanceName;
  }

  public void setNsInstanceName(String nsInstanceName) {
    this.nsInstanceName = nsInstanceName;
  }

  public NsInstancesNsInstance nsInstanceDescription(String nsInstanceDescription) {
    this.nsInstanceDescription = nsInstanceDescription;
    return this;
  }

   /**
   * Human readable description of the NS instance. 
   * @return nsInstanceDescription
  **/
  @Schema(required = true, description = "Human readable description of the NS instance. ")
  public String getNsInstanceDescription() {
    return nsInstanceDescription;
  }

  public void setNsInstanceDescription(String nsInstanceDescription) {
    this.nsInstanceDescription = nsInstanceDescription;
  }

  public NsInstancesNsInstance nsdId(String nsdId) {
    this.nsdId = nsdId;
    return this;
  }

   /**
   * An identifier with the intention of being globally unique. 
   * @return nsdId
  **/
  @Schema(required = true, description = "An identifier with the intention of being globally unique. ")
  public String getNsdId() {
    return nsdId;
  }

  public void setNsdId(String nsdId) {
    this.nsdId = nsdId;
  }

  public NsInstancesNsInstance nsdInfoId(String nsdInfoId) {
    this.nsdInfoId = nsdInfoId;
    return this;
  }

   /**
   * An identifier with the intention of being globally unique. 
   * @return nsdInfoId
  **/
  @Schema(required = true, description = "An identifier with the intention of being globally unique. ")
  public String getNsdInfoId() {
    return nsdInfoId;
  }

  public void setNsdInfoId(String nsdInfoId) {
    this.nsdInfoId = nsdInfoId;
  }

  public NsInstancesNsInstance flavourId(String flavourId) {
    this.flavourId = flavourId;
    return this;
  }

   /**
   * An identifier that is unique within a NS descriptor. Representation: string of variable length. 
   * @return flavourId
  **/
  @Schema(description = "An identifier that is unique within a NS descriptor. Representation: string of variable length. ")
  public String getFlavourId() {
    return flavourId;
  }

  public void setFlavourId(String flavourId) {
    this.flavourId = flavourId;
  }

  public NsInstancesNsInstance vnfInstance(List<NsInstancesNsInstanceVnfInstance> vnfInstance) {
    this.vnfInstance = vnfInstance;
    return this;
  }

  public NsInstancesNsInstance addVnfInstanceItem(NsInstancesNsInstanceVnfInstance vnfInstanceItem) {
    if (this.vnfInstance == null) {
      this.vnfInstance = new ArrayList<>();
    }
    this.vnfInstance.add(vnfInstanceItem);
    return this;
  }

   /**
   * Information on constituent VNF(s) of the NS instance. 
   * @return vnfInstance
  **/
  @Schema(description = "Information on constituent VNF(s) of the NS instance. ")
  public List<NsInstancesNsInstanceVnfInstance> getVnfInstance() {
    return vnfInstance;
  }

  public void setVnfInstance(List<NsInstancesNsInstanceVnfInstance> vnfInstance) {
    this.vnfInstance = vnfInstance;
  }

  public NsInstancesNsInstance pnfInfo(List<NsInstancesNsInstancePnfInfo> pnfInfo) {
    this.pnfInfo = pnfInfo;
    return this;
  }

  public NsInstancesNsInstance addPnfInfoItem(NsInstancesNsInstancePnfInfo pnfInfoItem) {
    if (this.pnfInfo == null) {
      this.pnfInfo = new ArrayList<>();
    }
    this.pnfInfo.add(pnfInfoItem);
    return this;
  }

   /**
   * Information on the PNF(s) that are part of the NS instance. 
   * @return pnfInfo
  **/
  @Schema(description = "Information on the PNF(s) that are part of the NS instance. ")
  public List<NsInstancesNsInstancePnfInfo> getPnfInfo() {
    return pnfInfo;
  }

  public void setPnfInfo(List<NsInstancesNsInstancePnfInfo> pnfInfo) {
    this.pnfInfo = pnfInfo;
  }

  public NsInstancesNsInstance virtualLinkInfo(List<NsInstancesNsInstanceVirtualLinkInfo> virtualLinkInfo) {
    this.virtualLinkInfo = virtualLinkInfo;
    return this;
  }

  public NsInstancesNsInstance addVirtualLinkInfoItem(NsInstancesNsInstanceVirtualLinkInfo virtualLinkInfoItem) {
    if (this.virtualLinkInfo == null) {
      this.virtualLinkInfo = new ArrayList<>();
    }
    this.virtualLinkInfo.add(virtualLinkInfoItem);
    return this;
  }

   /**
   * Information on the VL(s) of the NS instance. This attribute shall be present if the nsState attribute value is INSTANTIATED and if the NS instance has specified connectivity. 
   * @return virtualLinkInfo
  **/
  @Schema(description = "Information on the VL(s) of the NS instance. This attribute shall be present if the nsState attribute value is INSTANTIATED and if the NS instance has specified connectivity. ")
  public List<NsInstancesNsInstanceVirtualLinkInfo> getVirtualLinkInfo() {
    return virtualLinkInfo;
  }

  public void setVirtualLinkInfo(List<NsInstancesNsInstanceVirtualLinkInfo> virtualLinkInfo) {
    this.virtualLinkInfo = virtualLinkInfo;
  }

  public NsInstancesNsInstance vnffgInfo(List<NsInstancesNsInstanceVnffgInfo> vnffgInfo) {
    this.vnffgInfo = vnffgInfo;
    return this;
  }

  public NsInstancesNsInstance addVnffgInfoItem(NsInstancesNsInstanceVnffgInfo vnffgInfoItem) {
    if (this.vnffgInfo == null) {
      this.vnffgInfo = new ArrayList<>();
    }
    this.vnffgInfo.add(vnffgInfoItem);
    return this;
  }

   /**
   * Information on the VNFFG(s) of the NS instance. 
   * @return vnffgInfo
  **/
  @Schema(description = "Information on the VNFFG(s) of the NS instance. ")
  public List<NsInstancesNsInstanceVnffgInfo> getVnffgInfo() {
    return vnffgInfo;
  }

  public void setVnffgInfo(List<NsInstancesNsInstanceVnffgInfo> vnffgInfo) {
    this.vnffgInfo = vnffgInfo;
  }

  public NsInstancesNsInstance sapInfo(List<NsInstancesNsInstanceSapInfo> sapInfo) {
    this.sapInfo = sapInfo;
    return this;
  }

  public NsInstancesNsInstance addSapInfoItem(NsInstancesNsInstanceSapInfo sapInfoItem) {
    if (this.sapInfo == null) {
      this.sapInfo = new ArrayList<>();
    }
    this.sapInfo.add(sapInfoItem);
    return this;
  }

   /**
   * Information on the SAP(s) of the NS instance. 
   * @return sapInfo
  **/
  @Schema(description = "Information on the SAP(s) of the NS instance. ")
  public List<NsInstancesNsInstanceSapInfo> getSapInfo() {
    return sapInfo;
  }

  public void setSapInfo(List<NsInstancesNsInstanceSapInfo> sapInfo) {
    this.sapInfo = sapInfo;
  }

  public NsInstancesNsInstance nestedNsInstanceId(List<String> nestedNsInstanceId) {
    this.nestedNsInstanceId = nestedNsInstanceId;
    return this;
  }

  public NsInstancesNsInstance addNestedNsInstanceIdItem(String nestedNsInstanceIdItem) {
    if (this.nestedNsInstanceId == null) {
      this.nestedNsInstanceId = new ArrayList<>();
    }
    this.nestedNsInstanceId.add(nestedNsInstanceIdItem);
    return this;
  }

   /**
   * Identifier of the nested NS(s) of the NS instance. 
   * @return nestedNsInstanceId
  **/
  @Schema(description = "Identifier of the nested NS(s) of the NS instance. ")
  public List<String> getNestedNsInstanceId() {
    return nestedNsInstanceId;
  }

  public void setNestedNsInstanceId(List<String> nestedNsInstanceId) {
    this.nestedNsInstanceId = nestedNsInstanceId;
  }

  public NsInstancesNsInstance nsState(NsStateEnum nsState) {
    this.nsState = nsState;
    return this;
  }

   /**
   * The state of the NS instance. Permitted values: NOT_INSTANTIATED: The NS instance is terminated or not instantiated. INSTANTIATED: The NS instance is instantiated. 
   * @return nsState
  **/
  @Schema(required = true, description = "The state of the NS instance. Permitted values: NOT_INSTANTIATED: The NS instance is terminated or not instantiated. INSTANTIATED: The NS instance is instantiated. ")
  public NsStateEnum getNsState() {
    return nsState;
  }

  public void setNsState(NsStateEnum nsState) {
    this.nsState = nsState;
  }

  public NsInstancesNsInstance monitoringParameter(List<NsInstancesNsInstanceMonitoringParameter> monitoringParameter) {
    this.monitoringParameter = monitoringParameter;
    return this;
  }

  public NsInstancesNsInstance addMonitoringParameterItem(NsInstancesNsInstanceMonitoringParameter monitoringParameterItem) {
    if (this.monitoringParameter == null) {
      this.monitoringParameter = new ArrayList<>();
    }
    this.monitoringParameter.add(monitoringParameterItem);
    return this;
  }

   /**
   * Performance metrics tracked by the NFVO (e.g. for auto-scaling purposes) as identified by the NS designer in the NSD. 
   * @return monitoringParameter
  **/
  @Schema(description = "Performance metrics tracked by the NFVO (e.g. for auto-scaling purposes) as identified by the NS designer in the NSD. ")
  public List<NsInstancesNsInstanceMonitoringParameter> getMonitoringParameter() {
    return monitoringParameter;
  }

  public void setMonitoringParameter(List<NsInstancesNsInstanceMonitoringParameter> monitoringParameter) {
    this.monitoringParameter = monitoringParameter;
  }

  public NsInstancesNsInstance nsScaleStatus(List<NsInstancesNsInstanceNsScaleStatus> nsScaleStatus) {
    this.nsScaleStatus = nsScaleStatus;
    return this;
  }

  public NsInstancesNsInstance addNsScaleStatusItem(NsInstancesNsInstanceNsScaleStatus nsScaleStatusItem) {
    if (this.nsScaleStatus == null) {
      this.nsScaleStatus = new ArrayList<>();
    }
    this.nsScaleStatus.add(nsScaleStatusItem);
    return this;
  }

   /**
   * Status of each NS scaling aspect declared in the applicable DF, how \&quot;big\&quot; the NS instance has been scaled w.r.t. that aspect. This attribute shall be present if the nsState attribute value is INSTANTIATED. 
   * @return nsScaleStatus
  **/
  @Schema(description = "Status of each NS scaling aspect declared in the applicable DF, how \"big\" the NS instance has been scaled w.r.t. that aspect. This attribute shall be present if the nsState attribute value is INSTANTIATED. ")
  public List<NsInstancesNsInstanceNsScaleStatus> getNsScaleStatus() {
    return nsScaleStatus;
  }

  public void setNsScaleStatus(List<NsInstancesNsInstanceNsScaleStatus> nsScaleStatus) {
    this.nsScaleStatus = nsScaleStatus;
  }

  public NsInstancesNsInstance additionalAffinityOrAntiAffinityRule(List<NsInstancesNsInstanceAdditionalAffinityOrAntiAffinityRule> additionalAffinityOrAntiAffinityRule) {
    this.additionalAffinityOrAntiAffinityRule = additionalAffinityOrAntiAffinityRule;
    return this;
  }

  public NsInstancesNsInstance addAdditionalAffinityOrAntiAffinityRuleItem(NsInstancesNsInstanceAdditionalAffinityOrAntiAffinityRule additionalAffinityOrAntiAffinityRuleItem) {
    if (this.additionalAffinityOrAntiAffinityRule == null) {
      this.additionalAffinityOrAntiAffinityRule = new ArrayList<>();
    }
    this.additionalAffinityOrAntiAffinityRule.add(additionalAffinityOrAntiAffinityRuleItem);
    return this;
  }

   /**
   * Information on the additional affinity or anti-affinity rule from NS instantiation operation. Shall not conflict with rules already specified in the NSD. 
   * @return additionalAffinityOrAntiAffinityRule
  **/
  @Schema(description = "Information on the additional affinity or anti-affinity rule from NS instantiation operation. Shall not conflict with rules already specified in the NSD. ")
  public List<NsInstancesNsInstanceAdditionalAffinityOrAntiAffinityRule> getAdditionalAffinityOrAntiAffinityRule() {
    return additionalAffinityOrAntiAffinityRule;
  }

  public void setAdditionalAffinityOrAntiAffinityRule(List<NsInstancesNsInstanceAdditionalAffinityOrAntiAffinityRule> additionalAffinityOrAntiAffinityRule) {
    this.additionalAffinityOrAntiAffinityRule = additionalAffinityOrAntiAffinityRule;
  }

  public NsInstancesNsInstance _links(NsInstancesNsInstanceLinks _links) {
    this._links = _links;
    return this;
  }

   /**
   * Get _links
   * @return _links
  **/
  @Schema(required = true, description = "")
  public NsInstancesNsInstanceLinks getLinks() {
    return _links;
  }

  public void setLinks(NsInstancesNsInstanceLinks _links) {
    this._links = _links;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesNsInstance nsInstancesNsInstance = (NsInstancesNsInstance) o;
    return Objects.equals(this.id, nsInstancesNsInstance.id) &&
        Objects.equals(this.nsInstanceName, nsInstancesNsInstance.nsInstanceName) &&
        Objects.equals(this.nsInstanceDescription, nsInstancesNsInstance.nsInstanceDescription) &&
        Objects.equals(this.nsdId, nsInstancesNsInstance.nsdId) &&
        Objects.equals(this.nsdInfoId, nsInstancesNsInstance.nsdInfoId) &&
        Objects.equals(this.flavourId, nsInstancesNsInstance.flavourId) &&
        Objects.equals(this.vnfInstance, nsInstancesNsInstance.vnfInstance) &&
        Objects.equals(this.pnfInfo, nsInstancesNsInstance.pnfInfo) &&
        Objects.equals(this.virtualLinkInfo, nsInstancesNsInstance.virtualLinkInfo) &&
        Objects.equals(this.vnffgInfo, nsInstancesNsInstance.vnffgInfo) &&
        Objects.equals(this.sapInfo, nsInstancesNsInstance.sapInfo) &&
        Objects.equals(this.nestedNsInstanceId, nsInstancesNsInstance.nestedNsInstanceId) &&
        Objects.equals(this.nsState, nsInstancesNsInstance.nsState) &&
        Objects.equals(this.monitoringParameter, nsInstancesNsInstance.monitoringParameter) &&
        Objects.equals(this.nsScaleStatus, nsInstancesNsInstance.nsScaleStatus) &&
        Objects.equals(this.additionalAffinityOrAntiAffinityRule, nsInstancesNsInstance.additionalAffinityOrAntiAffinityRule) &&
        Objects.equals(this._links, nsInstancesNsInstance._links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nsInstanceName, nsInstanceDescription, nsdId, nsdInfoId, flavourId, vnfInstance, pnfInfo, virtualLinkInfo, vnffgInfo, sapInfo, nestedNsInstanceId, nsState, monitoringParameter, nsScaleStatus, additionalAffinityOrAntiAffinityRule, _links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesNsInstance {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nsInstanceName: ").append(toIndentedString(nsInstanceName)).append("\n");
    sb.append("    nsInstanceDescription: ").append(toIndentedString(nsInstanceDescription)).append("\n");
    sb.append("    nsdId: ").append(toIndentedString(nsdId)).append("\n");
    sb.append("    nsdInfoId: ").append(toIndentedString(nsdInfoId)).append("\n");
    sb.append("    flavourId: ").append(toIndentedString(flavourId)).append("\n");
    sb.append("    vnfInstance: ").append(toIndentedString(vnfInstance)).append("\n");
    sb.append("    pnfInfo: ").append(toIndentedString(pnfInfo)).append("\n");
    sb.append("    virtualLinkInfo: ").append(toIndentedString(virtualLinkInfo)).append("\n");
    sb.append("    vnffgInfo: ").append(toIndentedString(vnffgInfo)).append("\n");
    sb.append("    sapInfo: ").append(toIndentedString(sapInfo)).append("\n");
    sb.append("    nestedNsInstanceId: ").append(toIndentedString(nestedNsInstanceId)).append("\n");
    sb.append("    nsState: ").append(toIndentedString(nsState)).append("\n");
    sb.append("    monitoringParameter: ").append(toIndentedString(monitoringParameter)).append("\n");
    sb.append("    nsScaleStatus: ").append(toIndentedString(nsScaleStatus)).append("\n");
    sb.append("    additionalAffinityOrAntiAffinityRule: ").append(toIndentedString(additionalAffinityOrAntiAffinityRule)).append("\n");
    sb.append("    _links: ").append(toIndentedString(_links)).append("\n");
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
