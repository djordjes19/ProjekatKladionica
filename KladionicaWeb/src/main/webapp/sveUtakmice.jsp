<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>Sve utakmice</title>
</head>
<body>
<div class="sidenav">
	
	<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
</div>
<div class="main">
	<img src="${pageContext.request.contextPath}/img/image.jpg" class="center"/>
<div class="center">
 <c:if test="${!empty utakmice }">
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Sport</th>
			<th>Tim 1</th>
			<th>Tim 2</th>
		</tr>
		<c:forEach items="${utakmice}" var="u">
			<tr>
				<td>${u.datumUtakmice}</td>
				<td>${u.sport.naziv}</td>
				<td>${u.tim1.naziv}</td>
				<td>${u.tim2.naziv}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<br>
	<form action="/Kladionica/kontroler/prikazZaSport" method="post">
		<table>
			<tr>
				<td>Izaberite sport: </td>
			</tr>
			<tr>
				<td>
					<select name="sportId">
						<c:forEach items="${sportovi }" var="s">
							<option value="${s.idSport }">${s.naziv }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Prikazi"><td />
			</tr>
		</table>
	</form>
	<br>
	<form action="/Kladionica/kontroler/prikazZaTim" method="post">
		<table>
			<tr>
				<td>Izaberite tim: </td>
			</tr>
			<tr>
				<td>
					<select name="timId">
						<c:forEach items="${timovi}" var="t">
							<option value="${t.idTim}">${t.naziv}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Prikazi"><td />
			</tr>
		</table>
	</form>
	<br>
	<c:if test="${!empty utSport }">
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Sport</th>
			<th>Tim 1</th>
			<th>Tim 2</th>
		</tr>
		<c:forEach items="${utSport}" var="u">
			<tr>
				<td>${u.datumUtakmice}</td>
				<td>${u.sport.naziv}</td>
				<td>${u.tim1.naziv}</td>
				<td>${u.tim2.naziv}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<br><br>
	<c:if test="${!empty utTim }">
	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Sport</th>
			<th>Tim 1</th>
			<th>Tim 2</th>
		</tr>
		<c:forEach items="${utTim}" var="u">
			<tr>
				<td>${u.datumUtakmice}</td>
				<td>${u.sport.naziv}</td>
				<td>${u.tim1.naziv}</td>
				<td>${u.tim2.naziv}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<br><br>
	</div>
</div>

</body>
</html>