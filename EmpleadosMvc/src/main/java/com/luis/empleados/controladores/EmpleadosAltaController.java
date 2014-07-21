package com.luis.empleados.controladores;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.empleados.modelo.Departamento;
import com.luis.empleados.modelo.Empleado;
import com.luis.empleados.modelo.Puesto;
import com.luis.empleados.modelo.viewforms.EmpleadoViewForm;
import com.luis.empleados.repositorios.RepositorioDepartamento;
import com.luis.empleados.repositorios.RepositorioEmpleados;
import com.luis.empleados.repositorios.RepositorioPuesto;

@Controller
@RequestMapping(value="altaEmpleado.html")
public class EmpleadosAltaController {

	@Autowired
	RepositorioEmpleados dao;
	@Autowired
	RepositorioPuesto daoPuesto;
	@Autowired
	RepositorioDepartamento daoDepartamento;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String alta(ModelMap modelo){
		
		EmpleadoViewForm empleado=new EmpleadoViewForm();
		modelo.addAttribute("empleado", empleado);
		
		Map<Integer,String> lp=daoPuesto.getMapaOptions();
		
		
		Map<Integer,String> ld=daoDepartamento.getMapaOptions();
		
		modelo.addAttribute("puestos", lp);
		modelo.addAttribute("departamentos",ld);
		
		return "alta";
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public String 
		doAlta(@ModelAttribute("empleado") EmpleadoViewForm empleado,
				BindingResult resultado,
				HttpServletRequest request){
		
		if(resultado.hasErrors()){
			Map<Integer,String> lp=daoPuesto.getMapaOptions();
			Map<Integer,String> ld=daoDepartamento.getMapaOptions();
			request.setAttribute("puestos", lp);
			request.setAttribute("departamentos",ld);
			
			return "alta";
			
		}
		Empleado emple=empleado.getEmpleado();
		emple.setFechaAlta(new Date());
		dao.add(emple);
		
		return "redirect:/listado.html";
	}
	
}
