package com.techment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.dto.UserDto;
import com.techment.entity.User;

public interface IUserDao extends JpaRepository<User, Integer>{

	User findByUsername(String username);


}
