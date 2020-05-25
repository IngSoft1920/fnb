<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<meta http-equiv="refresh" content="30; URL= ${request.getHeader()}/cocina">
<html lan="es">
<head>
<meta charset="utf-8">
<!--Para decodificaciÃ³n de caracteres especiales -->
<title>COCINEROS :</title>
<!--TÃ­tulo-->
<link rel="stylesheet" type="text/css" href="css/estilo2.css">
<style><%@include file="./css/estilo2.css"%></style>
<!--carpeta donde se encuentra el estilo css-->


</head>

<body>
	<header class="header">
		<!-- La parte de arriba de la pÃ¡gina web-->
		<div id="encabezado">
			<div id="logo">PORTAL COCINERO</div>

			<div id="menu">
				<ul>
					<!-- LI= lista de caracteres desordenada-->
					<li><a href="#" class="activate-menu">Inicio</a></li>
					<li><a href="#" class="enlace">Comandas</a></li>
					<li><a href="inventario" class="enlace">Inventario</a></li>

				</ul>
			</div>
		</div>
	</header>

	
				<c:set var="val" value="${tareasBean.getLista().isEmpty()}" /> 
						<c:if
							test="${val != true}">
    									
  									
				<c:forEach
				
						items="${tareasBean.getLista()}" var="entry">
		<section id="publicaciones">
			<article class="post">

				
						<h2 class="titulo-post">Comanda ${entry.getIdMesa()}</h2>
						<form method="POST" action="quitarTarea">
							 <input type="hidden" name="pedidoAtendido" value="${entry.getIdMesa()}">
							<input type="submit" value="Tarea Lista"
								/>
						</form>

				
						<c:forEach
							items="${entry.getListaPlatos().entrySet()}"
							var="platos">
							
								<p class="parrafo-post">${platos.getKey()} - ${platos.getValue().getUnidades()}</p>
						</c:forEach>
						
						<p class="parrafo-post">${entry.getHora().getMinute()}</p>
						<%/* 
						<c:forEach
							items="${entry.getValue().getListaBebidas().entrySet()}"
							var="bebidas">
							
								<p class="parrafo-post">${bebidas.getKey()} - ${bebidas.getValue().getUnidades()}</p>

							
						</c:forEach>
						
						*/%>
								</article>
			
					</section>
					</c:forEach>
			</c:if>
			<c:if
							test="${val != false}">
							
							No hay mas tareas
							
			</c:if>
			
			
	
	</body>