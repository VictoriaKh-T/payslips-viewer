# Payslip Platform

_Payslip Platform_ is a solution  for viewing payslips. 

A microservice architecture was used to develop the platform

This platform is a great addition tool for payroll management.

## Project Structure 
* Payslip_platform
  * **documentation** -- contains all documentation and diagrams of the project 
  * **library** -- contains addition library
  * **platform** -- all microservices each with its own README file for specific setup and instructions:
     - **authorization** --  handles user authentication and authorization
     - **employee** -- manages employee data
     - **organization** -- manages organization data
     - **payslip** --downloading and viewing payslips
     - **person** -- manages person data

## Dependencies
Before installing the program, ensure the following prerequisites are met:

* **Java 17+** – required to run the backend microservices.
* **Gradle** – for building the Java project.
* **Spring Boot** – framework for the backend.
* **Docker** – for containerizing and deploying the microservices.
* **PostgreSQL** – used as the primary database. Ensure that the database is created, 
* and the user has the necessary privileges.

Ensure that all necessary environment variables (like database credentials) are properly configured.

## Installing
To install the project locally, follow these steps:

1. Clone the repository to your local machine:
  ```
git clone https://github.com/VictoriaKh-T/Payslip_platform
  ```
2. Navigate to the project directory:

  ```
 cd Payslip_platform
  ```
 
3.  Set up the database:

   * Open the application.properties or application.yml file in your project.

   * Set the database connection properties. Replace database_name, your_login, and your_pass with your database settings:

   ````
   spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ````

````