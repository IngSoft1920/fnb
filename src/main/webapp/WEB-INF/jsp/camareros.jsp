8<%@page import="org.apache.coyote.Request"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lan="es">
<head>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
	
<meta charset="utf-8">
<!--Para decodificación de caracteres especiales -->
<title>CAMAREROS :</title>
<!--Título-->
<!--link rel="stylesheet" type="text/css" href="./css/estilo1.css"-->
<style><%@include file="./css/estilo1.css"%>
</style>
<!--carpeta donde se encuentra el estilo css-->
<body>
	<header class="header">
		<!-- La parte de arriba de la página web-->
		<%! String t1; %>
				<%
				t1=request.getParameter("text1");
				%>
		<div id="encabezado">
			<div id="logo">PORTAL CAMAREROS</div>

			<div id="menu">
				<ul>
					<!-- LI= lista de caracteres desordenada-->
					<li><a href="#" class="activate-menu">Inicio</a></li>
					<li><a href="#" class="enlace">Platos</a></li>
					<li><a href="#" class="enlace">Bebida</a></li>
					<li><a href="#" class="enlace">Formulario a completar</a></li>
				</ul>
			</div>
		</div>
	</header>

	<section id="principal">
		<section id="publicaciones">
			<article class="post">

				<a href="" class="enlace-post">
					<h2 class="titulo-post">Platos</h2>
				</a>
				<c:forEach items="${comandaBean.getCantidades().entrySet()}"
					var="item">
					<li><label>${item.getKey()} 
						<c:set var="val" value="${item.getValue().getUnidades()}" /> 
						<c:if
							test="${val != '0'}">
    									${item.getValue().getUnidades()}
  									</c:if>
  									</label>

						<form method="POST" action="anadirItem">
							<input type="hidden" name="platoNuevo"
								value="${item.getValue().getId()}" /> <input type="submit" class="leer-mas"
								value="+">
								<input type="hidden" name="numMesa" value=<%=t1%>> <br>
							</form>
							<form method="POST" action="quitarItem">
							<input type="hidden" name="platoNuevo"
								value="${item.getValue().getId()}" /> <input type="submit" class="leer-mas"
								value="-">
								<input type="hidden" name="numMesa" value=<%=t1%>> <br>
						</form>
					</li>
				</c:forEach>
				<br>

			</article>

		</section>

		<section id="publicaciones">
			<article class="post">

				<a href="" class="enlace-post">
					<h2 class="titulo-post">Bebida</h2>
				</a>

				<c:forEach items="${comandaBean.getBebidas().entrySet()}" var="item">
					<li><label>${item.getKey()} 
						 <c:set var="val" value="${item.getValue().getUnidades()}" /> 
						<c:if
							test="${val != '0'}">
    									${item.getValue().getUnidades()}
  									</c:if>
  									
  									</label>
						<form method="POST" action="anadirBebida">
							<input type="hidden" name="bebidaNueva"
								value="${item.getValue().getId()}" /> <input type="submit" class="leer-mas"
								value="+">
								<input type="hidden" name="numMesa" value=<%=t1%>> <br>
						</form>
						<form method="POST" action="quitarBebida">
							<input type="hidden" name="bebidaNueva"
								value="${item.getValue().getId()}" /> <input type="submit" class="leer-mas"
								value="-">
								<input type="hidden" name="numMesa" value=<%=t1%>> <br>
						</form>
					</li>
				</c:forEach>

			</article>

		</section>

		<section id="publicaciones">
			<article class="post">

				<a href="" class="enlace-post">
					<h2 class="titulo-post">Formulario a completar</h2>
				</a>
				
				<p class="parrafo-post">Mesa
				<form method="POST" action="enviarComanda">
					<input type="hidden" name="fecha"> 
					<input type="hidden" name="numMesa" value="${comandaBean.getNumMesa()}"> <br> <input
						type="submit" value="Enviar comanda">
				</form>
				
				
			</article>

		</section>
<section id="sidebar">
  <section id="informacion">
    <h2 class="encabezado-sidebar"> Información </h2>
    <h4> Adrián José García</h4>
    <p> Alérgico a la fruta y legumbres. </p>

    <h4> Miriam Sánchez</h4>
    <p> Alérgica al gluten. </p>



  </section>

</section>
	</section>




</body>

</html>
