
package com.company.ems.controller;

import com.company.ems.model.Employee;
import com.company.ems.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    // Display Admin Dashboard
    @GetMapping("/dashboard")
    public String adminDashboard(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "admin/dashboard";
    }

    // Add Employee Form
    @GetMapping("/employees/add")
    public String showAddEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "admin/add-employee";
    }

    // Handle Add Employee
    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee, Model model){
        // Perform validations if necessary
        employeeService.saveEmployee(employee);
        return "redirect:/admin/dashboard";
    }

    // Edit Employee Form
    @GetMapping("/employees/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "admin/edit-employee";
    }

    // Handle Edit Employee
    @PostMapping("/employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, @ModelAttribute Employee employee, Model model){
        // Ensure certain fields are not updated if admin cannot modify them
        Employee existingEmployee = employeeService.getEmployeeById(id);
        // Update fields accordingly
        employeeService.updateEmployee(existingEmployee, employee);
        return "redirect:/admin/dashboard";
    }

    // Delete Employee
    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "redirect:/admin/dashboard";
    }
}
