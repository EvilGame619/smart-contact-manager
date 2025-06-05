# 📇 Smart Contact Manager

Smart Contact Manager is a full-stack web application designed to help users efficiently manage and communicate with their contacts. It offers robust contact management, direct email integration, and secure role-based access, all wrapped in a responsive UI.

---

## 🚀 Features

### ✅ Contact Management
  - Add, update, delete contacts
  - Categorize contacts by groups such as Family, Work, Friends, etc.

### ✉️ Direct Email
- Send emails directly from the app using integrated SMTP

### 🔐 Secure Authentication
- Role-based login and access control using Spring Security
- Ability to fix issues based on suggestions

### 💾 Backend & Database
- Backend built with **Java** and **Spring Boot**
- Uses **MySQL** for storing user activity and contacts.

---


## 🛠️ Tech Stack

### 🔧 Backend
- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- REST APIs

### 🌐 Frontend
- Thymeleaf (server-side rendering)
- Tailwind CSS
  
---

## 📦 Getting Started

### 🧰 Prerequisites

- Java 17+
- Node.js + npm
- MySQL
- Maven

### 🔄 Clone the Repo

git clone https://github.com/EvilGame619/smart-contact-manager.git

---

## ⚙️ Setup & Run
- Create a MySQL database (e.g., smart_contact_manager)
- Update database credentials and SMTP settings in src/main/resources/application.properties
- Build and run the application:
  - mvn clean install
  - mvn spring-boot:run
  - Open your browser at http://localhost:8080

