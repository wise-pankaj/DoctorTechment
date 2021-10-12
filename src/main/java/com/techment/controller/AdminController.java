package com.techment.controller;


import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.techment.dto.AdminDto;
import com.techment.entity.Admin;
import com.techment.exception.AdminNotFoundException;
import com.techment.service.IAdminService;

@RestController
@RequestMapping(value = "Admin")
public class AdminController {

	@Autowired
	IAdminService adminService;

	// For Add/Insert admin data..
	@PostMapping(name = "addAdmin")
	public ResponseEntity<String> registerAdmin(@RequestBody AdminDto admin) {

		adminService.AddAdmin(admin);
		return new ResponseEntity<String>("Admin Registered Successfully", HttpStatus.ACCEPTED);

	}

	// For ViewingAll AdminList By Specific Id
	@GetMapping(value = "/ViewadminById/{id}")
	public Admin getAdminById(@PathVariable int id) {
		
		Admin A = adminService.getAdminById(id);
		return A;
	
		
	}

	// For DeleteAdmin details By Id
	@DeleteMapping("/DeleteAdminById/{id}")
	public String deleteAdminId(@PathVariable int id) {
		try {
	     adminService.deleteAdminById(id);
	    return "Admin id Deleted";
	    }catch (Exception e) {
			return "this id not present ";
		}
		
	}

	// For Updating Use PUT method in the postman otherwise it will pop up the error
	@PutMapping("/AdminUpdateById/{id}")
	public String updateAdmin(@PathVariable int id, @RequestBody AdminDto admin) 
	{

		try {
			return adminService.updateAdmin(id, admin);
		} 
		catch (Exception e) {
	
			throw new AdminNotFoundException("admin not found");
		}

   }
}


