<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List, model.Company" %>
    
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Company list</title>
	</head>
	<body>
		Company list: <br>
		<ul>
			<% 
				List<Company> companyList = (List<Company>) request.getAttribute("companyList");
				for(Company company : companyList){
			%>
			<li>
				<%= company.getName()  %>
			</li>
			<% 
				}
			%>
		</ul>
	</body>
</html>