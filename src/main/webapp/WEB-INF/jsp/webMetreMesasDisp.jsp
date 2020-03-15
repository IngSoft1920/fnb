<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificación de caracteres especiales -->
  <title> METREMESASDISP : </title> <!--Título-->
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
          <li><a href="#" class="enlace">Mesas disponibles</a></li>


        </ul>
      </div>
    </div>
  </header>

  <section id="principal">
    <section id="publicaciones">
      <article class="post">

      <a href="" class="enlace-post">
        <h2 class="titulo-post">Mesas disponibles</h2>
        </a>


        <table border="1">
          <thead>
          <tr>
            <th>Mesas</th>
            <th>Nº personas</th>
            <th>Asignación mesas</th>
            <th>Confirmación</th>

          </tr>
          </thead>

          <tbody>

			<c:forEach items="${listaReservasBean.getListaMesas()}"
					var="item">
                    <tr>
            <td><p class="parrafo-post1">
              <strong><i>Mesa ${item.getNum_mesa()} </i></strong>

            </p>
          </td>
            <td><p class="parrafo-post1">
              <strong><i> ${item.getCapacidad()}</i></strong>

            </p>
          </td>

            <td><p class="parrafo-post">
              <nav class="nav">
              <ul class="menu">
               
              <li><label id="lab1"> ${listaReservasBean.getMapAsign().get(item.getNum_mesa())}
  									</label>
                  <ul class="submenu">
                  
                 <form action="asignarHab" method="GET">
                      <li>
                  	<input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                      <button name="hab1" class="leer-mas" id="hab1" value="Habitacion 1">Habitación 1</button>
                      </form>  
                     <form action="asignarHab" method="GET">
                     <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                      <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 2">Habitación 2</button>
                      </form><form action="asignarHab" method="GET">
                      <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                      <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 3">Habitación 3</button>
                      </form><form action="asignarHab" method="GET">
                      <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                      <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 4<">Habitación 4</button>
                      </form>  
                  </ul>
                 

              </li>
              </ul>
              </nav>
              </p>
            </td>
          </td>
            <td><p class="parrafo-post1">
            <form method="POST" action="alojarMesa" >
        	<input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
              <input type="submit" class="leer-mas" value="OK">
				</form>
            </p>
          </td>

          </tr>
		</c:forEach>
          </tbody>
        </table>




  </article>
</section>
  </section>
