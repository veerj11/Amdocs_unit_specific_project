# Amdocs_unit_specific_project
 
In this application two REST services have been created one rest service handles CRUD operations on a database and the other application consumes data generated from the employeeApp. The employeeApp is divided into multiple layers to communicate with the database and to give output to the user.

Technologies Used:
 1. Spring BOOT
 2. Spring MVC
 3. REST API
 4. Swagger
 5. MY SQL
 6. JSP
    
The employee app uses Spring framework to develop controllers to handle input requests further. Employee Repository class uses Spring JPA to communicate with the database and provides CRUD operations. GlobalExceptionHandler was developed using RestControllerAdvice to handle invalid requests, data not found and database empty errors. Hibernate validator was used to provide validation to all the fields. MySql database was used to store Employee Data.

A consumer application called ConsumerApp was developed which uses Spring MVC using Resttemplate the parent EmployeeApp was queried and operations for Get all employees, get one employee, search an employee, update and employee and delete an employee were made. Views were developed in JSP for dynamic pages. The input request was recieved by a dispatcher servlet and the using the handler mapping controller were queried. The controllers return a model and a view model holds the data and view holds the name of the view to be diplayed. finally view resolver maps the view to its name and returns it to the user. Various exceptions on input were also handled.

Change Application properties, and dependency(pom.xml) files according to local machine.

