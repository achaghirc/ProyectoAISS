<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wikifilm</title>
<link rel="stylesheet" type="text/css" href="css/valoracion.css">
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
        	<div><h2>Comentario publicado correctamente</h2></div>
        	<div>
        	<a class="button" href="/InicioController"><button type="button" class="read_more"> Vuelve al inicio</button></a>
        	</div> 
        	<h4>El comentario es: <c:out value="${message}"/></h4> 
		</div>
	</div>     
       
    </div>
</body>
</html>