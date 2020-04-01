/*
 * SOL005 - NSD Management Interface
 * SOL005 - NSD Management Interface  IMPORTANT: Please note that this file might be not aligned to the current version of the ETSI Group Specification it refers to and has not been approved by the ETSI NFV ISG. In case of discrepancies the published ETSI Group Specification takes precedence. Please report bugs to https://forge.etsi.org/bugzilla/buglist.cgi?component=Nfv-Openapis 
 *
 * OpenAPI spec version: 2.0.0-impl:etsi.org:ETSI_NFV_OpenAPI:1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.openslice.sol005nbi.model.nsd;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
/**
 * This type represents a subscription related to notifications about NSD management. 
 */
@Schema(description = "This type represents a subscription related to notifications about NSD management. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-31T22:46:27.985+03:00[Europe/Athens]")
public class InlineResponse2012 {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("filter")
  private SubscriptionsFilter filter = null;

  @JsonProperty("callbackUri")
  private String callbackUri = null;

  @JsonProperty("_links")
  private SubscriptionsLinks _links = null;

  public InlineResponse2012 id(String id) {
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

  public InlineResponse2012 filter(SubscriptionsFilter filter) {
    this.filter = filter;
    return this;
  }

   /**
   * Get filter
   * @return filter
  **/
  @Schema(description = "")
  public SubscriptionsFilter getFilter() {
    return filter;
  }

  public void setFilter(SubscriptionsFilter filter) {
    this.filter = filter;
  }

  public InlineResponse2012 callbackUri(String callbackUri) {
    this.callbackUri = callbackUri;
    return this;
  }

   /**
   * String formatted according to IETF RFC 3986. 
   * @return callbackUri
  **/
  @Schema(required = true, description = "String formatted according to IETF RFC 3986. ")
  public String getCallbackUri() {
    return callbackUri;
  }

  public void setCallbackUri(String callbackUri) {
    this.callbackUri = callbackUri;
  }

  public InlineResponse2012 _links(SubscriptionsLinks _links) {
    this._links = _links;
    return this;
  }

   /**
   * Get _links
   * @return _links
  **/
  @Schema(required = true, description = "")
  public SubscriptionsLinks getLinks() {
    return _links;
  }

  public void setLinks(SubscriptionsLinks _links) {
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
    InlineResponse2012 inlineResponse2012 = (InlineResponse2012) o;
    return Objects.equals(this.id, inlineResponse2012.id) &&
        Objects.equals(this.filter, inlineResponse2012.filter) &&
        Objects.equals(this.callbackUri, inlineResponse2012.callbackUri) &&
        Objects.equals(this._links, inlineResponse2012._links);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, filter, callbackUri, _links);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2012 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filter: ").append(toIndentedString(filter)).append("\n");
    sb.append("    callbackUri: ").append(toIndentedString(callbackUri)).append("\n");
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
