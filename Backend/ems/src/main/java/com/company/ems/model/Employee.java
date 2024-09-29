
package com.company.ems.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 6)
    @Pattern(regexp = "\\d{6}", message = "Employment Code must be a 6-digit number")
    private String employmentCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_details_id", referencedColumnName = "id")
    private PersonalDetails personalDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_details_id", referencedColumnName = "id")
    private ProfessionalDetails professionalDetails;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "finance_id", referencedColumnName = "id")
    private Finance finance;

    // Getters and Setters
}
