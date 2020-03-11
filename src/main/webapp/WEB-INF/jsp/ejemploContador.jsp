<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
<head>

	
</head>
	<div>
	<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<h1>
			Numero de visitas ${ejemploContadorBean.contadorVisitas}
		</h1>
		<h2>Horario de las visitas:</h2>
		<ol>
			<!-- Con esta etiqueta podemos iterar sobre un List de Java. El item que esta en la iteracion se guarda en 
			la variable hora, y la lista de items sobre los que iterar se pone en items
			Esto equivaldria en Java a:
			
			for each(String hora : ejemploContadorBean.getListaHoras()){...}
			
			Notad que en jsp teneis que poner el nombre del campo de la clase, no el getter o setter. Spring
			automaticamente identifica el campo con el getter y lo ejecuta por vosotros. -->
			<c:forEach items="${ejemploContadorBean.listaHoras}" var="hora">
			<li>
				${hora}
			</li>
			</c:forEach>
		</ol>
	</div>
	<form:form method="POST" action="setContador"
		modelAttribute="ejemploContadorBean">
		<label>Nombre de usuario</label>
		<form:input type="text" name="contadorVisitas" path="contadorVisitas" />
		<input type="submit" value="Set Contador">
		<br>
	</form:form>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
 //Checks if there is any change on checkBox class
$(function(){
 $("#checkbox1").click(function () {
	 
    if ($(this).prop("checked")) {
        $("#text1").val("jQuery");
    }
    else {
        $("#text1").val("AndreaCorrupta");
    }
});
} );
</script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>

<body>
<div>

  <input type="text" id="text1" />
<input type="checkbox" id="checkbox1" />checkbox

</div>
</head>
</body>
</body>
</html>