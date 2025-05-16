# 🚀 Spring Boot + MySQL Web Application

A web application built with Spring Boot and MySQL, designed to [ manage reboot logs.].

## 📦 Features

- ✅ Spring Boot backend (REST API)
- ✅ MySQL database integration
- ✅ Role-based access control (Manager / Technician)
- ✅ Scheduled tasks 
- ✅ Docker-ready 

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Docker 
- IntelliJ IDEA

## 🚀 Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/ElMehdiEssakhi/GestionRebootBackEnd
cd GestionRebootBackEnd
```
### 2. Set Up MySQL DB

- Create a new database in MySQL (e.g., dbAlert) .
- Execute the SQL dump to create tables:
```bash
mysql -u your_user -p dbAlert < Dump.sql
```
### 3.Configure Application Properties

Edit src/main/resources/application.properties with your database credentials:

### 4.Build and Run the Application

- Build the project using Maven:
```bash
mvn clean install
```
- Run the app
```bash
java -jar your-app-name.jar
```