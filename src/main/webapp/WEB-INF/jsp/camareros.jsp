<%@page import="org.apache.coyote.Request"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--Para decodificación de caracteres especiales -->
<title>CAMAREROS :</title>
<!--Título-->
<!--link rel="stylesheet" type="text/css" href="./css/estilo1.css"-->
<style><%@include file="./css/estilo1.css"%>
</style>
<!--carpeta donde se encuentra el estilo css-->
<body>
<script type="text/javascript">
$(document).ready(function (e) {
    let UrlsObj = localStorage.getItem('rememberScroll');
    let ParseUrlsObj = JSON.parse(UrlsObj);
    let windowUrl = window.location.href;

    if (ParseUrlsObj == null) {
        return false;
    }

    ParseUrlsObj.forEach(function (el) {
        if (el.url === windowUrl) {
            let getPos = el.scroll;
            $(window).scrollTop(getPos);
        }
    });

});

function RememberScrollPage(scrollPos) {

    let UrlsObj = localStorage.getItem('rememberScroll');
    let urlsArr = JSON.parse(UrlsObj);

    if (urlsArr == null) {
        urlsArr = [];
    }

    if (urlsArr.length == 0) {
        urlsArr = [];
    }

    let urlWindow = window.location.href;
    let urlScroll = scrollPos;
    let urlObj = {url: urlWindow, scroll: scrollPos};
    let matchedUrl = false;
    let matchedIndex = 0;

    if (urlsArr.length != 0) {
        urlsArr.forEach(function (el, index) {

            if (el.url === urlWindow) {
                matchedUrl = true;
                matchedIndex = index;
            }

        });

        if (matchedUrl === true) {
            urlsArr[matchedIndex].scroll = urlScroll;
        } else {
            urlsArr.push(urlObj);
        }


    } else {
        urlsArr.push(urlObj);
    }

    localStorage.setItem('rememberScroll', JSON.stringify(urlsArr));

}

$(window).scroll(function (event) {
    let topScroll = $(window).scrollTop();
    console.log('Scrolling', topScroll);
    RememberScrollPage(topScroll);
});
</script>
	<header class="header">
		<!-- La parte de arriba de la página web-->
		<%! String t1; %>
				<%
				t1=request.getParameter("text1");
				%>
		<div id="encabezado">
			<div id="logo">PORTAL CAMAREROS</div>

			<div id="menu">
				<ul>
					<!-- LI= lista de caracteres desordenada-->
					<li><a href="mesas" class="activate-menu">Inicio</a></li>
					<li><a href="#" class="enlace">Platos</a></li>
					<li><a href="#" class="enlace">Bebida</a></li>
					<li><a href="pruebaliberarmesas" class="enlace">Checkout</a></li>
				</ul>
			</div>
		</div>
	</header>

	<section id="principal">
		<section id="publicaciones">
			<article class="post">
				<style>
  				 form { display: inline; }
				</style>
			
					<h2 class="titulo-post">Platos</h2>
				
				<c:forEach items="${comandaBean.getCantidades().entrySet()}"
					var="item">
					<p> <c:set var="vip" value="${item.getValue().getVip()}" />
					 <c:if test="${vip != false}" >
					 <img src="/img/streyita 3.0.png" height="2%" weight="2%"> 
					 </c:if>
					  ${item.getKey()}  
						<c:set var="val" value="${item.getValue().getUnidades()}" /> 
						<c:if
							test="${val != '0'}">
    									${item.getValue().getUnidades()}
  									</c:if>
  									
						
						<form method="POST" action="anadirItem">
						
							<input type="hidden" name="platoNuevo"
								value="${item.getValue().getId()}" />
								<input type="submit" class="leer-mas" value="+"> 
								<input type="hidden" name="numMesa" value=<%=t1%>> 
							</form>
							<form method="POST" action="quitarItem">
							<input type="hidden" name="platoNuevo"
								value="${item.getValue().getId()}" /> <input type="submit" class="leer-mas"
								value="-">
								<input type="hidden" name="numMesa" value=<%=t1%>> 

						</form>
						
						
					</p>
				</c:forEach>
				

			</article>

		</section>

		<section id="publicaciones">
			<article class="post">

			<style>
  				 form { display: inline; }
				</style>

					<h2 class="titulo-post">Bebida</h2>
				
				<c:forEach items="${comandaBean.getBebidas().entrySet()}" var="item">
					<p>
					<label>
					<c:set var="vip" value="${item.getValue().getVip()}" />
					<c:if test="${vip != false}" >
					 <img src="/img/streyita 3.0.png" height="2%" weight="2%"> 
					 </c:if>
					${item.getKey()} 
						 <c:set var="val" value="${item.getValue().getUnidades()}" /> 
						 
					 
						<c:if
							test="${val != '0'}">
    									${item.getValue().getUnidades()}
  									</c:if>
  									
  									</label>
						<form method="POST" action="anadirBebida">
							<input type="hidden" name="bebidaNueva"
								value="${item.getValue().getId()}" /> <input type="submit" class="leer-mas"
								value="+">
								<input type="hidden" name="numMesa" value=<%=t1%>> 
						</form>
						<form method="POST" action="quitarBebida">
							<input type="hidden" name="bebidaNueva"
								value="${item.getValue().getId()}" /> <input type="submit" class="leer-mas"
								value="-">
								<input type="hidden" name="numMesa" value=<%=t1%>> 
						</form>
					</p>
				</c:forEach>
				
				<form method="POST" action="enviarComanda">
					<input type="hidden" name="fecha"> 
					<input type="hidden" name="numMesa" value="${comandaBean.getNumMesa()}"> <br> <input
						type="submit" value="Enviar comanda">
				</form>

			</article>

		

		</section>

		<section id="publicaciones">
		

		</section>
<section id="sidebar">
  <section id="informacion">
    <h2 class="encabezado-sidebar"> Información </h2>
     <form method="POST" action="enviarObservaciones">
     <c:set var="val" value="${comandaBean.getObservaciones()}" /> 
	<c:if test="${val != ''}">
		<p>${comandaBean.getObservaciones()}</p>
  	</c:if>
	<p><input type="text" name ="observaciones" value="" placeholder="Escribe aqui observaciones del cliente"></p>
	<input type="submit" name="Enviar">
	</form>
	
  </section>

</section>
	</section>




</body>

</html>
