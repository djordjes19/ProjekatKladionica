<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>Svi tiketi</title>
</head>
<body>
<div class="sidenav">
	
	<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
</div>
<div class="main">
	<img src="${pageContext.request.contextPath}/img/image.jpg" class="center"/>
<div class="center">
 <c:if test="${!empty tiketi }">
 	<br><br>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Datum</th>
			<th>Korisnik</th>
			<th>Uplaceno novca</th>
			<th></th>
		</tr>
		<c:forEach items="${tiketi }" var="t">
			<tr>
				<td>${t.idTiket }</td>
				<td>${t.datumTIketa }</td>
				<td>${t.registrovanikorisnik.ime } ${t.registrovanikorisnik.prezime }</td>
				<td>${t.uplata}</td>
				<td><a href="/Kladionica/kontroler/prikaziTiket?idTiketa=${t.idTiket}">Prikazi</a></td> 				
			</tr>
		</c:forEach>
	</table>
	<br><br>
	</c:if>
	</div>
</div>

</body>
</html>