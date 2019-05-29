package com.example.apitest.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestModel {
	private String firstName;
	private String lastName;
	private String password;
	private String email;
}
