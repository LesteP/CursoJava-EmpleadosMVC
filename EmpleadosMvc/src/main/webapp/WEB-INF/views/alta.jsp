<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
	prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	Datos del empleado<br />
	<form:form method="post" commandName="empleado">
		Nombre:<form:input path="nombre"/><br />
		Salario:<form:input path="salario"/><br />
		Puesto: <form:select path="idPuesto">
			<form:options items="${puestos}"/>
		</form:select>
		<br />
		Departamento: <form:select path="idDepartamento">
			<form:options items="${departamentos}"/>
		</form:select>
		<br />
	<input type="submit" value="Guardar" />
	
	</form:form>
	

</body>
</html>