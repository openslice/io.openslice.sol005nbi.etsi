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
 * This type contains information used to create or modify NFP instance parameters for the update of an existing VNFFG instance. It shall comply with the provisions defined in Table 6.5.3.38-1. 
 */
@Schema(description = "This type contains information used to create or modify NFP instance parameters for the update of an existing VNFFG instance. It shall comply with the provisions defined in Table 6.5.3.38-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesnsInstanceIdupdateNfp {
  @JsonProperty("nfpInfoId")
  private String nfpInfoId = null;

  @JsonProperty("nfpName")
  private String nfpName = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("cpGroup")
  private List<NsInstancesnsInstanceIdupdateCpGroup> cpGroup = null;

  @JsonProperty("nfpRule")
  private NsInstancesnsInstanceIdupdateNfpRule nfpRule = null;

  public NsInstancesnsInstanceIdupdateNfp nfpInfoId(String nfpInfoId) {
    this.nfpInfoId = nfpInfoId;
    return this;
  }

   /**
   * An identifier that is unique with respect to a NS. Representation: string of variable length. 
   * @return nfpInfoId
  **/
  @Schema(description = "An identifier that is unique with respect to a NS. Representation: string of variable length. ")
  public String getNfpInfoId() {
    return nfpInfoId;
  }

  public void setNfpInfoId(String nfpInfoId) {
    this.nfpInfoId = nfpInfoId;
  }

  public NsInstancesnsInstanceIdupdateNfp nfpName(String nfpName) {
    this.nfpName = nfpName;
    return this;
  }

   /**
   * Human readable name for the NFP. It shall be present for the new NFP, and it may be present otherwise. It shall be present for the new NFP, and it may be  present otherwise. 
   * @return nfpName
  **/
  @Schema(description = "Human readable name for the NFP. It shall be present for the new NFP, and it may be present otherwise. It shall be present for the new NFP, and it may be  present otherwise. ")
  public String getNfpName() {
    return nfpName;
  }

  public void setNfpName(String nfpName) {
    this.nfpName = nfpName;
  }

  public NsInstancesnsInstanceIdupdateNfp description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Human readable description for the NFP. It shall be present for the new NFP, and it may be present otherwise. It shall be present for the new NFP, and it may be  present otherwise. 
   * @return description
  **/
  @Schema(description = "Human readable description for the NFP. It shall be present for the new NFP, and it may be present otherwise. It shall be present for the new NFP, and it may be  present otherwise. ")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NsInstancesnsInstanceIdupdateNfp cpGroup(List<NsInstancesnsInstanceIdupdateCpGroup> cpGroup) {
    this.cpGroup = cpGroup;
    return this;
  }

  public NsInstancesnsInstanceIdupdateNfp addCpGroupItem(NsInstancesnsInstanceIdupdateCpGroup cpGroupItem) {
    if (this.cpGroup == null) {
      this.cpGroup = new ArrayList<>();
    }
    this.cpGroup.add(cpGroupItem);
    return this;
  }

   /**
   * Group(s) of CPs and/or SAPs which the NFP passes by. Cardinality can be 0 if only updated or newly created NFP classification and selection rule which applied to an existing NFP is provided. At least a CP or an nfpRule shall be present. When multiple identifiers are included, the position of  the identifier in the cpGroup value specifies the position  of the group in the path. 
   * @return cpGroup
  **/
  @Schema(description = "Group(s) of CPs and/or SAPs which the NFP passes by. Cardinality can be 0 if only updated or newly created NFP classification and selection rule which applied to an existing NFP is provided. At least a CP or an nfpRule shall be present. When multiple identifiers are included, the position of  the identifier in the cpGroup value specifies the position  of the group in the path. ")
  public List<NsInstancesnsInstanceIdupdateCpGroup> getCpGroup() {
    return cpGroup;
  }

  public void setCpGroup(List<NsInstancesnsInstanceIdupdateCpGroup> cpGroup) {
    this.cpGroup = cpGroup;
  }

  public NsInstancesnsInstanceIdupdateNfp nfpRule(NsInstancesnsInstanceIdupdateNfpRule nfpRule) {
    this.nfpRule = nfpRule;
    return this;
  }

   /**
   * Get nfpRule
   * @return nfpRule
  **/
  @Schema(description = "")
  public NsInstancesnsInstanceIdupdateNfpRule getNfpRule() {
    return nfpRule;
  }

  public void setNfpRule(NsInstancesnsInstanceIdupdateNfpRule nfpRule) {
    this.nfpRule = nfpRule;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesnsInstanceIdupdateNfp nsInstancesnsInstanceIdupdateNfp = (NsInstancesnsInstanceIdupdateNfp) o;
    return Objects.equals(this.nfpInfoId, nsInstancesnsInstanceIdupdateNfp.nfpInfoId) &&
        Objects.equals(this.nfpName, nsInstancesnsInstanceIdupdateNfp.nfpName) &&
        Objects.equals(this.description, nsInstancesnsInstanceIdupdateNfp.description) &&
        Objects.equals(this.cpGroup, nsInstancesnsInstanceIdupdateNfp.cpGroup) &&
        Objects.equals(this.nfpRule, nsInstancesnsInstanceIdupdateNfp.nfpRule);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nfpInfoId, nfpName, description, cpGroup, nfpRule);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesnsInstanceIdupdateNfp {\n");
    
    sb.append("    nfpInfoId: ").append(toIndentedString(nfpInfoId)).append("\n");
    sb.append("    nfpName: ").append(toIndentedString(nfpName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    cpGroup: ").append(toIndentedString(cpGroup)).append("\n");
    sb.append("    nfpRule: ").append(toIndentedString(nfpRule)).append("\n");
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
