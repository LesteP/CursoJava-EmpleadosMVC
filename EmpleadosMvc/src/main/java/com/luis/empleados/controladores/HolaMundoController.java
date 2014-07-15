package com.luis.empleados.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaMundoController {

	@RequestMapping(value="/holamundo.html")
	public String hola(Model modelo){
		
		modelo.addAttribute("saludo","Hola luis, bienvenido");
		return "hola";
		
		
	}
	
}
