package com.tsti.smn.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Provincia {
	
	
	//atributos
	 
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	public int id;
	public String nombre;
	
	@OneToMany(mappedBy = "provincia")
	public List<Ciudad>ciudades;
	
	
	//constructores
	 
	public Provincia() {};
	public Provincia(String nombre, int id, List<Ciudad>ciudades) {
		this.nombre=nombre;
		this.id = id;
		this.ciudades=ciudades;
	}
	
	//getters
	 
	public String getNombre() {
		return this.nombre;
	}
	
	public int getId() {
		return this.id;
	}
	public List<Ciudad> getCiudades(){
		return this.ciudades;
	}
	
	//setters
	 
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public void getId(int id) {
		this.id=id;
	}
	public void getCiudades(List<Ciudad>ciudades){
		this.ciudades=ciudades;
	}
	
	public boolean agregarCiudad(Ciudad c) {
		return this.ciudades.add(c);
	}
	
	public boolean eliminarCiudad(Ciudad c) {
		return this.ciudades.remove(c);
	}
	
	public boolean editarCiudad(Ciudad vieja, Ciudad editada) {
		this.ciudades.remove(vieja);
		return this.ciudades.add(editada);
	}
	
	
	

}
