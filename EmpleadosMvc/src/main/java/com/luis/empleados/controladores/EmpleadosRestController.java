package com.luis.empleados.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	@RequestMapping(method=RequestMethod.GET,
			value="/buscar/{texto}")
	public @ResponseBody List<Empleado> 
				buscar(@PathVariable String texto){
	
		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Empleado> l=dao.find("empleado.buscador", params);
		return l;
		
		
	}
	@RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody 
										Empleado empleado){
		
		dao.delete(empleado);
		
		return "borrado";
	}
}









