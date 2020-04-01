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
 * This type represents a subscription filter related to notifications about  NS lifecycle changes. It shall comply with the provisions defined in Table 6.5.3.8-1. At a particular nesting level in the filter structure, the following applies:  All attributes shall match in order for the filter to match (logical \&quot;and\&quot; between different filter attributes).  If an attribute is an array, the attribute shall match if at least one of the values in the array matches (logical \&quot;or\&quot; between the values of one filter attribute). 
 */
@Schema(description = "This type represents a subscription filter related to notifications about  NS lifecycle changes. It shall comply with the provisions defined in Table 6.5.3.8-1. At a particular nesting level in the filter structure, the following applies:  All attributes shall match in order for the filter to match (logical \"and\" between different filter attributes).  If an attribute is an array, the attribute shall match if at least one of the values in the array matches (logical \"or\" between the values of one filter attribute). ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class SubscriptionsFilter {
  @JsonProperty("nsInstanceSubscriptionFilter")
  private SubscriptionsFilterNsInstanceSubscriptionFilter nsInstanceSubscriptionFilter = null;

  /**
   * Gets or Sets notificationTypes
   */
  public enum NotificationTypesEnum {
    NSLCMOPERATIONOCCURENCENOTIFICATION("NsLcmOperationOccurenceNotification"),
    NSIDENTIFIERCREATIONNOTIFICATION("NsIdentifierCreationNotification"),
    NSIDENTIFIERDELETIONNOTIFICATION("NsIdentifierDeletionNotification"),
    NSCHANGENOTIFICATION("NsChangeNotification");

    private String value;

    NotificationTypesEnum(String value) {
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
    public static NotificationTypesEnum fromValue(String text) {
      for (NotificationTypesEnum b : NotificationTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("notificationTypes")
  private List<NotificationTypesEnum> notificationTypes = null;

  /**
   * The enumeration NsLcmOpType represents those lifecycle operations that trigger a NS lifecycle management operation occurrence notification. Value | Description ------|------------ INSTANTIATE | Represents the \&quot;Instantiate NS\&quot; LCM operation. SCALE | Represents the \&quot;Scale NS\&quot; LCM operation. UPDATE | Represents the \&quot;Update NS\&quot; LCM operation. TERMINATE | Represents the \&quot;Terminate NS\&quot; LCM operation. HEAL | Represents the \&quot;Heal NS\&quot; LCM operation. 
   */
  public enum OperationTypesEnum {
    INSTANTIATE("INSTANTIATE"),
    SCALE("SCALE"),
    UPDATE("UPDATE"),
    TERMINATE("TERMINATE"),
    HEAL("HEAL");

    private String value;

    OperationTypesEnum(String value) {
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
    public static OperationTypesEnum fromValue(String text) {
      for (OperationTypesEnum b : OperationTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("operationTypes")
  private List<OperationTypesEnum> operationTypes = null;

  /**
   * Value | Description ------|------------ PROCESSING | The LCM operation is currently in execution. COMPLETED | The LCM operation has been completed successfully. PARTIALLY_COMPLETED | The LCM operation has been partially completed with accepTable errors. FAILED_TEMP | The LCM operation has failed and execution has stopped, but the execution of the operation is not considered to be closed. FAILED | The LCM operation has failed and it cannot be retried or rolled back, as it is determined that such action will not succeed. OLLING_BACK | The LCM operation is currently being rolled back. ROLLED_BACK | The LCM operation has been successfully rolled back, i.e. The state of the NS prior to the original operation invocation has been restored as closely as possible. 
   */
  public enum OperationStatesEnum {
    PROCESSING("PROCESSING"),
    COMPLETED("COMPLETED"),
    PARTIALLY_COMPLETED("PARTIALLY_COMPLETED"),
    FAILED_TEMP("FAILED_TEMP"),
    FAILED("FAILED"),
    ROLLING_BACK("ROLLING_BACK"),
    ROLLED_BACK("ROLLED_BACK");

    private String value;

    OperationStatesEnum(String value) {
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
    public static OperationStatesEnum fromValue(String text) {
      for (OperationStatesEnum b : OperationStatesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("operationStates")
  private List<OperationStatesEnum> operationStates = null;

  /**
   * The enumeration NsComponentType represents the NS component type. It shall comply with the provisions defined in Table 6.5.4.5-1. Value | Description ------|------------ VNF | Represents the impacted NS component is a VNF. PNF | Represents the impacted NS component is a PNF. NS | Represents the impacted NS component is a nested NS. 
   */
  public enum NsComponentTypesEnum {
    VNF("VNF"),
    PNF("PNF"),
    NS("NS");

    private String value;

    NsComponentTypesEnum(String value) {
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
    public static NsComponentTypesEnum fromValue(String text) {
      for (NsComponentTypesEnum b : NsComponentTypesEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("nsComponentTypes")
  private List<NsComponentTypesEnum> nsComponentTypes = null;

  /**
   * The enumeration LcmOpNameForChangeNotificationType represents the name of the lifecycle operation that impacts the NS component and trigger an NS change notification. It shall comply with the provisions defined in Table 6.5.4.6-1. Value | Description ------|------------ VNF_INSTANTIATE | Represents the \&quot;Instantiate VNF\&quot; LCM operation. VNF_SCALE | Represents the \&quot;Scale VNF\&quot; LCM operation. VNF_SCALE_TO_LEVEL | Represents the \&quot;Scale VNF to Level\&quot; LCM operation. VNF_CHANGE_FLAVOUR | Represents the \&quot;Change VNF Flavor\&quot; LCM operation. VNF_TERMINATE | Represents the \&quot;Terminate VNF\&quot; LCM operation. VNF_HEAL | Represents the \&quot;Heal VNF\&quot; LCM operation. VNF_OPERATE | Represents the \&quot;Operate VNF\&quot; LCM operation. VNF_CHANGE_EXT_CONN | Represents the \&quot;Change external VNF connectivity\&quot; LCM operation. VNF_MODIFY_INFO | Represents the \&quot;Modify VNF Information\&quot; LCM operation.            NS_INSTANTIATE | Represents the \&quot;Instantiate NS\&quot; LCM operation NS_SCALE | Represents the \&quot;Scale NS\&quot; LCM operation. NS_UPDATE | Represents the \&quot;Update NS\&quot; LCM operation. NS_TERMINATE | Represents the \&quot;Terminate NS\&quot; LCM operation. NS_HEAL | Represents the \&quot;Heal NS\&quot; LCM operation. 
   */
  public enum LcmOpNameImpactingNsComponentEnum {
    VNF_INSTANTIATE("VNF_INSTANTIATE"),
    VNF_SCALE("VNF_SCALE"),
    VNF_SCALE_TO_LEVEL("VNF_SCALE_TO_LEVEL"),
    VNF_CHANGE_FLAVOUR("VNF_CHANGE_FLAVOUR"),
    VNF_TERMINATE("VNF_TERMINATE"),
    VNF_HEAL("VNF_HEAL"),
    VNF_OPERATE("VNF_OPERATE"),
    VNF_CHANGE_EXT_CONN("VNF_CHANGE_EXT_CONN"),
    VNF_MODIFY_INFO("VNF_MODIFY_INFO"),
    NS_INSTANTIATE("NS_INSTANTIATE"),
    NS_SCALE("NS_SCALE"),
    NS_UPDATE("NS_UPDATE"),
    NS_TERMINATE("NS_TERMINATE"),
    NS_HEAL("NS_HEAL");

    private String value;

    LcmOpNameImpactingNsComponentEnum(String value) {
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
    public static LcmOpNameImpactingNsComponentEnum fromValue(String text) {
      for (LcmOpNameImpactingNsComponentEnum b : LcmOpNameImpactingNsComponentEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("lcmOpNameImpactingNsComponent")
  private List<LcmOpNameImpactingNsComponentEnum> lcmOpNameImpactingNsComponent = null;

  /**
   * The enumeration LcmOpOccStatusForChangeNotificationType represents the status of the lifecycle management operation occurrence that impacts the NS component and triggers an NS change notification. It shall comply with the provisions defined in Table 6.5.4.7-1. Value | Description ------|------------ START | The impact on the NS component is identified. COMPLETED | The impact on the NS component stops and related lifecycle operation completes successfully. PARTIALLY_COMPLETED | The impact on the NS component stops and related lifecycle operation partially completes. Inconsistency state may exist on the NS       component. FAILED | The impact on the NS component stops and related lifecycle operation fails. Inconsistency state may exist for the NS component. ROLLED_BACK | The impact on the NS component stops and related lifecycle operation is rolled back. 
   */
  public enum LcmOpOccStatusImpactingNsComponentEnum {
    START("START"),
    COMPLETED("COMPLETED"),
    PARTIALLY_COMPLETED("PARTIALLY_COMPLETED"),
    FAILED("FAILED"),
    ROLLED_BACK("ROLLED_BACK");

    private String value;

    LcmOpOccStatusImpactingNsComponentEnum(String value) {
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
    public static LcmOpOccStatusImpactingNsComponentEnum fromValue(String text) {
      for (LcmOpOccStatusImpactingNsComponentEnum b : LcmOpOccStatusImpactingNsComponentEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("lcmOpOccStatusImpactingNsComponent")
  private List<LcmOpOccStatusImpactingNsComponentEnum> lcmOpOccStatusImpactingNsComponent = null;

  public SubscriptionsFilter nsInstanceSubscriptionFilter(SubscriptionsFilterNsInstanceSubscriptionFilter nsInstanceSubscriptionFilter) {
    this.nsInstanceSubscriptionFilter = nsInstanceSubscriptionFilter;
    return this;
  }

   /**
   * Get nsInstanceSubscriptionFilter
   * @return nsInstanceSubscriptionFilter
  **/
  @Schema(description = "")
  public SubscriptionsFilterNsInstanceSubscriptionFilter getNsInstanceSubscriptionFilter() {
    return nsInstanceSubscriptionFilter;
  }

  public void setNsInstanceSubscriptionFilter(SubscriptionsFilterNsInstanceSubscriptionFilter nsInstanceSubscriptionFilter) {
    this.nsInstanceSubscriptionFilter = nsInstanceSubscriptionFilter;
  }

  public SubscriptionsFilter notificationTypes(List<NotificationTypesEnum> notificationTypes) {
    this.notificationTypes = notificationTypes;
    return this;
  }

  public SubscriptionsFilter addNotificationTypesItem(NotificationTypesEnum notificationTypesItem) {
    if (this.notificationTypes == null) {
      this.notificationTypes = new ArrayList<>();
    }
    this.notificationTypes.add(notificationTypesItem);
    return this;
  }

   /**
   * Match particular notification types. Permitted values: - NsLcmOperationOccurenceNotification - NsIdentifierCreationNotification - NsIdentifierDeletionNotification - NsChangeNotification 
   * @return notificationTypes
  **/
  @Schema(description = "Match particular notification types. Permitted values: - NsLcmOperationOccurenceNotification - NsIdentifierCreationNotification - NsIdentifierDeletionNotification - NsChangeNotification ")
  public List<NotificationTypesEnum> getNotificationTypes() {
    return notificationTypes;
  }

  public void setNotificationTypes(List<NotificationTypesEnum> notificationTypes) {
    this.notificationTypes = notificationTypes;
  }

  public SubscriptionsFilter operationTypes(List<OperationTypesEnum> operationTypes) {
    this.operationTypes = operationTypes;
    return this;
  }

  public SubscriptionsFilter addOperationTypesItem(OperationTypesEnum operationTypesItem) {
    if (this.operationTypes == null) {
      this.operationTypes = new ArrayList<>();
    }
    this.operationTypes.add(operationTypesItem);
    return this;
  }

   /**
   * Match particular NS lifecycle operation types for the notification of type NsLcmOperationOccurrenceNotification. May be present if the \&quot;notificationTypes\&quot; attribute contains the value \&quot;NsLcmOperationOccurrenceNotification\&quot;, and shall be absent otherwise. 
   * @return operationTypes
  **/
  @Schema(description = "Match particular NS lifecycle operation types for the notification of type NsLcmOperationOccurrenceNotification. May be present if the \"notificationTypes\" attribute contains the value \"NsLcmOperationOccurrenceNotification\", and shall be absent otherwise. ")
  public List<OperationTypesEnum> getOperationTypes() {
    return operationTypes;
  }

  public void setOperationTypes(List<OperationTypesEnum> operationTypes) {
    this.operationTypes = operationTypes;
  }

  public SubscriptionsFilter operationStates(List<OperationStatesEnum> operationStates) {
    this.operationStates = operationStates;
    return this;
  }

  public SubscriptionsFilter addOperationStatesItem(OperationStatesEnum operationStatesItem) {
    if (this.operationStates == null) {
      this.operationStates = new ArrayList<>();
    }
    this.operationStates.add(operationStatesItem);
    return this;
  }

   /**
   * Match particular LCM operation state values as reported in notifications of type NsLcmOperationOccurrenceNotification. May be present if the \&quot;notificationTypes\&quot; attribute contains the value \&quot;NsLcmOperationOccurrenceNotification\&quot;, and shall be absent otherwise. 
   * @return operationStates
  **/
  @Schema(description = "Match particular LCM operation state values as reported in notifications of type NsLcmOperationOccurrenceNotification. May be present if the \"notificationTypes\" attribute contains the value \"NsLcmOperationOccurrenceNotification\", and shall be absent otherwise. ")
  public List<OperationStatesEnum> getOperationStates() {
    return operationStates;
  }

  public void setOperationStates(List<OperationStatesEnum> operationStates) {
    this.operationStates = operationStates;
  }

  public SubscriptionsFilter nsComponentTypes(List<NsComponentTypesEnum> nsComponentTypes) {
    this.nsComponentTypes = nsComponentTypes;
    return this;
  }

  public SubscriptionsFilter addNsComponentTypesItem(NsComponentTypesEnum nsComponentTypesItem) {
    if (this.nsComponentTypes == null) {
      this.nsComponentTypes = new ArrayList<>();
    }
    this.nsComponentTypes.add(nsComponentTypesItem);
    return this;
  }

   /**
   * Match particular NS component types for the notification of type NsChangeNotification. May be present if the \&quot;notificationTypes\&quot; attribute contains the value \&quot;NsChang. 
   * @return nsComponentTypes
  **/
  @Schema(description = "Match particular NS component types for the notification of type NsChangeNotification. May be present if the \"notificationTypes\" attribute contains the value \"NsChang. ")
  public List<NsComponentTypesEnum> getNsComponentTypes() {
    return nsComponentTypes;
  }

  public void setNsComponentTypes(List<NsComponentTypesEnum> nsComponentTypes) {
    this.nsComponentTypes = nsComponentTypes;
  }

  public SubscriptionsFilter lcmOpNameImpactingNsComponent(List<LcmOpNameImpactingNsComponentEnum> lcmOpNameImpactingNsComponent) {
    this.lcmOpNameImpactingNsComponent = lcmOpNameImpactingNsComponent;
    return this;
  }

  public SubscriptionsFilter addLcmOpNameImpactingNsComponentItem(LcmOpNameImpactingNsComponentEnum lcmOpNameImpactingNsComponentItem) {
    if (this.lcmOpNameImpactingNsComponent == null) {
      this.lcmOpNameImpactingNsComponent = new ArrayList<>();
    }
    this.lcmOpNameImpactingNsComponent.add(lcmOpNameImpactingNsComponentItem);
    return this;
  }

   /**
   * Match particular LCM operation names for the notification of type NsChangeNotification. May be present if the \&quot;notificationTypes\&quot; attribute contains the value \&quot;NsChangeNotification\&quot;, and shall be absent otherwise. 
   * @return lcmOpNameImpactingNsComponent
  **/
  @Schema(description = "Match particular LCM operation names for the notification of type NsChangeNotification. May be present if the \"notificationTypes\" attribute contains the value \"NsChangeNotification\", and shall be absent otherwise. ")
  public List<LcmOpNameImpactingNsComponentEnum> getLcmOpNameImpactingNsComponent() {
    return lcmOpNameImpactingNsComponent;
  }

  public void setLcmOpNameImpactingNsComponent(List<LcmOpNameImpactingNsComponentEnum> lcmOpNameImpactingNsComponent) {
    this.lcmOpNameImpactingNsComponent = lcmOpNameImpactingNsComponent;
  }

  public SubscriptionsFilter lcmOpOccStatusImpactingNsComponent(List<LcmOpOccStatusImpactingNsComponentEnum> lcmOpOccStatusImpactingNsComponent) {
    this.lcmOpOccStatusImpactingNsComponent = lcmOpOccStatusImpactingNsComponent;
    return this;
  }

  public SubscriptionsFilter addLcmOpOccStatusImpactingNsComponentItem(LcmOpOccStatusImpactingNsComponentEnum lcmOpOccStatusImpactingNsComponentItem) {
    if (this.lcmOpOccStatusImpactingNsComponent == null) {
      this.lcmOpOccStatusImpactingNsComponent = new ArrayList<>();
    }
    this.lcmOpOccStatusImpactingNsComponent.add(lcmOpOccStatusImpactingNsComponentItem);
    return this;
  }

   /**
   * Match particular LCM operation status values as reported in notifications of type NsChangeNotification. May be present if the \&quot;notificationTypes\&quot; attribute contains the value \&quot;NsChangeNotification\&quot;, and shall be absent otherwise. 
   * @return lcmOpOccStatusImpactingNsComponent
  **/
  @Schema(description = "Match particular LCM operation status values as reported in notifications of type NsChangeNotification. May be present if the \"notificationTypes\" attribute contains the value \"NsChangeNotification\", and shall be absent otherwise. ")
  public List<LcmOpOccStatusImpactingNsComponentEnum> getLcmOpOccStatusImpactingNsComponent() {
    return lcmOpOccStatusImpactingNsComponent;
  }

  public void setLcmOpOccStatusImpactingNsComponent(List<LcmOpOccStatusImpactingNsComponentEnum> lcmOpOccStatusImpactingNsComponent) {
    this.lcmOpOccStatusImpactingNsComponent = lcmOpOccStatusImpactingNsComponent;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionsFilter subscriptionsFilter = (SubscriptionsFilter) o;
    return Objects.equals(this.nsInstanceSubscriptionFilter, subscriptionsFilter.nsInstanceSubscriptionFilter) &&
        Objects.equals(this.notificationTypes, subscriptionsFilter.notificationTypes) &&
        Objects.equals(this.operationTypes, subscriptionsFilter.operationTypes) &&
        Objects.equals(this.operationStates, subscriptionsFilter.operationStates) &&
        Objects.equals(this.nsComponentTypes, subscriptionsFilter.nsComponentTypes) &&
        Objects.equals(this.lcmOpNameImpactingNsComponent, subscriptionsFilter.lcmOpNameImpactingNsComponent) &&
        Objects.equals(this.lcmOpOccStatusImpactingNsComponent, subscriptionsFilter.lcmOpOccStatusImpactingNsComponent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nsInstanceSubscriptionFilter, notificationTypes, operationTypes, operationStates, nsComponentTypes, lcmOpNameImpactingNsComponent, lcmOpOccStatusImpactingNsComponent);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionsFilter {\n");
    
    sb.append("    nsInstanceSubscriptionFilter: ").append(toIndentedString(nsInstanceSubscriptionFilter)).append("\n");
    sb.append("    notificationTypes: ").append(toIndentedString(notificationTypes)).append("\n");
    sb.append("    operationTypes: ").append(toIndentedString(operationTypes)).append("\n");
    sb.append("    operationStates: ").append(toIndentedString(operationStates)).append("\n");
    sb.append("    nsComponentTypes: ").append(toIndentedString(nsComponentTypes)).append("\n");
    sb.append("    lcmOpNameImpactingNsComponent: ").append(toIndentedString(lcmOpNameImpactingNsComponent)).append("\n");
    sb.append("    lcmOpOccStatusImpactingNsComponent: ").append(toIndentedString(lcmOpOccStatusImpactingNsComponent)).append("\n");
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
