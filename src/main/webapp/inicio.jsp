<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Token:
	<p><c:out value="${requestScope.token.requestToken}"/></p>
		<p><a href="https://www.themoviedb.org/authenticate/<c:out value="${requestScope.token.requestToken}"/>?redirect_to=https://localhost:8090">
		Logueate en TMDB </a></p>
	
	
</body>
</html>