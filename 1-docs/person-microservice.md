# Person Microservice Documentation

## Main functionality:
The Person microservice is responsible for managing personal data, including storing, updating, and deleting information about individuals. It handles essential details such as name, date of birth, and contact information.

## Interaction with other microservices:
The Person microservice closely integrates with the Employee and Organization microservices. 

The Employee microservice uses data from Person to link employees to their respective individuals. 

Additionally, through Organization, it associates employees with specific companies, ensuring data consistency across the system.

## Requirements 
* Java 17;
* JUnit 5 ;
* Spring Boot;
* Gradle;
* Docker;
* Swagger;
* Lombok;
* PostgreSQL

## Structure

"there will be descriptions" 

## UML 

- ER-diagram


 ![person.png](er-diagram%2Fdiagram%2Fperson.png)


## 3. API

### 3.1. Create Person

- **Method:** `POST`
- **URL:** `/hrm/persons`
- **Views:** 
  - **Query:**
    ```json
    {
      "email": "string",
      "firstName": "string",
      "secondName": "string",
      "surname": "string",
      "birthDate": "YYYY-MM-DD"
    }

- **Response**
   ```json
  {
    "personId": "long",
    "email": "string",
    "firstName": "string",
    "secondName": "string",
    "surname": "string",
    "birthDate": "YYYY-MM-DD"
   }
