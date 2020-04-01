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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("resourceHandle")
  private NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle resourceHandle = null;

  @JsonProperty("cpInstanceId")
  private String cpInstanceId = null;

  /**
   * Type of the CP instance that is identified by cpInstanceId. Shall be present if \&quot;cpInstanceId\&quot; is present, and shall be absent otherwise. Permitted values: * VNFC_CP: The link port is connected to a VNFC CP * EXT_CP: The link port is associated to an external CP. 
   */
  public enum CpInstanceTypeEnum {
    VNFC_CP("VNFC_CP"),
    EXT_CP("EXT_CP");

    private String value;

    CpInstanceTypeEnum(String value) {
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
    public static CpInstanceTypeEnum fromValue(String text) {
      for (CpInstanceTypeEnum b : CpInstanceTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("cpInstanceType")
  private CpInstanceTypeEnum cpInstanceType = null;

  public NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts id(String id) {
    this.id = id;
    return this;
  }

   /**
   * An identifier that is unique for the respective type within a VNF instance, but may not be globally unique. 
   * @return id
  **/
  @Schema(required = true, description = "An identifier that is unique for the respective type within a VNF instance, but may not be globally unique. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts resourceHandle(NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle resourceHandle) {
    this.resourceHandle = resourceHandle;
    return this;
  }

   /**
   * Get resourceHandle
   * @return resourceHandle
  **/
  @Schema(required = true, description = "")
  public NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle getResourceHandle() {
    return resourceHandle;
  }

  public void setResourceHandle(NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle resourceHandle) {
    this.resourceHandle = resourceHandle;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts cpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
    return this;
  }

   /**
   * An identifier that is unique for the respective type within a VNF instance, but may not be globally unique. 
   * @return cpInstanceId
  **/
  @Schema(description = "An identifier that is unique for the respective type within a VNF instance, but may not be globally unique. ")
  public String getCpInstanceId() {
    return cpInstanceId;
  }

  public void setCpInstanceId(String cpInstanceId) {
    this.cpInstanceId = cpInstanceId;
  }

  public NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts cpInstanceType(CpInstanceTypeEnum cpInstanceType) {
    this.cpInstanceType = cpInstanceType;
    return this;
  }

   /**
   * Type of the CP instance that is identified by cpInstanceId. Shall be present if \&quot;cpInstanceId\&quot; is present, and shall be absent otherwise. Permitted values: * VNFC_CP: The link port is connected to a VNFC CP * EXT_CP: The link port is associated to an external CP. 
   * @return cpInstanceType
  **/
  @Schema(description = "Type of the CP instance that is identified by cpInstanceId. Shall be present if \"cpInstanceId\" is present, and shall be absent otherwise. Permitted values: * VNFC_CP: The link port is connected to a VNFC CP * EXT_CP: The link port is associated to an external CP. ")
  public CpInstanceTypeEnum getCpInstanceType() {
    return cpInstanceType;
  }

  public void setCpInstanceType(CpInstanceTypeEnum cpInstanceType) {
    this.cpInstanceType = cpInstanceType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts nsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts = (NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts) o;
    return Objects.equals(this.id, nsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts.id) &&
        Objects.equals(this.resourceHandle, nsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts.resourceHandle) &&
        Objects.equals(this.cpInstanceId, nsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts.cpInstanceId) &&
        Objects.equals(this.cpInstanceType, nsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts.cpInstanceType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, resourceHandle, cpInstanceId, cpInstanceType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesNsInstanceInstantiatedVnfInfoVnfLinkPorts {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    resourceHandle: ").append(toIndentedString(resourceHandle)).append("\n");
    sb.append("    cpInstanceId: ").append(toIndentedString(cpInstanceId)).append("\n");
    sb.append("    cpInstanceType: ").append(toIndentedString(cpInstanceType)).append("\n");
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
