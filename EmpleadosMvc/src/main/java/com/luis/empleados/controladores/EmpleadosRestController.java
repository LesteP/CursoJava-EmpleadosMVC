package com.luis.empleados.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luis.empleados.modelo.Empleado;
import com.luis.empleados.repositorios.RepositorioEmpleados;

@Controller
@RequestMapping(value="/empleado")
public class EmpleadosRestController {

	@Autowired
	RepositorioEmpleados dao;
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public @ResponseBody Empleado empleado(@PathVariable int id){
		
		Empleado e=dao.get(Empleado.class, id);
		
		return e;
		
		
	}
	
	
}
