<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>
<form action="/updateOne" modelAttribute = "employee">
Id:<input type="text" name="employeeId"/><br/>
First Name:<input type="text" name="employeeFirstName"/><br/>
Last Name:<input type="text" name="employeeLastName"/><br/>
Email:<input type="text" name="employeeEmail"/><br/>
<button type="submit">Go</button>
</form>
</body>
</html>