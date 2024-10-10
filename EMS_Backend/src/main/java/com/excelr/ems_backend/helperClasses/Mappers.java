package com.excelr.ems_backend.helperClasses;

import org.springframework.stereotype.Component;

import com.excelr.ems_backend.dtos.EmployeeRecordDTO;
import com.excelr.ems_backend.dtos.PersonalDetailsDto;
import com.excelr.ems_backend.dtos.ProfessionalDetailsDto;
import com.excelr.ems_backend.dtos.ProjectDto;
import com.excelr.ems_backend.models.EmployeeRecord;
import com.excelr.ems_backend.models.PersonalDetails;
import com.excelr.ems_backend.models.ProfessionalDetails;
import com.excelr.ems_backend.models.ProjectDetails;

@Component
public class Mappers {
	
	public ProjectDetails getProjectEntity(ProjectDto projectDto) {
		ProjectDetails project = new ProjectDetails();
        project.setProjectCode(projectDto.getProjectCode());
        project.setStartDate(projectDto.getStartDate());
        project.setEndDate(projectDto.getEndDate());
        project.setClientName(projectDto.getClientName());
        project.setProjectName(projectDto.getProjectName());
        project.setReportingManagerEmployeeCode(projectDto.getReportingManagerEmployeeCode());
        project.setReportingManagerEmployeeMail(projectDto.getReportingManagerEmployeeMail());

        return project;
    }
	
	public EmployeeRecord getEmployeeRecordEntity(EmployeeRecordDTO dto) {
		EmployeeRecord employeeRecord = new EmployeeRecord();
		employeeRecord.setEmploymentCode(dto.getEmploymentCode());
		employeeRecord.setCompanyMail(dto.getCompanyMail());
		employeeRecord.setPassword(dto.getPassword());
		employeeRecord.setRole(dto.getRole());
		employeeRecord.setPersonalDetails(dto.getPersonalDetails());
		employeeRecord.setProfessionalDetails(dto.getProfessionalDetails());
		employeeRecord.setProjects(dto.getProjects());
		employeeRecord.setFinanceDetails(dto.getFinanceDetails());

		return employeeRecord;
	}
	
	public PersonalDetails getPersonalDetailsEntity(PersonalDetailsDto dto) {
		PersonalDetails details=new PersonalDetails();
		details.setFullName(dto.getFullName());
		details.setDob(dto.getDob());
		details.setGender(dto.getGender());
		details.setAge(dto.getAge());
		details.setPermanentAddress(dto.getPermanentAddress());
		details.setCurrentAddress(dto.getCurrentAddress());
		details.setMobile(dto.getMobile());
		details.setPersonalMail(dto.getPersonalMail());
		details.setEmergencyContactName(dto.getEmergencyContactName());
		details.setEmergencyContact(dto.getEmergencyContact());
		return details;
	}
	
	public ProfessionalDetails getProfessionalDetailsEntity(ProfessionalDetailsDto dto) {
		
		ProfessionalDetails details=new ProfessionalDetails();
		details.setEmploymentCode(dto.getEmploymentCode());
		details.setCompanyMail(dto.getCompanyMail());
		details.setOfficePhone(dto.getOfficePhone());
		details.setOfficeAddress(dto.getOfficeAddress());
		details.setReportManagerEmployeeCode(dto.getReportManagerEmployeeMail());
		details.setReportManagerEmployeeMail(dto.getReportManagerEmployeeMail());
		details.setEmploymentHistory(dto.getEmploymentHistory());
		details.setDateOfJoining(dto.getDateOfJoining());
		details.setHrName(dto.getHrName());
		return details;
	}
}
