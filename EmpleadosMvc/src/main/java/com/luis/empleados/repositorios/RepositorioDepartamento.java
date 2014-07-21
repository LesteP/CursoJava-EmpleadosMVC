package com.luis.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.empleados.modelo.Departamento;


public class RepositorioDepartamento 
				extends Repositorio<Departamento>{

public Map<Integer, String> getMapaOptions(){
		
		List<Departamento> l=get(Departamento.class);
		Map<Integer, String> mapa=new HashMap<Integer, String>();
		
		for (Departamento departamento : l) {
			
			mapa.put(departamento.getIdDepartamento(),
					departamento.getNombre());
		}
		
		return mapa;
	}
}
