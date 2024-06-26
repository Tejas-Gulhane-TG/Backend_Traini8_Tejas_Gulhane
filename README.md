
# Traini8: Registry for Govt Funded Training Centers
Welcome to the README file for the Traini8 project, an MVP for a registry for Government-funded Training Centers. This project is designed to meet the following minimum requirements:

## Project Overview
Traini8 aims to create a Minimum Viable Product (MVP) for a registry of Government-funded Training Centers. The MVP includes two APIs, each serving specific functionalities as outlined below.

## Technologies Used
* Java
* Spring Boot
* MySql

## API Endpoints
### First API : Create a New Training Center
* **Endpoint** : POST localhost:8080/training/centers/create
* **Description** : Creates and saves a new training center with the provided details.
* **Request Body** : JSON
```json

{
    "centerName":"Learn_India",
    "centerCode":"ABCS1234DC75",
    "address":{
        "detailedAddress":"Main Line Road Building NO 10",
        "city":"Yavatmal",
        "state":"Maharashtra",
        "pinCode":445001
    },
    "student_Capacity":25,
    "course_Offered":["Computer", "Electronics", "Electrical", "Civil"],
    "email":"learningIndia@gmail.com",
    "phoneNo":9552776482
}

```
* **Response** : JSON
```json

{
    "id": 17,
    "centerName": "Learn_India",
    "centerCode": "ABCS1234DC75",
    "address": {
        "detailedAddress": "Main Line Road Building NO 10",
        "city": "Yavatmal",
        "state": "Maharashtra",
        "pinCode": "445001"
    },
    "student_Capacity": 25,
    "course_Offered": [
        "Computer",
        "Electronics",
        "Electrical",
        "Civil"
    ],
    "email": "learningIndia@gmail.com",
    "phoneNo": "9552776482",
    "createdOn": "2024-04-27T05:55:20.910+00:00"
}

```

* **Validation** :
  
  * Mandatory fields are validated.
  * Phone number and email are validated.
  * createdOn field is populated based on server timestamp.

### Second API : Get List of Training Centers
* **Endpoint** : GET localhost:8080/training/centers/get
* **Description** : Retrieves a list of all stored training centers information.
* **Response** : JSON (Array)
```Json
[
    {
        "id": 17,
        "centerName": "Learn_India",
        "centerCode": "ABCS1234DC75",
        "address": {
            "detailedAddress": "Main Line Road Building NO 10",
            "city": "Yavatmal",
            "state": "Maharashtra",
            "pinCode": "445001"
        },
        "student_Capacity": 25,
        "course_Offered": [
            "Computer",
            "Electronics",
            "Electrical",
            "Civil"
        ],
        "email": "learningIndia@gmail.com",
        "phoneNo": "9552776482",
        "createdOn": "2024-04-27T05:55:20.910+00:00"
    },
    {
        "id": 18,
        "centerName": "Center_1",
        "centerCode": "CDAS1234DC70",
        "address": {
            "detailedAddress": "Building NO 10",
            "city": "New Delhi",
            "state": "Delhi",
            "pinCode": "124560"
        },
        "student_Capacity": 125,
        "course_Offered": [
            "Computer",
            "Electronics",
            "Electrical",
            "Civil"
        ],
        "email": "Center1@gmail.com",
        "phoneNo": "1234567890",
        "createdOn": "2024-04-27T06:05:22.159+00:00"
    },
    {
        "id": 19,
        "centerName": "Center_2",
        "centerCode": "CDAS1DSA5V70",
        "address": {
            "detailedAddress": "New Highway",
            "city": "Surat",
            "state": "Gujarat",
            "pinCode": "1245000"
        },
        "student_Capacity": 100,
        "course_Offered": [
            "Chemistry",
            "Mathematics",
            "Electrical",
            "Physics"
        ],
        "email": "Center2@gmail.com",
        "phoneNo": "1234567800",
        "createdOn": "2024-04-27T06:07:39.678+00:00"
    }
]
```
* **Special Cases** :
    * If no training centers are stored, an empty list is returned.
 


### MySQL Database Setup
1. Install MySQL if not already installed: MySQL Installation Guide
2. Create a new MySQL database named BuyogoDB.
3. Update the application.properties file with your MySQL database configuration:

```Bash
spring.datasource.url=jdbc:mysql://localhost:3306/BuyogoDB?createTableIfNotExists=true
spring.datasource.username=root
spring.datasource.password=Tejas@9335
spring.jpa.hibernate.ddl-auto=update
```
4. Run the project. Spring Boot will automatically create necessary tables based on the entity classes.

### Setup Instructions
1. Clone the repository: git clone https://github.com/Tejas-Gulhane-TG/Backend_Traini8_Tejas_Gulhane.git
3. Build the project.
4. Run the project.
5. The APIs are now accessible at http://localhost:8080
   
**Contributors**
  * Tejas Gulhane

*Contact Information*
  * For any inquiries or issues, please contact tgulhane28@gmail.com.



