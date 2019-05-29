package com.example.apitest.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "Users")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1950301180335183961L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String dspId;

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String password;
	
	@Column
	private String encryptedPassword;
	
	@Column
	private String email;
	
	private String emailToken;
	
	@Column
	private Boolean emailTokenStatus = false;
}
