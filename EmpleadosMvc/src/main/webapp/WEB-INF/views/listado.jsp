<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" 
src='<c:url value="/resources/js/jquery-1.11.1.min.js" />'></script>
<title>Insert title here</title>
</head>
<body>
Buscar:<input type="text" id="txtBuscar" 
				placeholder="Pon tu busqueda">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 
<table id="tblDatos">
<c:forEach items="${empleados }" var="empleado">
	<tr>
		<td>${empleado.nombre }</td>
		<td>${empleado.salario }</td>
		<td><a href="detalle.html?id=${empleado.idEmpleado}">
				Ver detalle
			</a>
			<a href="#" id="lnkDetalle" 
					onclick="evento(${empleado.idEmpleado})">
				Detalle Ajax
			</a>
			<a href="#" id="lnkBorrar" 
			onclick="borrar(${empleado.idEmpleado})">Borrar</a>
		</td>
	</tr>


</c:forEach>
</table>
<div id="divDetalle">

</div>
<script type="text/javascript">

function borrar(id){

	var datos={idEmpleado:id};

	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"empleado",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Empleado borrado correctamente");
					$("#txtBuscar").text("");
					buscar();

					},
				error: function(res){
					alert(JSON.stringify(res));
					}


				}
			);



	
}


function buscar(){
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="NoBuscoNada";
	var url="empleado/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});



		for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td>"+res[i].salario+"</td>";
			h+="<td><a href='detalle.html?id="+
					res[i].idEmpleado+"'>Detalle</a>";
			h+="<a href='#' onclick='evento("+
				res[i].idEmpleado+")'>Detalle ajax</a></td>";
			h+="<a href='#' onclick='borrar("+
				res[i].idEmpleado+")'>Borrar</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}



		"<a href='detalle.html?id=22'>Ver detalle</a>"

		});
	
}


function evento(id){

	var url="empleado/"+id;
//HAcemos una llamada ajax usando el metodo get
//Le pasamos la url y la funcion que se ejecuta cuando nos 
//devuelve la informacion
	$.get(url,function(res){

		var resultado="<ul>";
		resultado+="<li>"+res.nombre+"</li>";
		resultado+="<li>"+res.salario+"</li>";
		resultado+="<li>"+res.puesto.nombre+"</li>";
		resultado+="<li>"+res.departamento.nombre+"</li></ul>";
	
		$("#divDetalle").html(resultado);

		});
	

	
}

</script>
</body>
</html>








