package com.example.apitest.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apitest.model.dao.UserDao;
import com.example.apitest.model.dto.UserDto;
import com.example.apitest.model.entity.UserEntity;
import com.example.apitest.model.response.UserResponseModel;

@Service
public class UserServiceImpl implements UserService {

	public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserDto createUser(UserDto udto) {
		//TODO: hard coding for now
//		UserDto returnDto = UserDto.builder()
//				.dspId("CPA-" + LocalDate.now().getDayOfYear() + "wooseok")
//				.firstName("wooseok")
//				.lastName("lee")
//				.email("stoneage95xp@gmail.com")
//				.build();
		
		UserEntity entity = new UserEntity();
		log.info("UserService's dto : {}", udto);
		BeanUtils.copyProperties(udto, entity);
		entity.setDspId(entity.getLastName() + " - " + LocalDate.now().getDayOfYear());
		userDao.save(entity);
		BeanUtils.copyProperties(entity, udto);
		log.info("UserService's dto : {}", udto);
		return udto;
	}

	@Override
	public List<UserResponseModel> getUserList() {
		List<UserEntity> userList;
		List<UserResponseModel> returnUserList = new ArrayList<>();
		userList = (List<UserEntity>) userDao.findAll();
		for(UserEntity ue : userList) {
			UserResponseModel model = new UserResponseModel();
			BeanUtils.copyProperties(ue, model);
			returnUserList.add(model);
		}
		return returnUserList;
	}

	@Override
	public UserResponseModel getUser(Long id) {
		UserEntity user = userDao.findById(id).orElse(new UserEntity());
		UserResponseModel returnUser = new UserResponseModel();
		BeanUtils.copyProperties(user, returnUser);
		return returnUser;
	}

}
