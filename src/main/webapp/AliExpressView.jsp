<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Productos</title>
</head>

 <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <!-- Custom styles for this template -->
 <link href="css/landing-page.min.css" rel="stylesheet">
 
<body>
<div class="masthead text-black text-center">
    <div class="overlay"></div>
    <div class="container">
      <div class="row">
 <div class="col-xl-9 mx-auto">
			<div style="text-align: center;">
			<h2 class="mb-3">Productos de <c:out value="${requestScope.title}" /></h2>
			</div>
		<c:forEach items="${requestScope.products}" var="producto" begin="1" end="5">
			<h6><a>${producto.productTitle}</a></h6>
			<a href="<c:out value="${producto.productUrl}"/>" target="_blank">
			<img style="width:450px; height:250px;" src="<c:out value = "${producto.imageUrl}"/>"></a>
			<br><br>
			<div style="text-align: center;">
			<span style="font-size: 28px; font-family: arial; color:#f60; font-weight: 700; align: center; "><c:out value="${producto.localPrice}"/></span>
			</div>
			<br>
			<br>
		</c:forEach>
		</div>
		</div>
		</div>
		</div>
		<!-- Bootstrap core JavaScript -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>        
		
</body>
</html>
