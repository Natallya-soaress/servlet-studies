<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrance" var="link"> </c:url>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title> Login </title>
	</head>
	
	<body>
		<form action="${link}" method="post">
			Login: <input type="text" name="userName"> <br>
			Password: <input type="password" name="password"> <br>
			
			<input type="hidden" name="action" value="Login"> <br>
			<input type="submit">
		</form>
	</body>
</html>