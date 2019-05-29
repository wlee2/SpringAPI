package com.example.apitest.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseModel {
	private String dspId;
	private String firstName;
	private String lastName;
	private String email;
}
