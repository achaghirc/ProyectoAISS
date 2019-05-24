<%@page import="aiss.Movie.ProductionCompany"%>
<%@page import="aiss.Movie.Movie"%>
<%@page import="aiss.model.resources.MovieResources"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title><c:out value="${requestScope.movies.title}" /></title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- Custom styles for this template -->
<link href="css/landing-page.min2.css" rel="stylesheet">
</head>
<body>
	<div class="masthead text-black text-center">
		<div class="datos_pelis">
			<div>
				<h1>
					<c:out value="${requestScope.movies.title}" />
				</h1>
			</div>
			<div>
				<h3>Poster:</h3>
				<img
					src="https://image.tmdb.org/t/p/w185/${requestScope.movies.posterPath}" />
			</div>
			<div class="card-footer">
				<form id="searchForm" method="post" class="listaForm"action="/AliController">
					<input type='hidden' name='title' value="<c:out value="${requestScope.movies.originalTitle}"/>" />
					<p>
						&nbsp; <input type="submit" class="btn btn-primary"
							name="tituloEnviar" value="<c:out value="Productos"/>" />
					</p>
				</form>
			</div>
			<div class="card-footer">
				<form id="searchForm" method="post" class="listaForm"action="/ValoracionController">
					<input type='hidden' name='idpelicula' value="<c:out value="${requestScope.movies.id}"/>" />
					<input type='hidden' name='titlePeli' value="<c:out value="${requestScope.movies.title}"/>" />
					<input type='number' name='rate'/>
					<p>
						&nbsp; <input type="submit" class="btn btn-primary"
							name="tituloEnviar" value="<c:out value="Valorar"/>" />
					</p>
				</form>
			</div>
			<div>
				<h3>OVERVIEW:</h3>
				<p>
					<c:out value="${requestScope.movies.overview}" />
				</p>
			</div>
			<div>
				<p>
					Adult:
					<c:out value="${requestScope.movies.adult}" />
				</p>
				<p>Production Companies:</p>
				<c:forEach items="${requestScope.movies.productionCompanies}"
					var="prodcom">
					<p>
						&nbsp; &nbsp; &nbsp; &nbsp;<c:out value="${prodcom.name}" />
					</p>
				</c:forEach>
				<p>
					Vote Average:
					<c:out value="${requestScope.movies.voteAverage}" />
					Points.
				</p>
				<p>
					Vote Count:
					<c:out value="${requestScope.movies.voteCount}" />
					Votes.
				</p>
				<p>
					Status:
					<c:out value="${requestScope.movies.status}" />
				</p>
				<p>Actores:</p>
				<c:set var="noOfRows" value="9" />
				<c:forEach items="${requestScope.credits.cast}" var="casting"
					begin="${param.first}" end="${param.first + noOfRows -1}">
					<img src="https://image.tmdb.org/t/p/w185/${casting.profilePath}" />
					<form id="searchForm" method="post" class="listaForm" action="/WikiaController">
						<input type='hidden' name='name' value="<c:out value="${casting.name}"/>" />
						<p>
							&nbsp; <input type="submit" class="tituloEnviar" name="titulo"
								value="<c:out value="${casting.name}"/>" /> interpretando a
							<c:out value="${casting.character}" />
						</p>
					</form>
				</c:forEach>
 				<p>Trailer</p>
				<c:forEach items="${requestScope.items}" var="item">
					<iframe id="ytplayer" type="text/html" width="420" height="205"
						src="https://www.youtube.com/embed/${item.id.videoId}"
						frameborder="0" allowfullscreen></iframe>
					<form method="post" action="/ComentarioController">
						<div class="card">
							<div class="card-body">
								<input type='hidden' name='videoId' value="<c:out value="${item.id.videoId}"/>" /> 
								<input type='hidden' name='MOVId' value="<c:out value="${requestScope.movies.id}"/>" /> 
								<input type='hidden' name='channelId' value="<c:out value="${item.snippet.channelId}"/>" /> 
								<input type="text" name="comentarios" class="form-control" placeholder="Escribe tu comentario aqui"></input>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Comentar</button>
					</form>
				</c:forEach>
				<p>
					Banda Sonora de la pelicula
					<c:out value="${requestScope.movies.title}" />
				</p>
				<c:forEach items="${requestScope.tracks}" var="track">
					<iframe id="ytplayer" type="text/html" width="420" height="205"
						src="https://www.youtube.com/embed/${track.id.videoId}"
						frameborder="0" allowfullscreen></iframe>
					<form method="post" action="/ComentarioController">
						<div class="card">
							<div class="card-body">
								<input type='hidden' name='videoId' value="<c:out value="${track.id.videoId}"/>" /> 
								<input type='hidden' name='MOVId' value="<c:out value="${requestScope.movies.id}"/>" /> 
								<input type='hidden' name='channelId' value="<c:out value="${track.snippet.channelId}"/>" /> 
								<input type="text" name="comentarios" class="form-control" placeholder="Escribe tu comentario aqui"></input>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Comentar</button>
					</form>
				</c:forEach>
			</div>
		</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>