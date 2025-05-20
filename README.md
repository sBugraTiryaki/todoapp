# Todo Application

A simple and elegant Todo application built with Spring Boot, Thymeleaf, and MySQL. This application allows users to create, track, complete, and delete tasks with a clean user interface that supports dark/light themes.

## Features

- Create, toggle, and delete tasks
- Filter tasks by status (All, Active, Completed)
- Clear all completed tasks
- Dark/Light theme toggle with persistent user preference
- Responsive design using Bootstrap 5

## Technologies

- Java 24
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL Database
- Thymeleaf
- Bootstrap 5.3.6
- Lombok
- Maven

## Prerequisites

Before you begin, ensure you have met the following requirements:

- JDK 24 or later
- MySQL Server 8.0 or later
- Maven 3.6 or later

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/todoapp.git
cd todoapp
```

### Setup Database

1. Create a MySQL database named `todo-app`

```sql
CREATE DATABASE `todo-app`;
```

2. Configure the database connection in `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo-app
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### Build and Run the Application

#### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

#### Using the Spring Boot Maven Plugin

```bash
./mvnw spring-boot:run
```

The application will be available at `http://localhost:8080`

## Project Structure

```
todoapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── app/
│   │   │           ├── controller/
│   │   │           │   └── TaskController.java
│   │   │           ├── models/
│   │   │           │   └── Task.java
│   │   │           ├── repository/
│   │   │           │   └── TaskRepository.java
│   │   │           ├── service/
│   │   │           │   └── TaskService.java
│   │   │           └── starter/
│   │   │               └── TodoappApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           └── tasks.html
│   └── test/
│       └── java/
│           └── com/
│               └── app/
│                   └── starter/
│                       └── TodoappApplicationTests.java
└── pom.xml
```

## Usage

After launching the application:

1. Navigate to `http://localhost:8080` in your web browser
2. Use the form at the top to add new tasks
3. Click on the circle next to a task to mark it as complete/incomplete
4. Use the filter tabs (All, Active, Completed) to view different task categories
5. Click the trash icon to delete individual tasks
6. Use the "Clear completed" button to remove all completed tasks at once
7. Toggle between dark and light theme using the icon in the top-right corner

## Configuration Options

### Application Properties

You can customize various aspects of the application by modifying `src/main/resources/application.properties`:

```properties
# Server port configuration
server.port=8080

# Database configuration
spring.datasource.url=jdbc:mysql://localhost:3306/todo-app
spring.datasource.username=root
spring.datasource.password=password

# Hibernate configurations
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# HTTP Method override for PUT, DELETE, etc.
spring.mvc.hiddenmethod.filter.enabled=true
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

If you have any questions, feel free to reach out to me at [your-email@example.com](mailto:your-email@example.com).
