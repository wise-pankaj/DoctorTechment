package com.techment.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.techment.dao.IAdminDao;
import com.techment.dao.IUserDao;
import com.techment.dto.AdminDto;
//import com.techment.dto.UserDto;
import com.techment.entity.Admin;
import com.techment.entity.User;
import com.techment.service.IAdminService;


@Service
public class IAdminServiceImpl implements IAdminService {

	@Autowired
	IAdminDao dao;
	
	@Autowired
	IUserDao user;
	
	@Override
	public String AddAdmin(AdminDto admin) {
		if(admin.getEmail()==null||admin.getEmail()=="")
		{
			return ("Please enter your vailed email");
		}
		
		else if(admin.getName()==null||admin.getName()=="")
		{
			return  ("Please enter name");
		}
		
	   else if(admin.getPassword()==null||admin.getPassword()=="")
		{
			return ("Please enter your name");
		}
		else if(admin.getContactnumber()==null||admin.getContactnumber()=="")
		{
			return ("Please enter contactnumber");
		}
		else {
			
			Admin oldAdmin = new Admin(admin.getName(), admin.getContactnumber(), admin.getEmail(), admin.getPassword());
			if(user.findByUsername(admin.getContactnumber())==null)
			{
				user.save(new User(admin.getContactnumber(), admin.getPassword(), "SuperUser"));
			}
			
		dao.save(oldAdmin);
		return "Admin Registerd Successfully";
		}
		
        }

	@Override 
	public Admin getAdminById(int id) {
    return dao.findById(id).get();
     
	}

	@Override
	public String deleteAdminById(Integer id) {
		
     dao.deleteById(id);
     return "Admin data deleted";
     
	}

	@Override
	public List<AdminDto> getAdmins() {
		// TODO Auto-generated method stub
		
		List<Admin> admins = dao.findAll();
		List<AdminDto> adminList = new ArrayList<AdminDto>();
		for(Admin a:admins)
		{
			adminList.add(new AdminDto(a.getName(), a.getContactnumber(), a.getEmail(), a.getPassword()));
		}
		//return Arrays.asList(modelMapper.map(dao.findAll(),AdminDto.class));
		return adminList;
	}

	@Override
	public String updateAdmin(int id, AdminDto admin) {

		Admin A = dao.findById(id).get();
		
		
			A.setContactnumber(admin.getContactnumber());
			A.setPassword(admin.getPassword());
			A.setName(admin.getName());
			A.setEmail(admin.getEmail());

			dao.save(A);
			
	
	
		return "Admin updated";
	}

	@Override
	public AdminDto login(String name, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	

	}

	

