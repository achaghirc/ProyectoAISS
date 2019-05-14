<%@page import="aiss.Movie.Movie"%>
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

	<h1>Pelicula: <c:out value="${param.searchQuery}"/></h1>
	<fieldset id="tmdb">
	<c:forEach items="${requestScope.movies}" var="movie">
		<form id="searchForm" method="post" class="listaForm" action="/SelectedMovieController">
		<input type='hidden' name='seachQuery' value="<c:out value="${movie.title}"/>"/>
		<input type='hidden' name='id' value="<c:out value="${movie.id}"/>"/>
		<span>Movie title: <input type="submit" class="tituloEnviar" name="titulo" value="<c:out value="${movie.title}"/>"/>(<c:out value="${movie.releaseDate}"/>)</span><br/>
		</form>
	</c:forEach>
	</fieldset>
	
</body>
</html>