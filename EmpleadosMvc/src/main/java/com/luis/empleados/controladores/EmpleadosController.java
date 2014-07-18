package com.luis.empleados.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping(value="detalle.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		Empleado e=daoEmpleado.get(Empleado.class, id);
		
		
		
		modelo.addAttribute("empleado", e);
		
		return "detalle";
	}
	
	
	
}







