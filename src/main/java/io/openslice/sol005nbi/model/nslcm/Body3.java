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
 * This operation supports the update of a NS instance,  It shall comply with the provisions defined in Table 6.5.2.12-1. 
 */
@Schema(description = "This operation supports the update of a NS instance,  It shall comply with the provisions defined in Table 6.5.2.12-1. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class Body3 {
  /**
   * The type of update. It determines also which one of the following parameters is present in the operation. Possible values include: * ADD_VNF: Adding existing VNF instance(s) * REMOVE_VNF: Removing VNF instance(s) * INSTANTIATE_VNF: Instantiating new VNF(s) * CHANGE_VNF_DF: Changing VNF DF * OPERATE_VNF: Changing VNF state, * MODIFY_VNF_INFORMATION: Modifying VNF information and/or the configurable properties of VNF instance(s) * CHANGE_EXTERNAL_VNF_CONNECTIVITY: Changing the external connectivity of VNF instance(s) * ADD_SAP: Adding SAP(s) * REMOVE_SAP: Removing SAP(s) * ADD_NESTED_NS: Adding existing NS instance(s) as nested NS(s) * REMOVE_NESTED_NS: Removing existing nested NS instance(s) * ASSOC_NEW_NSD_VERSION: Associating a new NSD version to the NS instance * MOVE_VNF: Moving VNF instance(s) from one origin NS instance to another target NS instance * ADD_VNFFG: Adding VNFFG(s) * REMOVE_VNFFG: Removing VNFFG(s) * UPDATE_VNFFG: Updating VNFFG(s) * CHANGE_NS_DF: Changing NS DF * ADD_PNF: Adding PNF * MODIFY_PNF: Modifying PNF * REMOVE_PNF: Removing PNF 
   */
  public enum UpdateTypeEnum {
    ADD_VNF("ADD_VNF"),
    REMOVE_VNF("REMOVE_VNF"),
    INSTANTIATE_VNF("INSTANTIATE_VNF"),
    CHANGE_VNF_DF("CHANGE_VNF_DF"),
    OPERATE_VNF("OPERATE_VNF"),
    MODIFY_VNF_INFORMATION("MODIFY_VNF_INFORMATION"),
    CHANGE_EXTERNAL_VNF_CONNECTIVITY("CHANGE_EXTERNAL_VNF_CONNECTIVITY"),
    ADD_SAP("ADD SAP"),
    REMOVE_SAP("REMOVE_SAP"),
    ADD_NESTED_NS("ADD_NESTED_NS"),
    REMOVE_NESTED_NS("REMOVE_NESTED_NS"),
    ASSOC_NEW_NSD_VERSION("ASSOC_NEW_NSD_VERSION"),
    MOVE_VNF("MOVE_VNF"),
    ADD_VNFFG("ADD_VNFFG"),
    REMOVE_VNFFG("REMOVE_VNFFG"),
    UPDATE_VNFFG("UPDATE_VNFFG"),
    CHANGE_NS_DF("CHANGE_NS_DF"),
    ADD_PNF("ADD_PNF"),
    MODIFY_PNF("MODIFY_PNF"),
    REMOVE_PNF("REMOVE_PNF");

    private String value;

    UpdateTypeEnum(String value) {
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
    public static UpdateTypeEnum fromValue(String text) {
      for (UpdateTypeEnum b : UpdateTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("updateType")
  private UpdateTypeEnum updateType = null;

  @JsonProperty("addVnfIstance")
  private List<NsInstancesnsInstanceIdinstantiateVnfInstanceData> addVnfIstance = null;

  @JsonProperty("removeVnfInstanceId")
  private List<String> removeVnfInstanceId = null;

  @JsonProperty("instantiateVnfData")
  private List<NsInstancesnsInstanceIdupdateInstantiateVnfData> instantiateVnfData = null;

  @JsonProperty("changeVnfFlavourData")
  private List<NsInstancesnsInstanceIdupdateChangeVnfFlavourData> changeVnfFlavourData = null;

  @JsonProperty("operateVnfData")
  private List<NsInstancesnsInstanceIdupdateOperateVnfData> operateVnfData = null;

  @JsonProperty("modifyVnfInfoData")
  private List<NsInstancesnsInstanceIdupdateModifyVnfInfoData> modifyVnfInfoData = null;

  @JsonProperty("changeExtVnfConnectivityData")
  private List<NsInstancesnsInstanceIdupdateChangeExtVnfConnectivityData> changeExtVnfConnectivityData = null;

  @JsonProperty("addSap")
  private List<NsInstancesnsInstanceIdinstantiateSapData> addSap = null;

  @JsonProperty("removeSapId")
  private List<String> removeSapId = null;

  @JsonProperty("addNestedNsData")
  private List<NsInstancesnsInstanceIdinstantiateNestedNsInstanceData> addNestedNsData = null;

  @JsonProperty("removeNestedNsId")
  private List<String> removeNestedNsId = null;

  @JsonProperty("assocNewNsdVersionData")
  private NsInstancesnsInstanceIdupdateAssocNewNsdVersionData assocNewNsdVersionData = null;

  @JsonProperty("moveVnfInstanceData")
  private List<NsInstancesnsInstanceIdupdateMoveVnfInstanceData> moveVnfInstanceData = null;

  @JsonProperty("addVnffg")
  private List<NsInstancesnsInstanceIdupdateAddVnffg> addVnffg = null;

  @JsonProperty("removeVnffgId")
  private List<String> removeVnffgId = null;

  @JsonProperty("updateVnffg")
  private List<NsInstancesnsInstanceIdupdateUpdateVnffg> updateVnffg = null;

  @JsonProperty("changeNsFlavourData")
  private NsInstancesnsInstanceIdupdateChangeNsFlavourData changeNsFlavourData = null;

  @JsonProperty("addPnfData")
  private List<NsInstancesnsInstanceIdinstantiateAddpnfData> addPnfData = null;

  @JsonProperty("modifyPnfData")
  private List<NsInstancesnsInstanceIdupdateModifyPnfData> modifyPnfData = null;

  @JsonProperty("removePnfId")
  private List<String> removePnfId = null;

  @JsonProperty("updateTime")
  private Object updateTime = null;

  public Body3 updateType(UpdateTypeEnum updateType) {
    this.updateType = updateType;
    return this;
  }

   /**
   * The type of update. It determines also which one of the following parameters is present in the operation. Possible values include: * ADD_VNF: Adding existing VNF instance(s) * REMOVE_VNF: Removing VNF instance(s) * INSTANTIATE_VNF: Instantiating new VNF(s) * CHANGE_VNF_DF: Changing VNF DF * OPERATE_VNF: Changing VNF state, * MODIFY_VNF_INFORMATION: Modifying VNF information and/or the configurable properties of VNF instance(s) * CHANGE_EXTERNAL_VNF_CONNECTIVITY: Changing the external connectivity of VNF instance(s) * ADD_SAP: Adding SAP(s) * REMOVE_SAP: Removing SAP(s) * ADD_NESTED_NS: Adding existing NS instance(s) as nested NS(s) * REMOVE_NESTED_NS: Removing existing nested NS instance(s) * ASSOC_NEW_NSD_VERSION: Associating a new NSD version to the NS instance * MOVE_VNF: Moving VNF instance(s) from one origin NS instance to another target NS instance * ADD_VNFFG: Adding VNFFG(s) * REMOVE_VNFFG: Removing VNFFG(s) * UPDATE_VNFFG: Updating VNFFG(s) * CHANGE_NS_DF: Changing NS DF * ADD_PNF: Adding PNF * MODIFY_PNF: Modifying PNF * REMOVE_PNF: Removing PNF 
   * @return updateType
  **/
  @Schema(required = true, description = "The type of update. It determines also which one of the following parameters is present in the operation. Possible values include: * ADD_VNF: Adding existing VNF instance(s) * REMOVE_VNF: Removing VNF instance(s) * INSTANTIATE_VNF: Instantiating new VNF(s) * CHANGE_VNF_DF: Changing VNF DF * OPERATE_VNF: Changing VNF state, * MODIFY_VNF_INFORMATION: Modifying VNF information and/or the configurable properties of VNF instance(s) * CHANGE_EXTERNAL_VNF_CONNECTIVITY: Changing the external connectivity of VNF instance(s) * ADD_SAP: Adding SAP(s) * REMOVE_SAP: Removing SAP(s) * ADD_NESTED_NS: Adding existing NS instance(s) as nested NS(s) * REMOVE_NESTED_NS: Removing existing nested NS instance(s) * ASSOC_NEW_NSD_VERSION: Associating a new NSD version to the NS instance * MOVE_VNF: Moving VNF instance(s) from one origin NS instance to another target NS instance * ADD_VNFFG: Adding VNFFG(s) * REMOVE_VNFFG: Removing VNFFG(s) * UPDATE_VNFFG: Updating VNFFG(s) * CHANGE_NS_DF: Changing NS DF * ADD_PNF: Adding PNF * MODIFY_PNF: Modifying PNF * REMOVE_PNF: Removing PNF ")
  public UpdateTypeEnum getUpdateType() {
    return updateType;
  }

  public void setUpdateType(UpdateTypeEnum updateType) {
    this.updateType = updateType;
  }

  public Body3 addVnfIstance(List<NsInstancesnsInstanceIdinstantiateVnfInstanceData> addVnfIstance) {
    this.addVnfIstance = addVnfIstance;
    return this;
  }

  public Body3 addAddVnfIstanceItem(NsInstancesnsInstanceIdinstantiateVnfInstanceData addVnfIstanceItem) {
    if (this.addVnfIstance == null) {
      this.addVnfIstance = new ArrayList<>();
    }
    this.addVnfIstance.add(addVnfIstanceItem);
    return this;
  }

   /**
   * Identifies an existing VNF instance to be added to the NS instance. It shall be present only if updateType &#x3D; \&quot;ADD_VNF\&quot;.          
   * @return addVnfIstance
  **/
  @Schema(description = "Identifies an existing VNF instance to be added to the NS instance. It shall be present only if updateType = \"ADD_VNF\".          ")
  public List<NsInstancesnsInstanceIdinstantiateVnfInstanceData> getAddVnfIstance() {
    return addVnfIstance;
  }

  public void setAddVnfIstance(List<NsInstancesnsInstanceIdinstantiateVnfInstanceData> addVnfIstance) {
    this.addVnfIstance = addVnfIstance;
  }

  public Body3 removeVnfInstanceId(List<String> removeVnfInstanceId) {
    this.removeVnfInstanceId = removeVnfInstanceId;
    return this;
  }

  public Body3 addRemoveVnfInstanceIdItem(String removeVnfInstanceIdItem) {
    if (this.removeVnfInstanceId == null) {
      this.removeVnfInstanceId = new ArrayList<>();
    }
    this.removeVnfInstanceId.add(removeVnfInstanceIdItem);
    return this;
  }

   /**
   * Identifies an existing VNF instance to be removed from the NS instance. It contains the identifier(s) of the VNF instances to be removed. It shall be present only if updateType &#x3D; \&quot;REMOVE_VNF.\&quot; Note: If a VNF instance is removed from a NS and this NS was the last one for which this VNF instance was a part, the VNF instance is terminated by the NFVO. 
   * @return removeVnfInstanceId
  **/
  @Schema(description = "Identifies an existing VNF instance to be removed from the NS instance. It contains the identifier(s) of the VNF instances to be removed. It shall be present only if updateType = \"REMOVE_VNF.\" Note: If a VNF instance is removed from a NS and this NS was the last one for which this VNF instance was a part, the VNF instance is terminated by the NFVO. ")
  public List<String> getRemoveVnfInstanceId() {
    return removeVnfInstanceId;
  }

  public void setRemoveVnfInstanceId(List<String> removeVnfInstanceId) {
    this.removeVnfInstanceId = removeVnfInstanceId;
  }

  public Body3 instantiateVnfData(List<NsInstancesnsInstanceIdupdateInstantiateVnfData> instantiateVnfData) {
    this.instantiateVnfData = instantiateVnfData;
    return this;
  }

  public Body3 addInstantiateVnfDataItem(NsInstancesnsInstanceIdupdateInstantiateVnfData instantiateVnfDataItem) {
    if (this.instantiateVnfData == null) {
      this.instantiateVnfData = new ArrayList<>();
    }
    this.instantiateVnfData.add(instantiateVnfDataItem);
    return this;
  }

   /**
   * Identifies the new VNF to be instantiated. It can be used e.g. for the bottom-up NS creation. It shall be present only if updateType &#x3D; \&quot;INSTANTIATE_VNF\&quot;. 
   * @return instantiateVnfData
  **/
  @Schema(description = "Identifies the new VNF to be instantiated. It can be used e.g. for the bottom-up NS creation. It shall be present only if updateType = \"INSTANTIATE_VNF\". ")
  public List<NsInstancesnsInstanceIdupdateInstantiateVnfData> getInstantiateVnfData() {
    return instantiateVnfData;
  }

  public void setInstantiateVnfData(List<NsInstancesnsInstanceIdupdateInstantiateVnfData> instantiateVnfData) {
    this.instantiateVnfData = instantiateVnfData;
  }

  public Body3 changeVnfFlavourData(List<NsInstancesnsInstanceIdupdateChangeVnfFlavourData> changeVnfFlavourData) {
    this.changeVnfFlavourData = changeVnfFlavourData;
    return this;
  }

  public Body3 addChangeVnfFlavourDataItem(NsInstancesnsInstanceIdupdateChangeVnfFlavourData changeVnfFlavourDataItem) {
    if (this.changeVnfFlavourData == null) {
      this.changeVnfFlavourData = new ArrayList<>();
    }
    this.changeVnfFlavourData.add(changeVnfFlavourDataItem);
    return this;
  }

   /**
   * Identifies the new DF of the VNF instance to be changed to. It shall be present only if updateType &#x3D; \&quot;CHANGE_VNF_DF\&quot;. 
   * @return changeVnfFlavourData
  **/
  @Schema(description = "Identifies the new DF of the VNF instance to be changed to. It shall be present only if updateType = \"CHANGE_VNF_DF\". ")
  public List<NsInstancesnsInstanceIdupdateChangeVnfFlavourData> getChangeVnfFlavourData() {
    return changeVnfFlavourData;
  }

  public void setChangeVnfFlavourData(List<NsInstancesnsInstanceIdupdateChangeVnfFlavourData> changeVnfFlavourData) {
    this.changeVnfFlavourData = changeVnfFlavourData;
  }

  public Body3 operateVnfData(List<NsInstancesnsInstanceIdupdateOperateVnfData> operateVnfData) {
    this.operateVnfData = operateVnfData;
    return this;
  }

  public Body3 addOperateVnfDataItem(NsInstancesnsInstanceIdupdateOperateVnfData operateVnfDataItem) {
    if (this.operateVnfData == null) {
      this.operateVnfData = new ArrayList<>();
    }
    this.operateVnfData.add(operateVnfDataItem);
    return this;
  }

   /**
   * Identifies the state of the VNF instance to be changed.  It shall be present only if updateType &#x3D; \&quot;OPERATE_VNF\&quot;. 
   * @return operateVnfData
  **/
  @Schema(description = "Identifies the state of the VNF instance to be changed.  It shall be present only if updateType = \"OPERATE_VNF\". ")
  public List<NsInstancesnsInstanceIdupdateOperateVnfData> getOperateVnfData() {
    return operateVnfData;
  }

  public void setOperateVnfData(List<NsInstancesnsInstanceIdupdateOperateVnfData> operateVnfData) {
    this.operateVnfData = operateVnfData;
  }

  public Body3 modifyVnfInfoData(List<NsInstancesnsInstanceIdupdateModifyVnfInfoData> modifyVnfInfoData) {
    this.modifyVnfInfoData = modifyVnfInfoData;
    return this;
  }

  public Body3 addModifyVnfInfoDataItem(NsInstancesnsInstanceIdupdateModifyVnfInfoData modifyVnfInfoDataItem) {
    if (this.modifyVnfInfoData == null) {
      this.modifyVnfInfoData = new ArrayList<>();
    }
    this.modifyVnfInfoData.add(modifyVnfInfoDataItem);
    return this;
  }

   /**
   * Identifies the VNF information parameters and/or the configurable properties of VNF instance to be modified. It shall be present only if updateType &#x3D; \&quot;MODIFY_VNF_INFORMATION\&quot;. 
   * @return modifyVnfInfoData
  **/
  @Schema(description = "Identifies the VNF information parameters and/or the configurable properties of VNF instance to be modified. It shall be present only if updateType = \"MODIFY_VNF_INFORMATION\". ")
  public List<NsInstancesnsInstanceIdupdateModifyVnfInfoData> getModifyVnfInfoData() {
    return modifyVnfInfoData;
  }

  public void setModifyVnfInfoData(List<NsInstancesnsInstanceIdupdateModifyVnfInfoData> modifyVnfInfoData) {
    this.modifyVnfInfoData = modifyVnfInfoData;
  }

  public Body3 changeExtVnfConnectivityData(List<NsInstancesnsInstanceIdupdateChangeExtVnfConnectivityData> changeExtVnfConnectivityData) {
    this.changeExtVnfConnectivityData = changeExtVnfConnectivityData;
    return this;
  }

  public Body3 addChangeExtVnfConnectivityDataItem(NsInstancesnsInstanceIdupdateChangeExtVnfConnectivityData changeExtVnfConnectivityDataItem) {
    if (this.changeExtVnfConnectivityData == null) {
      this.changeExtVnfConnectivityData = new ArrayList<>();
    }
    this.changeExtVnfConnectivityData.add(changeExtVnfConnectivityDataItem);
    return this;
  }

   /**
   * Specifies the new external connectivity data of the VNF instance to be changed. It shall be present only if updateType &#x3D; \&quot;CHANGE_EXTERNAL_VNF_CONNECTIVITY\&quot;. 
   * @return changeExtVnfConnectivityData
  **/
  @Schema(description = "Specifies the new external connectivity data of the VNF instance to be changed. It shall be present only if updateType = \"CHANGE_EXTERNAL_VNF_CONNECTIVITY\". ")
  public List<NsInstancesnsInstanceIdupdateChangeExtVnfConnectivityData> getChangeExtVnfConnectivityData() {
    return changeExtVnfConnectivityData;
  }

  public void setChangeExtVnfConnectivityData(List<NsInstancesnsInstanceIdupdateChangeExtVnfConnectivityData> changeExtVnfConnectivityData) {
    this.changeExtVnfConnectivityData = changeExtVnfConnectivityData;
  }

  public Body3 addSap(List<NsInstancesnsInstanceIdinstantiateSapData> addSap) {
    this.addSap = addSap;
    return this;
  }

  public Body3 addAddSapItem(NsInstancesnsInstanceIdinstantiateSapData addSapItem) {
    if (this.addSap == null) {
      this.addSap = new ArrayList<>();
    }
    this.addSap.add(addSapItem);
    return this;
  }

   /**
   * Identifies a new SAP to be added to the NS instance. It shall be present only if updateType &#x3D; \&quot;ADD_SAP.\&quot; 
   * @return addSap
  **/
  @Schema(description = "Identifies a new SAP to be added to the NS instance. It shall be present only if updateType = \"ADD_SAP.\" ")
  public List<NsInstancesnsInstanceIdinstantiateSapData> getAddSap() {
    return addSap;
  }

  public void setAddSap(List<NsInstancesnsInstanceIdinstantiateSapData> addSap) {
    this.addSap = addSap;
  }

  public Body3 removeSapId(List<String> removeSapId) {
    this.removeSapId = removeSapId;
    return this;
  }

  public Body3 addRemoveSapIdItem(String removeSapIdItem) {
    if (this.removeSapId == null) {
      this.removeSapId = new ArrayList<>();
    }
    this.removeSapId.add(removeSapIdItem);
    return this;
  }

   /**
   * The identifier an existing SAP to be removed from the NS instance. It shall be present only if updateType &#x3D; \&quot;REMOVE_SAP.\&quot; 
   * @return removeSapId
  **/
  @Schema(description = "The identifier an existing SAP to be removed from the NS instance. It shall be present only if updateType = \"REMOVE_SAP.\" ")
  public List<String> getRemoveSapId() {
    return removeSapId;
  }

  public void setRemoveSapId(List<String> removeSapId) {
    this.removeSapId = removeSapId;
  }

  public Body3 addNestedNsData(List<NsInstancesnsInstanceIdinstantiateNestedNsInstanceData> addNestedNsData) {
    this.addNestedNsData = addNestedNsData;
    return this;
  }

  public Body3 addAddNestedNsDataItem(NsInstancesnsInstanceIdinstantiateNestedNsInstanceData addNestedNsDataItem) {
    if (this.addNestedNsData == null) {
      this.addNestedNsData = new ArrayList<>();
    }
    this.addNestedNsData.add(addNestedNsDataItem);
    return this;
  }

   /**
   * The identifier of an existing nested NS instance to be added to (nested within) the NS instance. It shall be present only if updateType &#x3D; \&quot;ADD_NESTED_NS\&quot;. 
   * @return addNestedNsData
  **/
  @Schema(description = "The identifier of an existing nested NS instance to be added to (nested within) the NS instance. It shall be present only if updateType = \"ADD_NESTED_NS\". ")
  public List<NsInstancesnsInstanceIdinstantiateNestedNsInstanceData> getAddNestedNsData() {
    return addNestedNsData;
  }

  public void setAddNestedNsData(List<NsInstancesnsInstanceIdinstantiateNestedNsInstanceData> addNestedNsData) {
    this.addNestedNsData = addNestedNsData;
  }

  public Body3 removeNestedNsId(List<String> removeNestedNsId) {
    this.removeNestedNsId = removeNestedNsId;
    return this;
  }

  public Body3 addRemoveNestedNsIdItem(String removeNestedNsIdItem) {
    if (this.removeNestedNsId == null) {
      this.removeNestedNsId = new ArrayList<>();
    }
    this.removeNestedNsId.add(removeNestedNsIdItem);
    return this;
  }

   /**
   * The identifier of an existing nested NS instance to be removed from the NS instance. It shall be present only if updateType &#x3D; \&quot;REMOVE_NESTED_NS\&quot;. 
   * @return removeNestedNsId
  **/
  @Schema(description = "The identifier of an existing nested NS instance to be removed from the NS instance. It shall be present only if updateType = \"REMOVE_NESTED_NS\". ")
  public List<String> getRemoveNestedNsId() {
    return removeNestedNsId;
  }

  public void setRemoveNestedNsId(List<String> removeNestedNsId) {
    this.removeNestedNsId = removeNestedNsId;
  }

  public Body3 assocNewNsdVersionData(NsInstancesnsInstanceIdupdateAssocNewNsdVersionData assocNewNsdVersionData) {
    this.assocNewNsdVersionData = assocNewNsdVersionData;
    return this;
  }

   /**
   * Get assocNewNsdVersionData
   * @return assocNewNsdVersionData
  **/
  @Schema(description = "")
  public NsInstancesnsInstanceIdupdateAssocNewNsdVersionData getAssocNewNsdVersionData() {
    return assocNewNsdVersionData;
  }

  public void setAssocNewNsdVersionData(NsInstancesnsInstanceIdupdateAssocNewNsdVersionData assocNewNsdVersionData) {
    this.assocNewNsdVersionData = assocNewNsdVersionData;
  }

  public Body3 moveVnfInstanceData(List<NsInstancesnsInstanceIdupdateMoveVnfInstanceData> moveVnfInstanceData) {
    this.moveVnfInstanceData = moveVnfInstanceData;
    return this;
  }

  public Body3 addMoveVnfInstanceDataItem(NsInstancesnsInstanceIdupdateMoveVnfInstanceData moveVnfInstanceDataItem) {
    if (this.moveVnfInstanceData == null) {
      this.moveVnfInstanceData = new ArrayList<>();
    }
    this.moveVnfInstanceData.add(moveVnfInstanceDataItem);
    return this;
  }

   /**
   * Specify existing VNF instance to be moved from one NS instance to another NS instance. It shall be present only if updateType &#x3D; MOVE_VNF\&quot;. 
   * @return moveVnfInstanceData
  **/
  @Schema(description = "Specify existing VNF instance to be moved from one NS instance to another NS instance. It shall be present only if updateType = MOVE_VNF\". ")
  public List<NsInstancesnsInstanceIdupdateMoveVnfInstanceData> getMoveVnfInstanceData() {
    return moveVnfInstanceData;
  }

  public void setMoveVnfInstanceData(List<NsInstancesnsInstanceIdupdateMoveVnfInstanceData> moveVnfInstanceData) {
    this.moveVnfInstanceData = moveVnfInstanceData;
  }

  public Body3 addVnffg(List<NsInstancesnsInstanceIdupdateAddVnffg> addVnffg) {
    this.addVnffg = addVnffg;
    return this;
  }

  public Body3 addAddVnffgItem(NsInstancesnsInstanceIdupdateAddVnffg addVnffgItem) {
    if (this.addVnffg == null) {
      this.addVnffg = new ArrayList<>();
    }
    this.addVnffg.add(addVnffgItem);
    return this;
  }

   /**
   * Specify the new VNFFG to be created to the NS Instance. It shall be present only if updateType &#x3D; \&quot;ADD_VNFFG\&quot;. 
   * @return addVnffg
  **/
  @Schema(description = "Specify the new VNFFG to be created to the NS Instance. It shall be present only if updateType = \"ADD_VNFFG\". ")
  public List<NsInstancesnsInstanceIdupdateAddVnffg> getAddVnffg() {
    return addVnffg;
  }

  public void setAddVnffg(List<NsInstancesnsInstanceIdupdateAddVnffg> addVnffg) {
    this.addVnffg = addVnffg;
  }

  public Body3 removeVnffgId(List<String> removeVnffgId) {
    this.removeVnffgId = removeVnffgId;
    return this;
  }

  public Body3 addRemoveVnffgIdItem(String removeVnffgIdItem) {
    if (this.removeVnffgId == null) {
      this.removeVnffgId = new ArrayList<>();
    }
    this.removeVnffgId.add(removeVnffgIdItem);
    return this;
  }

   /**
   * Identifier of an existing VNFFG to be removed from the NS Instance. It shall be present only if updateType &#x3D; \&quot;REMOVE_VNFFG\&quot;. 
   * @return removeVnffgId
  **/
  @Schema(description = "Identifier of an existing VNFFG to be removed from the NS Instance. It shall be present only if updateType = \"REMOVE_VNFFG\". ")
  public List<String> getRemoveVnffgId() {
    return removeVnffgId;
  }

  public void setRemoveVnffgId(List<String> removeVnffgId) {
    this.removeVnffgId = removeVnffgId;
  }

  public Body3 updateVnffg(List<NsInstancesnsInstanceIdupdateUpdateVnffg> updateVnffg) {
    this.updateVnffg = updateVnffg;
    return this;
  }

  public Body3 addUpdateVnffgItem(NsInstancesnsInstanceIdupdateUpdateVnffg updateVnffgItem) {
    if (this.updateVnffg == null) {
      this.updateVnffg = new ArrayList<>();
    }
    this.updateVnffg.add(updateVnffgItem);
    return this;
  }

   /**
   * Specify the new VNFFG Information data to be updated for a VNFFG of the NS Instance. It shall be present only if updateType &#x3D; \&quot;UPDATE_VNFFG\&quot;. 
   * @return updateVnffg
  **/
  @Schema(description = "Specify the new VNFFG Information data to be updated for a VNFFG of the NS Instance. It shall be present only if updateType = \"UPDATE_VNFFG\". ")
  public List<NsInstancesnsInstanceIdupdateUpdateVnffg> getUpdateVnffg() {
    return updateVnffg;
  }

  public void setUpdateVnffg(List<NsInstancesnsInstanceIdupdateUpdateVnffg> updateVnffg) {
    this.updateVnffg = updateVnffg;
  }

  public Body3 changeNsFlavourData(NsInstancesnsInstanceIdupdateChangeNsFlavourData changeNsFlavourData) {
    this.changeNsFlavourData = changeNsFlavourData;
    return this;
  }

   /**
   * Get changeNsFlavourData
   * @return changeNsFlavourData
  **/
  @Schema(description = "")
  public NsInstancesnsInstanceIdupdateChangeNsFlavourData getChangeNsFlavourData() {
    return changeNsFlavourData;
  }

  public void setChangeNsFlavourData(NsInstancesnsInstanceIdupdateChangeNsFlavourData changeNsFlavourData) {
    this.changeNsFlavourData = changeNsFlavourData;
  }

  public Body3 addPnfData(List<NsInstancesnsInstanceIdinstantiateAddpnfData> addPnfData) {
    this.addPnfData = addPnfData;
    return this;
  }

  public Body3 addAddPnfDataItem(NsInstancesnsInstanceIdinstantiateAddpnfData addPnfDataItem) {
    if (this.addPnfData == null) {
      this.addPnfData = new ArrayList<>();
    }
    this.addPnfData.add(addPnfDataItem);
    return this;
  }

   /**
   * specifies the PNF to be added into the NS instance.  It shall be present only if updateType &#x3D; \&quot;ADD_PNF\&quot;. 
   * @return addPnfData
  **/
  @Schema(description = "specifies the PNF to be added into the NS instance.  It shall be present only if updateType = \"ADD_PNF\". ")
  public List<NsInstancesnsInstanceIdinstantiateAddpnfData> getAddPnfData() {
    return addPnfData;
  }

  public void setAddPnfData(List<NsInstancesnsInstanceIdinstantiateAddpnfData> addPnfData) {
    this.addPnfData = addPnfData;
  }

  public Body3 modifyPnfData(List<NsInstancesnsInstanceIdupdateModifyPnfData> modifyPnfData) {
    this.modifyPnfData = modifyPnfData;
    return this;
  }

  public Body3 addModifyPnfDataItem(NsInstancesnsInstanceIdupdateModifyPnfData modifyPnfDataItem) {
    if (this.modifyPnfData == null) {
      this.modifyPnfData = new ArrayList<>();
    }
    this.modifyPnfData.add(modifyPnfDataItem);
    return this;
  }

   /**
   * Specifies the PNF to be modified in the NS instance.  It shall be present only if updateType &#x3D; \&quot;MODIFY_PNF\&quot;. 
   * @return modifyPnfData
  **/
  @Schema(description = "Specifies the PNF to be modified in the NS instance.  It shall be present only if updateType = \"MODIFY_PNF\". ")
  public List<NsInstancesnsInstanceIdupdateModifyPnfData> getModifyPnfData() {
    return modifyPnfData;
  }

  public void setModifyPnfData(List<NsInstancesnsInstanceIdupdateModifyPnfData> modifyPnfData) {
    this.modifyPnfData = modifyPnfData;
  }

  public Body3 removePnfId(List<String> removePnfId) {
    this.removePnfId = removePnfId;
    return this;
  }

  public Body3 addRemovePnfIdItem(String removePnfIdItem) {
    if (this.removePnfId == null) {
      this.removePnfId = new ArrayList<>();
    }
    this.removePnfId.add(removePnfIdItem);
    return this;
  }

   /**
   * Identifier of the PNF to be deleted from the NS instance. It shall be present only if updateType &#x3D; \&quot;REMOVE_PNF\&quot;. 
   * @return removePnfId
  **/
  @Schema(description = "Identifier of the PNF to be deleted from the NS instance. It shall be present only if updateType = \"REMOVE_PNF\". ")
  public List<String> getRemovePnfId() {
    return removePnfId;
  }

  public void setRemovePnfId(List<String> removePnfId) {
    this.removePnfId = removePnfId;
  }

  public Body3 updateTime(Object updateTime) {
    this.updateTime = updateTime;
    return this;
  }

   /**
   * Date-time stamp. Representation: String formatted according toas defined by the date-time production in IETF RFC 3339. 
   * @return updateTime
  **/
  @Schema(description = "Date-time stamp. Representation: String formatted according toas defined by the date-time production in IETF RFC 3339. ")
  public Object getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Object updateTime) {
    this.updateTime = updateTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Body3 body3 = (Body3) o;
    return Objects.equals(this.updateType, body3.updateType) &&
        Objects.equals(this.addVnfIstance, body3.addVnfIstance) &&
        Objects.equals(this.removeVnfInstanceId, body3.removeVnfInstanceId) &&
        Objects.equals(this.instantiateVnfData, body3.instantiateVnfData) &&
        Objects.equals(this.changeVnfFlavourData, body3.changeVnfFlavourData) &&
        Objects.equals(this.operateVnfData, body3.operateVnfData) &&
        Objects.equals(this.modifyVnfInfoData, body3.modifyVnfInfoData) &&
        Objects.equals(this.changeExtVnfConnectivityData, body3.changeExtVnfConnectivityData) &&
        Objects.equals(this.addSap, body3.addSap) &&
        Objects.equals(this.removeSapId, body3.removeSapId) &&
        Objects.equals(this.addNestedNsData, body3.addNestedNsData) &&
        Objects.equals(this.removeNestedNsId, body3.removeNestedNsId) &&
        Objects.equals(this.assocNewNsdVersionData, body3.assocNewNsdVersionData) &&
        Objects.equals(this.moveVnfInstanceData, body3.moveVnfInstanceData) &&
        Objects.equals(this.addVnffg, body3.addVnffg) &&
        Objects.equals(this.removeVnffgId, body3.removeVnffgId) &&
        Objects.equals(this.updateVnffg, body3.updateVnffg) &&
        Objects.equals(this.changeNsFlavourData, body3.changeNsFlavourData) &&
        Objects.equals(this.addPnfData, body3.addPnfData) &&
        Objects.equals(this.modifyPnfData, body3.modifyPnfData) &&
        Objects.equals(this.removePnfId, body3.removePnfId) &&
        Objects.equals(this.updateTime, body3.updateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(updateType, addVnfIstance, removeVnfInstanceId, instantiateVnfData, changeVnfFlavourData, operateVnfData, modifyVnfInfoData, changeExtVnfConnectivityData, addSap, removeSapId, addNestedNsData, removeNestedNsId, assocNewNsdVersionData, moveVnfInstanceData, addVnffg, removeVnffgId, updateVnffg, changeNsFlavourData, addPnfData, modifyPnfData, removePnfId, updateTime);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Body3 {\n");
    
    sb.append("    updateType: ").append(toIndentedString(updateType)).append("\n");
    sb.append("    addVnfIstance: ").append(toIndentedString(addVnfIstance)).append("\n");
    sb.append("    removeVnfInstanceId: ").append(toIndentedString(removeVnfInstanceId)).append("\n");
    sb.append("    instantiateVnfData: ").append(toIndentedString(instantiateVnfData)).append("\n");
    sb.append("    changeVnfFlavourData: ").append(toIndentedString(changeVnfFlavourData)).append("\n");
    sb.append("    operateVnfData: ").append(toIndentedString(operateVnfData)).append("\n");
    sb.append("    modifyVnfInfoData: ").append(toIndentedString(modifyVnfInfoData)).append("\n");
    sb.append("    changeExtVnfConnectivityData: ").append(toIndentedString(changeExtVnfConnectivityData)).append("\n");
    sb.append("    addSap: ").append(toIndentedString(addSap)).append("\n");
    sb.append("    removeSapId: ").append(toIndentedString(removeSapId)).append("\n");
    sb.append("    addNestedNsData: ").append(toIndentedString(addNestedNsData)).append("\n");
    sb.append("    removeNestedNsId: ").append(toIndentedString(removeNestedNsId)).append("\n");
    sb.append("    assocNewNsdVersionData: ").append(toIndentedString(assocNewNsdVersionData)).append("\n");
    sb.append("    moveVnfInstanceData: ").append(toIndentedString(moveVnfInstanceData)).append("\n");
    sb.append("    addVnffg: ").append(toIndentedString(addVnffg)).append("\n");
    sb.append("    removeVnffgId: ").append(toIndentedString(removeVnffgId)).append("\n");
    sb.append("    updateVnffg: ").append(toIndentedString(updateVnffg)).append("\n");
    sb.append("    changeNsFlavourData: ").append(toIndentedString(changeNsFlavourData)).append("\n");
    sb.append("    addPnfData: ").append(toIndentedString(addPnfData)).append("\n");
    sb.append("    modifyPnfData: ").append(toIndentedString(modifyPnfData)).append("\n");
    sb.append("    removePnfId: ").append(toIndentedString(removePnfId)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
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
