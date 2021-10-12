package com.techment.service;

import java.util.List;

import com.techment.dto.AdminDto;
import com.techment.entity.Admin;

public interface IAdminService {
	public String AddAdmin(AdminDto admin);       //Add
	public Admin getAdminById(int id);         //get/viewAll(data)
  public String updateAdmin(int id, AdminDto dto);
	public AdminDto login(String name, String password);
	public List<AdminDto> getAdmins();
	String deleteAdminById(Integer id);

}
