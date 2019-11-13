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
public class PostmanRequest {
	


	public PostmanRequest(String playerLogin) {
		this.playerLogin = playerLogin;
	}

	@JsonProperty("username")
	private String username;
	
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("method")
	private String method;
	
	@JsonProperty("locale")
	private String locale;
	
	@JsonProperty("isDemo")
	private Boolean isDemo;
	
	@JsonProperty("returnUrl")
	private String returnUrl;
	
	@JsonProperty("playerLogin")
	private String playerLogin;
	
}
