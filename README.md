Smart Contact Manager
A full-stack web application for efficient contact management, developed with Spring Boot, Thymeleaf, Tailwind CSS, and MySQL.

Features
CRUD Operations: Create, read, update, and delete contacts.

Categorization: Organize contacts into custom categories (e.g., Family, Work).

Integrated Email: Send emails directly from the application via configured SMTP.

Authentication & Authorization: Secure user login with role-based access control implemented using Spring Security.

Responsive UI: Frontend styled with Tailwind CSS and rendered with Thymeleaf templates.

Technology Stack
Backend: Spring Boot 3.x

Frontend: Thymeleaf, Tailwind CSS

Database: MySQL (relational database)

Security: Spring Security for authentication and role management

Build Tool: Maven

Architecture Overview
MVC architecture with separation of concerns between Controllers, Services, and Repositories.

Data persistence via Spring Data JPA.

Thymeleaf templates rendered server-side for dynamic HTML generation.

Tailwind CSS used for utility-first styling to ensure responsiveness and consistency.

Secure routes guarded via Spring Security filters based on user roles.

Setup Instructions
Prerequisites
JDK 17 or later

Maven 3.x

MySQL Server

Configuration
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/smart-contact-manager.git
cd smart-contact-manager
Create a MySQL database, e.g., smart_contact_manager.

Update the database connection in src/main/resources/application.properties:

properties
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/smart_contact_manager
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
Configure SMTP properties in the same file for email functionality.

Build & Run
Using Maven:

bash
Copy
Edit
mvn clean install
mvn spring-boot:run
Or run from your IDE by running the main Spring Boot application class.

Access
Open a browser and go to:
http://localhost:8080

Register a new user or login with pre-seeded credentials.

Project Structure
bash
Copy
Edit
src/
 ├── main/
 │    ├── java/com/yourorg/smartcontactmanager/
 │    │    ├── controller/        # MVC Controllers
 │    │    ├── model/             # JPA Entity models
 │    │    ├── repository/        # Spring Data JPA Repositories
 │    │    ├── service/           # Business logic
 │    │    └── security/          # Spring Security configurations
 │    └── resources/
 │         ├── templates/         # Thymeleaf HTML templates
 │         ├── static/            # CSS, JS, images (Tailwind compiled CSS)
 │         └── application.properties
Future Enhancements
REST API endpoints to support decoupled frontends or mobile apps.

Integration with OAuth providers for social login.

Enhanced search and filter capabilities.

UI improvements with advanced Tailwind components.
