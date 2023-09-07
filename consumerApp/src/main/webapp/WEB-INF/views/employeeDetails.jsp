<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<title>All Employees</title>
<body>
<div style="text-align:center;width: 400px;margin: 0 auto;border-style: dotted;">
<table>

<c:forEach var="employee" items="${employeeList}"> 
	<tr>	
		<td>${employee.employeeId}</td>
		<td>${employee.employeeFirstName}</td>
		<td>${employee.employeeLastName}</td>
		<td>${employee.employeeEmail}</td>
	</tr>
</c:forEach> 
</table>
</div>
</body>
</html>