<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lan="es">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> CAMAREROS  : </title> <!--Título-->
  <link rel="stylesheet" type="text/css" href="css/estilo1.css"> <!--carpeta donde se encuentra el estilo css-->

<style><%@include file="./css/estilo1.css"%>
</style>
</head>

<body>
  <header class="header"> <!-- La parte de arriba de la página web-->
    <div id="encabezado">
      <div id="logo">
        PORTAL CAMAREROS
      </div>

      <div id="menu">
        <ul> <!-- LI= lista de caracteres desordenada-->
          <li><a href="#" class="activate-menu">Inicio</a></li>
            <li><a href="#" class="enlace">Formulario a completar</a></li>
          <li><a href="#" class="enlace">Platos</a></li>
          <li><a href="#" class="enlace">Bebida</a></li>

        </ul>
      </div>
    </div>
  </header>

<section id="principal">
  <section id="publicaciones">
    <article class="post">

    
        <h2 class="titulo-post">Formulario a completar</h2>
      
      <c:forEach items="${mesaBean.getListaMesas()}"
					var="item">
					
	
	<script type="text/javascript">
	
	$(function(){
		var m=${item};
		 $("#"+m).click(function () {
			
		    if ($(this).prop("checked")) {
		    	var i=$(this).attr("id");
		        $("#text1").val(""+i);
		    }
		   
		});
		} );
	</script>
	<form action="camareros" method="post">
	<input type="submit" class="leer-mas" id="${item}" value="Mesa ${item}"/>
	<input type="hidden"  id="text1" name="text1" value="${item}" />
	 <%
				String textMesa=request.getParameter("text1");
				
				%>
	
	</form>
	</c:forEach>


  	
	
    </article>

  </section>
  <section id="publicaciones">
    <article class="post">

        <h2 class="titulo-post"> Tareas pendientes </h2>
      


        <p class="parrafo-post">
          <input type="checkbox">
          Llevar comanda habitación 1

        </p>

        <p class="parrafo-post">
          <input type="checkbox">
        Llevar comanda habitación 2

        </p>

        <p class="parrafo-post">
          <input type="checkbox">
        Llevar comanda habitación 3

        </p>

        <p class="parrafo-post">
          <input type="checkbox">
        Llevar comanda habitación 4


        </p>


    </article>

  </section>

</section>
