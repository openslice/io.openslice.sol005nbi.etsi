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
 * This type represents subscription filter criteria to match NS instances. NOTE 1: The attributes \&quot;nsdIds\&quot;, \&quot;vnfdIds\&quot; and \&quot;pnfdIds\&quot; are alternatives to reference to NS instances that are created based on certain NSDs, or contain VNF instances that are based on certain VNFDs, or contain PNFs that are based on certain PNFDs in a filter. They should not be used together in the same filter instance, but one alternative should be chosen. NOTE 2: The attributes \&quot;nsInstanceIds\&quot; and \&quot;nsInstanceNames\&quot; are alternatives to reference to particular NS Instances in a filter. They should not be used both in the same filter instance, but one alternative should be chosen. 
 */
@Schema(description = "This type represents subscription filter criteria to match NS instances. NOTE 1: The attributes \"nsdIds\", \"vnfdIds\" and \"pnfdIds\" are alternatives to reference to NS instances that are created based on certain NSDs, or contain VNF instances that are based on certain VNFDs, or contain PNFs that are based on certain PNFDs in a filter. They should not be used together in the same filter instance, but one alternative should be chosen. NOTE 2: The attributes \"nsInstanceIds\" and \"nsInstanceNames\" are alternatives to reference to particular NS Instances in a filter. They should not be used both in the same filter instance, but one alternative should be chosen. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class SubscriptionsFilterNsInstanceSubscriptionFilter {
  @JsonProperty("nsdIds")
  private List<String> nsdIds = null;

  @JsonProperty("vnfdIds")
  private List<String> vnfdIds = null;

  @JsonProperty("pnfdIds")
  private List<String> pnfdIds = null;

  @JsonProperty("nsInstanceIds")
  private List<String> nsInstanceIds = null;

  @JsonProperty("nsInstanceNames")
  private List<String> nsInstanceNames = null;

  public SubscriptionsFilterNsInstanceSubscriptionFilter nsdIds(List<String> nsdIds) {
    this.nsdIds = nsdIds;
    return this;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter addNsdIdsItem(String nsdIdsItem) {
    if (this.nsdIds == null) {
      this.nsdIds = new ArrayList<>();
    }
    this.nsdIds.add(nsdIdsItem);
    return this;
  }

   /**
   * If present, match NS instances that were created based on a NSD identified by one of the nsdId values listed in this attribute. 
   * @return nsdIds
  **/
  @Schema(description = "If present, match NS instances that were created based on a NSD identified by one of the nsdId values listed in this attribute. ")
  public List<String> getNsdIds() {
    return nsdIds;
  }

  public void setNsdIds(List<String> nsdIds) {
    this.nsdIds = nsdIds;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter vnfdIds(List<String> vnfdIds) {
    this.vnfdIds = vnfdIds;
    return this;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter addVnfdIdsItem(String vnfdIdsItem) {
    if (this.vnfdIds == null) {
      this.vnfdIds = new ArrayList<>();
    }
    this.vnfdIds.add(vnfdIdsItem);
    return this;
  }

   /**
   * If present, match NS instances that contain VNF instances that were created based on a VNFD identified by one of the vnfdId values listed in this attribute. 
   * @return vnfdIds
  **/
  @Schema(description = "If present, match NS instances that contain VNF instances that were created based on a VNFD identified by one of the vnfdId values listed in this attribute. ")
  public List<String> getVnfdIds() {
    return vnfdIds;
  }

  public void setVnfdIds(List<String> vnfdIds) {
    this.vnfdIds = vnfdIds;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter pnfdIds(List<String> pnfdIds) {
    this.pnfdIds = pnfdIds;
    return this;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter addPnfdIdsItem(String pnfdIdsItem) {
    if (this.pnfdIds == null) {
      this.pnfdIds = new ArrayList<>();
    }
    this.pnfdIds.add(pnfdIdsItem);
    return this;
  }

   /**
   * If present, match NS instances that contain PNFs that are represented by a PNFD identified by one of the pnfdId values listed in this attribute. 
   * @return pnfdIds
  **/
  @Schema(description = "If present, match NS instances that contain PNFs that are represented by a PNFD identified by one of the pnfdId values listed in this attribute. ")
  public List<String> getPnfdIds() {
    return pnfdIds;
  }

  public void setPnfdIds(List<String> pnfdIds) {
    this.pnfdIds = pnfdIds;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter nsInstanceIds(List<String> nsInstanceIds) {
    this.nsInstanceIds = nsInstanceIds;
    return this;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter addNsInstanceIdsItem(String nsInstanceIdsItem) {
    if (this.nsInstanceIds == null) {
      this.nsInstanceIds = new ArrayList<>();
    }
    this.nsInstanceIds.add(nsInstanceIdsItem);
    return this;
  }

   /**
   * If present, match NS instances with an instance identifier listed in this attribute. 
   * @return nsInstanceIds
  **/
  @Schema(description = "If present, match NS instances with an instance identifier listed in this attribute. ")
  public List<String> getNsInstanceIds() {
    return nsInstanceIds;
  }

  public void setNsInstanceIds(List<String> nsInstanceIds) {
    this.nsInstanceIds = nsInstanceIds;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter nsInstanceNames(List<String> nsInstanceNames) {
    this.nsInstanceNames = nsInstanceNames;
    return this;
  }

  public SubscriptionsFilterNsInstanceSubscriptionFilter addNsInstanceNamesItem(String nsInstanceNamesItem) {
    if (this.nsInstanceNames == null) {
      this.nsInstanceNames = new ArrayList<>();
    }
    this.nsInstanceNames.add(nsInstanceNamesItem);
    return this;
  }

   /**
   * If present, match NS instances with a NS Instance Name listed in this attribute. 
   * @return nsInstanceNames
  **/
  @Schema(description = "If present, match NS instances with a NS Instance Name listed in this attribute. ")
  public List<String> getNsInstanceNames() {
    return nsInstanceNames;
  }

  public void setNsInstanceNames(List<String> nsInstanceNames) {
    this.nsInstanceNames = nsInstanceNames;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionsFilterNsInstanceSubscriptionFilter subscriptionsFilterNsInstanceSubscriptionFilter = (SubscriptionsFilterNsInstanceSubscriptionFilter) o;
    return Objects.equals(this.nsdIds, subscriptionsFilterNsInstanceSubscriptionFilter.nsdIds) &&
        Objects.equals(this.vnfdIds, subscriptionsFilterNsInstanceSubscriptionFilter.vnfdIds) &&
        Objects.equals(this.pnfdIds, subscriptionsFilterNsInstanceSubscriptionFilter.pnfdIds) &&
        Objects.equals(this.nsInstanceIds, subscriptionsFilterNsInstanceSubscriptionFilter.nsInstanceIds) &&
        Objects.equals(this.nsInstanceNames, subscriptionsFilterNsInstanceSubscriptionFilter.nsInstanceNames);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nsdIds, vnfdIds, pnfdIds, nsInstanceIds, nsInstanceNames);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionsFilterNsInstanceSubscriptionFilter {\n");
    
    sb.append("    nsdIds: ").append(toIndentedString(nsdIds)).append("\n");
    sb.append("    vnfdIds: ").append(toIndentedString(vnfdIds)).append("\n");
    sb.append("    pnfdIds: ").append(toIndentedString(pnfdIds)).append("\n");
    sb.append("    nsInstanceIds: ").append(toIndentedString(nsInstanceIds)).append("\n");
    sb.append("    nsInstanceNames: ").append(toIndentedString(nsInstanceNames)).append("\n");
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
