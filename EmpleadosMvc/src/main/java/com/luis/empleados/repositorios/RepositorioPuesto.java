package com.luis.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.empleados.modelo.Puesto;

public class RepositorioPuesto extends Repositorio<Puesto>{

	public Map<Integer, String> getMapaOptions(){
		
		List<Puesto> l=get(Puesto.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Puesto puesto : l) {
			
			mapa.put(puesto.getIdPuesto(), puesto.getNombre());
		}
		
		return mapa;
	}
}
