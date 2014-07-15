package com.luis.empleados.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luis.empleados.modelo.Empleado;
import com.luis.empleados.repositorios.RepositorioEmpleados;

@Controller
public class EmpleadosController {

	@Autowired
	RepositorioEmpleados daoEmpleado;
	
	
	@RequestMapping(value="/listado.html")
	public String listado(Model modelo){
		
		List<Empleado> l=
				daoEmpleado.get(Empleado.class);
		
		modelo.addAttribute("empleados", l);
		return "listado";
	}
	
}
