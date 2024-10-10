package com.excelr.ems_backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.excelr.ems_backend.models.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	@Query("SELECT u FROM Admin u WHERE u.companyMail = :input OR u.employmentCode = :input")
    Optional<Admin> findByEmailOrEmploymentCode(@Param("input") String input);

    Admin findByCompanyMail(String username);
}
