<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">

<meta charset="ISO-8859-1">
<title>Izbor utakmice za azuriranje</title>
</head>
<body>
<div class="sidenav">
	<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
</div>

<div class="main">
<img src="${pageContext.request.contextPath}/img/image.jpg" class="center"/>
<div class="center">
<c:if test="${!empty utakmice }">
<form action="/Kladionica/kontroler/brisanjeUtakmice" method="get">
	Odaberite utakmicu za brisanje <br><br>
	<select name="utakmica">
		<c:forEach items="${utakmice}" var="u">
			<option value="${u.idUtakmica}">${u.tim1.naziv} - ${u.tim2.naziv} -- ${u.datumUtakmice} </option>
		</c:forEach>
	</select><br>
	<input type="submit" value="OK"/>
	</form>

</c:if>
</div>
</div>

</body>
</html>