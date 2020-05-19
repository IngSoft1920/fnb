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

      
         <h2 class="titulo-post">Eliminar platos</h2>
       

       <p class="parrafo-post">
         Macarrones
         <input type="checkbox">
       </p>

       <p class="parrafo-post">
         Filete de ternera
         <input type="checkbox">
       </p>

       <p class="parrafo-post">
         Helado de vainilla
         <input type="checkbox">
       </p>

       <p class="parrafo-post">
         Cerveza con limon
         <input type="checkbox">
       </p>

       <p class="parrafo-post">
         Fanta de limon
         <input type="checkbox">
       </p>

       <p class="parrafo-post">
         Coca-cola
         <input type="checkbox">
       </p>

       <p class="parrafo-post">

           <button class="boton"> Ok </button>

       </p>
     </article>
  </section>


  <section class="publicaciones">
   <article class="post">
       <h2 class="titulo-post">Rellenar inventario</h2>
        <table border="1">
       <thead>
       <tr>
         
         
       <form action="pedidoRecibido" method="POST">
       <th><input type="text" name="producto" value="" placeholder="Escriba aqui el producto deseado" ></th>
       <th><input type="text" name="cantidad" value="" placeholder ="Escriba aqui la cantidad"></th>
      <th>     <p class="parrafo-post">
              <nav class="nav">
              <ul class="menu">
             <li> <a href="a" name="medida"> ${cartaBean.getUnidad()}</a>
                <ul class="submenu">
                  	<form action="asignarUnidad" method="GET">
                  	<input type="hidden" name="idMesa"  value="g"/> 
                      <li><button name="hab1" class="leer-mas" id="g" value="g">g</button>
                      </form>  
                     <form action="asignarUnidad" method="GET">
                     <input type="hidden" name="idMesa"  value="ml" /> 
                    <li><button name="hab1" class="leer-mas" id="ml" value="ml">ml</button>
                      </form><form action="asignarUnidad" method="GET">
                      <input type="hidden" name="idMesa"  value="unidad" /> 
                     <li><button name="hab1" class="leer-mas" id="unidad" value="unidad">unidad</button>
                      </form>  
                  </ul>
                 

            
              
              
             </ul> 
            </nav> 
            </li>
        
        </tr>
        </th>
        </form>
       </thead>
       </table>
       <br>
       <form action="Adho" method="GET">
        <input type="submit" value="Proveedores" >
</form>
       </article>
 </section>
 
 

 

 <section id="publicaciones">
   <article class="post">

   
       <h2 class="titulo-post">Visualizar carta</h2>
     

     <table border="1">
       <thead>
       <tr>
         <th>Nombre plato</th>
         <th>Ingredientes</th>
       </tr>
       </thead>

       <tbody>
       <c:forEach items="${cartaBean.getPlatosIngre()}"
					var="item">
       <tr>

      <td>${item.getKey()}</td>
         <td>
         <ul class="menu">
         <nav class="nav">
         <c:forEach items="${item.getValue()}"
					var="ingredientes">
         <p>  ${ingredientes.getIngrediente().getNombre()}  ${ingredientes.getCantidad()}    
         </c:forEach>
          </nav>
          </ul>
          
          </td>
         
         

       </tr>
       </c:forEach>

       </tbody>
     </table>

   </article>
  
</section>


</body>