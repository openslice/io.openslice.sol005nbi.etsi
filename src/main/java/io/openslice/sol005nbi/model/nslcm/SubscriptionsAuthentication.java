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
 * SubscriptionsAuthentication
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-03-28T00:48:29.393+02:00[Europe/Athens]")
public class SubscriptionsAuthentication {
  /**
   * Gets or Sets authType
   */
  public enum AuthTypeEnum {
    BASIC("BASIC"),
    OAUTH2_CLIENT_CREDENTIALS("OAUTH2_CLIENT_CREDENTIALS"),
    TLS_CERT("TLS_CERT");

    private String value;

    AuthTypeEnum(String value) {
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
    public static AuthTypeEnum fromValue(String text) {
      for (AuthTypeEnum b : AuthTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

  }  @JsonProperty("authType")
  private List<AuthTypeEnum> authType = new ArrayList<>();

  @JsonProperty("paramsBasic")
  private SubscriptionsAuthenticationParamsBasic paramsBasic = null;

  @JsonProperty("paramsOauth2ClientCredentials")
  private SubscriptionsAuthenticationParamsOauth2ClientCredentials paramsOauth2ClientCredentials = null;

  public SubscriptionsAuthentication authType(List<AuthTypeEnum> authType) {
    this.authType = authType;
    return this;
  }

  public SubscriptionsAuthentication addAuthTypeItem(AuthTypeEnum authTypeItem) {
    this.authType.add(authTypeItem);
    return this;
  }

   /**
   * Defines the types of Authentication / Authorization which the API consumer is willing to accept when receiving a notification. Permitted values: - BASIC: In every HTTP request to the notification endpoint, use   HTTP Basic authentication with the client credentials. - OAUTH2_CLIENT_CREDENTIALS: In every HTTP request to the   notification endpoint, use an OAuth 2.0 Bearer token, obtained   using the client credentials grant type. - TLS_CERT: Every HTTP request to the notification endpoint is sent   over a mutually authenticated TLS session, i.e. not only the   server is authenticated, but also the client is authenticated   during the TLS tunnel setup. 
   * @return authType
  **/
  @Schema(required = true, description = "Defines the types of Authentication / Authorization which the API consumer is willing to accept when receiving a notification. Permitted values: - BASIC: In every HTTP request to the notification endpoint, use   HTTP Basic authentication with the client credentials. - OAUTH2_CLIENT_CREDENTIALS: In every HTTP request to the   notification endpoint, use an OAuth 2.0 Bearer token, obtained   using the client credentials grant type. - TLS_CERT: Every HTTP request to the notification endpoint is sent   over a mutually authenticated TLS session, i.e. not only the   server is authenticated, but also the client is authenticated   during the TLS tunnel setup. ")
  public List<AuthTypeEnum> getAuthType() {
    return authType;
  }

  public void setAuthType(List<AuthTypeEnum> authType) {
    this.authType = authType;
  }

  public SubscriptionsAuthentication paramsBasic(SubscriptionsAuthenticationParamsBasic paramsBasic) {
    this.paramsBasic = paramsBasic;
    return this;
  }

   /**
   * Get paramsBasic
   * @return paramsBasic
  **/
  @Schema(description = "")
  public SubscriptionsAuthenticationParamsBasic getParamsBasic() {
    return paramsBasic;
  }

  public void setParamsBasic(SubscriptionsAuthenticationParamsBasic paramsBasic) {
    this.paramsBasic = paramsBasic;
  }

  public SubscriptionsAuthentication paramsOauth2ClientCredentials(SubscriptionsAuthenticationParamsOauth2ClientCredentials paramsOauth2ClientCredentials) {
    this.paramsOauth2ClientCredentials = paramsOauth2ClientCredentials;
    return this;
  }

   /**
   * Get paramsOauth2ClientCredentials
   * @return paramsOauth2ClientCredentials
  **/
  @Schema(description = "")
  public SubscriptionsAuthenticationParamsOauth2ClientCredentials getParamsOauth2ClientCredentials() {
    return paramsOauth2ClientCredentials;
  }

  public void setParamsOauth2ClientCredentials(SubscriptionsAuthenticationParamsOauth2ClientCredentials paramsOauth2ClientCredentials) {
    this.paramsOauth2ClientCredentials = paramsOauth2ClientCredentials;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubscriptionsAuthentication subscriptionsAuthentication = (SubscriptionsAuthentication) o;
    return Objects.equals(this.authType, subscriptionsAuthentication.authType) &&
        Objects.equals(this.paramsBasic, subscriptionsAuthentication.paramsBasic) &&
        Objects.equals(this.paramsOauth2ClientCredentials, subscriptionsAuthentication.paramsOauth2ClientCredentials);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authType, paramsBasic, paramsOauth2ClientCredentials);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionsAuthentication {\n");
    
    sb.append("    authType: ").append(toIndentedString(authType)).append("\n");
    sb.append("    paramsBasic: ").append(toIndentedString(paramsBasic)).append("\n");
    sb.append("    paramsOauth2ClientCredentials: ").append(toIndentedString(paramsOauth2ClientCredentials)).append("\n");
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
