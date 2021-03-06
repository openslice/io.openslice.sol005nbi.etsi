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
 * This type represents a request for the scale NS operation. Either the parameter scaleNsData or the parameter scaleVnfData, but not both shall be provided 
 */
@Schema(description = "This type represents a request for the scale NS operation. Either the parameter scaleNsData or the parameter scaleVnfData, but not both shall be provided ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class Body2 {
  /**
   * Indicates the type of scaling to be performed. Possible values: - SCALE_NS - SCALE_VNF 
   */
  public enum ScaleTypeEnum {
    NS("SCALE_NS"),
    VNF("SCALE_VNF");

    private String value;

    ScaleTypeEnum(String value) {
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
    public static ScaleTypeEnum fromValue(String text) {
      for (ScaleTypeEnum b : ScaleTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("scaleType")
  private ScaleTypeEnum scaleType = null;

  @JsonProperty("scaleNsData")
  private NsInstancesnsInstanceIdscaleScaleNsData scaleNsData = null;

  @JsonProperty("scaleVnfData")
  private List<NsInstancesnsInstanceIdscaleScaleVnfData> scaleVnfData = null;

  @JsonProperty("scaleTime")
  private Object scaleTime = null;

  public Body2 scaleType(ScaleTypeEnum scaleType) {
    this.scaleType = scaleType;
    return this;
  }

   /**
   * Indicates the type of scaling to be performed. Possible values: - SCALE_NS - SCALE_VNF 
   * @return scaleType
  **/
  @Schema(required = true, description = "Indicates the type of scaling to be performed. Possible values: - SCALE_NS - SCALE_VNF ")
  public ScaleTypeEnum getScaleType() {
    return scaleType;
  }

  public void setScaleType(ScaleTypeEnum scaleType) {
    this.scaleType = scaleType;
  }

  public Body2 scaleNsData(NsInstancesnsInstanceIdscaleScaleNsData scaleNsData) {
    this.scaleNsData = scaleNsData;
    return this;
  }

   /**
   * Get scaleNsData
   * @return scaleNsData
  **/
  @Schema(description = "")
  public NsInstancesnsInstanceIdscaleScaleNsData getScaleNsData() {
    return scaleNsData;
  }

  public void setScaleNsData(NsInstancesnsInstanceIdscaleScaleNsData scaleNsData) {
    this.scaleNsData = scaleNsData;
  }

  public Body2 scaleVnfData(List<NsInstancesnsInstanceIdscaleScaleVnfData> scaleVnfData) {
    this.scaleVnfData = scaleVnfData;
    return this;
  }

  public Body2 addScaleVnfDataItem(NsInstancesnsInstanceIdscaleScaleVnfData scaleVnfDataItem) {
    if (this.scaleVnfData == null) {
      this.scaleVnfData = new ArrayList<>();
    }
    this.scaleVnfData.add(scaleVnfDataItem);
    return this;
  }

   /**
   * The necessary information to scale the referenced NS instance. It shall be present when scaleType &#x3D; SCALE_VNF. 
   * @return scaleVnfData
  **/
  @Schema(description = "The necessary information to scale the referenced NS instance. It shall be present when scaleType = SCALE_VNF. ")
  public List<NsInstancesnsInstanceIdscaleScaleVnfData> getScaleVnfData() {
    return scaleVnfData;
  }

  public void setScaleVnfData(List<NsInstancesnsInstanceIdscaleScaleVnfData> scaleVnfData) {
    this.scaleVnfData = scaleVnfData;
  }

  public Body2 scaleTime(Object scaleTime) {
    this.scaleTime = scaleTime;
    return this;
  }

   /**
   * Date-time stamp. Representation: String formatted according toas defined by the date-time production in IETF RFC 3339. 
   * @return scaleTime
  **/
  @Schema(description = "Date-time stamp. Representation: String formatted according toas defined by the date-time production in IETF RFC 3339. ")
  public Object getScaleTime() {
    return scaleTime;
  }

  public void setScaleTime(Object scaleTime) {
    this.scaleTime = scaleTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body2 body2 = (Body2) o;
    return Objects.equals(this.scaleType, body2.scaleType) &&
        Objects.equals(this.scaleNsData, body2.scaleNsData) &&
        Objects.equals(this.scaleVnfData, body2.scaleVnfData) &&
        Objects.equals(this.scaleTime, body2.scaleTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(scaleType, scaleNsData, scaleVnfData, scaleTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body2 {\n");
    
    sb.append("    scaleType: ").append(toIndentedString(scaleType)).append("\n");
    sb.append("    scaleNsData: ").append(toIndentedString(scaleNsData)).append("\n");
    sb.append("    scaleVnfData: ").append(toIndentedString(scaleVnfData)).append("\n");
    sb.append("    scaleTime: ").append(toIndentedString(scaleTime)).append("\n");
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
