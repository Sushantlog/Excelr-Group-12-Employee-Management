package com.excelr.ems_backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.excelr.ems_backend.repositories.AdminRepository;
import com.excelr.ems_backend.repositories.EmployeeRepository;
import com.excelr.ems_backend.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity

public class SecurityConfig {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(registry -> {
			registry.requestMatchers("/home", "/login","/sendEmail").permitAll();
			registry.requestMatchers("/css/**", "/js/**", "/images/**", "/Html/**").permitAll();
			registry.requestMatchers("/api/**").permitAll();
			registry.requestMatchers("/admin/**").hasRole("ADMIN");
			registry.requestMatchers("/employee/**").hasRole("EMPLOYEE");
			registry.anyRequest().authenticated();
		}).formLogin(formLogin -> formLogin
				.loginPage("/login.html")
				.loginProcessingUrl("/login")
				.successHandler(new AuthenticationSuccessHandler(adminRepository, employeeRepository))
				.permitAll())
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login")  // Redirect to login after successful logout
						.permitAll())
				.build();

	}

	@Bean
	public UserDetailsService userDetailsService() {
		return myUserDetailsService;
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
