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
 * This type represents a NS termination request.  It shall comply with the provisions defined in Table 6.5.2.15-1. 
 */
@Schema(description = "This type represents a NS termination request.  It shall comply with the provisions defined in Table 6.5.2.15-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class Body5 {
  @JsonProperty("terminationTime")
  private Object terminationTime = null;

  public Body5 terminationTime(Object terminationTime) {
    this.terminationTime = terminationTime;
    return this;
  }

   /**
   * Date-time stamp. Representation: String formatted according toas defined by the date-time production in IETF RFC 3339. 
   * @return terminationTime
  **/
  @Schema(description = "Date-time stamp. Representation: String formatted according toas defined by the date-time production in IETF RFC 3339. ")
  public Object getTerminationTime() {
    return terminationTime;
  }

  public void setTerminationTime(Object terminationTime) {
    this.terminationTime = terminationTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body5 body5 = (Body5) o;
    return Objects.equals(this.terminationTime, body5.terminationTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(terminationTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body5 {\n");
    
    sb.append("    terminationTime: ").append(toIndentedString(terminationTime)).append("\n");
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
