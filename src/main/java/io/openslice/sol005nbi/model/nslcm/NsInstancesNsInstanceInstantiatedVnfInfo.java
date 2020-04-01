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
 * Information specific to an instantiated VNF instance. This attribute shall be present if the instantiateState attribute value is INSTANTIATED. 
 */
@Schema(description = "Information specific to an instantiated VNF instance. This attribute shall be present if the instantiateState attribute value is INSTANTIATED. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesNsInstanceInstantiatedVnfInfo {
  @JsonProperty("flavourId")
  private String flavourId = null;

  /**
   * Gets or Sets vnfState
   */
  public enum VnfStateEnum {
    STARTED("STARTED"),
    STOPPED("STOPPED");

    private String value;

    VnfStateEnum(String value) {
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
    public static VnfStateEnum fromValue(String text) {
      for (VnfStateEnum b : VnfStateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("vnfState")
  private VnfStateEnum vnfState = null;

  @JsonProperty("scaleStatus")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> scaleStatus = null;

  @JsonProperty("maxScaleLevels")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> maxScaleLevels = null;

  @JsonProperty("extCpInfo")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoExtCpInfo> extCpInfo = new ArrayList<>();

  @JsonProperty("extVirtualLinkInfo")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoExtVirtualLinkInfo> extVirtualLinkInfo = null;

  @JsonProperty("extManagedVirtualLinkInfo")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoExtManagedVirtualLinkInfo> extManagedVirtualLinkInfo = null;

  @JsonProperty("monitoringParameters")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoMonitoringParameters> monitoringParameters = null;

  @JsonProperty("localizationLanguage")
  private String localizationLanguage = null;

  @JsonProperty("vnfcResourceInfo")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoVnfcResourceInfo> vnfcResourceInfo = null;

  @JsonProperty("virtualLinkResourceInfo")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualLinkResourceInfo> virtualLinkResourceInfo = null;

  @JsonProperty("virtualStorageResourceInfo")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualStorageResourceInfo> virtualStorageResourceInfo = null;

  public NsInstancesNsInstanceInstantiatedVnfInfo flavourId(String flavourId) {
    this.flavourId = flavourId;
    return this;
  }

   /**
   * Identifier of the VNF Virtual Link Descriptor (VLD) in the VNFD. 
   * @return flavourId
  **/
  @Schema(required = true, description = "Identifier of the VNF Virtual Link Descriptor (VLD) in the VNFD. ")
  public String getFlavourId() {
    return flavourId;
  }

  public void setFlavourId(String flavourId) {
    this.flavourId = flavourId;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo vnfState(VnfStateEnum vnfState) {
    this.vnfState = vnfState;
    return this;
  }

   /**
   * Get vnfState
   * @return vnfState
  **/
  @Schema(required = true, description = "")
  public VnfStateEnum getVnfState() {
    return vnfState;
  }

  public void setVnfState(VnfStateEnum vnfState) {
    this.vnfState = vnfState;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo scaleStatus(List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> scaleStatus) {
    this.scaleStatus = scaleStatus;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addScaleStatusItem(NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus scaleStatusItem) {
    if (this.scaleStatus == null) {
      this.scaleStatus = new ArrayList<>();
    }
    this.scaleStatus.add(scaleStatusItem);
    return this;
  }

   /**
   * Scale status of the VNF, one entry per aspect. Represents for every scaling aspect how \&quot;big\&quot; the VNF has been scaled w.r.t. that aspect. 
   * @return scaleStatus
  **/
  @Schema(description = "Scale status of the VNF, one entry per aspect. Represents for every scaling aspect how \"big\" the VNF has been scaled w.r.t. that aspect. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> getScaleStatus() {
    return scaleStatus;
  }

  public void setScaleStatus(List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> scaleStatus) {
    this.scaleStatus = scaleStatus;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo maxScaleLevels(List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> maxScaleLevels) {
    this.maxScaleLevels = maxScaleLevels;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addMaxScaleLevelsItem(NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus maxScaleLevelsItem) {
    if (this.maxScaleLevels == null) {
      this.maxScaleLevels = new ArrayList<>();
    }
    this.maxScaleLevels.add(maxScaleLevelsItem);
    return this;
  }

   /**
   * Maximum allowed scale levels of the VNF, one entry per aspect. This attribute shall be present if the VNF supports scaling. 
   * @return maxScaleLevels
  **/
  @Schema(description = "Maximum allowed scale levels of the VNF, one entry per aspect. This attribute shall be present if the VNF supports scaling. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> getMaxScaleLevels() {
    return maxScaleLevels;
  }

  public void setMaxScaleLevels(List<NsInstancesNsInstanceInstantiatedVnfInfoScaleStatus> maxScaleLevels) {
    this.maxScaleLevels = maxScaleLevels;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo extCpInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoExtCpInfo> extCpInfo) {
    this.extCpInfo = extCpInfo;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addExtCpInfoItem(NsInstancesNsInstanceInstantiatedVnfInfoExtCpInfo extCpInfoItem) {
    this.extCpInfo.add(extCpInfoItem);
    return this;
  }

   /**
   * Information about the external CPs exposed by the VNF instance. 
   * @return extCpInfo
  **/
  @Schema(required = true, description = "Information about the external CPs exposed by the VNF instance. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoExtCpInfo> getExtCpInfo() {
    return extCpInfo;
  }

  public void setExtCpInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoExtCpInfo> extCpInfo) {
    this.extCpInfo = extCpInfo;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo extVirtualLinkInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoExtVirtualLinkInfo> extVirtualLinkInfo) {
    this.extVirtualLinkInfo = extVirtualLinkInfo;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addExtVirtualLinkInfoItem(NsInstancesNsInstanceInstantiatedVnfInfoExtVirtualLinkInfo extVirtualLinkInfoItem) {
    if (this.extVirtualLinkInfo == null) {
      this.extVirtualLinkInfo = new ArrayList<>();
    }
    this.extVirtualLinkInfo.add(extVirtualLinkInfoItem);
    return this;
  }

   /**
   * Information about the external VLs the VNF instance is connected to. 
   * @return extVirtualLinkInfo
  **/
  @Schema(description = "Information about the external VLs the VNF instance is connected to. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoExtVirtualLinkInfo> getExtVirtualLinkInfo() {
    return extVirtualLinkInfo;
  }

  public void setExtVirtualLinkInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoExtVirtualLinkInfo> extVirtualLinkInfo) {
    this.extVirtualLinkInfo = extVirtualLinkInfo;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo extManagedVirtualLinkInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoExtManagedVirtualLinkInfo> extManagedVirtualLinkInfo) {
    this.extManagedVirtualLinkInfo = extManagedVirtualLinkInfo;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addExtManagedVirtualLinkInfoItem(NsInstancesNsInstanceInstantiatedVnfInfoExtManagedVirtualLinkInfo extManagedVirtualLinkInfoItem) {
    if (this.extManagedVirtualLinkInfo == null) {
      this.extManagedVirtualLinkInfo = new ArrayList<>();
    }
    this.extManagedVirtualLinkInfo.add(extManagedVirtualLinkInfoItem);
    return this;
  }

   /**
   * External virtual links the VNF instance is connected to. 
   * @return extManagedVirtualLinkInfo
  **/
  @Schema(description = "External virtual links the VNF instance is connected to. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoExtManagedVirtualLinkInfo> getExtManagedVirtualLinkInfo() {
    return extManagedVirtualLinkInfo;
  }

  public void setExtManagedVirtualLinkInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoExtManagedVirtualLinkInfo> extManagedVirtualLinkInfo) {
    this.extManagedVirtualLinkInfo = extManagedVirtualLinkInfo;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo monitoringParameters(List<NsInstancesNsInstanceInstantiatedVnfInfoMonitoringParameters> monitoringParameters) {
    this.monitoringParameters = monitoringParameters;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addMonitoringParametersItem(NsInstancesNsInstanceInstantiatedVnfInfoMonitoringParameters monitoringParametersItem) {
    if (this.monitoringParameters == null) {
      this.monitoringParameters = new ArrayList<>();
    }
    this.monitoringParameters.add(monitoringParametersItem);
    return this;
  }

   /**
   * Performance metrics tracked by the VNFM (e.g. for  auto-scaling purposes) as identified by the VNF  provider in the VNFD. 
   * @return monitoringParameters
  **/
  @Schema(description = "Performance metrics tracked by the VNFM (e.g. for  auto-scaling purposes) as identified by the VNF  provider in the VNFD. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoMonitoringParameters> getMonitoringParameters() {
    return monitoringParameters;
  }

  public void setMonitoringParameters(List<NsInstancesNsInstanceInstantiatedVnfInfoMonitoringParameters> monitoringParameters) {
    this.monitoringParameters = monitoringParameters;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo localizationLanguage(String localizationLanguage) {
    this.localizationLanguage = localizationLanguage;
    return this;
  }

   /**
   * Information about localization language of the VNF (includes e.g. strings in the VNFD). The localization languages supported by a VNF can be declared in the VNFD, and localization language selection can take place at instantiation time. The value shall comply with the format defined in IETF RFC 5646. 
   * @return localizationLanguage
  **/
  @Schema(description = "Information about localization language of the VNF (includes e.g. strings in the VNFD). The localization languages supported by a VNF can be declared in the VNFD, and localization language selection can take place at instantiation time. The value shall comply with the format defined in IETF RFC 5646. ")
  public String getLocalizationLanguage() {
    return localizationLanguage;
  }

  public void setLocalizationLanguage(String localizationLanguage) {
    this.localizationLanguage = localizationLanguage;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo vnfcResourceInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoVnfcResourceInfo> vnfcResourceInfo) {
    this.vnfcResourceInfo = vnfcResourceInfo;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addVnfcResourceInfoItem(NsInstancesNsInstanceInstantiatedVnfInfoVnfcResourceInfo vnfcResourceInfoItem) {
    if (this.vnfcResourceInfo == null) {
      this.vnfcResourceInfo = new ArrayList<>();
    }
    this.vnfcResourceInfo.add(vnfcResourceInfoItem);
    return this;
  }

   /**
   * Information about the virtualised compute and storage resources used by the VNFCs of the VNF instance. 
   * @return vnfcResourceInfo
  **/
  @Schema(description = "Information about the virtualised compute and storage resources used by the VNFCs of the VNF instance. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoVnfcResourceInfo> getVnfcResourceInfo() {
    return vnfcResourceInfo;
  }

  public void setVnfcResourceInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoVnfcResourceInfo> vnfcResourceInfo) {
    this.vnfcResourceInfo = vnfcResourceInfo;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo virtualLinkResourceInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualLinkResourceInfo> virtualLinkResourceInfo) {
    this.virtualLinkResourceInfo = virtualLinkResourceInfo;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addVirtualLinkResourceInfoItem(NsInstancesNsInstanceInstantiatedVnfInfoVirtualLinkResourceInfo virtualLinkResourceInfoItem) {
    if (this.virtualLinkResourceInfo == null) {
      this.virtualLinkResourceInfo = new ArrayList<>();
    }
    this.virtualLinkResourceInfo.add(virtualLinkResourceInfoItem);
    return this;
  }

   /**
   * Information about the virtualised network resources used by the VLs of the VNF instance. 
   * @return virtualLinkResourceInfo
  **/
  @Schema(description = "Information about the virtualised network resources used by the VLs of the VNF instance. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualLinkResourceInfo> getVirtualLinkResourceInfo() {
    return virtualLinkResourceInfo;
  }

  public void setVirtualLinkResourceInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualLinkResourceInfo> virtualLinkResourceInfo) {
    this.virtualLinkResourceInfo = virtualLinkResourceInfo;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo virtualStorageResourceInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualStorageResourceInfo> virtualStorageResourceInfo) {
    this.virtualStorageResourceInfo = virtualStorageResourceInfo;
    return this;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfo addVirtualStorageResourceInfoItem(NsInstancesNsInstanceInstantiatedVnfInfoVirtualStorageResourceInfo virtualStorageResourceInfoItem) {
    if (this.virtualStorageResourceInfo == null) {
      this.virtualStorageResourceInfo = new ArrayList<>();
    }
    this.virtualStorageResourceInfo.add(virtualStorageResourceInfoItem);
    return this;
  }

   /**
   * Information on the virtualised storage resource(s) used as storage for the VNF instance. 
   * @return virtualStorageResourceInfo
  **/
  @Schema(description = "Information on the virtualised storage resource(s) used as storage for the VNF instance. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualStorageResourceInfo> getVirtualStorageResourceInfo() {
    return virtualStorageResourceInfo;
  }

  public void setVirtualStorageResourceInfo(List<NsInstancesNsInstanceInstantiatedVnfInfoVirtualStorageResourceInfo> virtualStorageResourceInfo) {
    this.virtualStorageResourceInfo = virtualStorageResourceInfo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesNsInstanceInstantiatedVnfInfo nsInstancesNsInstanceInstantiatedVnfInfo = (NsInstancesNsInstanceInstantiatedVnfInfo) o;
    return Objects.equals(this.flavourId, nsInstancesNsInstanceInstantiatedVnfInfo.flavourId) &&
        Objects.equals(this.vnfState, nsInstancesNsInstanceInstantiatedVnfInfo.vnfState) &&
        Objects.equals(this.scaleStatus, nsInstancesNsInstanceInstantiatedVnfInfo.scaleStatus) &&
        Objects.equals(this.maxScaleLevels, nsInstancesNsInstanceInstantiatedVnfInfo.maxScaleLevels) &&
        Objects.equals(this.extCpInfo, nsInstancesNsInstanceInstantiatedVnfInfo.extCpInfo) &&
        Objects.equals(this.extVirtualLinkInfo, nsInstancesNsInstanceInstantiatedVnfInfo.extVirtualLinkInfo) &&
        Objects.equals(this.extManagedVirtualLinkInfo, nsInstancesNsInstanceInstantiatedVnfInfo.extManagedVirtualLinkInfo) &&
        Objects.equals(this.monitoringParameters, nsInstancesNsInstanceInstantiatedVnfInfo.monitoringParameters) &&
        Objects.equals(this.localizationLanguage, nsInstancesNsInstanceInstantiatedVnfInfo.localizationLanguage) &&
        Objects.equals(this.vnfcResourceInfo, nsInstancesNsInstanceInstantiatedVnfInfo.vnfcResourceInfo) &&
        Objects.equals(this.virtualLinkResourceInfo, nsInstancesNsInstanceInstantiatedVnfInfo.virtualLinkResourceInfo) &&
        Objects.equals(this.virtualStorageResourceInfo, nsInstancesNsInstanceInstantiatedVnfInfo.virtualStorageResourceInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flavourId, vnfState, scaleStatus, maxScaleLevels, extCpInfo, extVirtualLinkInfo, extManagedVirtualLinkInfo, monitoringParameters, localizationLanguage, vnfcResourceInfo, virtualLinkResourceInfo, virtualStorageResourceInfo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesNsInstanceInstantiatedVnfInfo {\n");
    
    sb.append("    flavourId: ").append(toIndentedString(flavourId)).append("\n");
    sb.append("    vnfState: ").append(toIndentedString(vnfState)).append("\n");
    sb.append("    scaleStatus: ").append(toIndentedString(scaleStatus)).append("\n");
    sb.append("    maxScaleLevels: ").append(toIndentedString(maxScaleLevels)).append("\n");
    sb.append("    extCpInfo: ").append(toIndentedString(extCpInfo)).append("\n");
    sb.append("    extVirtualLinkInfo: ").append(toIndentedString(extVirtualLinkInfo)).append("\n");
    sb.append("    extManagedVirtualLinkInfo: ").append(toIndentedString(extManagedVirtualLinkInfo)).append("\n");
    sb.append("    monitoringParameters: ").append(toIndentedString(monitoringParameters)).append("\n");
    sb.append("    localizationLanguage: ").append(toIndentedString(localizationLanguage)).append("\n");
    sb.append("    vnfcResourceInfo: ").append(toIndentedString(vnfcResourceInfo)).append("\n");
    sb.append("    virtualLinkResourceInfo: ").append(toIndentedString(virtualLinkResourceInfo)).append("\n");
    sb.append("    virtualStorageResourceInfo: ").append(toIndentedString(virtualStorageResourceInfo)).append("\n");
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
