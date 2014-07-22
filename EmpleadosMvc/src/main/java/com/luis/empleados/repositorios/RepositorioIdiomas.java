package com.luis.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.empleados.modelo.Idioma;


public class RepositorioIdiomas extends Repositorio<Idioma>{

public Map<Integer, String> getMapaOptions(){
		
		List<Idioma> l=get(Idioma.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Idioma idioma : l) {
			
			mapa.put(idioma.getIdIdioma(), idioma.getNombre());
		}
		
		return mapa;
	}
	
}
