<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">

<meta charset="ISO-8859-1">
<title>Azuriranje informacija</title>
</head>
<body>
<div class="sidenav">
	<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
</div>
	<div class="main">
		<img src="${pageContext.request.contextPath}/img/image.jpg"
			class="center" />
		<div class="center" style="font-size: 25px; text-align: center;">
		<br><br>
			<form action="/Kladionica/kontroler/azuriraj" method="get">
				<table>
					<tr>
						<td>Datum</td>
						<td><input type="date" name="datum"
							placeholder="Unesite korisnicko ime"></td>
					</tr>
					<tr>
						<td>Sport</td>
						<td>
							<select name="sport">
								<c:forEach items="${sportovi }" var="s">
									<option value="${s.idSport }">${s.naziv }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					  <tr>
						<td>Kvote</td>
						<td>Pobeda domacina: <input type="tel" name="kec" step="0.1" min="0" max="10"></td>
						<td>Neresen rezultat: <input type="tel" name="x" step="0.1" min="0" max="10"></td>
						<td>Pobeda gosta: <input type="tel" name="dvojka" step="0.1" min="0" max="10"></td>
					</tr> 
					<tr>
						<td><input type="submit" value="Azuriraj" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<br> <br>
	${poruka }
</body>
</html>