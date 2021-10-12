package com.techment.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techment.config.JwtTokenUtil;
import com.techment.dao.IUserDao;
import com.techment.dto.UserDto;
import com.techment.dto.UserDtoShow;
import com.techment.entity.JwtRequest;
import com.techment.entity.JwtResponse;
import com.techment.entity.User;
import com.techment.exception.AlreadyExist;
import com.techment.exception.NotFound;
import com.techment.service.IUserService;
import com.techment.service.UserServiceImpl;

import javassist.NotFoundException;

@RestController
@RequestMapping("/userController")
public class UserController {

	@Autowired
	IUserService userService;
	@Autowired
	IUserDao dao;
	
	@Autowired
	private UserServiceImpl userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
		

		try {
			

			User Exist = dao.findByUsername(user.getUsername());
		
			
			
			
			if(Exist!=null)
				throw new AlreadyExist("User is already exist");
			else {

				String output =  userService.register(user);
				return new ResponseEntity<String>(output,HttpStatus.CREATED);
			}
			
			
		}catch(Exception e) {
			
			throw new AlreadyExist("User is already exist");
		}
		
		
		
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody UserDto user,@PathVariable int userId)
	{
		try {
			String Output = userService.updateUser(user, userId);
			return new ResponseEntity<String>(Output,HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			throw new NotFound("user not found");
		}
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId){
		
		try {
			return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
		}catch(Exception e) {
			throw new NotFound("user not found");
		}
		
	}
	
//	@GetMapping("/getUserByUsername/{username}")
//	public ResponseEntity<User> getUserByUsername(@PathVariable String username){
//		
//		try {
//			return new ResponseEntity<User>(dao.findByUsername(username),HttpStatus.OK);
//		}catch(Exception e) {
//			throw new NotFound("user not found");
//		}
//		
//		
//	}
//	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)  {

		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(authenticationRequest.getUsername());

			final String token = jwtTokenUtil.generateToken(userDetails);

			User user = dao.findByUsername(authenticationRequest.getUsername());
			
			user.setToken(token);
			
			dao.save(user);
			
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;

		
	}
	
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
	
	
	
	
	
}
