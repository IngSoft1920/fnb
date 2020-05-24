<%@page import="org.apache.coyote.Request"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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

    
        <h2 class="titulo-post">Mesas disponibles</h2>
        
	

        <table border="1">
          <thead>
          <tr>
           <th>Mesas</th>
            <th>Nº personas</th>
            <th>Asignación mesas</th>
            <th>Confirmación</th>
            <th>Nombre Reserva</th>

          </tr>
          </thead>

          <tbody>

			<c:forEach items="${listaReservasBean.getListaMesas()}"
					var="item">
			<c:if test="${item.getDisponible()==true}">
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
               
              <li><a href="a" name="habitacion" id="habitacion" > ${listaReservasBean.getMapAsign().get(item.getNum_mesa())}</a>
  									</label>
                  <ul class="submenu">
                  
                 <form action="asignarHab" method="GET">
                      
                  	<input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                      <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 101">Habitación 101</button>
                      </form>  
                     <form action="asignarHab" method="GET">
                     <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                    <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 102">Habitación 102</button>
                      </form><form action="asignarHab" method="GET">
                      <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                     <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 103">Habitación 103</button>
                      </form><form action="asignarHab" method="GET">
                      <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                    <li> <button name="hab1" class="leer-mas" id="hab1" value="Habitacion 104">Habitación 104</button>
                      </form>  
                  </ul>
                 

              </li>
              </ul>
              </nav>
              </p>
            </td>
            
       
            <td><p class="parrafo-post1">
            <form method="POST" action="alojarMesa" >
        	<input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
              <input type="submit" class="leer-mas" value="OK">
				</form>
            </p>
          </td>
          <td><p class="parrafo-post1">
          
          </td>

          </tr>
          </c:if>
          
          <c:if test="${item.getDisponible()==false}">
         
          <tr bgcolor="#f17c73">
            <td><p class="parrafo-post1">
              <strong><i>Mesa ${item.getNum_mesa()} </i></strong>
				
            </p>
          </td>
          
          
          
            <td><p class="parrafo-post1">
              <strong><i> ${item.getCapacidad()}</i></strong>
              
            </p>
            </td>
            <td>
            
            
           <p class="parrafo-post">
              <nav class="nav">
              <ul class="menu">
               
              <li><a href="a" name="habitacion" id="habitacion" > ${listaReservasBean.getMapAsign().get(item.getNum_mesa())}</a>
  									</label>
                  <ul class="submenu">
                  
                 <form action="asignarHab" method="GET">
                      
                  	<input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                      <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 101">Habitación 101</button>
                      </form>  
                     <form action="asignarHab" method="GET">
                     <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                    <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 102">Habitación 102</button>
                      </form><form action="asignarHab" method="GET">
                      <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                     <li><button name="hab1" class="leer-mas" id="hab1" value="Habitacion 103">Habitación 103</button>
                      </form><form action="asignarHab" method="GET">
                      <input type="hidden" name="idMesa"  value="${item.getMesa_id()}" /> 
                    <li> <button name="hab1" class="leer-mas" id="hab1" value="Habitacion 104">Habitación 104</button>
                      </form>  
                  </ul>
                 

              </li>
              </ul>
              </nav>
              </p>
            
            </td>
            
			<td>
				<c:if test="${item.filtro(item.getMesa_id())==false}">
					<p class="parrafo-post1">
					</p>
					</td>
					<td><p class="parrafo-post1">
					</p>
					</td>
					<td><p class="parrafo-post1">
					<strong><i>${listaReservasBean.getNombre(item.getNumMesa())}</i></strong>
					</p>
					   
				</c:if>
              
             </td>
                 

              
            
            < 
       
           

          </tr>
          
          </c:if>
          
          
		</c:forEach>
          </tbody>
        </table>




  </article>
</section>
  </section>
