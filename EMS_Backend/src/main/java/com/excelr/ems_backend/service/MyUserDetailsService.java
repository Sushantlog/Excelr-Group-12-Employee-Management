package com.excelr.ems_backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.excelr.ems_backend.models.Admin;
import com.excelr.ems_backend.models.EmployeeRecord;
import com.excelr.ems_backend.repositories.AdminRepository;
import com.excelr.ems_backend.repositories.EmployeeRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<EmployeeRecord> employee= employeeRepository.findByEmailOrEmploymentCode(username);
		Optional<Admin> admin=adminRepository.findByEmailOrEmploymentCode(username);
		if(admin.isPresent()) {
			System.out.println(admin.toString());
			var adminObj=admin.get();
			return User.builder()
	    			.username(adminObj.getCompanyMail())
	    			.password(adminObj.getPassword())//Prasad
	    			.roles(adminObj.getRole().toUpperCase())
	    			.build();
		}
		else if(employee.isPresent()) {
			System.out.println(employee.toString());
			var employeeObj=employee.get();
			return User.builder()
	    			.username(employeeObj.getCompanyMail())
	    			.password(employeeObj.getPassword())//Prasad
	    			.roles(employeeObj.getRole().toUpperCase())
	    			.build();
		}
		else{
			throw new UsernameNotFoundException("Invalid credentials");
		}
	}

}
