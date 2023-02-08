# jobseeker-app

This is a job seeker application Spring Boot application.
The application is capable of handling client registration, posting and retrieving jobs.


To be able to run the application you need Java JVM installed on your machine.
You can download it from here: https://www.oracle.com/java/technologies/downloads/

Maven build system is embedded into the application, so you don't have to download it separately.

Go to your terminal and open the folder in which the application resides.
In order to run the application type: mvn spring-boot:run


The API Swagger documentation can be accessed by typing http://localhost:8080/swagger-ui/index.html after running the application.

If you want to access the database while the application is running type localhost:8080/h2-console to your browser.
credentials:
username: admin
password: admin

Possible improvements:

Replace H2 inmemory database with a persistent one such as MySQL.
Introduce logging capabilities.
Implement unit testing and possibly mock testing.
Create relations between the tables. (currently the tables are not related to each other)
Upload the application to the cloud and run it there.
Containerization.
Don't hardcode credentials to application.properties, rather inject it at runtime for instance from the server.
Implement OAuth2 authentication.
