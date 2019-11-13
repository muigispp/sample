package com.muigs.systems.rtgapi.service;

import com.muigs.systems.rtgapi.model.user.UserModel;
import com.muigs.systems.rtgapi.request.PostmanRequest;

public interface UserService {
	
	static final String BIRTH_DAY = "10-10-1980";
	Object saveUser(UserModel usermodel);
	Object memberBalance(UserModel usermodel);
	Object transaction(PostmanRequest postmanrequest);
	Object playgame(PostmanRequest postmanrequest);
}
 