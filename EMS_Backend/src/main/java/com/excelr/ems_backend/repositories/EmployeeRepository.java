package com.excelr.ems_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.excelr.ems_backend.models.EmployeeRecord;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeRecord, Long> {
	
	@Query("SELECT u FROM EmployeeRecord u WHERE u.companyMail = :input OR u.employmentCode = :input")
    Optional<EmployeeRecord> findByEmailOrEmploymentCode(@Param("input") String input);
}
