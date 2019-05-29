package com.example.apitest.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.apitest.model.entity.UserEntity;
import com.example.apitest.model.response.UserResponseModel;

@Repository
public interface UserDao extends CrudRepository<UserEntity, Long>{

}
