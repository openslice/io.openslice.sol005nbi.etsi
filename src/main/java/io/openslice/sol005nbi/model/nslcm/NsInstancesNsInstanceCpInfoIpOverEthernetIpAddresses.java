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
 * NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses {
  /**
   * The type of the IP addresses. Permitted values: IPV4, IPV6. 
   */
  public enum TypeEnum {
    IPV4("IPV4"),
    IPV6("IPV6");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("type")
  private TypeEnum type = null;

  @JsonProperty("fixedAddresses")
  private List<String> fixedAddresses = null;

  @JsonProperty("numDynamicAddresses")
  private Integer numDynamicAddresses = null;

  @JsonProperty("addressRange")
  private NsInstancesNsInstanceCpInfoIpOverEthernetAddressRange addressRange = null;

  @JsonProperty("subnetId")
  private String subnetId = null;

  public NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * The type of the IP addresses. Permitted values: IPV4, IPV6. 
   * @return type
  **/
  @Schema(required = true, description = "The type of the IP addresses. Permitted values: IPV4, IPV6. ")
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses fixedAddresses(List<String> fixedAddresses) {
    this.fixedAddresses = fixedAddresses;
    return this;
  }

  public NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses addFixedAddressesItem(String fixedAddressesItem) {
    if (this.fixedAddresses == null) {
      this.fixedAddresses = new ArrayList<>();
    }
    this.fixedAddresses.add(fixedAddressesItem);
    return this;
  }

   /**
   * Fixed addresses to assign (from the subnet defined by \&quot;subnetId\&quot; if provided). Exactly one of \&quot;fixedAddresses\&quot;, \&quot;numDynamicAddresses\&quot; or \&quot;ipAddressRange\&quot; shall be present. 
   * @return fixedAddresses
  **/
  @Schema(description = "Fixed addresses to assign (from the subnet defined by \"subnetId\" if provided). Exactly one of \"fixedAddresses\", \"numDynamicAddresses\" or \"ipAddressRange\" shall be present. ")
  public List<String> getFixedAddresses() {
    return fixedAddresses;
  }

  public void setFixedAddresses(List<String> fixedAddresses) {
    this.fixedAddresses = fixedAddresses;
  }

  public NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses numDynamicAddresses(Integer numDynamicAddresses) {
    this.numDynamicAddresses = numDynamicAddresses;
    return this;
  }

   /**
   * Number of dynamic addresses to assign (from the subnet defined by \&quot;subnetId\&quot; if provided). Exactly one of \&quot;fixedAddresses\&quot;, \&quot;numDynamicAddresses\&quot; or \&quot;ipAddressRange\&quot; shall be present. 
   * @return numDynamicAddresses
  **/
  @Schema(description = "Number of dynamic addresses to assign (from the subnet defined by \"subnetId\" if provided). Exactly one of \"fixedAddresses\", \"numDynamicAddresses\" or \"ipAddressRange\" shall be present. ")
  public Integer getNumDynamicAddresses() {
    return numDynamicAddresses;
  }

  public void setNumDynamicAddresses(Integer numDynamicAddresses) {
    this.numDynamicAddresses = numDynamicAddresses;
  }

  public NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses addressRange(NsInstancesNsInstanceCpInfoIpOverEthernetAddressRange addressRange) {
    this.addressRange = addressRange;
    return this;
  }

   /**
   * Get addressRange
   * @return addressRange
  **/
  @Schema(description = "")
  public NsInstancesNsInstanceCpInfoIpOverEthernetAddressRange getAddressRange() {
    return addressRange;
  }

  public void setAddressRange(NsInstancesNsInstanceCpInfoIpOverEthernetAddressRange addressRange) {
    this.addressRange = addressRange;
  }

  public NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses subnetId(String subnetId) {
    this.subnetId = subnetId;
    return this;
  }

   /**
   * An identifier maintained by the VIM or other resource provider. It is expected to be unique within the VIM instance. Representation: string of variable length. 
   * @return subnetId
  **/
  @Schema(description = "An identifier maintained by the VIM or other resource provider. It is expected to be unique within the VIM instance. Representation: string of variable length. ")
  public String getSubnetId() {
    return subnetId;
  }

  public void setSubnetId(String subnetId) {
    this.subnetId = subnetId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses nsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses = (NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses) o;
    return Objects.equals(this.type, nsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses.type) &&
        Objects.equals(this.fixedAddresses, nsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses.fixedAddresses) &&
        Objects.equals(this.numDynamicAddresses, nsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses.numDynamicAddresses) &&
        Objects.equals(this.addressRange, nsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses.addressRange) &&
        Objects.equals(this.subnetId, nsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses.subnetId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, fixedAddresses, numDynamicAddresses, addressRange, subnetId);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesNsInstanceCpInfoIpOverEthernetIpAddresses {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    fixedAddresses: ").append(toIndentedString(fixedAddresses)).append("\n");
    sb.append("    numDynamicAddresses: ").append(toIndentedString(numDynamicAddresses)).append("\n");
    sb.append("    addressRange: ").append(toIndentedString(addressRange)).append("\n");
    sb.append("    subnetId: ").append(toIndentedString(subnetId)).append("\n");
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
