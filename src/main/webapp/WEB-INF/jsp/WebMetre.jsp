<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificaci�n de caracteres especiales -->
  <title> METRE  : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/estilo3.css"> <!--carpeta donde se encuentra el estilo css-->
<style><%@include file="./css/estilo3.css"%></style>

</head>

<body>
  <header class="header"> <!-- La parte de arriba de la página web-->
    <div id="encabezado">
      <div id="logo">
        PORTAL METRE
      </div>

      <div id="menu">
        <ul> <!-- LI= lista de caracteres desordenada-->
          <li><a href="#" class="activate-menu">Inicio</a></li>
          <li><a href="#" class="enlace">Reserva</a></li>
          <li><a href="#" class="enlace">Modificacion de carta</a></li>
         

        </ul>
      </div>
    </div>
  </header>

  <section id="principal">
    <section id="publicaciones">
      <article class="post">

        <a href="" class="enlace-post">
          <h2 class="titulo-post">Reserva</h2>
        </a>

        <p class="parrafo-post">
          <a href="metremesas" class="leer-mas"> Mesas disponibles </a>
        </p>

      </article>
    </section>

  </section>
