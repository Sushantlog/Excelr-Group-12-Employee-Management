package com.excelr.ems_backend.service;

import java.util.List;

import com.excelr.ems_backend.dtos.AdminDto;
import com.excelr.ems_backend.dtos.EmployeeRecordDTO;
import com.excelr.ems_backend.dtos.PersonalDetailsDto;
import com.excelr.ems_backend.dtos.ProfessionalDetailsDto;
import com.excelr.ems_backend.dtos.ProjectDto;
import com.excelr.ems_backend.models.Admin;
import com.excelr.ems_backend.models.EmployeeRecord;

public interface AdminService {

	public Admin createAdmin(AdminDto adminDto);

	public List<Admin> getAllAdmins();

	public String createEmployee(EmployeeRecordDTO employeeRecordDTO);

	public String deleteEmployee(Long id);

	public String updatePersonalDetails(Long id,PersonalDetailsDto personalDetailsDto);
	
	public String updateProfessionalDetails(Long id,ProfessionalDetailsDto professionalDetailsDto);

	public String updateProjects(Long id,List<ProjectDto> projectDto);

	public List<EmployeeRecord> getAllEmployees();

	public EmployeeRecord findEmployeeById(Long id);

	
}
