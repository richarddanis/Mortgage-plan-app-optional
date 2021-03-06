# Mortgage Spring Application

## Technology Stack
* Spring
* Hibernate

## Prerequisites
* Java 8
* Maven 3.5.0+

# Development
## Building
* From IDE (Eclipse, Intellij) open as a Maven project and compile.
* From Command Line `mvn clean package`

## Running the Application
Run or debug the app with the `Starter` main class at the root of your Java package hierarchy.

You must add the following VM options in order for logging to work properly:
```
-Dapplication.home=. -Dspring.profiles.active=dev -Dapplication.environment=dev
```
Alternately, you may use the following Maven target to run the application from either the command line or your IDE:
```
mvn spring-boot:run
```
Open a browser and visit [http://localhost:8080](http://localhost:8080) for Swagger documentation.

To run on a different port, e.g. 8090, add:
```
-Dserver.port=8090
```
