/*-
 * ========================LICENSE_START=================================
 * io.openslice.sol007nbi.osm
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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Ioannis Chatzis
 *
 */
enum ScaleVnfType {SCALE_OUT, SCALE_IN};

public class NSScaleRequestPayload 
{	
	
	private class ScaleVnfData
	{
		private class ScaleByStepData
		{
			private String scaling_group_descriptor;
			private String member_vnf_index;
			private String scaling_policy;

			public String getScaling_group_descriptor() {
				return scaling_group_descriptor;
			}
			public void setScaling_group_descriptor(String scaling_group_descriptor) {
				this.scaling_group_descriptor = scaling_group_descriptor;
			}
			public String getMember_vnf_index() {
				return member_vnf_index;
			}
			public void setMember_vnf_index(String member_vnf_index) {
				this.member_vnf_index = member_vnf_index;
			}
			public String getScaling_policy() {
				return scaling_policy;
			}
			public void setScaling_policy(String scaling_policy) {
				this.scaling_policy = scaling_policy;
			}			
		}

		private ScaleVnfType scaleVnfType;
		private String vnfInstanceId;		
		private ScaleByStepData scaleByStepData;

		public String getVnfInstanceId() {
			return vnfInstanceId;
		}
		public ScaleByStepData getScaleByStepData() {
			return scaleByStepData;
		}
		public void setScaleByStepData(ScaleByStepData scaleByStepData) {
			this.scaleByStepData = scaleByStepData;
		}
		public void setVnfInstanceId(String vnfInstanceId) {
			this.vnfInstanceId = vnfInstanceId;
		}
		public ScaleVnfType getScaleVnfType() {
			return scaleVnfType;
		}
		public void setScaleVnfType(ScaleVnfType scaleVnfType) {
			this.scaleVnfType = scaleVnfType;
		}
		
	}
	
    private String lcmOperationType; //"lcmOperationType": "scale"
    private String nsInstanceId;
	private String scaleType;
	private String timeout_ns_scale;
	private ScaleVnfData scaleVnfData;
	private String scaleTime;
    
	public String getLcmOperationType() {
		return lcmOperationType;
	}

	public void setLcmOperationType(String lcmOperationType) {
		this.lcmOperationType = lcmOperationType;
	}

	public String getNsInstanceId() {
		return nsInstanceId;
	}

	public void setNsInstanceId(String nsInstanceId) {
		this.nsInstanceId = nsInstanceId;
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

	public String getScaleType() {
		return scaleType;
	}

	public void setScaleType(String scaleType) {
		this.scaleType = scaleType;
	}

	public String getTimeout_ns_scale() {
		return timeout_ns_scale;
	}

	public void setTimeout_ns_scale(String timeout_ns_scale) {
		this.timeout_ns_scale = timeout_ns_scale;
	}

	public ScaleVnfData getScaleVnfData() {
		return scaleVnfData;
	}

	public void setScaleVnfData(ScaleVnfData scaleVnfData) {
		this.scaleVnfData = scaleVnfData;
	}

	public String getScaleTime() {
		return scaleTime;
	}

	public void setScaleTime(String scaleTime) {
		this.scaleTime = scaleTime;
	}    
}

