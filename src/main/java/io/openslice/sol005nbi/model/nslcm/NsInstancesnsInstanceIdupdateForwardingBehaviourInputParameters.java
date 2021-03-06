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
 * This type represents provides input parameters to configure the forwarding behaviour.  It shall comply with the provisions defined in Table 6.5.3.73-1. 
 */
@Schema(description = "This type represents provides input parameters to configure the forwarding behaviour.  It shall comply with the provisions defined in Table 6.5.3.73-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class NsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters {
  /**
   * May be included if forwarding behaviour is equal to LB. Shall not be included otherwise. Permitted values: * ROUND_ROBIN * LEAST_CONNECTION * LEAST_TRAFFIC * LEAST_RESPONSE_TIME * CHAINED_FAILOVER * SOURCE_IP_HASH * SOURCE_MAC_HASH 
   */
  public enum AlgortihmNameEnum {
    ROUND_ROBIN("ROUND_ROBIN"),
    LEAST_CONNECTION("LEAST_CONNECTION"),
    LEAST_TRAFFIC("LEAST_TRAFFIC"),
    LEAST_RESPONSE_TIME("LEAST_RESPONSE_TIME"),
    CHAINED_FAILOVER("CHAINED_FAILOVER"),
    SOURCE_IP_HASH("SOURCE_IP_HASH"),
    SOURCE_MAC_HASH("SOURCE_MAC_HASH");

    private String value;

    AlgortihmNameEnum(String value) {
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
    public static AlgortihmNameEnum fromValue(String text) {
      for (AlgortihmNameEnum b : AlgortihmNameEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("algortihmName")
  private AlgortihmNameEnum algortihmName = null;

  @JsonProperty("algorithmWeights")
  private List<Integer> algorithmWeights = null;

  public NsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters algortihmName(AlgortihmNameEnum algortihmName) {
    this.algortihmName = algortihmName;
    return this;
  }

   /**
   * May be included if forwarding behaviour is equal to LB. Shall not be included otherwise. Permitted values: * ROUND_ROBIN * LEAST_CONNECTION * LEAST_TRAFFIC * LEAST_RESPONSE_TIME * CHAINED_FAILOVER * SOURCE_IP_HASH * SOURCE_MAC_HASH 
   * @return algortihmName
  **/
  @Schema(description = "May be included if forwarding behaviour is equal to LB. Shall not be included otherwise. Permitted values: * ROUND_ROBIN * LEAST_CONNECTION * LEAST_TRAFFIC * LEAST_RESPONSE_TIME * CHAINED_FAILOVER * SOURCE_IP_HASH * SOURCE_MAC_HASH ")
  public AlgortihmNameEnum getAlgortihmName() {
    return algortihmName;
  }

  public void setAlgortihmName(AlgortihmNameEnum algortihmName) {
    this.algortihmName = algortihmName;
  }

  public NsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters algorithmWeights(List<Integer> algorithmWeights) {
    this.algorithmWeights = algorithmWeights;
    return this;
  }

  public NsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters addAlgorithmWeightsItem(Integer algorithmWeightsItem) {
    if (this.algorithmWeights == null) {
      this.algorithmWeights = new ArrayList<>();
    }
    this.algorithmWeights.add(algorithmWeightsItem);
    return this;
  }

   /**
   * Percentage of messages sent to a CP instance. May be included if applicable to  the algorithm. If applicable to the algorithm but not provided, default values determined by  the VIM or NFVI are expected to be used. Weight applies to the CP instances in the order they have been created. 
   * @return algorithmWeights
  **/
  @Schema(description = "Percentage of messages sent to a CP instance. May be included if applicable to  the algorithm. If applicable to the algorithm but not provided, default values determined by  the VIM or NFVI are expected to be used. Weight applies to the CP instances in the order they have been created. ")
  public List<Integer> getAlgorithmWeights() {
    return algorithmWeights;
  }

  public void setAlgorithmWeights(List<Integer> algorithmWeights) {
    this.algorithmWeights = algorithmWeights;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters nsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters = (NsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters) o;
    return Objects.equals(this.algortihmName, nsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters.algortihmName) &&
        Objects.equals(this.algorithmWeights, nsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters.algorithmWeights);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algortihmName, algorithmWeights);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsInstancesnsInstanceIdupdateForwardingBehaviourInputParameters {\n");
    
    sb.append("    algortihmName: ").append(toIndentedString(algortihmName)).append("\n");
    sb.append("    algorithmWeights: ").append(toIndentedString(algorithmWeights)).append("\n");
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
