<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>Comentario</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- Custom styles for this template -->
<link href="css/valoracion.css" rel="stylesheet">
</head>
<body>
	<div class="masthead text-black text-center">
		<div class="container">
			<div class="row">
				<div class="col-xl-9 mx-auto">
					<h1 class="mb-4">
						WikiFilm<img src="images/Logo4.png" width="100" height="100">
					</h1>
				</div>
        	<div class="col-md-10 col-lg-8 col-xl-7 mx-auto" >
        	<h2>Comentario publicado correctamente</h2>
        	</div>
        	<div class="col-md-10 col-lg-8 col-xl-7 mx-auto" > 
        		<p>
        		    <b>El comentario es: <c:out value="${message}"/></b>
        		</p>
        	</div>
        	<div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
        	<a class="button" href="/InicioController"><button type="button" class="read_more"> Vuelve al inicio</button></a>
        	</div> 
        	 
		</div>
	</div>     
       
    </div>
</body>
</html>