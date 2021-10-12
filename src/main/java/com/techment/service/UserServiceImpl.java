package com.techment.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techment.dao.IUserDao;
import com.techment.dto.UserDto;
import com.techment.dto.UserDtoShow;
import com.techment.entity.User;
import com.techment.service.IUserService;
import com.techment.util.SiteUtil;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

	@Autowired
	IUserDao userdao;

	@Autowired
	SiteUtil siteutil;
	
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public String register(UserDto user) {
	
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		User user1 = new User(user.getUsername(),bcryptEncoder.encode(user.getPassword()), user.getRole());
		userdao.save(user1);
		return "User sucessfully Added";

	}



	@Override
	public String deleteUser(int userId) {
		userdao.deleteById(userId);

		return "User deleted";
	}

	@Override
	public String updateUser(UserDto user,int userId) {

		User oldUser = userdao.findById(userId).get();

		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		oldUser.setRole(user.getRole());

		userdao.save(oldUser);




		return "Updated";
	}

//	@Override
//	public UserDtoShow validateUser(String user) {       
//		User tokenUpdateuser =  userdao.findByUsername(user);
//		if(tokenUpdateuser!= null)
//		{
//			String token = siteutil.generateToken();  	
//			tokenUpdateuser.setToken(token);  	
//			userdao.save(tokenUpdateuser);
//		}
//
//
//
//		UserDtoShow dto = new UserDtoShow(tokenUpdateuser.getUsername(), tokenUpdateuser.getToken());
//		return dto;
//	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

  User user =  userdao.findByUsername(username);
  if (user == null) {
		throw new UsernameNotFoundException("User not found with username: " + username);
	}
	return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
			new ArrayList<>());
	}

//
//		if ("javainuse".equals(username)) {
//			return (UserDetails) new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					"admin");
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}

}
