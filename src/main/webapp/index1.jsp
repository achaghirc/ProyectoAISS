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
				    <p>Estas Logueado</p>
				    <c:forEach items="${requestScope.sessionId}" var="sesion">
				   	<p>SesionId: <c:out value="${sesion}"/></p>
				   	</c:forEach>
			    </form>
            </div>
        </div>
        </center>
    </div>
</body>
</html>