<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lan="es">
<head>

  <meta charset="utf-8">	<!--Para decodificaci�n de caracteres especiales -->
  <title> METRECONFIRMACION : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/estilo3.css"> <!--carpeta donde se encuentra el estilo css-->
<style><%@include file="./css/estilo3.css"%></style>

</head>

<body>
  <header class="header"> <!-- La parte de arriba de la pï¿½gina web-->
    <div id="encabezado">
      <div id="logo">
        PORTAL METRE
      </div>

      <div id="menu">
        <ul> <!-- LI= lista de caracteres desordenada-->
          <li><a href="#" class="activate-menu">Inicio</a></li>
          <li><a href="#" class="enlace">Confirmación</a></li>


        </ul>
      </div>
    </div>
  </header>

  <section id="principal">
    <section id="publicaciones">
      <article class="post">
        
          <h2 class="titulo-post">Confirmar asignación</h2>
        

        <p class="parrafo-post">
          MESA ${confirmacionBean.getMesa()}
          </p>

          <p class="parrafo-post">

          ${confirmacionBean.getNumPersonas()} personas

          </p>

          <p class="parrafo-post">

          ${confirmacionBean.getHab()}

          </p>

          <p class="parrafo-post">
          <form action="denegar" method="get">
          
            <input type="submit" class="leer-mas1" value="Denegar"> 
            </form>
            <form action="confirmar" method="get">
            <input type="hidden" name="habitacion" value="${confirmacionBean.getHab()}">
             <input type=hidden name="idMesa" value="${confirmacionBean.getMesa()}">
            <input
             type=submit class="leer-mas1" value="Confirmar">
			</form>
          </p>






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
