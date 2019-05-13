<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Wikifilm</title>
<link rel="stylesheet" type="text/css" href="css/header.css">
</head>
<body>
    <div class = "main">
        <center>
        <div class="header">
            <div class="header_box">
                <div class="title">
                    <a href=""><b>WikiFilm</b><img src="images/Logo3.png" width="100" height="100"></a>
                </div>
            </div>
            <div class="searchDiv">
			    <form id="searchForm" action="SearchController" method="post">
				    <input type="text" name="searchQuery" required/> 
				    <input type="hidden" name="sesionId" value="${requestScope.sessionId}"/>
				    <input type="submit" name="searchBtn" title="search" value="search">
				    
			    </form>
			    
			   <form id="searchForm" method="post" class="listaForm" action="/TMDBRegistryController">
				<input type='submit' name='Logueate en TMDB' title="Logueate en TMDB" value="logeate"/>
				</form>	
				
				  <form id="searchF" method="post" class="listaF" action="/InicioController">
				<input type='submit' name='Logueate' title="Logueate" value="Mas Popular"/>
				</form>	
            </div>
        </div>
        </center>
       <fieldset>
        <legend>Mas Popular:</legend>
        	
        	<c:forEach items="${requestScope.movie}" var="popular"
        	begin="${param.first}"  end="${param.first + noOfRows -1}">
			<h3><c:out value="${popular.title}"/></h3>
			<img src="https://image.tmdb.org/t/p/w185/${popular.posterPath}"/>
				
        	</c:forEach>
        </fieldset>
    </div>
</body>
</html>