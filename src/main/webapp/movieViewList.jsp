<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="">
<title>Resultado de Peliculas: </title>
</head>
<body>
	<h1>Resultado de Peliculas: </h1>
	<fieldset id="tmdb">
	<h2>TMDB search for <c:out value="${param.searchQuery}"/></h2>
	<c:forEach items="${requestScope.movies}" var="movie">
		<ul class="listaBusqueda">
			<li>Movie title: <c:out value="${movie.title}"/> <a href="/movieView.jsp">ver más</a></li>
		</ul>
	</c:forEach>
	</fieldset>
	<table id="movies">
		<tr>
			<th>Title:</th>
			<th>Year:</th>
			<th>Language:</th>
		</tr>
		<c:forEach items="${requestScope.movieList}" var="movie">
		</c:forEach>
</body>
</html>