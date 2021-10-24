/*-
 * ========================LICENSE_START=================================
 * io.openslice.sol005nbi.osm7
 * %%
 * Copyright (C) 2019 openslice.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

package io.openslice.sol005nbi.etsi;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NSInstantiateInstanceRequestPayload
{
	private String nsName;
	public String getNsName() {
		return nsName;
	}

	public void setNsName(String nsName) {
		this.nsName = nsName;
	}

	private String vimAccountId;
	public String getVimAccountId() {
		return vimAccountId;
	}

	public void setVimAccountId(String vimAccountId) {
		this.vimAccountId = vimAccountId;
	}

	private Boolean wimAccountId;
	public Boolean getWimAccountId() {
		return wimAccountId;
	}

	public void setWimAccountId(Boolean wimAccountId) {
		this.wimAccountId = wimAccountId;
	}

	
	private String nsdId;
	public String getNsdId() {
		return nsdId;
	}

	public void setNsdId(String nsdId) {
		this.nsdId = nsdId;
	}

	public class VnF
	{
		@JsonProperty("member-vnf-index")
		private String memberVnFIndex;
		public String getMemberVnFIndex() {
			return memberVnFIndex;
		}
		public void setMemberVnFIndex(String memberVnFIndex) {
			this.memberVnFIndex = memberVnFIndex;
		}
		@JsonProperty("vdu")
		private List<Vdu> vdu = null;
		
		public List<Vdu> getVdu() {
			return vdu;
		}
		public void setVdu(List<Vdu> vdu) {
			this.vdu = vdu;
		}
		
		@JsonProperty("vimAccountId")
		private String vimAccount;
		public String getVimAccount() {
			return vimAccount;
		}
		public void setVimAccount(String vimAccount) {
			this.vimAccount = vimAccount;
		}
		
		public VnF()
		{
			
		};
	}
	
	
	public class Vdu
	{
		@JsonProperty("id")
		private String id;
		@JsonProperty("interface")
		private ArrayList<NInterface> interfaceObj = null;

		public ArrayList<NInterface> getInterfaceObj() {
			return interfaceObj;
		}
		public void setInterfaceObj(ArrayList<NInterface> interfaceObj) {
			this.interfaceObj = interfaceObj;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
	}
	
	public class NInterface
	{
		@JsonProperty("name")
		private String name;
		@JsonProperty("floating-ip-required")
		private Boolean floating_ip_required;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Boolean getFloating_ip_required() {
			return floating_ip_required;
		}
		public void setFloating_ip_required(Boolean floating_ip_required) {
			this.floating_ip_required = floating_ip_required;
		}
	}

	class Vld
	{
		@JsonProperty("name")
		private String name;
		@JsonProperty("vim-network-name")
		private LinkedHashMap<String,String> vimNetworkName = new LinkedHashMap<>();

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public LinkedHashMap<String, String> getVimNetworkName() {
			return vimNetworkName;
		}
		public void setVimNetworkName(LinkedHashMap<String, String> vimNetworkName) {
			this.vimNetworkName = vimNetworkName;
		}
//		private String vimNetworkName;
//		public String getVimNetworkName() {
//			return vimNetworkName;
//		}
//		public void setVimNetworkName(String vimNetworkName) {
//			this.vimNetworkName = vimNetworkName;
//		}
	}
	private List<VnF> vnf = new ArrayList<>();
	public List<VnF> getVnf() {
		return vnf;
	}

	public void setVnf(List<VnF> vnf) {
		this.vnf = vnf;
	}

	private List<Vld> vld = new ArrayList<>();
	
	public List<Vld> getVld() {
		return vld;
	}

	public void setVld(List<Vld> vld) {
		this.vld = vld;
	}

		
	public String toJSON()
	{
		String jsonInString=null;
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		try {
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return jsonInString;
	}
	
}
