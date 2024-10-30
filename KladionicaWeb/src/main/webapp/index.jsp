<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>KLADIONICA</title>
</head>
<body>

	<sec:authorize access="!hasAnyRole('gost', 'radnik', 'kladionicar')">
		<div class="main">
			<img src="${pageContext.request.contextPath}/img/image.jpg"
				class="center" /> <br> <br>
			<div class="center" style="font-size: 25px; text-align: center;">
				<c:if test="${empty korisnik}">
					 Dobrodosli na sajt nase kladionice.  <br /> Kako
						biste nastavili sa radom, molimo prijavite se klikom na <a
						href="/Kladionica/kontroler/loginPage"><i>Link</i></a>
					
				</c:if>
				<c:if test="${!empty korisnik}">
					<i> Dobrodosli na sajt nase kladionice, ${korisnik.ime} <br>
					</i>
				</c:if>
			</div>
		</div>
	</sec:authorize>

	<div class="sidenav">
		<a href="/Kladionica/kontroler/getSportTim">Unos utakmice</a> <a
			href="/Kladionica/kontroler/izborUtakmice">Brisanje utakmice</a> <a
			href="/Kladionica/kontroler/odabirUtakmice">Azurizanje informacija o utakmici</a>
			 <a href="/Kladionica/kontroler/getSveUtakmice">Prikaz svih utakmica</a>
		<c:if test="${empty korisnik}">
			<a href="/Kladionica/kontroler/loginPage">Prijavite se</a>
		</c:if>
		
		


		<sec:authorize access="isAuthenticated()">	<%-- korisnik koji je prijavljen --%>
			<c:if test="${korisnik.uloga.nazivUloga eq 'zaposleni'}">
				<a href="/Kladionica/kontroler/getSportTim">Unos utakmice</a>
				<a href="/Kladionica/kontroler/izborUtakmice">Brisanje utakmice</a>
				<a href="/Kladionica/kontroler/odabirUtakmice">Azurizanje
					informacija o utakmici</a>
				<a href="/Kladionica/kontroler/getSviTiketi">Prikaz svih tiketa
					u bazi</a>
				
				
			</c:if>


			<a href="/Kladionica/kontroler/getKorisniciIUtakmice">Popunjavanje tiketa</a>
			<a href="/Kladionica/kontroler/prikazSvihTiketaKorisnika">Prikaz svih tiketa korisnika</a>
			<a href="/Kladionica/kontroler/logout">Odjava</a>
		</sec:authorize>

	</div>


</body>
</html>