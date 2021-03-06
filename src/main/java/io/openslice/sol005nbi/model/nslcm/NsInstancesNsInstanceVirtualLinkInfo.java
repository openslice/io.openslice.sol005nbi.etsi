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
 * This type specifies the information about an NS VL instance.  It shall comply with the provisions defined in Table 6.5.3.53-1 
 */
@Schema(description = "This type specifies the information about an NS VL instance.  It shall comply with the provisions defined in Table 6.5.3.53-1 ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesNsInstanceVirtualLinkInfo {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("nsVirtualLinkDescId")
  private String nsVirtualLinkDescId = null;

  @JsonProperty("nsVirtualLinkProfileId")
  private String nsVirtualLinkProfileId = null;

  @JsonProperty("resourceHandle")
  private List<NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle> resourceHandle = null;

  @JsonProperty("linkPort")
  private List<NsInstancesNsInstanceLinkPort> linkPort = null;

  public NsInstancesNsInstanceVirtualLinkInfo id(String id) {
    this.id = id;
    return this;
  }

   /**
   * An identifier that is unique with respect to a NS. Representation: string of variable length. 
   * @return id
  **/
  @Schema(required = true, description = "An identifier that is unique with respect to a NS. Representation: string of variable length. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public NsInstancesNsInstanceVirtualLinkInfo nsVirtualLinkDescId(String nsVirtualLinkDescId) {
    this.nsVirtualLinkDescId = nsVirtualLinkDescId;
    return this;
  }

   /**
   * An identifier that is unique within a NS descriptor. Representation: string of variable length. 
   * @return nsVirtualLinkDescId
  **/
  @Schema(required = true, description = "An identifier that is unique within a NS descriptor. Representation: string of variable length. ")
  public String getNsVirtualLinkDescId() {
    return nsVirtualLinkDescId;
  }

  public void setNsVirtualLinkDescId(String nsVirtualLinkDescId) {
    this.nsVirtualLinkDescId = nsVirtualLinkDescId;
  }

  public NsInstancesNsInstanceVirtualLinkInfo nsVirtualLinkProfileId(String nsVirtualLinkProfileId) {
    this.nsVirtualLinkProfileId = nsVirtualLinkProfileId;
    return this;
  }

   /**
   * An identifier that is unique within a NS descriptor. Representation: string of variable length. 
   * @return nsVirtualLinkProfileId
  **/
  @Schema(required = true, description = "An identifier that is unique within a NS descriptor. Representation: string of variable length. ")
  public String getNsVirtualLinkProfileId() {
    return nsVirtualLinkProfileId;
  }

  public void setNsVirtualLinkProfileId(String nsVirtualLinkProfileId) {
    this.nsVirtualLinkProfileId = nsVirtualLinkProfileId;
  }

  public NsInstancesNsInstanceVirtualLinkInfo resourceHandle(List<NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle> resourceHandle) {
    this.resourceHandle = resourceHandle;
    return this;
  }

  public NsInstancesNsInstanceVirtualLinkInfo addResourceHandleItem(NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle resourceHandleItem) {
    if (this.resourceHandle == null) {
      this.resourceHandle = new ArrayList<>();
    }
    this.resourceHandle.add(resourceHandleItem);
    return this;
  }

   /**
   * Identifier(s) of the virtualised network resource(s) realizing the VL instance. See note. 
   * @return resourceHandle
  **/
  @Schema(description = "Identifier(s) of the virtualised network resource(s) realizing the VL instance. See note. ")
  public List<NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle> getResourceHandle() {
    return resourceHandle;
  }

  public void setResourceHandle(List<NsInstancesNsInstanceInstantiatedVnfInfoResourceHandle> resourceHandle) {
    this.resourceHandle = resourceHandle;
  }

  public NsInstancesNsInstanceVirtualLinkInfo linkPort(List<NsInstancesNsInstanceLinkPort> linkPort) {
    this.linkPort = linkPort;
    return this;
  }

  public NsInstancesNsInstanceVirtualLinkInfo addLinkPortItem(NsInstancesNsInstanceLinkPort linkPortItem) {
    if (this.linkPort == null) {
      this.linkPort = new ArrayList<>();
    }
    this.linkPort.add(linkPortItem);
    return this;
  }

   /**
   * Link ports of the VL instance. Cardinality of zero indicates that no port has yet been created for the VL instance. 
   * @return linkPort
  **/
  @Schema(description = "Link ports of the VL instance. Cardinality of zero indicates that no port has yet been created for the VL instance. ")
  public List<NsInstancesNsInstanceLinkPort> getLinkPort() {
    return linkPort;
  }

  public void setLinkPort(List<NsInstancesNsInstanceLinkPort> linkPort) {
    this.linkPort = linkPort;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesNsInstanceVirtualLinkInfo nsInstancesNsInstanceVirtualLinkInfo = (NsInstancesNsInstanceVirtualLinkInfo) o;
    return Objects.equals(this.id, nsInstancesNsInstanceVirtualLinkInfo.id) &&
        Objects.equals(this.nsVirtualLinkDescId, nsInstancesNsInstanceVirtualLinkInfo.nsVirtualLinkDescId) &&
        Objects.equals(this.nsVirtualLinkProfileId, nsInstancesNsInstanceVirtualLinkInfo.nsVirtualLinkProfileId) &&
        Objects.equals(this.resourceHandle, nsInstancesNsInstanceVirtualLinkInfo.resourceHandle) &&
        Objects.equals(this.linkPort, nsInstancesNsInstanceVirtualLinkInfo.linkPort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nsVirtualLinkDescId, nsVirtualLinkProfileId, resourceHandle, linkPort);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesNsInstanceVirtualLinkInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nsVirtualLinkDescId: ").append(toIndentedString(nsVirtualLinkDescId)).append("\n");
    sb.append("    nsVirtualLinkProfileId: ").append(toIndentedString(nsVirtualLinkProfileId)).append("\n");
    sb.append("    resourceHandle: ").append(toIndentedString(resourceHandle)).append("\n");
    sb.append("    linkPort: ").append(toIndentedString(linkPort)).append("\n");
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
