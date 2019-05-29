package com.example.apitest.model.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2800854886585880124L;
	
	private Long id;
	private String dspId;
	private String firstName;
	private String lastName;
	private String password;
	private String encryptedPassword;
	private String email;
	private String emailToken;
	private Boolean emailTokenStatus = false;
}
