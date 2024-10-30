<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>Prikaz tiketa</title>
</head>
<body>
	<div class="sidenav">
		<%-- <a href="/Kladionica/kontroler/getSveUtakmice">Prikaz svih utakmica</a>--%>
		<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
	</div>
	<div class="main">
		<img src="${pageContext.request.contextPath}/img/image.jpg"
			class="center" />
		<div class="center">
			<c:if test="${!empty t }">
				<table border="1">
					<tr>
						<th>Id</th>
						<th>Datum</th>
						<th>Korisnik</th>
					</tr>

					<tr>
						<td>${t.idTiket}</td>
						<td>${t.datumTIketa}</td>
						<td>${t.registrovanikorisnik.ime} ${t.registrovanikorisnik.prezime}</td>
					</tr>
				</table> <br> <br>
				Utakmice i vrednost kvota:
				<c:forEach items="${t.utakmicas}" var="u">
					${u.tim1.naziv} - ${u.tim2.naziv}    vrednost kvote: 
					<c:forEach items="${u.kvotas}" var="k">
						<c:if test="${k.naziv eq 'kec'}">
							${k.vrednost}
						</c:if>
					</c:forEach>
				</c:forEach> <br> <br>
				Uplata: ${t.uplata} <br> <br>
				Ukupan dobitak: ${dobitak}
			</c:if>			
		</div>
	</div>

</body>
</html>