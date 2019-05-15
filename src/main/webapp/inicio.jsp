<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Token:<c:out value="${requestScope.token}"/>
	<p><c:out value="${requestScope.token}"/></p>
		<p><a href="https://www.themoviedb.org/authenticate/${requestScope.token}?redirect_to=https://appwikifilm.appspot.com">
		Logueate en TMDB </a></p>
	
	
</body>
</html>