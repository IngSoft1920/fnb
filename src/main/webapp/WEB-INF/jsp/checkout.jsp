<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lan="es">
<head>
<meta charset="utf-8">
<!--Para decodificaciÃ³n de caracteres especiales -->
<title>METRE :</title>
<!--TÃ­tulo-->
<link rel="stylesheet" type="text/css" href="css/estilo2.css">
<style><%@include file="./css/estilo2.css"%></style>
<!--carpeta donde se encuentra el estilo css-->


</head>

<body>
	<header class="header">
		<!-- La parte de arriba de la pÃ¡gina web-->
		<div id="encabezado">
			<div id="logo">CHECK OUT</div>

			<div id="menu">
				<ul>
					<!-- LI= lista de caracteres desordenada-->
					<li><a href="#" class="activate-menu">Inicio</a></li>
					<li><a href="mesas" class="enlace">Mesas</a></li>

				</ul>
			</div>
		</div>
	</header>

	
				<c:set var="val" value="${tareasBean.getListaComandasListas().isEmpty()}" /> 
						<c:if
							test="${val != true}">
    									
  									
				<c:forEach
				
						items="${tareasBean.getListaComandasListas()}" var="entry">
		<section id="publicaciones">
			<article class="post">

				<form method="POST" action="chekinOut">
						<h2 class="titulo-post">Mesa ${entry.getMesa().getNum_mesa()}</h2>
						<p>  Comanda ${entry.getComanda_id()}  </p>
						<input type="hidden" name="checkOut" value="${entry.getComanda_id()}">
							<input type="submit" value="CheckOut"
								/>
						</form>

				
						
								</article>
			
					</section>
					</c:forEach>
							
			</c:if>
			<c:if
							test="${val != false}">
							
							No hay mas tareas
							
			</c:if>