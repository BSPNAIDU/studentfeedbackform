# 🎓 Student Feedback Portal

A web-based **Student Feedback Management System** developed using Java, JSP, Servlets, JDBC, MySQL, Maven, Bootstrap, Jenkins, and Apache Tomcat.

The application allows students to submit feedback online and provides administrators with a secure dashboard to view, search, delete, and export feedback records. The project also implements a Jenkins CI/CD pipeline for automated Maven build and deployment to Apache Tomcat.

---

## 📌 Project Overview

Traditional paper-based feedback systems are time-consuming and difficult to manage. The Student Feedback Portal provides a centralized digital solution for collecting and managing student feedback.

Students can submit feedback through a responsive web form, while administrators can monitor feedback statistics and manage submitted records through the Admin Dashboard.

---

## ✨ Features

### 👨‍🎓 Student Module

- Online student feedback submission
- Student name and email collection
- Department selection
- Rating submission
- Feedback message
- Data stored permanently in MySQL
- Successful submission confirmation

### 👨‍💼 Admin Module

- Secure admin login
- Session-based authentication
- Admin Dashboard
- Total feedback statistics
- Average rating
- Department count
- Today's feedback count
- View all feedback
- Search feedback
- Delete feedback
- Export feedback to Excel
- Secure logout

### ⚙️ DevOps Features

- Git version control
- GitHub source-code repository
- Maven build automation
- Jenkins CI/CD pipeline
- Automatic WAR generation
- Jenkins artifact archiving
- Automatic deployment to Apache Tomcat

---

## 🛠️ Technologies Used

| Category | Technologies |
|---|---|
| Programming Language | Java 21 |
| Frontend | JSP, HTML5, CSS3, Bootstrap 5, JavaScript |
| Backend | Java Servlets |
| Database Connectivity | JDBC |
| Database | MySQL |
| Architecture | Servlet + JSP + DAO |
| Build Tool | Apache Maven |
| Version Control | Git |
| Repository | GitHub |
| CI/CD | Jenkins |
| Application Server | Apache Tomcat 10 |
| Report Export | Excel |
| Development Environment | Visual Studio Code |

---

## 🏗️ System Architecture

```text
Student
   |
   v
JSP Feedback Form
   |
   v
Java Servlet
   |
   v
DAO Layer
   |
   v
JDBC
   |
   v
MySQL Database
   |
   v
Admin Dashboard
```

---

## 🔄 CI/CD Architecture

```text
Developer / VS Code
        |
        v
       Git
        |
        v
      GitHub
        |
        v
      Jenkins
        |
        v
 Maven Clean Package
        |
        v
StudentFeedbackPortal.war
        |
        v
  Apache Tomcat
        |
        v
Student Feedback Portal
```

---

## 📂 Project Structure

```text
StudentFeedbackPortal/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/studentfeedback/
│       │       ├── config/
│       │       ├── dao/
│       │       ├── model/
│       │       └── servlet/
│       │
│       ├── resources/
│       │
│       └── webapp/
│           ├── css/
│           ├── index.jsp
│           ├── feedback.jsp
│           ├── admin-login.jsp
│           ├── dashboard.jsp
│           └── view-feedback.jsp
│
├── Jenkinsfile
├── pom.xml
├── .gitignore
└── README.md
```

---

## 🗄️ Database

The application uses a MySQL database with two main tables.

### Admin Table

| Column | Description |
|---|---|
| admin_id | Unique administrator ID |
| username | Administrator username |
| password | Administrator password |

### Feedback Table

| Column | Description |
|---|---|
| feedback_id | Unique feedback ID |
| student_name | Student name |
| email | Student email |
| department | Student department |
| rating | Feedback rating |
| feedback_message | Student feedback |
| submitted_at | Submission date and time |

---

## 🔐 Demo Admin Login

For local project demonstration:

```text
Username: admin
Password: admin123
```

> These credentials are intended only for the project/demo environment.

---

## 🚀 Running the Project Locally

### Prerequisites

Install:

- Java JDK 21
- Apache Maven
- MySQL
- Apache Tomcat 10
- Git

### 1. Clone the repository

```bash
git clone https://github.com/BSPNAIDU/studentfeedbackform.git
```

### 2. Open the project

```bash
cd studentfeedbackform
```

### 3. Configure MySQL

Create the required database and tables and configure the database connection details used by the application.

### 4. Build the project

```bash
mvn clean package
```

After a successful build, Maven generates:

```text
target/StudentFeedbackPortal.war
```

### 5. Deploy to Tomcat

Copy:

```text
StudentFeedbackPortal.war
```

to:

```text
apache-tomcat-10.1.57/webapps/
```

Start Apache Tomcat.

---

## 🌐 Application URLs

When Tomcat is running locally on port `9090`:

### Home Page

```text
http://localhost:9090/StudentFeedbackPortal/
```

### Admin Login

```text
http://localhost:9090/StudentFeedbackPortal/admin-login.jsp
```

> `localhost` URLs work only on the computer where Tomcat is running.

---

## 🔧 Jenkins CI/CD Pipeline

The project uses Jenkins for Continuous Integration and Continuous Deployment.

The pipeline performs:

1. Source-code checkout from GitHub
2. Maven build
3. WAR file generation
4. WAR artifact archiving
5. Deployment to Apache Tomcat
6. Application update

The main build command is:

```bash
mvn clean package
```

Successful builds generate:

```text
StudentFeedbackPortal.war
```

---

## 📊 Main Application Workflow

```text
Student Opens Portal
        |
        v
Opens Feedback Form
        |
        v
Submits Feedback
        |
        v
Servlet Processes Request
        |
        v
FeedbackDAO Stores Data
        |
        v
MySQL Database
        |
        v
Admin Logs In
        |
        v
Dashboard / Feedback Management
        |
        +----> Search Feedback
        |
        +----> Delete Feedback
        |
        +----> Export Excel Report
```

---

## 📸 Screenshots

Add the final project screenshots here:

### Home Page

`[Insert Home Page Screenshot]`

### Student Feedback Form

`[Insert Feedback Form Screenshot]`

### Admin Login

`[Insert Admin Login Screenshot]`

### Admin Dashboard

`[Insert Dashboard Screenshot]`

### Feedback Management

`[Insert View Feedback Screenshot]`

### Excel Export

`[Insert Excel Report Screenshot]`

### Jenkins Pipeline

`[Insert Jenkins Build Success Screenshot]`

---

## 🧪 Testing

The following functions were tested successfully:

- Student feedback submission
- MySQL data insertion
- Admin authentication
- Session management
- Dashboard statistics
- View feedback
- Search feedback
- Delete feedback
- Excel export
- Maven WAR generation
- Jenkins build
- Automatic Tomcat deployment

---

## 🔮 Future Enhancements

- Dashboard charts and advanced analytics
- Password hashing and improved authentication
- Multiple administrator roles
- Email notifications
- PDF report generation
- AI-based sentiment analysis
- Docker containerization
- AWS cloud deployment
- Mobile application

---

## 👨‍💻 Developer

**Bhale Durga Prasad**

Project: **Student Feedback Portal**

---

## 📚 Project Purpose

This project was developed for academic/internship learning to demonstrate:

- Java Web Development
- Database Connectivity
- MVC/Layered Architecture
- Maven Build Management
- Git & GitHub
- Jenkins CI/CD
- Apache Tomcat Deployment

---

## 📄 License

This project is intended for educational and academic purposes.