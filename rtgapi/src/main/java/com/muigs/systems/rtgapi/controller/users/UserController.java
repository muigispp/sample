package com.muigs.systems.rtgapi.controller.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muigs.systems.rtgapi.model.user.UserModel;
import com.muigs.systems.rtgapi.request.PostmanRequest;
import com.muigs.systems.rtgapi.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	//Create new Data
	@PostMapping("/create")
	public Object saveUser(@RequestBody UserModel usermodel) {
		return userservice.saveUser(usermodel);
	}
	
	@PostMapping("/balance")
	public Object memberBalance(@RequestBody UserModel usermodel) {
		return userservice.memberBalance(usermodel);
	}
	@PostMapping("/transaction")
	public Object transaction(@RequestBody PostmanRequest postmanrequest) {
		return userservice.transaction(postmanrequest);
	}
	@PostMapping("/playgame")
	public Object playgame(@RequestBody PostmanRequest postmanrequest) {
		return userservice.playgame(postmanrequest);
	}
	
	
}
