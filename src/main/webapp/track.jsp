<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cancion</title>
</head>
<body>
	<h1>Canción:</h1>
	<div class="Titulo_Canción">
		<h2><c:out value="${requestScope.Track.title}" /></h2>
	</div>
	
	<div class="Url_Video">
		<h2><c:out value="${requestScope.Track.videoUrl}"/></h2>
	</div>
		
</body>
</html>