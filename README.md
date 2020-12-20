# navyug_test

Implement Rest API for ATM Backend service.

# To Run

Clone this repository<br /> 
Make sure you are using JDK 1.8 and Maven 3.x<br />
to build--- mvn clean install<br />

Unzip the zip file (if you downloaded one)<br />
Open Command Prompt and Change directory (cd) to folder containing pom.xml<br />
Open Eclipse<br />
File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip<br />
Select the right project<br />
Choose the Spring Boot Application file (search for @SpringBootApplication)<br />
Right Click on the file and Run as Java Application<br />

By default it will run in 8080 port

# To Test Api

You can use postman to hit the APIs ,sample curl request are provided below <br />

// TO DEPOSIT MONEY<br />

curl --location --request POST 'localhost:8080/deposit' \<br />
--header 'Content-Type: application/json' \<br />
--data-raw '{<br />
"account_id":1000000,<br />
"amount": 5000<br />
}'<br />

// TO WITHDRAW MONEY<br />

curl --location --request POST 'localhost:8080/withdraw' \<br />
--header 'Content-Type: application/json' \<br />
--data-raw '{<br />
"account_id":1000000,<br />
"amount": 3000<br />
}'<br />

// TO CHECK BALANCE<br />

curl --location --request GET 'localhost:8080/check-balance/1000000' <br />


// TO ADD NEW USER<br />

curl --location --request POST 'localhost:8080/newUser' \<br />
--header 'Content-Type: application/json' \<br />
--data-raw '{<br />
"name":"test",<br />
"city": "udaipur",<br />
"phone":9078987689,<br />
"account_type":"savings"<br />
}'<br />

