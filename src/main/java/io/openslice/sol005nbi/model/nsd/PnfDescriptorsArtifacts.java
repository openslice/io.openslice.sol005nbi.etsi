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
 * This type represents an artifact contained in a PNFD archive. It shall comply with provisions defined in Table 5.5.3.6-1. 
 */
@Schema(description = "This type represents an artifact contained in a PNFD archive. It shall comply with provisions defined in Table 5.5.3.6-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-31T22:46:27.985+03:00[Europe/Athens]")
public class PnfDescriptorsArtifacts {
  @JsonProperty("artifactPath")
  private String artifactPath = null;

  @JsonProperty("checksum")
  private NsDescriptorsChecksum checksum = null;

  @JsonProperty("nonManoArtifactSetId")
  private String nonManoArtifactSetId = null;

  @JsonProperty("metadata")
  private Object metadata = null;

  public PnfDescriptorsArtifacts artifactPath(String artifactPath) {
    this.artifactPath = artifactPath;
    return this;
  }

   /**
   * A string as defined in IETF RFC 8259. 
   * @return artifactPath
  **/
  @Schema(required = true, description = "A string as defined in IETF RFC 8259. ")
  public String getArtifactPath() {
    return artifactPath;
  }

  public void setArtifactPath(String artifactPath) {
    this.artifactPath = artifactPath;
  }

  public PnfDescriptorsArtifacts checksum(NsDescriptorsChecksum checksum) {
    this.checksum = checksum;
    return this;
  }

   /**
   * Get checksum
   * @return checksum
  **/
  @Schema(required = true, description = "")
  public NsDescriptorsChecksum getChecksum() {
    return checksum;
  }

  public void setChecksum(NsDescriptorsChecksum checksum) {
    this.checksum = checksum;
  }

  public PnfDescriptorsArtifacts nonManoArtifactSetId(String nonManoArtifactSetId) {
    this.nonManoArtifactSetId = nonManoArtifactSetId;
    return this;
  }

   /**
   * A string as defined in IETF RFC 8259. 
   * @return nonManoArtifactSetId
  **/
  @Schema(description = "A string as defined in IETF RFC 8259. ")
  public String getNonManoArtifactSetId() {
    return nonManoArtifactSetId;
  }

  public void setNonManoArtifactSetId(String nonManoArtifactSetId) {
    this.nonManoArtifactSetId = nonManoArtifactSetId;
  }

  public PnfDescriptorsArtifacts metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

   /**
   * This type represents a list of key-value pairs. The order of the pairs in the list is not significant. In JSON, a set of key- value pairs is represented as an object. It shall comply with the provisions defined in clause 4 of IETF RFC 7159. 
   * @return metadata
  **/
  @Schema(description = "This type represents a list of key-value pairs. The order of the pairs in the list is not significant. In JSON, a set of key- value pairs is represented as an object. It shall comply with the provisions defined in clause 4 of IETF RFC 7159. ")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PnfDescriptorsArtifacts pnfDescriptorsArtifacts = (PnfDescriptorsArtifacts) o;
    return Objects.equals(this.artifactPath, pnfDescriptorsArtifacts.artifactPath) &&
        Objects.equals(this.checksum, pnfDescriptorsArtifacts.checksum) &&
        Objects.equals(this.nonManoArtifactSetId, pnfDescriptorsArtifacts.nonManoArtifactSetId) &&
        Objects.equals(this.metadata, pnfDescriptorsArtifacts.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artifactPath, checksum, nonManoArtifactSetId, metadata);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PnfDescriptorsArtifacts {\n");
    
    sb.append("    artifactPath: ").append(toIndentedString(artifactPath)).append("\n");
    sb.append("    checksum: ").append(toIndentedString(checksum)).append("\n");
    sb.append("    nonManoArtifactSetId: ").append(toIndentedString(nonManoArtifactSetId)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
