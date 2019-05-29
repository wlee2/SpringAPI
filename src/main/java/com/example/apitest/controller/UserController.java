package com.example.apitest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apitest.model.dto.UserDto;
import com.example.apitest.model.request.UserRequestModel;
import com.example.apitest.model.response.UserResponseModel;
import com.example.apitest.service.UserService;

//@CrossOrigin(origins="http://localhost:...") //cors setting
@RestController
@RequestMapping("users")
public class UserController {

	public static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping
	List<UserResponseModel> getUserList() {
		List<UserResponseModel> userList = userService.getUserList();
		return userList;
	}

	@GetMapping("{id}")
	UserResponseModel getUser(@PathVariable Long id) {

		UserResponseModel user = userService.getUser(id);
		return user;
	}
	
	@GetMapping("param")
	UserResponseModel getUserParam(Long id) {
		UserResponseModel user = userService.getUser(id);
		return user;
	}

	@PostMapping
	UserResponseModel postUserList(UserRequestModel uReqM) {
		// if request is Json type, it has to add @RequestBody front of the
		// userquestmodel.
		log.info("UserController's request : {}", uReqM);

		UserResponseModel uResM = new UserResponseModel();
		UserDto ud = new UserDto();
		BeanUtils.copyProperties(uReqM, ud);
		log.info("UserController's dto : {}", ud);

		ud = this.userService.createUser(ud);
		BeanUtils.copyProperties(ud, uResM);
		return uResM;
	}

	@PutMapping
	String putUser() {
		return "not implemented put req";
	}

	@DeleteMapping
	String deleteUser() {
		return "not implemented delete req";
	}

}
