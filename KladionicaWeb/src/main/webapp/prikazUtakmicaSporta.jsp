<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>Sve utakmica sporta</title>
</head>
<body>
<div class="sidenav">
	<%-- <a href="/Kladionica/kontroler/getSveUtakmice">Prikaz svih utakmica</a>--%>
	<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
</div>
<div class="main">
	<img src="${pageContext.request.contextPath}/img/image.jpg" class="center"/>
<div class="center">
 <c:if test="${!empty us }">
 	<table border="1">
		<tr>
			<th>Datum</th>
			<th>Sport</th>
			<th>Timovi</th>
		</tr>
		<c:forEach items="${us }" var="ut">
			<tr>
				<td>${ut.datumUtakmice }</td>
				<td>${ut.sport.naziv }</td>
				<td>
					<c:forEach items="${ut.tims }" var="t">
						${t.naziv} <br>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	</div>
</div>

</body>
</html>