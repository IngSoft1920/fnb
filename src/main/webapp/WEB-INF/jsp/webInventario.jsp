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
       Inventario
      </div>

      <div id="menu">
        <ul> <!-- LI= lista de caracteres desordenada-->
          <li><a href="#" class="activate-menu">Inicio</a></li>
          <li><a href="#" class="enlace">Reserva</a></li>
          

        </ul>
      </div>
    </div>
  </header>



<section id="publicaciones">

			<article class="post">
			<table border="1"> 
			<tr>
	        <th>ingrediente</th>
	        <th>cantidad</th>
	        <th> unidades </th>
	        </tr>
	        <tbody>
	        
			<c:forEach items="${inventarioBean.getListaInventario()}" var="ingrediente">
			<tr>
			
	        <td>${ingrediente.getIngrediente().getNombre()} </td>  
	        <td> ${ingrediente.getCantidad()}</td> 
			<td>${ingrediente.getUnidad()}</td>
			</tr>
			
			</c:forEach>
			
			
		</tbody>
		</table>
		
		</article>
			
		</section>
</body>