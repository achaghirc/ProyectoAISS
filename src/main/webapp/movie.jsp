<%@page import="java.util.ArrayList"%>
<%@page import="aiss.Movie.ProductionCompany"%>
<%@page import="java.util.List"%>
<%@page import="aiss.Movie.Movie"%>
<%@page import="aiss.model.resources.MovieResources"%>
<%@page import="java.util.Date"%>
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
			<p>&nbsp; <c:out value="${casting.name}"/> interpretando a <c:out value="${casting.character}"/></p>
		</c:forEach>
		<p>Trailer</p>
			<c:forEach items="${requestScope.items}" var="item">
			<iframe src="http://www.youtube.com/embed/${item.id.videoId}"></iframe>
			</c:forEach>
		<fieldset id="SoundCloud">
		<legend>Canción de la película <c:out value="${param.searchQuery}"/></legend>
		<c:forEach items="${requestScope.Track}" var="track"/>
		<form id="getTrackForm" action="/SoundCloudContoller" method="post">
		<iframe width="100%" height="300" scrolling="no" frameborder="no" allow="autoplay" src="http://soundcloud.com/oembed/<c:out value="{track.id}"/>&color=%23ff5500&auto_play=false&hide_related=false&show_comments=true&show_user=true&show_reposts=false&show_teaser=true&visual=true"></iframe>
		</form>
		
	</fieldset>
	</div>
	
</body>
</html>