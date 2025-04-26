# Quiz Application 🎯

Welcome to the **Quiz Application**!  
This project is built using **Java Spring Boot** and connects to a **MySQL** database to dynamically fetch and generate random quiz questions.

🔗 **Repository:** [Quiz-Application](https://github.com/thirupathireddykr/Quiz-Application.git)

---

## 📜 Project Overview

The **Quiz Application** is a backend API that:
- Connects to a MySQL database storing quiz questions.
- Provides an endpoint to generate a set of random questions for a quiz session.
- Handles data operations efficiently using Spring Boot and JPA (Hibernate).

This project showcases how to build a RESTful API using Java Spring Boot, with a focus on CRUD operations, database interaction, and random question generation logic.

---

## 🛠️ Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven
- **API Testing:** Postman / cURL (optional)

---

## 🚀 Features

- Randomly generates quiz questions on API call.
- Retrieves data directly from MySQL database.
- Designed for scalability and easy addition of new questions.
- Organized, clean, and modular codebase.

---

## 🏗️ Setup Instructions

Follow these steps to run the project locally:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/thirupathireddykr/Quiz-Application.git
   ```

2. **Navigate into the project directory:**
   ```bash
   cd Quiz-Application
   ```

3. **Configure the MySQL Database:**
   - Create a new database in MySQL (e.g., `quiz_db`).
   - Update your `application.properties` file with your MySQL database details:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
     ```

4. **Build and Run the Application:**
   ```bash
   ./mvnw spring-boot:run
   ```
   or
   ```bash
   mvn spring-boot:run
   ```

5. **Access the API:**
   - The application will run by default on `http://localhost:8080/`
   - You can test the quiz generation endpoint using tools like Postman.

---

## 📂 Project Structure

```
Quiz-Application
├── src/main/java/com/quizapp
│   ├── Controller
│   ├── Model
│   ├── Service
│   ├── dao
│   └── QuizApplication.java
├── src/main/resources
│   ├── application.properties
├── pom.xml
└── README.md
```

---

## 📌 Future Enhancements

- Add support for multiple quiz categories.
- Implement user authentication and quiz history tracking.
- Add difficulty levels to questions.
- Create a frontend interface for users to take the quiz.

---

## 🤝 Contributions

Contributions, issues, and feature requests are welcome!  
Feel free to check the [issues page](https://github.com/thirupathireddykr/Quiz-Application/issues).

---

> Made with ❤️ by **Thirupathi Reddy Kapa**
