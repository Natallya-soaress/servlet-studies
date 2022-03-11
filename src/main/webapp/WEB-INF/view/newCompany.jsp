<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registers</title>
	</head>
	<body>
		<c:if test="${not empty company}">
			Company ${ company } successfully registered!!
		</c:if>
		<c:if test="${empty company}">
			No company registered!!
		</c:if>
	</body>
</html>