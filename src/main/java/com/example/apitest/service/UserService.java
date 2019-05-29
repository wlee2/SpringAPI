package com.example.apitest.service;

import java.util.List;

import com.example.apitest.model.dto.UserDto;
import com.example.apitest.model.response.UserResponseModel;

public interface UserService {
	UserDto createUser(UserDto udto);

	List<UserResponseModel> getUserList();
	UserResponseModel getUser(Long id);
}
