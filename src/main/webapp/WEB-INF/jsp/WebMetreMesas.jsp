
<html lan="es">
<head>
  <meta charset="utf-8">	<!--Para decodificaci�n de caracteres especiales -->
  <title> METREMESASDISP : </title> <!--T�tulo-->
  <link rel="stylesheet" type="text/css" href="css/estilo3.css"> <!--carpeta donde se encuentra el estilo css-->


</head>

<body>
  <header class="header"> <!-- La parte de arriba de la p�gina web-->
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
            <th>N� personas</th>
            <th>Asignaci�n mesas</th>

          </tr>
          </thead>
          <c:set var="val" value="${ListaMesasDispBean.getLista().isEmpty()}" /> 
						<c:if
							test="${val != true}">
    									
  									
				<c:forEach
				
						items="${ListaMesasDispBean.getLista()}" var="entry">
		<section id="publicaciones">
			<article class="post">
			
				</c:if>
				
          
  </article>
</section>
  </section>
          
          