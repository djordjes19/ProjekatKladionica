<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Date"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">

<meta charset="ISO-8859-1">
<title>Unos tiketa</title>
</head>
<body>
	<c:set var="today" value="<%=new Date()%>" />
	<div class="sidenav">
		<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
	</div>

	<div class="main">
		<img src="${pageContext.request.contextPath}/img/image.jpg"
			class="center" />
		<div class="center" style="font-size: 20px; text-align: left;">

			<form action="/Kladionica/kontroler/saveTiket" method="post">
				<table>
					<tr>
						<td>Datum</td>
						<td><input type="date" name="datumTIketa"
							value='<fmt:formatDate pattern="yyyy-MM-dd" value="${today}"/>' /></td>
					</tr>
					<tr>
						<td>Potvrdite svoj id</td>
						<td><select name="idKorisnika">
								<c:forEach items="${svikorisnici}" var="k">
									<option value="${k.idKorisnika}">${k.idKorisnika}</option>
								</c:forEach>
						</select></td>
					</tr>
					
					<tr>
						<td>Uplata</td>
						<td><input type="tel" name="uplata" step="10" min="10" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Sacuvaj">
						<td />
					</tr>
				</table>
			</form>
			<br> ${porukaTiket}
		</div>
	</div>
</body>
</html>