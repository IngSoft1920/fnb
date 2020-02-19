<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	Ejemplo foreach y acceso a propiedades
</head>
<body>
	<h1>Puedo acceder a la propiedad de SesionBean mediante el nombre del campo</h1>
	<h2>${sesionBean.usuarioID}</h2>
	<br><br>
	<h1>Tambien puedo hacer bucles sobre listas como listaStrings</h1>
	<ul>
		<c:forEach items="listaStrings" var="item">
			<li>${item}</li>
		</c:forEach>
	</ul>
</body>
</html>