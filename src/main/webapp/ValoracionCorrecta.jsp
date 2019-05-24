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
<link href="css/valoracion.css" rel="stylesheet">
</head>
<body>
	<div class="masthead text-black text-center">
		<div class = "main">
        
        <div class="header">
            <div class="header_box">
                <div class="title">
                    <a href=""><b>WikiFilm</b><img src="images/Logo3.png" width="100" height="100"></a>
                </div>
            </div>
        	<div><h2>Valoracion Introducida correctamente</h2></div>
        	 
        	<div><p><b>La Pelicula <c:out value="${title}"/> con id <c:out value="${idmovie}"/> ha sido valorada con <c:out value="${rate}"/> puntos.</b></p></div>
        	<div>
        	<a class="button" href="/InicioController"><button type="button" class="read_more"> Vuelve al inicio</button></a>
        	</div>  
        	
        </div>
     </div>
    </div>


</body>
</html>