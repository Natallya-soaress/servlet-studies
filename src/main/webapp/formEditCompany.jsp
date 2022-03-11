<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<c:url value="/changeCompany" var="link"> </c:url>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Edit </title>
	</head>
	
	<body>
		<form action="${link}" method="post">
			Name: <input type="text" name="name" value="${company.name}"> <br>
			Opening date: <input type="text" name="date" value="<fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy"/>"> <br>
			<input type="hidden" name="id" value="${company.id}"> <br>
			<input type="submit">
		</form>
	</body>
</html>