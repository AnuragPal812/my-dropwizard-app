# My Dropwizard App

A minimal example Dropwizard project to demonstrate:
- Jetty for embedded HTTP server
- Jersey for routing REST APIs
- Jackson for JSON serialization
- Hibernate Validator for input validation
- JDBI for database access
- H2 for an in-memory database (for demo)
- Simple `/users` API to create and list users
  
# Requirements

- Java 11+ (or your project’s version)
- Maven

# How to Run
**Build the project:**
```bash
mvn clean package
```
**Run the server**
```bash
java -jar target/my-dropwizard-app-1.0-SNAPSHOT.jar server config.yml
```
# Example http requests
**POST**
```bash
curl --location 'localhost:8080/users' \
--header 'Content-Type: application/json' \
--data-raw '{"name":"Anurag3","email":"anurag3@example.com"}'
```
**GET**
```bash
curl --location 'localhost:8080/users'
```





