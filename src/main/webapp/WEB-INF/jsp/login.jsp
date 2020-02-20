<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> LOGIN  : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/estilo4.css"> <!--carpeta donde se encuentra el estilo css-->
<style><%@include file="./css/estilo2.css"%></style>

</head>

<body>
  <header class="header"> <!-- La parte de arriba de la página web-->
    <div id="encabezado">
      <div id="logo">
        LOG IN
      </div>
      <div id="menu">
        <ul> <!-- LI= lista de caracteres desordenada-->
          <li><a href="#" class="activate-menu">Inicio</a></li>
        </ul>
      </div>
    </div>
  </header>

  <section id="principal">
<section id="publicaciones">
  <article class="post">

    <a href="" class="enlace-post">
      <h2 class="titulo-post">Inicio</h2>
    </a>
	<form method="GET" action="entrar">
    <p class="parrafo-post">
      Nombre de usuario
     
        <input type="text" name="username" placeholder="Escribe aqui">

      
    </p>


    <p class="parrafo-post">
      Contraseña
     
        <input type="password" name="pass" placeholder="Escribe aqui">

     
    </p>
    <p>
      
		 <input type="submit" value="Enviar">
						</form> 
  </article>

</section>

<c:set var="val" value="${loginBean.getHabilitated()}" /> 
						<c:if
							test="${val eq 'true'}">
    									<label> errooooor!</label>
  									</c:if>


</section>
  </section>



</body>

</html>
