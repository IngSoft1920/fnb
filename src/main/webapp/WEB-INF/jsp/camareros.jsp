<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<link rel="stylesheet" type="text/css" href="css/estilo1.css">
<!--carpeta donde se encuentra el estilo css-->
<body>
	<header class="header">
		<!-- La parte de arriba de la página web-->
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
					<h2 class="titulo-post">Menu</h2>
				</a>
				<c:forEach items="${comandaBean.getCantidades().entrySet()}"
					var="item">
					<li>${item.getKey()}-${item.getValue().getUnidades()}
						<form method="POST" action="anadirItem">
							<input type="hidden" name="platoNuevo"
								value="${item.getValue().getId()}" /> <input type="submit"
								value="+">
						</form>
						<form method="POST" action="quitarItem">
							<input type="hidden" name="platoNuevo"
								value="${item.getValue().getId()}" /> <input type="submit"
								value="-">
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
					<li>${item.getKey()}-${item.getValue().getUnidades()}
						<form method="POST" action="anadirBebida">
							<input type="hidden" name="bebidaNueva"
								value="${item.getValue().getId()}" /> <input type="submit"
								value="+">
						</form>
						<form method="POST" action="quitarBebida">
							<input type="hidden" name="bebidaNueva"
								value="${item.getValue().getId()}" /> <input type="submit"
								value="-">
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
				<form>
					<input type="text" name="Clientes" placeholder="Escribe aqui">
					<button class="boton">Ok</button>
				</form>
				</p>


				
			</article>

		</section>


		<form method="POST" action="enviarComanda">

			<input type="submit" value="Enviar comanda">
		</form>

	</section>
	</section>



</body>

</html>
