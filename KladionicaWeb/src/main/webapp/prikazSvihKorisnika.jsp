<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>Svi korisnici</title>
</head>
<body>
	<div class="sidenav">
		
		<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
	</div>
	<div class="main">
		<img src="${pageContext.request.contextPath}/img/image.jpg"
			class="center" />
		<div class="center">
			<c:if test="${!empty korisnici }">
				<table border="1">
					<tr>
						<th>Id</th>
						<th>Ime i prezime</th>
						<th>Adresa</th>
						<th>Korisnicko ime</th>
					</tr>
					<c:forEach items="${korisnici }" var="k">
						<tr>
							<td>${k.idKorisnika }</td>
							<td>${k.ime } ${k.prezime }</td>
							<td>${k.adresa }</td>
							<td>${k.korisnickoIme }</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				

				<c:if test="${!empty dobitnici }">
					<table border="1">
					<tr>
						<th>Id</th>
						<th>Ime i prezime</th>
						<th>Adresa</th>
						<th>Korisnicko ime</th>
					</tr>
					<c:forEach items="${dobitnici }" var="k">
						<tr>
							<td>${k.idKorisnika }</td>
							<td>${k.ime } ${k.prezime }</td>
							<td>${k.adresa }</td>
							<td>${k.korisnickoIme }</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
			</c:if>
		</div>
	</div>

</body>
</html>