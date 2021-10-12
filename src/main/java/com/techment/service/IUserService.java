package com.techment.service;

import com.techment.dto.UserDto;
import com.techment.dto.UserDtoShow;
import com.techment.entity.User;

public interface IUserService {

	
	String register(UserDto user);
	String deleteUser(int userId);
	String updateUser(UserDto user,int userId);
	//UserDtoShow validateUser(String user);
}
