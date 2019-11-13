package com.muigs.systems.rtgapi.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
	@JsonProperty("id")
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("balance")
	private Double balance;
	@JsonProperty("locales")
	private List<String> locales = null;
	@JsonProperty("currencies")
	private List<String> currencies = null;
	@JsonProperty("agentId")
	private String agentId;
	@JsonProperty("agentname")
	private String agentname;
	@JsonProperty("activesessions")
	private Boolean activesessions;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("lastName")
	private String lastName;
	@JsonProperty("username")
	private String username;
	@JsonProperty("email")
	private String email;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("dayPhone")
	private String dayPhone;
	@JsonProperty("eveningPhone")
	private String eveningPhone;
	@JsonProperty("cellPhone")
	private String cellPhone;
	@JsonProperty("birthdate")
	private String birthdate;
	@JsonProperty("playerClassId")
	private String playerClassId;
	@JsonProperty("countryId")
	private String countryId;
	@JsonProperty("city")
	private String city;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("postalCode")
	private String postalCode;
	@JsonProperty("state")
	private String state;
	@JsonProperty("walletEndpoint")
	private String walletEndpoint;
	@JsonProperty("playerClass")
	private String playerClass;
	@JsonProperty("languageId")
	private String languageId;
	@JsonProperty("language")
	private String language;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("walletId")
	private String walletId;
	@JsonProperty("errorMessage")
	private String errorMessage;
	@JsonProperty("transactionId")
	private String transactionId;
	@JsonProperty("errorCode")
	private String errorCode;
	@JsonProperty("playerId")
	private String playerId;
	@JsonProperty("gameId")
	private String gameId;
	@JsonProperty("locale")
	private String locale;
	@JsonProperty("description")
	private String description;
	@JsonProperty("longDescription")
	private String longDescription;
	@JsonProperty("instantPlayUrl")
	private String instantPlayUrl;
	@JsonProperty("token")
	private String token;
}
