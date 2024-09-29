
package com.company.ems.controller;

import com.company.ems.model.Role;
import com.company.ems.model.User;
import com.company.ems.service.RoleService;
import com.company.ems.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model){
        if(userService.findByEmail(user.getEmail()).isPresent()){
            model.addAttribute("error", "User already exists with this email.");
            return "register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        // Assign ROLE_EMPLOYEE by default
        Role role = roleService.findByName("ROLE_EMPLOYEE");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(){
        // Redirect based on role
        return "redirect:/dashboard";
    }
}
