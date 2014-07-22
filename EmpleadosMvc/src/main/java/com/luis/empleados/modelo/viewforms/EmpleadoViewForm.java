package com.luis.empleados.modelo.viewforms;

import java.util.HashSet;
import java.util.Set;

import com.luis.empleados.modelo.Departamento;
import com.luis.empleados.modelo.Empleado;
import com.luis.empleados.modelo.Idioma;
import com.luis.empleados.modelo.Puesto;

public class EmpleadoViewForm {

	private Integer idEmpleado;
	private String nombre;
	private Double salario;
	private Integer idPuesto;
	private Integer idDepartamento;
	private Integer[] idIdioma;
	
	
	public EmpleadoViewForm() {
	}
	
	
	
	public EmpleadoViewForm(Integer idEmpleado, String nombre, 
			Double salario,
			Integer idPuesto, Integer idDepartamento) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.salario = salario;
		this.idPuesto = idPuesto;
		this.idDepartamento = idDepartamento;
	}

	public Empleado getEmpleado(){
		Empleado emple=new Empleado();
		emple.setIdEmpleado(idEmpleado);
		emple.setNombre(nombre);
		emple.setSalario(salario);
		Departamento d=new Departamento();
		d.setIdDepartamento(idDepartamento);
		emple.setDepartamento(d);
		Puesto p=new Puesto();
		p.setIdPuesto(idPuesto);
		emple.setPuesto(p);
		
		Set<Idioma> s=new HashSet<Idioma>();
		for (Integer idioma : idIdioma) {
			Idioma i=new Idioma();
			i.setIdIdioma(idioma);
			s.add(i);
		}
		emple.setIdiomas(s);
		
		return emple;
	}

	public void fromEmpleado(Empleado emple){
		setIdEmpleado(emple.getIdEmpleado());
		setNombre(emple.getNombre());
		setSalario(emple.getSalario());
		setIdDepartamento(emple.getDepartamento().
				getIdDepartamento());
		setIdPuesto(emple.getPuesto().getIdPuesto());
		
		idIdioma=new Integer[emple.getIdiomas().size()];
		int i=0;
		for (Idioma idioma : emple.getIdiomas()) {
			idIdioma[i++]=idioma.getIdIdioma();
		}
		
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Integer getIdPuesto() {
		return idPuesto;
	}
	public void setIdPuesto(Integer idPuesto) {
		this.idPuesto = idPuesto;
	}
	public Integer getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(Integer idDepartamento) {
		this.idDepartamento = idDepartamento;
	}



	public Integer[] getIdIdioma() {
		return idIdioma;
	}



	public void setIdIdioma(Integer[] idIdioma) {
		this.idIdioma = idIdioma;
	}
	
	
	
	
}
