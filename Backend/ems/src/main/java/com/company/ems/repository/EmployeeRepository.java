
package com.company.ems.repository;

import com.company.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByProfessionalDetails_CompanyMail(String email);
}
