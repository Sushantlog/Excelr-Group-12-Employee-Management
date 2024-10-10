package com.excelr.ems_backend.dtos;

import java.util.List;

import com.excelr.ems_backend.models.FinanceDetails;
import com.excelr.ems_backend.models.PersonalDetails;
import com.excelr.ems_backend.models.ProfessionalDetails;
import com.excelr.ems_backend.models.ProjectDetails;
import com.excelr.ems_backend.validators.NotNullOrBlank;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeRecordDTO {
	
	@Pattern(regexp = "\\d{6}", message = "employement code must be 6 digit number.")
    private String employmentCode;
    
    @Email(message = "Invalid Company email.")
    private String companyMail;
    
    @Size(min=8,max = 32,message = "password must be min 8 max 32 characters")
    private String password;
    
    @NotNullOrBlank(message = "The role is required")
    private String role;
    
    @Valid
    private PersonalDetails personalDetails;
    
    @Valid
    private ProfessionalDetails professionalDetails;
    
    private List<ProjectDetails> projects;
    
    @Valid
    private FinanceDetails financeDetails;

    // Default constructor
    public EmployeeRecordDTO() {
    }

    // Constructor to initialize fields
    public EmployeeRecordDTO(String employmentCode, String companyMail, String password, String role,
                             PersonalDetails personalDetails, ProfessionalDetails professionalDetails,
                             List<ProjectDetails> projects, FinanceDetails financeDetails) {
        this.employmentCode = employmentCode;
        this.companyMail = companyMail;
        this.password = password;
        this.role = role;
        this.personalDetails = personalDetails;
        this.professionalDetails = professionalDetails;
        this.projects = projects;
        this.financeDetails = financeDetails;
    }

    // Getters and Setters
    public String getEmploymentCode() {
        return employmentCode;
    }

    public void setEmploymentCode(String employmentCode) {
        this.employmentCode = employmentCode;
    }

    public String getCompanyMail() {
        return companyMail;
    }

    public void setCompanyMail(String companyMail) {
        this.companyMail = companyMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }

    public ProfessionalDetails getProfessionalDetails() {
        return professionalDetails;
    }

    public void setProfessionalDetails(ProfessionalDetails professionalDetails) {
        this.professionalDetails = professionalDetails;
    }

    public List<ProjectDetails> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDetails> projects) {
        this.projects = projects;
    }

    public FinanceDetails getFinanceDetails() {
        return financeDetails;
    }

    public void setFinanceDetails(FinanceDetails financeDetails) {
        this.financeDetails = financeDetails;
    }

    @Override
    public String toString() {
        return "EmployeeRecordDTO{" +
                "employmentCode='" + employmentCode + '\'' +
                ", companyMail='" + companyMail + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", personalDetails=" + personalDetails +
                ", professionalDetails=" + professionalDetails +
                ", projects=" + projects +
                ", financeDetails=" + financeDetails +
                '}';
    }
}
