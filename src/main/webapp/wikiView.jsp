<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><c:out value="${requestScope.wiki.parse.title}"/></title>
</head>
<body>
	<pre><c:out value="${requestScope.wiki.parse.wikitext.t}"/></pre>
</body>
</html>