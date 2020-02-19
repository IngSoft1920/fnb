<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	Signup
</head>
<body>
	<div>
	<!-- Podemos acceder a tipos basicos (String, int...) mediante esta etiqueta -->
		<h1>
			${mensajeError}
		</h1>
	</div>
	<form:form method="POST" action="signup"
		modelAttribute="signupBean">
		<label>Nombre de usuario</label>
		<form:input type="text" name="usuario" path="usuario" />
		<br>
		<label>Contraseña</label>
		<form:input type="password" name="password" path="password" />
		<br>
		<label>Correo electrónico</label>
		<form:input type="text" name="email" path="email" />
		<br>
		<label>ID estudiante</label>
		<form:input type="text" name="idEstudiante" path="idEstudiante" />
		<br>
		<input type="submit" value="Registro">
		<br>
	</form:form>
</body>
</html>