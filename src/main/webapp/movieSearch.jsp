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
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="css/landing-page.min2.css" rel="stylesheet">
</head>
<body>

	<div class="masthead text-black text-center">
		<h1>Pelicula: <c:out value="${param.searchQuery}"/></h1>
		<fieldset id="tmdb">
		<c:forEach items="${requestScope.movies}" var="movie">
			<form id="searchForm" method="post" class="listaForm" action="/SelectedMovieController">
			<input type='hidden' name='seachQuery' value="<c:out value="${movie.title}"/>"/>
			<input type='hidden' name='id' value="<c:out value="${movie.id}"/>"/>
			<span><input type="submit" class="tituloEnviar" name="titulo" value="<c:out value="${movie.title}"/>"/>(<c:out value="${movie.releaseDate}"/>)</span><br/>
			</form>
		</c:forEach>
		</fieldset>
	</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>  
</body>
</html>