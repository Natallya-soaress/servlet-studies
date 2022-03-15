<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrance" var="link"> </c:url>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Cadastre </title>
	</head>
	
	<body>
		<form action="${link}" method="post">
			Name: <input type="text" name="name"> <br>
			Opening date: <input type="text" name="date"> <br>
			
			<input type="hidden" name="action" value="NewCompany"> <br>
			<input type="submit">
		</form>
	</body>
</html>