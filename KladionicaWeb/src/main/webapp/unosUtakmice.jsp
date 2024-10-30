<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">

<meta charset="ISO-8859-1">
<title>Unos utakmice</title>
</head>
<body>

	<div class="sidenav">
		<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
	</div>

	<div class="main">
		<img src="${pageContext.request.contextPath}/img/image.jpg"
			class="center" />
		<div class="center" style="font-size: 20px; text-align: left;">

			<form action="/Kladionica/kontroler/saveUtakmica" method="post">
				<table>
					<tr>
						<td>Datum</td>
						<td><input type="date" name="datum" /></td>
					</tr>
					<tr>
						<td>Sport</td>
						<td><select name="sport">
								<c:forEach items="${sportovi }" var="s">
									<option value="${s.idSport }">${s.naziv }</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Tim 1</td>
						<td><select name="tim1">
								<c:forEach items="${timovi }" var="t">
									<option value="${t.idTim }">${t.naziv}</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>Tim 2</td>
						<td><select name="tim2">
								<c:forEach items="${timovi }" var="t">
									<option value="${t.idTim }">${t.naziv}</option>
								</c:forEach>
						</select></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Sacuvaj">
						<td />
					</tr>
				</table>
			</form>
			 ${poruka} <br> <br><br>
			<c:if test="${!empty novaUt}">
			<br>
				
				<br> ${porKvota} <br> <br>
			</c:if>			
		</div>
	</div>
</body>
</html>