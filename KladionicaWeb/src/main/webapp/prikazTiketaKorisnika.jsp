<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>Tiketi odredjenog korisnika</title>
</head>
<body>
<div class="sidenav">
	
	<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
</div>
<div class="main">
	<img src="${pageContext.request.contextPath}/img/image.jpg" class="center"/>
<div class="center">
 <c:if test="${!empty tiketiKor }">
 <p>Tiketi korisnika ${korisnik.ime } ${korisnik.prezime }</p>
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Uplata</th>
		</tr>
		<c:forEach items="${tiketiKor }" var="t">
			<tr>
				<td>${t.datumTIketa}</td>
				<td>${t.uplata}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	</div>
</div>

</body>
</html>