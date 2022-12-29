package com.tsti.smn.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdministradorSMN {
	
	
	//atributos
	@Id
	private Long dni;
	private String nombre;
	private String apellido;
	private String nombre_usuario;
	private String password;
	
	
	//constructores
	public AdministradorSMN() {};
	public AdministradorSMN(long dni, String nombre, String ape, String n_u, String pass) {
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=ape;
		this.nombre_usuario=n_u;
		this.password=pass;
		
	}
	
	
	//getters
	public long getDni() {
		return this.dni;
	}
	public String getNombre() {
		return this.nombre ;
	}
	public String getApellido() {
		return this.apellido ;
	}
	public String getNombre_usuario() {
		return this.nombre_usuario ;
	}
	public String getPassword() {
		return this.password ;
	}
	
	//setters
	
	public void setDni(long dni) {
		this.dni = dni;
	}
	public void setNombre(String n) {
		this.nombre = n;
	}
	public void setApellido(String ape) {
		this.apellido = ape ;
	}
	public void setNombre_usuario(String n_u) {
		this.nombre_usuario = n_u;
	}
	public void setPassword( String pass) {
		this.password =pass;
	}
	
}
