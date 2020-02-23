<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lan="es">
<head>
<meta charset="utf-8">
<!--Para decodificación de caracteres especiales -->
<title>COCINEROS :</title>
<!--Título-->
<link rel="stylesheet" type="text/css" href="css/estilo2.css">
<style><%@include file="./css/estilo2.css"%></style>
<!--carpeta donde se encuentra el estilo css-->


</head>

<body>
	<header class="header">
		<!-- La parte de arriba de la página web-->
		<div id="encabezado">
			<div id="logo">PORTAL COCINERO</div>

			<div id="menu">
				<ul>
					<!-- LI= lista de caracteres desordenada-->
					<li><a href="#" class="activate-menu">Inicio</a></li>
					<li><a href="#" class="enlace">Comandas</a></li>

				</ul>
			</div>
		</div>
	</header>

	
				<c:set var="val" value="${tareasBean.getListaTareas().entrySet().isEmpty()}" /> 
						<c:if
							test="${val != false}">
    									
  									
				<c:forEach
				
						items="${tareasBean.getListaTareas().entrySet()}" var="entry">
		<section id="publicaciones">
			<article class="post">

				
						<h2 class="titulo-post">Mesa ${entry.getValue().getIdMesa()}</h2>
						<form method="POST" action="quitarTarea">
							 <input type="hidden" name="pedidoAtendido" value="${entry.getKey()}">
							<input type="submit"
								/>
						</form>

				
						<c:forEach
							items="${entry.getValue().getListaPlatos().entrySet()}"
							var="platos">
							
								<p class="parrafo-post">${platos.getKey()} - ${platos.getValue().getUnidades()}</p>
						</c:forEach>

						<c:forEach
							items="${entry.getValue().getListaBebidas().entrySet()}"
							var="bebidas">
							
								<p class="parrafo-post">${bebidas.getKey()} - ${bebidas.getValue().getUnidades()}</p>

							
						</c:forEach>
								</article>
			
					</section>
					</c:forEach>
			</c:if>
		
		<section id="publicaciones">
			<article class="post">

				<a href="" class="enlace-post">
					<h2 class="titulo-post">Mesa 3</h2>
				</a>

				<p class="parrafo-post">
					Macarrones <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Filete de ternera <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Helado de vainilla <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Cerveza con limón <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Fanta de limón <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Coca-cola <input type="checkbox">
				</p>


			</article>

		</section>
		<section id="publicaciones">
			<article class="post">

				<a href="" class="enlace-post"> </a>

				<p class="parrafo-post">
					Macarrones <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Filete de ternera <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Helado de vainilla <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Cerveza con limón <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Fanta de limón <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Coca-cola <input type="checkbox">
				</p>


			</article>

		</section>
		<section id="publicaciones">
			<article class="post">

				<a href="" class="enlace-post">
					<h2 class="titulo-post">Mesa 4</h2>
				</a>

				<p class="parrafo-post">
					Macarrones <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Filete de ternera <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Helado de vainilla <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Cerveza con limón <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Fanta de limón <input type="checkbox">
				</p>

				<p class="parrafo-post">
					Coca-cola <input type="checkbox">
				</p>


			</article>

		</section>
	
	</body>