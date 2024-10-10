package com.excelr.ems_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.excelr.ems_backend.dtos.AdminDto;
import com.excelr.ems_backend.dtos.EmployeeRecordDTO;
import com.excelr.ems_backend.dtos.PersonalDetailsDto;
import com.excelr.ems_backend.dtos.ProfessionalDetailsDto;
import com.excelr.ems_backend.dtos.ProjectDto;
import com.excelr.ems_backend.exceptionhandling.EmployeeNotFoundException;
import com.excelr.ems_backend.helperClasses.CurrentAddress;
import com.excelr.ems_backend.helperClasses.Mappers;
import com.excelr.ems_backend.helperClasses.PermanentAddress;
import com.excelr.ems_backend.models.Admin;
import com.excelr.ems_backend.models.EmployeeRecord;
import com.excelr.ems_backend.models.PersonalDetails;
import com.excelr.ems_backend.models.ProfessionalDetails;
import com.excelr.ems_backend.models.ProjectDetails;
import com.excelr.ems_backend.repositories.AdminRepository;
import com.excelr.ems_backend.repositories.EmployeeRepository;

import jakarta.mail.MessagingException;

@Service
public class AdminServiceImplementation implements AdminService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private Mappers mappers;

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private EmailService emailService;
	
	@Override
	public Admin createAdmin(AdminDto adminDto) {
		Admin admin = new Admin();
		admin.setName(adminDto.getName());
		admin.setCompanyMail(adminDto.getCompanyMail());
		admin.setEmploymentCode(adminDto.getEmploymentCode());
		admin.setPassword(passwordEncoder.encode(adminDto.getPassword()));
		return adminRepository.save(admin);
	}

	@Override
	public String createEmployee(EmployeeRecordDTO employeeRecordDTO) {

	    EmployeeRecord employeeRecord = mappers.getEmployeeRecordEntity(employeeRecordDTO);
	    
	    String hashedPassword = passwordEncoder.encode(employeeRecord.getPassword());
	    employeeRecord.setPassword(hashedPassword);

	    if (employeeRecord.getProjects() != null && !employeeRecord.getProjects().isEmpty()) {
	        for (ProjectDetails project : employeeRecord.getProjects()) {
	            project.setEmployee(employeeRecord);
	        }
	    }

	    employeeRepository.save(employeeRecord);
	    
	   
	    try {
			emailService.sendProfileCreationEmail(employeeRecord.getPersonalDetails().getPersonalMail(),
					employeeRecord.getPersonalDetails().getFullName(),
					employeeRecord.getEmploymentCode(),employeeRecord.getProfessionalDetails().getCompanyMail(),
					employeeRecordDTO.getPassword(), employeeRecord.getProfessionalDetails().getOfficePhone());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	    
	    return "New Employee created";
	}


	@Override
	public String deleteEmployee(Long id) {
		EmployeeRecord existRecord = findEmployeeById(id);
		employeeRepository.delete(existRecord);
		return "Employee with this id: " + id + " deleted";
	}

	@Override
	public List<EmployeeRecord> getAllEmployees() {
		List<EmployeeRecord> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public EmployeeRecord findEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with this Id: " + id));
	}

	@Override
	public String updateProjects(Long id, List<ProjectDto> projectDtos) {
		EmployeeRecord employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

		// Loop through the incoming projectDtos
		for (ProjectDto projectDto : projectDtos) {
			boolean projectExists = false;

			// Check if a project with the same projectCode already exists in the employee's
			// projects
			for (ProjectDetails existingProject : employee.getProjects()) {
				if (existingProject.getProjectCode() == projectDto.getProjectCode()) {
					// If the project exists, update its details
					ProjectDetails updatedProject = mappers.getProjectEntity(projectDto); // Convert DTO to entity
					updatedProject.setEmployee(employee); // Set the employee reference
					existingProject.setStartDate(updatedProject.getStartDate());
					existingProject.setEndDate(updatedProject.getEndDate());
					existingProject.setClientName(updatedProject.getClientName());
					existingProject.setProjectName(updatedProject.getProjectName());
					existingProject.setReportingManagerEmployeeCode(updatedProject.getReportingManagerEmployeeCode());
					existingProject.setReportingManagerEmployeeMail(updatedProject.getReportingManagerEmployeeMail());
					projectExists = true;
					break; // Exit loop after finding and updating the project
				}
			}

			// If the project doesn't exist, add it as a new project
			if (!projectExists) {
				ProjectDetails newProject = mappers.getProjectEntity(projectDto); // Convert DTO to entity
				newProject.setEmployee(employee); // Set the employee reference
				employee.getProjects().add(newProject); // Add new project to employee
			}
		}

		employeeRepository.save(employee); // Save updated employee with new or updated projects
		return "Projects updated for employee ID: " + id + " successfully!";
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public String updatePersonalDetails(Long id, PersonalDetailsDto personalDetailsDto) {
		System.out.println("personal details updated");
		EmployeeRecord employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

		PersonalDetails personalDetails = employee.getPersonalDetails();

		if (personalDetailsDto.getFullName() != null) {
			personalDetails.setFullName(personalDetailsDto.getFullName());
		}

		if (personalDetailsDto.getDob() != null) {
			personalDetails.setDob(personalDetailsDto.getDob());
			// You can also recalculate age based on dob, if necessary
		}

		if (personalDetailsDto.getGender() != null) {
			personalDetails.setGender(personalDetailsDto.getGender());
		}

		if (personalDetailsDto.getAge() > 0) {
			personalDetails.setAge(personalDetailsDto.getAge());
		}

		if (personalDetailsDto.getPermanentAddress() != null) {
			PermanentAddress permanentAddress = personalDetailsDto.getPermanentAddress();
			if (permanentAddress.getPerm_city() != null) {
				personalDetails.getPermanentAddress().setPerm_city(permanentAddress.getPerm_city());
			}
			if (permanentAddress.getPerm_line1() != null) {
				personalDetails.getPermanentAddress().setPerm_line1(permanentAddress.getPerm_line1());
			}
			if (permanentAddress.getPerm_line2() != null) {
				personalDetails.getPermanentAddress().setPerm_line2(permanentAddress.getPerm_line2());
			}
			if (permanentAddress.getPerm_pincode() > 0) {
				personalDetails.getPermanentAddress().setPerm_pincode(permanentAddress.getPerm_pincode());
			}

		}

		if (personalDetailsDto.getCurrentAddress() != null) {
			CurrentAddress currentAddress = personalDetailsDto.getCurrentAddress();
			if (currentAddress.getCurr_city() != null) {
				personalDetails.getCurrentAddress().setCurr_city(currentAddress.getCurr_city());
			}
			if (currentAddress.getCurr_line1() != null) {
				personalDetails.getCurrentAddress().setCurr_line1(currentAddress.getCurr_line1());
			}
			if (currentAddress.getCurr_line2() != null) {
				personalDetails.getCurrentAddress().setCurr_line2(currentAddress.getCurr_line2());
			}
			if (currentAddress.getCurr_pincode() > 0) {
				personalDetails.getCurrentAddress().setCurr_pincode(currentAddress.getCurr_pincode());
			}
		}

		if (personalDetailsDto.getMobile() != null) {
			personalDetails.setMobile(personalDetailsDto.getMobile());
		}

		if (personalDetailsDto.getPersonalMail() != null) {
			personalDetails.setPersonalMail(personalDetailsDto.getPersonalMail());
		}

		if (personalDetailsDto.getEmergencyContactName() != null) {
			personalDetails.setEmergencyContactName(personalDetailsDto.getEmergencyContactName());
		}

		if (personalDetailsDto.getEmergencyContact() != null) {
			personalDetails.setEmergencyContact(personalDetailsDto.getEmergencyContact());
		}

		employee.setPersonalDetails(personalDetails);
		employeeRepository.save(employee);

		return "Personal details updated successfully for Employee ID: " + id;
	}

	@Override
	public String updateProfessionalDetails(Long id, ProfessionalDetailsDto professionalDetailsDto) {
		// Find the employee's professional details by ID
		EmployeeRecord employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

		// Check and update each field if provided in DTO
		ProfessionalDetails professionalDetails = employee.getProfessionalDetails();
		if (professionalDetailsDto.getEmploymentCode() != null) {
			professionalDetails.setEmploymentCode(professionalDetailsDto.getEmploymentCode());
		}

		if (professionalDetailsDto.getCompanyMail() != null) {
			professionalDetails.setCompanyMail(professionalDetailsDto.getCompanyMail());
		}

		if (professionalDetailsDto.getOfficePhone() != null) {
			professionalDetails.setOfficePhone(professionalDetailsDto.getOfficePhone());
		}

		// Update officeAddress if provided
		if (professionalDetailsDto.getOfficeAddress() != null) {
			CurrentAddress officeAddress = professionalDetails.getOfficeAddress();
			if (professionalDetailsDto.getOfficeAddress().getCurr_city() != null) {
				officeAddress.setCurr_city(professionalDetailsDto.getOfficeAddress().getCurr_city());
			}
			if (professionalDetailsDto.getOfficeAddress().getCurr_line1() != null) {
				officeAddress.setCurr_line1(professionalDetailsDto.getOfficeAddress().getCurr_line1());
			}
			if (professionalDetailsDto.getOfficeAddress().getCurr_line2() != null) {
				officeAddress.setCurr_line2(professionalDetailsDto.getOfficeAddress().getCurr_line2());
			}
			if (professionalDetailsDto.getOfficeAddress().getCurr_pincode() > 0) {
				officeAddress.setCurr_pincode(professionalDetailsDto.getOfficeAddress().getCurr_pincode());
			}
		}

		if (professionalDetailsDto.getReportManagerEmployeeCode() != null) {
			professionalDetails.setReportManagerEmployeeCode(professionalDetailsDto.getReportManagerEmployeeCode());
		}

		if (professionalDetailsDto.getReportManagerEmployeeMail() != null) {
			professionalDetails.setReportManagerEmployeeMail(professionalDetailsDto.getReportManagerEmployeeMail());
		}

		// Update employmentHistory if provided
		if (professionalDetailsDto.getEmploymentHistory() != null
				&& !professionalDetailsDto.getEmploymentHistory().isEmpty()) {
			professionalDetails.getEmploymentHistory().clear(); // Clear existing history
			professionalDetails.getEmploymentHistory().addAll(professionalDetailsDto.getEmploymentHistory());
		}

		if (professionalDetailsDto.getDateOfJoining() != null) {
			professionalDetails.setDateOfJoining(professionalDetailsDto.getDateOfJoining());
		}

		if (professionalDetailsDto.getHrName() != null) {
			professionalDetails.setHrName(professionalDetailsDto.getHrName());
		}

		employee.setProfessionalDetails(professionalDetails);
		// Save the updated professional details
		employeeRepository.save(employee);

		return "Professional details updated for ID: " + id;
	}

    public boolean authenticateAdmin(String username, String password) {
        // TODO Auto-generated method stub
		Admin admin = adminRepository.findByCompanyMail(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return true; // Authentication successful
        }
        return false;
       
    }
	
}
