package com.muigs.systems.rtgapi.request;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
	public UserRequest() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("agentid")
	private String agentid;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("balance")
	private Double balance;
	
	@JsonProperty("countryId")
	private String countryId;
	
	@JsonProperty("birthdate")
	private String birthdate;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("playerId")
	private String playerId;
	
	@JsonProperty("playerLogin")
	private String playerLogin;
	
	@JsonProperty("agentId")
	private String agentId;
	
	@JsonProperty("gameId")
	private String gameId;
	
	@JsonProperty("locale")
	private String locale;
	
	@JsonProperty("returnUrl")
	private String returnUrl;
	
	@JsonProperty("isDemo")
	private Boolean isDemo;
	
	@JsonProperty("player")
	private String player;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("trackingOne")
	private String trackingOne;
}
