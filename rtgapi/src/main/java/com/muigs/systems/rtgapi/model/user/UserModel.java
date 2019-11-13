package com.muigs.systems.rtgapi.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "usermodel_tb")
public class UserModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "emails")
	private String emails;
	
	@Column(name = "currency")
	private String currency;
	
	@Column(name ="countryId")
	private String countryId;
	
	@Column(name ="playerId")
	private String playerid;
	
}
