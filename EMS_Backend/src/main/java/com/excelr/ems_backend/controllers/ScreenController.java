package com.excelr.ems_backend.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.HttpSession;


@Controller
public class ScreenController {
	
	//admin page handlers
	
	@GetMapping("/admin/dashboard")
	public String adminDashboard() {
		return "forward:/Html/AdminPages/adminDashboard.html";
	}
	
	@GetMapping("/admin/update")
	public String adminUpdate() {
		return "forward:/Html/AdminPages/adminUpdateEmployee.html";
	}
	
	@GetMapping("/admin/create")
	public String adminCreateEmployee() {
		return "forward:/Html/AdminPages/adminAddEmployee.html";
	}
	
	@GetMapping("/admin/view")
	public String adminViewEmployee() {
		return "forward:/Html/AdminPages/adminViewEmployee.html";
	}

	
	
	// employee page handlers
	
	@GetMapping("/employee/dashboard")
	public String employeeDashboard() {
		return "forward:/Html/EmployeePages/employeeDashboard.html";
	}
	
	@GetMapping("/employee/professional")
	public String employeeProfessional() {
		return "forward:/Html/EmployeePages/employeeProfessional.html";
	}
	
	@GetMapping("/employee/finance")
	public String employeeFinance() {
		return "forward:/Html/EmployeePages/employeeFinance.html";
	}
	
	@GetMapping("/employee/projects")
	public String employeeProjects() {
		return "forward:/Html/EmployeePages/employeeProjects.html";
	}
	
	@GetMapping("/login")
	public String customeLogin() {
		return "forward:/login.html";
	}
	
    @GetMapping("/admin/view_employee/{id}")
public String viewEmployee(@PathVariable Long id) {
    // Load the employee details using the ID and pass it to the frontend (you can use ModelAndView or ModelMap if needed)
    return "forward:/Html/AdminPages/adminViewEmployee.html";
}

	
//	sending login info to frontend
	@GetMapping("/details")
    public ResponseEntity<?> getUserDetails(HttpSession session) {
        // Fetch the user details from the session
        Object userDetails = session.getAttribute("userDetails");

        if (userDetails == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No user details found in session.");
        }
        return ResponseEntity.ok(userDetails);
    }
}
