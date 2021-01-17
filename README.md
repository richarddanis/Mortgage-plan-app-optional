# Mortgage Optional Application

Technology Stack
- Spring
- ReactJS
- Hibernate

Required tools for build the applications
- Maven
- NPM
- NodeJS

## Build Front End Application
### Building
In the project directory, you can run:
```
npm install
```

### Running the application
In the project directory, you can run:

```
npm start
```

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

## Back End Application

### Building
* From IDE (Eclipse, Intellij) open as a Maven project and compile.
* From Command Line `mvn clean package`

### Running the Application
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
