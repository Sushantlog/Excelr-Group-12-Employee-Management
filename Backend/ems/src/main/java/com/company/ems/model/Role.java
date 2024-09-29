package com.company.ems.model;

import jakarta.persistence.*;

@Entity
public class Role {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 
 @Column(nullable = false, unique = true)
 private String name; // e.g., ROLE_ADMIN, ROLE_EMPLOYEE

 // Getters and Setters
}
