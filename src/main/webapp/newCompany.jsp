<% String companyName = (String)request.getAttribute("company"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registers</title>
	</head>
	<body>
		Empresa <% out.println(companyName); %>
	</body>
</html>