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
 * Links to resources related to this resource. 
 */
@Schema(description = "Links to resources related to this resource. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsLcmOpOccsNsLcmOpOccLinks {
  @JsonProperty("self")
  private NsInstancesNsInstanceLinksSelf self = null;

  @JsonProperty("nsInstance")
  private NsInstancesNsInstanceLinksSelf nsInstance = null;

  @JsonProperty("cancel")
  private NsInstancesNsInstanceLinksSelf cancel = null;

  @JsonProperty("retry")
  private NsInstancesNsInstanceLinksSelf retry = null;

  @JsonProperty("rollback")
  private NsInstancesNsInstanceLinksSelf rollback = null;

  @JsonProperty("continue")
  private NsInstancesNsInstanceLinksSelf _continue = null;

  @JsonProperty("fail")
  private NsInstancesNsInstanceLinksSelf fail = null;

  public NsLcmOpOccsNsLcmOpOccLinks self(NsInstancesNsInstanceLinksSelf self) {
    this.self = self;
    return this;
  }

   /**
   * Get self
   * @return self
  **/
  @Schema(required = true, description = "")
  public NsInstancesNsInstanceLinksSelf getSelf() {
    return self;
  }

  public void setSelf(NsInstancesNsInstanceLinksSelf self) {
    this.self = self;
  }

  public NsLcmOpOccsNsLcmOpOccLinks nsInstance(NsInstancesNsInstanceLinksSelf nsInstance) {
    this.nsInstance = nsInstance;
    return this;
  }

   /**
   * Get nsInstance
   * @return nsInstance
  **/
  @Schema(required = true, description = "")
  public NsInstancesNsInstanceLinksSelf getNsInstance() {
    return nsInstance;
  }

  public void setNsInstance(NsInstancesNsInstanceLinksSelf nsInstance) {
    this.nsInstance = nsInstance;
  }

  public NsLcmOpOccsNsLcmOpOccLinks cancel(NsInstancesNsInstanceLinksSelf cancel) {
    this.cancel = cancel;
    return this;
  }

   /**
   * Get cancel
   * @return cancel
  **/
  @Schema(description = "")
  public NsInstancesNsInstanceLinksSelf getCancel() {
    return cancel;
  }

  public void setCancel(NsInstancesNsInstanceLinksSelf cancel) {
    this.cancel = cancel;
  }

  public NsLcmOpOccsNsLcmOpOccLinks retry(NsInstancesNsInstanceLinksSelf retry) {
    this.retry = retry;
    return this;
  }

   /**
   * Get retry
   * @return retry
  **/
  @Schema(description = "")
  public NsInstancesNsInstanceLinksSelf getRetry() {
    return retry;
  }

  public void setRetry(NsInstancesNsInstanceLinksSelf retry) {
    this.retry = retry;
  }

  public NsLcmOpOccsNsLcmOpOccLinks rollback(NsInstancesNsInstanceLinksSelf rollback) {
    this.rollback = rollback;
    return this;
  }

   /**
   * Get rollback
   * @return rollback
  **/
  @Schema(description = "")
  public NsInstancesNsInstanceLinksSelf getRollback() {
    return rollback;
  }

  public void setRollback(NsInstancesNsInstanceLinksSelf rollback) {
    this.rollback = rollback;
  }

  public NsLcmOpOccsNsLcmOpOccLinks _continue(NsInstancesNsInstanceLinksSelf _continue) {
    this._continue = _continue;
    return this;
  }

   /**
   * Get _continue
   * @return _continue
  **/
  @Schema(description = "")
  public NsInstancesNsInstanceLinksSelf getContinue() {
    return _continue;
  }

  public void setContinue(NsInstancesNsInstanceLinksSelf _continue) {
    this._continue = _continue;
  }

  public NsLcmOpOccsNsLcmOpOccLinks fail(NsInstancesNsInstanceLinksSelf fail) {
    this.fail = fail;
    return this;
  }

   /**
   * Get fail
   * @return fail
  **/
  @Schema(description = "")
  public NsInstancesNsInstanceLinksSelf getFail() {
    return fail;
  }

  public void setFail(NsInstancesNsInstanceLinksSelf fail) {
    this.fail = fail;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsLcmOpOccsNsLcmOpOccLinks nsLcmOpOccsNsLcmOpOccLinks = (NsLcmOpOccsNsLcmOpOccLinks) o;
    return Objects.equals(this.self, nsLcmOpOccsNsLcmOpOccLinks.self) &&
        Objects.equals(this.nsInstance, nsLcmOpOccsNsLcmOpOccLinks.nsInstance) &&
        Objects.equals(this.cancel, nsLcmOpOccsNsLcmOpOccLinks.cancel) &&
        Objects.equals(this.retry, nsLcmOpOccsNsLcmOpOccLinks.retry) &&
        Objects.equals(this.rollback, nsLcmOpOccsNsLcmOpOccLinks.rollback) &&
        Objects.equals(this._continue, nsLcmOpOccsNsLcmOpOccLinks._continue) &&
        Objects.equals(this.fail, nsLcmOpOccsNsLcmOpOccLinks.fail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, nsInstance, cancel, retry, rollback, _continue, fail);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsLcmOpOccsNsLcmOpOccLinks {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    nsInstance: ").append(toIndentedString(nsInstance)).append("\n");
    sb.append("    cancel: ").append(toIndentedString(cancel)).append("\n");
    sb.append("    retry: ").append(toIndentedString(retry)).append("\n");
    sb.append("    rollback: ").append(toIndentedString(rollback)).append("\n");
    sb.append("    _continue: ").append(toIndentedString(_continue)).append("\n");
    sb.append("    fail: ").append(toIndentedString(fail)).append("\n");
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
