// src/main/java/com/company/ems/controller/EmployeeController.java
package com.company.ems.controller;

import com.company.ems.model.Employee;
import com.company.ems.service.EmployeeService;
import com.company.ems.service.PayslipService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PayslipService payslipService;

    // Existing dashboard method

    @GetMapping("/payslips")
    public ResponseEntity<InputStreamResource> downloadPayslip(Authentication authentication){
        String email = authentication.getName();
        Employee employee = employeeService.getEmployeeByEmail(email);
        
        ByteArrayInputStream bis = payslipService.generatePayslip(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=payslip.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}
