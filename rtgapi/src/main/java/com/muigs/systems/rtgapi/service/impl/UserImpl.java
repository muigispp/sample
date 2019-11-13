package com.muigs.systems.rtgapi.service.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.muigs.systems.rtgapi.model.user.UserModel;
import com.muigs.systems.rtgapi.repository.MyRepository;
import com.muigs.systems.rtgapi.request.PostmanRequest;
import com.muigs.systems.rtgapi.request.UserRequest;
import com.muigs.systems.rtgapi.response.UserResponse;
import com.muigs.systems.rtgapi.service.UserService;

@Service
public class UserImpl implements UserService {
	@Autowired
	private MyRepository myrepository;

	private static final Logger log = LoggerFactory.getLogger(UserImpl.class);
	private static final String GET_TOKEN = "/start/token?username={0}&password={1}";
	private static String apiUrl = "https://cms.rtgintegrations.com/api";
	private static String gameId = "1179887";
	private static String username = "aplusapi_prod";
	private static String password = "UP7w0KyAQ8";
	private static String agentId = "72a7c586-6407-45a9-9709-02bc2570339e";
	private static String returnUrl = "www.testurl.com";
	private static final RestTemplate restTemplate = new RestTemplate();
	// CREATE USER with GSP provider
	@Override
	public Object saveUser(UserModel usermodel) {

		String createURL = apiUrl + "/player";
		UserResponse response = null;
		UserRequest request = new UserRequest();
		request.setAgentid(agentId);
		request.setUsername(usermodel.getUsername());
		request.setFirstName(usermodel.getUsername());
		request.setLastName(usermodel.getUsername());
		request.setEmail(usermodel.getUsername() + "@gmail.com");
		request.setCurrency(usermodel.getCurrency());
		request.setCountryId(usermodel.getCountryId());
		request.setBirthdate(BIRTH_DAY);
		try {
			response = restTemplate.exchange(createURL, HttpMethod.PUT,new HttpEntity<UserRequest>(request, getHttpHeaders()), UserResponse.class).getBody();
			log.debug("RESPONSE", response);
			System.out.println(response.getId() + " aws");
		} catch (HttpClientErrorException e) {
			return e.getResponseBodyAsString();
		}
		if (response == null || response.getId().isEmpty()) {
			return "Null Data";
		}
		String id = response.getId();
		usermodel.setUsername(usermodel.getUsername());
		usermodel.setCountryId(usermodel.getCountryId());
		usermodel.setEmails(usermodel.getUsername() + "@gmail.com");
		usermodel.setCurrency(usermodel.getCurrency());
		usermodel.setPlayerid(id);
		
		return myrepository.save(usermodel);
	}
	@Override
	public Object memberBalance(UserModel usermodel) {

		String createURL = apiUrl + "/wallet";
		String response= null;
		UserRequest request = new UserRequest();
		request.setPlayerLogin(usermodel.getUsername());
		try {
			response= restTemplate.exchange(createURL,HttpMethod.POST, new HttpEntity<UserRequest>(request,getHttpHeaders()),String.class).getBody();
		} catch (HttpClientErrorException e) {
			return e.getResponseBodyAsString();
		}
		return response.toString();
	}
	@Override
	public Object transaction(PostmanRequest postmanrequest) {
		String response = null;
		UserRequest request = new UserRequest();
		request.setPlayerLogin(postmanrequest.getUsername());
		request.setAmount(postmanrequest.getAmount());
		BigDecimal amount = postmanrequest.getAmount();
		String method = postmanrequest.getMethod();
		String url = apiUrl + "/wallet/{0}/{1}";
		String finalUrl = MessageFormat.format(url, method,amount);
		System.out.println(finalUrl);
		try {
			response = restTemplate.exchange(finalUrl, HttpMethod.POST,new HttpEntity<UserRequest>(request, getHttpHeaders()), String.class).getBody();
			
		} catch (HttpClientErrorException e) {
			return e.getResponseBodyAsString();
		}
		
		return response;
	}
	
	@Override
	public Object playgame(PostmanRequest postmanrequest) {
		
		String createURL = apiUrl + "/GameLauncher";
		UserResponse response = null;
		UserRequest playerRequest = new UserRequest();
		playerRequest.setGameId(gameId);
		playerRequest.setLocale("en-US");
		playerRequest.setIsDemo(false);
		playerRequest.setReturnUrl(returnUrl);
		System.out.println(playerRequest.getPlayer());
		try {
			response = restTemplate.exchange(createURL, HttpMethod.POST,new HttpEntity<UserRequest>(playerRequest, getHttpHeaders()), UserResponse.class).getBody();
			System.out.println(response);
			System.out.println("nice");
		} catch (HttpClientErrorException e) {
//			System.out.println(createURL);
			return "CATCH" + e.getResponseBodyAsString();
		}catch(HttpMessageNotReadableException e) {
			return e.getMessage();
		}
		return response;
	}
	
	
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", getToken());
		return headers;
	}

	public String getToken() {
		String url = MessageFormat.format(apiUrl + GET_TOKEN, username, password);
		UserResponse response = new UserResponse();
		try {
			response = restTemplate.getForObject(url, UserResponse.class);
			log.debug("Response" + response.getToken());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.getToken();
	}

	public String getStart() {
		String url = apiUrl + "/start";
		UserResponse response = new UserResponse();
		HttpHeaders httpHeaders = getHttpHeaders();
		try {
			response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<UserRequest>(null, httpHeaders), UserResponse.class).getBody();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.getAgentId();

	}

}
