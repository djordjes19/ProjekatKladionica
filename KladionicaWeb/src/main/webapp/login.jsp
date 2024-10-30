<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<meta charset="UTF-8">
<title>Prijava</title>
</head>


<body>
<div class="sidenav">
	<a href="/Kladionica/kontroler/getSveUtakmice">Prikaz svih utakmica</a>
    <a href="/Kladionica/kontroler/registracija">Registrujte se</a>
</div>

<div class="main">
	<img src="${pageContext.request.contextPath}/img/image.jpg" class="center"/>
	<div class="center" style="font-size:25px; text-align:center;">

	<c:url var="loginUrl" value="/login" />
	<c:if test="${not empty param.error}">
		<div class="alert alert-danger">
			<p>Pogresni podaci.</p>
		</div>
	</c:if>
	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td>Korisnicko ime</td>
				<td><input type="text" name="username"
					placeholder="Unesite korisnicko ime" required></td>
			</tr>
			<tr>
				<td>Sifra</td>
				<td><input type="password" name="password"
					placeholder="Unesite sifru" required></td>
			</tr>
			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
				<td><input type="submit" value="Prijava"></td>
			</tr>
		</table><br/><br/>
		Nemate nalog? <a href="/Kladionica/kontroler/registracija">Registrujte se</a>
	</form>
	</div>
</div>
	
</body>
</html>