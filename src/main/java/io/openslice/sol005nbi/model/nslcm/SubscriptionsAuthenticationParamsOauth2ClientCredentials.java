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
 * Parameters for authentication/authorization using OAUTH2_CLIENT_CREDENTIALS. Shall be present if authType is \&quot;OAUTH2_CLIENT_CREDENTIALS\&quot; and the contained information has not been provisioned out of band. Shall be absent otherwise. 
 */
@Schema(description = "Parameters for authentication/authorization using OAUTH2_CLIENT_CREDENTIALS. Shall be present if authType is \"OAUTH2_CLIENT_CREDENTIALS\" and the contained information has not been provisioned out of band. Shall be absent otherwise. ")
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class SubscriptionsAuthenticationParamsOauth2ClientCredentials {
  @JsonProperty("clientId")
  private String clientId = null;

  @JsonProperty("clientPassword")
  private String clientPassword = null;

  @JsonProperty("tokenEndpoint")
  private String tokenEndpoint = null;

  public SubscriptionsAuthenticationParamsOauth2ClientCredentials clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

   /**
   * Client identifier to be used in the access token request of the OAuth 2.0 client credentials grant type. Shall be present if it has not been provisioned out of band. The clientId and clientPassword passed in a subscription shall not be the same as the clientId and clientPassword that are used to obtain authorization for API requests. Client credentials may differ between subscriptions. The value of clientPassword should be generated by a random process. 
   * @return clientId
  **/
  @Schema(description = "Client identifier to be used in the access token request of the OAuth 2.0 client credentials grant type. Shall be present if it has not been provisioned out of band. The clientId and clientPassword passed in a subscription shall not be the same as the clientId and clientPassword that are used to obtain authorization for API requests. Client credentials may differ between subscriptions. The value of clientPassword should be generated by a random process. ")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public SubscriptionsAuthenticationParamsOauth2ClientCredentials clientPassword(String clientPassword) {
    this.clientPassword = clientPassword;
    return this;
  }

   /**
   * Client password to be used in the access token request of the OAuth 2.0 client credentials grant type. Shall be present if it has not been provisioned out of band. The clientId and clientPassword passed in a subscription shall not be the same as the clientId and clientPassword that are used to obtain authorization for API requests. Client credentials may differ between subscriptions. The value of clientPassword should be generated by a random process. 
   * @return clientPassword
  **/
  @Schema(description = "Client password to be used in the access token request of the OAuth 2.0 client credentials grant type. Shall be present if it has not been provisioned out of band. The clientId and clientPassword passed in a subscription shall not be the same as the clientId and clientPassword that are used to obtain authorization for API requests. Client credentials may differ between subscriptions. The value of clientPassword should be generated by a random process. ")
  public String getClientPassword() {
    return clientPassword;
  }

  public void setClientPassword(String clientPassword) {
    this.clientPassword = clientPassword;
  }

  public SubscriptionsAuthenticationParamsOauth2ClientCredentials tokenEndpoint(String tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
    return this;
  }

   /**
   * String formatted according to IETF RFC 3986. 
   * @return tokenEndpoint
  **/
  @Schema(description = "String formatted according to IETF RFC 3986. ")
  public String getTokenEndpoint() {
    return tokenEndpoint;
  }

  public void setTokenEndpoint(String tokenEndpoint) {
    this.tokenEndpoint = tokenEndpoint;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionsAuthenticationParamsOauth2ClientCredentials subscriptionsAuthenticationParamsOauth2ClientCredentials = (SubscriptionsAuthenticationParamsOauth2ClientCredentials) o;
    return Objects.equals(this.clientId, subscriptionsAuthenticationParamsOauth2ClientCredentials.clientId) &&
        Objects.equals(this.clientPassword, subscriptionsAuthenticationParamsOauth2ClientCredentials.clientPassword) &&
        Objects.equals(this.tokenEndpoint, subscriptionsAuthenticationParamsOauth2ClientCredentials.tokenEndpoint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, clientPassword, tokenEndpoint);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionsAuthenticationParamsOauth2ClientCredentials {\n");
    
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    clientPassword: ").append(toIndentedString(clientPassword)).append("\n");
    sb.append("    tokenEndpoint: ").append(toIndentedString(tokenEndpoint)).append("\n");
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
