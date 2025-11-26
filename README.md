# Employee Management System

A backend-driven **Spring MVC application** to manage employees with CRUD operations, soft deletion, search functionality, and server-side validation.

---

## 🚀 Features

- Add, Update, and **Soft Delete** Employees  
- View All Employees  
- **Search Employee by ID**  
- Server-side Validation using Spring Validator + JSR-303  
- **Custom Error Pages**: 404, 500, and default error  
- Clean MVC Architecture (Controller → Service → Repository)  
- Department mapping using **Many-to-One** relationship  

---

## 🛠 Tech Stack

**Backend:** Java, Spring Boot MVC, Spring Data JPA, Hibernate  
**Frontend:** JSP, JSTL  
**Database:** MySQL  
**Tools:** Maven, Git, Eclipse IDE / STS  

---
## 📂 Project Structure
controller/ → Request handling
service/ → Business logic
repository/ → JPA Repositories
entity/ → Employee, Department
vo/ → EmployeeVO (validation object)
views/ → JSP pages
errors/ → Custom error pages (404.jsp, 500.jsp, error.jsp)


---

## ⚙️ Setup & Run

1️⃣ Create MySQL Database

   CREATE DATABASE ems_db;

2️⃣ Update application.properties

Add your MySQL username, password, and DB name.

3️⃣ Run the Application

Run the Spring Boot application from your IDE (Eclipse/STS).

4️⃣ Open in Browser
http://localhost:8080/

⭐ Summary

This project demonstrates strong backend development skills including MVC design, validation, database mapping, and clean code architecture.


