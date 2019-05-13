<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>
<body>
	<fieldset id="aliexpress">
		<legend>
			Productos de <c:out value="${requestScope.title}" />
		</legend>
		<c:forEach items="${requestScope.products}" var="producto" begin="1" end="5">
			<a target="_blank" href="<c:out value="${producto.productUrl}"/>">${producto.productTitle}</a>
			<img src="<c:out value = "${producto.imageUrl}"/>" height="314"
				width="350" />
			<br><br>
			<div style="text-align: center;">
			<span style="font-size: 24px; font-family: arial; color:#f60; font-weight: 700; align: center; "><c:out value="${producto.localPrice}"/></span>
			</div>
			<br>
			<br>
		</c:forEach>
	</fieldset>
</body>
</html>