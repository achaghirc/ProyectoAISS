<%@page import="aiss.Movie.ProductionCompany"%>
<%@page import="aiss.Movie.Movie"%>
<%@page import="aiss.model.resources.MovieResources"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title><c:out value="${requestScope.movies.title}"/></title>
</head>
<body>
		
	<div class="titulo_peli">
		<h1><c:out value="${requestScope.movies.title}"/></h1>
	</div>
	<div class="poster_pelicula">
		<h3>Poster:</h3>
		<img src="https://image.tmdb.org/t/p/w185/${requestScope.movies.posterPath}"/>
	</div>
	<div class="overview_pelicula">
		<h3>OVERVIEW:</h3>
		<p><c:out value="${requestScope.movies.overview}"/></p>
	</div>	
	<div class="">
		<h3><input type="submit" name="añadir" title="Añadir a Favoritos" value="Añadir a Favoritos"/></h3>
	</div>
	<div class="datos_pelicula">
		<p>Adult:<c:out value="${requestScope.movies.adult}"/></p>
		<p>Production Companies:</p> 
		<c:forEach items="${requestScope.movies.productionCompanies}" var="prodcom">
			<p> &nbsp; &nbsp; &nbsp; &nbsp; <c:out value="${prodcom.name}"/></p>
		</c:forEach> 
		<p>Vote Average:<c:out value="${requestScope.movies.voteAverage}"/> Points.</p>
		<p>Vote Count:<c:out value="${requestScope.movies.voteCount}"/> Votes.</p>
		<p>Status:<c:out value="${requestScope.movies.status}"/></p>
		<p>Actores:</p>
		<c:set var="noOfRows" value="10"/>
		<c:forEach items="${requestScope.credits.cast}" var="casting"
			begin="${param.first}"  end="${param.first + noOfRows -1}">
			<img src="https://image.tmdb.org/t/p/w185/${casting.profilePath}"/>
			<form id="searchForm" method="post" class="listaForm" action="/WikiaController">
			<input type='hidden' name='name' value="<c:out value="${casting.name}"/>"/>
			<p>&nbsp; <input type="submit" class="tituloEnviar" name="titulo" value="<c:out value="${casting.name}"/>"/> interpretando a <c:out value="${casting.character}"/></p>
			</form>
		</c:forEach>
		<p>Trailer</p>
			<c:forEach items="${requestScope.items}" var="item">
			<iframe src="https://www.youtube.com/embed/<c:out value="${item.id.videoId}"/>"></iframe>
			</c:forEach>	

	</div>
	
</body>
</html>