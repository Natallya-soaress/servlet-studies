<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List, model.Company" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Company list</title>
	</head>
	<body>
		<c:if test="${not empty company}">
			Company ${ company } successfully registered!! <br>
		</c:if>
		Company list: <br>
		<ul>
			<c:forEach items="${companyList}" var="company">
				<li> 
				${company.name} -  <fmt:formatDate value="${company.openingDate}" pattern="dd/MM/yyyy"/> 
				<a href="showCompany?id=${company.id}"> Edit - </a>
				<a href="removeCompany?id=${company.id}"> Remove </a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>