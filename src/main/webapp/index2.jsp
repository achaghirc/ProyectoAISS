<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta name="google-site-verification"
	content="SQee3iH8COG07c4RWybp1e_pFTFOypo9Ys_n0-7I9oA" />
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/jsp; accept-charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>WikiFilm</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- Custom styles for this template -->
<link href="css/landing-page.min.css" rel="stylesheet">

</head>

<body>
	<!-- Masthead -->

	<div class="masthead text-black text-center">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h1 class="mb-4">
						WikiFilm<img src="images/Logo4.png" width="100" height="100">
					</h1>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
				<b>Recuerda que para poder poner un comentario en Youtube debes loguearte</b>
				</div>
				<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
					<form id="searchForm" action="SearchController" method="post">
						<div class="form-row">
							<div class="col-12 col-md-9 mb-2 mb-md-0">
								<input type="text" name="searchQuery"
									class="form-control form-control-lg"
									placeholder="Introduce el nombre de la película...">
							</div>
							<div class="col-12 col-md-3">
								<button type="submit" name="searchBtn" title="Search"
									value="search" class="btn btn-block btn-lg btn-primary">Search</button>
							</div>

						</div>
					</form>
					<form id="logForm" action="/ComentarioController" method="post">
						<div class="col-12 col-md4">
							<button type="submit" name="searchBoton" value="Search"
								class="btn btn-block btn-lg btn-primary">Logueate en
								Youtube</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:set var="noOfRows" value="1" />
		<c:forEach items="${requestScope.movie}" var="popular"
			begin="${param.first}" end="${param.first + noOfRows -1}">
			<div class="container">
				<div class="row">
					<div class="col-md-4 mb-5" style="margin-left: 180px">
						<p class="font-weight-bolder">POPULAR</p>
						<div class="card h-150">
							<img class="card-img-top"
								src="https://image.tmdb.org/t/p/w185/${popular.posterPath}"
								alt="">
							<div class="card-footer">
								<form id="searchForm" method="post" class="listaForm"
									action="/SelectedMovieController">
									<input type='hidden' name='seachQuery'
										value="<c:out value="${popular.title}"/>" /> <input
										type='hidden' name='id' value="<c:out value="${popular.id}"/>" />
									<input type="submit" class="btn btn-primary"
										name="tituloEnviar" value="<c:out value="${popular.title}"/>" />
								</form>
							</div>
						</div>
					</div>
		</c:forEach>

		<c:set var="noOfRows" value="1" />
		<c:forEach items="${requestScope.upcoming}" var="upcom" begin="1"
			end="1">
			<div class="col-md-4 mb-5">
				<p class="font-weight-bolder">UPCOMING</p>
				<div class="card h-150">
					<img class="card-img-top"
						src="https://image.tmdb.org/t/p/w185/${upcom.posterPath}" alt="">

					<div class="card-footer">
						<form id="searchForm" method="post" class="listaForm"
							action="/SelectedMovieController">
							<input type='hidden' name='seachQuery'
								value="<c:out value="${upcom.title}"/>" /> <input type='hidden'
								name='id' value="<c:out value="${upcom.id}"/>" /> <input
								type="submit" class="btn btn-primary" name="tituloEnviar"
								value="<c:out value="${upcom.title}"/>" />
						</form>
					</div>
				</div>
			</div>
		</c:forEach>
		<c:set var="noOfRows2" value="10" />
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