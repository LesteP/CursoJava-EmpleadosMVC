package com.luis.empleados.repositorios;

import org.hibernate.Hibernate;

import com.luis.empleados.modelo.Empleado;

public class RepositorioEmpleados extends Repositorio<Empleado> {

	@Override
	public Empleado get(Class<Empleado> tipo, int id) {
		// TODO Auto-generated method stub
		Empleado e= super.get(tipo, id);
		
		Hibernate.initialize(e.getDepartamento());
		Hibernate.initialize(e.getPuesto());
		
		return e;
	}
}
