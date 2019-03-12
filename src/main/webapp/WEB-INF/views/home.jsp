<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<P>  Time::  ${serverTime}. </P>

<h1>
	Add User   
</h1>

<form:form action="addEmployee" modelAttribute="Employee"> 
	<p> Id      :   <form:input path="id" /> </p>
    <p> Name    :   <form:input path="name" /> </p>
    <p> Gender  :   <form:input path="gender" /> </p>
     
     <button type="submit">Submit</button>
     
</form:form>


<h2>
	Employee List   
</h2>
<c:if test="${not empty empList }">
<table border=1>
	<tr>
		<th> Id </th>
		<th> Name </th>
		<th> Gender </th>
		</tr>
	 <c:forEach var="emp" items="${empList}">
	 	<tr> 
	 		<td> ${emp.id} </td>
	 		<td> ${emp.name} </td>
	 		<td> ${emp.gender} </td>
	 	</tr>
	 </c:forEach>

</table>
</c:if>

</body>
</html>
