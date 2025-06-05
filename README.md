📇 Smart Contact Manager
Smart Contact Manager is a full-stack web application designed to help users efficiently manage their contacts. It offers CRUD operations, categorization, direct email functionality, and secure role-based access.

🚀 Features
✅ Contact Management
Add, update, delete, and categorize contacts (e.g., Family, Work).

✅ Direct Email
Send emails seamlessly from within the app.

✅ Security
Secure login and role-based access using Spring Security.

✅ Responsive UI
Built with Tailwind CSS and Thymeleaf templates for a clean and responsive user interface.

🛠️ Tech Stack
🔧 Backend
Java 17+

Spring Boot

Spring Security

MySQL

Spring Data JPA

🌐 Frontend
Thymeleaf (server-side rendering)

Tailwind CSS

📦 Getting Started
🧰 Prerequisites
Java 17+

Maven

MySQL Server

🔄 Clone the Repository
bash
Copy
Edit
git clone https://github.com/yourusername/smart-contact-manager.git
⚙️ Setup
Create a MySQL database (e.g., smart_contact_manager).

Update database credentials and SMTP settings in src/main/resources/application.properties.

Build and run the app:

bash
Copy
Edit
mvn clean install
mvn spring-boot:run
🌐 Access
Open your browser at http://localhost:8080

🗂️ Project Structure
bash
Copy
Edit
src/
 ├── main/
 │    ├── java/com/yourorg/smartcontactmanager/
 │    │    ├── controller/        # Web controllers
 │    │    ├── model/             # JPA entities
 │    │    ├── repository/        # Data access layer
 │    │    ├── service/           # Business logic
 │    │    └── security/          # Security config
 │    └── resources/
 │         ├── templates/         # Thymeleaf views
 │         ├── static/            # Tailwind CSS and static assets
 │         └── application.properties
🔮 Future Improvements
REST API support for decoupled frontends or mobile apps

OAuth/social login integration

Enhanced search and filtering for contacts

UI improvements with advanced Tailwind components
