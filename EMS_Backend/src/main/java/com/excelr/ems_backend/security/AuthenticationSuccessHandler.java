package com.excelr.ems_backend.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.excelr.ems_backend.dtos.LoginUserDto;
import com.excelr.ems_backend.models.Admin;
import com.excelr.ems_backend.models.EmployeeRecord;
import com.excelr.ems_backend.repositories.AdminRepository;
import com.excelr.ems_backend.repositories.EmployeeRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	 private AdminRepository adminRepository;
	 
	 private EmployeeRepository employeeRepository;

	    public AuthenticationSuccessHandler(AdminRepository adminRepository,EmployeeRepository employeeRepository) {
	        this.adminRepository = adminRepository;
	        this.employeeRepository=employeeRepository;
	    }


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		boolean isAdmin = authentication.getAuthorities().stream()
				.anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		String username = userDetails.getUsername();
		LoginUserDto loginUserDto;
		String targetUrl;
		if (isAdmin) {
			System.out.println("admin logined");
			targetUrl="/admin/dashboard";

			Optional<Admin> admin = adminRepository.findByEmailOrEmploymentCode(username);

			loginUserDto = new LoginUserDto(admin.get().getId(), admin.get().getName(),
					admin.get().getCompanyMail());

			
		} else {
			System.out.println("employee logined");
			targetUrl="/employee/dashboard";

			Optional<EmployeeRecord> employee = employeeRepository.findByEmailOrEmploymentCode(username);
			loginUserDto = new LoginUserDto(employee.get().getId(), employee.get().getPersonalDetails().getFullName(),
					employee.get().getCompanyMail());

		}
		setDefaultTargetUrl(targetUrl);
		request.getSession().setAttribute("userDetails", loginUserDto);
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
