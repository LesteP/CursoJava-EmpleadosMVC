package com.luis.empleados.controladores;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.empleados.modelo.Empleado;
import com.luis.empleados.modelo.viewforms.EmpleadoViewForm;
import com.luis.empleados.repositorios.RepositorioDepartamento;
import com.luis.empleados.repositorios.RepositorioEmpleados;
import com.luis.empleados.repositorios.RepositorioIdiomas;
import com.luis.empleados.repositorios.RepositorioPuesto;


@Controller
@RequestMapping(value="modificarEmpleado.html")
public class ModificarEmpleadoController {

	@Autowired
	RepositorioEmpleados dao;
	@Autowired
	RepositorioPuesto daoPuesto;
	@Autowired
	RepositorioDepartamento daoDepartamento;
	@Autowired 
	RepositorioIdiomas daoIdiomas;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap modelo, @PathVariable int id){
		
		Empleado emple=dao.get(Empleado.class, id);
		EmpleadoViewForm ev=new EmpleadoViewForm();
		ev.fromEmpleado(emple);
		modelo.addAttribute("empleado", ev);
		
		Map<Integer,String> lp=daoPuesto.getMapaOptions();
		Map<Integer,String> ld=daoDepartamento.getMapaOptions();
		Map<Integer,String> li=daoIdiomas.getMapaOptions();
		
		modelo.addAttribute("puestos", lp);
		modelo.addAttribute("departamentos",ld);
		modelo.addAttribute("idiomas",li);
		
		
		return "modificar";
	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String 
		doModificar(@ModelAttribute("empleado") EmpleadoViewForm empleado,
				BindingResult resultado,
				HttpServletRequest request){
		
		if(resultado.hasErrors()){
			Map<Integer,String> lp=daoPuesto.getMapaOptions();
			Map<Integer,String> ld=daoDepartamento.getMapaOptions();
			Map<Integer,String> li=daoIdiomas.getMapaOptions();
			request.setAttribute("puestos", lp);
			request.setAttribute("departamentos",ld);
			request.setAttribute("idiomas",li);
			return "modificar";
			
		}
		Empleado emple=empleado.getEmpleado();
		emple.setFechaAlta(new Date());
		dao.update(emple);
		
		return "redirect:/listado.html";
	}
}
