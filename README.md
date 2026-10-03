# Student Management System

## Project Overview

The Student Management System is a Java-based console application developed to manage student information and academic results.

The system provides CRUD operations, result management, input validation, report generation, and file-based data storage.

## Objectives

* Manage student records efficiently.
* Provide student search and update operations.
* Manage academic results.
* Calculate total marks, average, and grade.
* Generate student academic reports.
* Validate user input.
* Store data permanently using text files.
* Demonstrate core Java programming concepts.

## Features

1. Add Student
2. View Students
3. Search Student
4. Update Student
5. Delete Student
6. Add Result
7. View Result
8. Generate Student Report
9. Input Validation
10. File Storage
11. File Loading
12. Exception Handling

## Technologies Used

* Java
* Java Collections Framework
* File Handling
* Exception Handling
* Object-Oriented Programming
* Visual Studio Code
* Git and GitHub

## Java Concepts Used

* Classes and Objects
* Constructors
* Inheritance
* Encapsulation
* Methods
* ArrayList
* Conditional Statements
* Loops
* Exception Handling
* File Handling

## Project Structure

```text
Student-Management-System/
│
├── src/
│   ├── Main.java
│   ├── Person.java
│   ├── Student.java
│   ├── Result.java
│   ├── Validation.java
│   ├── FileManager.java
│   ├── StudentManager.java
│   ├── ResultManager.java
│   └── ReportGenerator.java
│
├── students.txt
├── results.txt
├── statement.md
└── README.md
```

## How to Run

### Using VS Code

1. Open the project folder in Visual Studio Code.
2. Open `Main.java`.
3. Click the Run button.
4. Select an option from the menu.
5. Enter the required information.

### Using Command Prompt / PowerShell

Open the project folder and compile the Java files:

```text
javac src\*.java
```

Run the application:

```text
java -cp src Main
```

## Data Storage

Student information is stored in `students.txt`.

Academic result information is stored in `results.txt`.

The files allow data to remain available when the application is restarted.

## Validation

The system validates:

* Student ID
* Student name
* Course
* Age
* Marks
* Invalid numeric input
* Duplicate Student ID

## Result Calculation

The system calculates:

* Total marks
* Average marks
* Grade

## Student Report

The system can generate a student academic report containing:

* Student details
* Subject marks
* Total marks
* Average marks
* Grade

## Non-Functional Requirements

* **Usability:** The system provides a simple menu-driven interface.
* **Reliability:** The system validates user input and handles common input errors.
* **Maintainability:** The system is divided into multiple Java classes and modules.
* **Performance:** The system provides quick operations for storing and retrieving student records.
* **Portability:** The application can run on systems with a compatible Java Development Kit.

## Future Enhancements

* Database integration
* User authentication
* Graphical user interface
* Attend
