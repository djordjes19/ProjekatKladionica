<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "sf" uri="http://www.springframework.org/tags/form"%>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style/style.css">
<meta charset="ISO-8859-1">
<title>Registracija</title>
</head>
<body>
<div class="sidenav">
	<a href="/Kladionica/kontroler/indexPage">Pocetna stranica</a>
    <a href="/Kladionica/kontroler/loginPage">Prijavite se</a>
</div>

<div class="main">
	<img src="${pageContext.request.contextPath}/img/image.jpg" class="center"/>
<div class="center" style="font-size:20px; text-align:left;">

<sf:form modelAttribute="user" action="register" method="post">
</sf:form>
<form action="/Kladionica/kontroler/register"  method="post">
  <table>
  	<tr>
  	   <td>Ime:</td><td><input type="text" name="ime"/>
  	   </td>
  	</tr>
  	<tr>
  	   <td>Prezime:</td><td><input type="text" name="prezime">
  	   </td>
  	</tr>
  	<tr>
  	   <td>Adresa:</td><td><input type="text" name="adresa">
  	   </td>
  	</tr>
  		<tr>
  	   <td>Korisnicko ime:</td><td><input type="text" name="korisnickoIme">
  	 </td>
  	</tr>
  	<tr>
  	   <td>Sifra:</td><td><input type="password" name="sifra"></td>
  	</tr>
  	<tr>
  	  <td>
  	   Uloga
  	  </td>
  	  <td>
  	  	<select name="uloga">
  	 		<c:forEach items="${uloge}" var="u">
  	 			<option value="${u.idUloga}">${u.nazivUloga}</option>
  	 		</c:forEach>
  	 	</select>
	   </td>
	</tr>
  	<tr><td/><td><input type="submit" value="Sacuvaj"></tr>
  	</table>
</form>
</div>
</div>

</body>
</html>