<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); //works only for https version >1.0
		// for version <1.0 [response.setHeader("pragma","no-cache");]
		if(session.getAttribute("user")==null)
			response.sendRedirect("login.jsp");
	%>
<h2>Welcome ${user }</h2>
<br>
<div class="container">
	<a href="welcome.jsp">Home</a>
	<a href="about.jsp">About Us</a>
	<a href="admin.jsp">Admin</a>
	<br>
	<form action="Logout">
		<input type="submit" value="logout">
	</form>
</div>
</body>
</html>