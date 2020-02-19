<%@page import="ingsoft1920.ejemplo.Beans.ComandaBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
</head>
<body>
	<ul>
		<c:forEach items="${comandaBean.getCantidades().entrySet()}" var="item">
			<li>${item.getKey()}- ${item.getValue().getUnidades()}
				<form method="POST" action="anadirItem">
					<label>Plato</label> <input type="hidden" name="platoNuevo" value="${item.getValue().getId()}" /> <input
						type="submit" value="+"> <br>
				</form>
				
			</li>
		</c:forEach>
		


		<form method="POST" action="enviarComanda">
			<input type="submit" value="Enviar comanda">
		</form>
	</ul>

</body>
</html>
