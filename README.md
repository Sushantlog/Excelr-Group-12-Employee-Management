# Employee Management System

## Overview

The **Employee Management System (EMS)** is a comprehensive web-based application designed to streamline the management of employee records within an organization. It provides two main user roles: **Admin** and **Employee**, each with distinct permissions and functionalities.

- **Admins** have complete control over managing employee data, including adding new employees, editing details, and removing records.
- **Employees** can log in to view their personal information, including project assignments, financial records, and previous employment history.

EMS offers essential features such as customizable employee records, financial management, and robust validation for critical fields like email, phone numbers, and address formats.

## Key Features

### 1. Role-based Login

EMS utilizes a secure role-based login system. Users authenticate using their company-provided email or employment code and password. Based on the user's role (**Admin** or **Employee**), the application navigates them to the appropriate dashboard.

- **Admins** have access to a full suite of features.
- **Employees** have limited, view-only permissions.

### 2. Admin Dashboard

The Admin dashboard serves as a central hub for managing all employee records. Admins can:

- **Create New Employees**: Add new employees by entering personal, professional, project, and financial details. All fields undergo validation to ensure correct data input.
- **Edit Employee Records**: Update employee details except for key fields like Employment Code, Date of Birth, and Company Email, which are immutable after creation.
- **Delete Employees**: Remove employee records to ensure obsolete or inactive employees are no longer in the system.
- **View Employee List**: Access a comprehensive list of employees, including Employment Code, Employee Name, Company Email, Manager Name, Current Project, and action buttons for viewing, editing, or deleting records.

### 3. Employee Dashboard

Designed for individual employees, the Employee dashboard allows employees to view their own details:

- **Personal Information**: Full name, address, contact information, and emergency contact.
- **Professional Details**: Employment code, office phone number, office address, and details of their reporting manager.
- **Project History**: Current and previous project assignments, including project code, start/end dates, client/project name, and reporting manager.
- **Financial Information**: PAN, Aadhar, bank account details (Bank Name, Branch, and IFSC code), and salary details, with an option to download the last six months' payslips in PDF format.

### 4. Project Management

Admins can associate employees with various projects. Each project entry includes:

- **Project Code**
- **Start/End Dates**
- **Client/Project Name**
- **Reporting Manager Details**

This feature helps track employee project assignments over time.

### 5. Data Validation

EMS incorporates several data validation rules to ensure data integrity:

- **Employment Codes**: 6-digit numbers.
- **Emails**: Proper format for personal and company emails.
- **Age**: Maximum of 3 digits, positive numbers only.
- **Phone Numbers**: 8 to 12 digits for office numbers, 10 digits for personal numbers.
- **Addresses**: Validated for address lines and 6-digit pincode formats.

### 6. Finance Management

The finance section includes personal financial data like PAN, Aadhar, and bank details. Employees can access their salary breakdown and download payslips. **Admins do not have access to download employee payslips**.

## Technologies Used

- **Frontend**: HTML, CSS, JavaScript, Thymeleaf
- **Backend**: Java, Spring Boot, Spring Security, Spring Data JPA
- **Database**: MySQL
- **Build Tool**: Maven

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven**
- **MySQL** database
- **IDE**: IntelliJ IDEA, Eclipse, or any preferred IDE

### Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/Sushantlog/Excelr-Group-12-Employee-Management.git
   cd ems-backend

2. **Set up Development Environment:**

   Ensure you have Java 17 and Maven installed on your machine. If not, download and install them from the official websites.

3. **Run the Application:**

   mvn spring-boot:run
   The application will be accessible at http://localhost:8080.
