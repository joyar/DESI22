package com.tsti.smn.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {
	
	
	
	//atributos
	 
	@Id
	private Integer codigo_postal;
	
	private String nombre;
	@ManyToOne
	private Provincia provincia;
	@OneToOne
	private Clima clima;
	private String estado;
	
	@OneToMany(mappedBy = "ciudad")
	private List<clima_extendido>pronostico_extendido;
	
	

	//constructores
	 
	
	public Ciudad () {};
	public Ciudad (String nombre, Provincia provincia, int c_p, Clima clima, String estado, List<clima_extendido>p_e) {
		this.nombre=nombre;
		this.provincia=provincia;
		this.codigo_postal=c_p;
		this.estado=estado;
		this.pronostico_extendido=p_e;
	}
	
	
	//setters
	 
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	public void setProvincia (Provincia provincia) {
		this.provincia = provincia ;
	}
	public void setClima (Clima clima) {
		this.clima =clima ;
	}
	public void setEstado (String estado) {
		this.estado = estado ;
	}
	public void setPronostico_extendido(List<clima_extendido>p_e ){
		this.pronostico_extendido=p_e;
	}
	public void setCodigo_postal(int c_p) {
		this.codigo_postal=c_p;
	}
	


	//getters
	 
	public List<clima_extendido> getPronostico_extendido(){
		return this.pronostico_extendido;
	}
	public String getNombre () {
		return this.nombre ;
	}
	public Provincia getProvincia (Provincia provincia) {
		return this.provincia ;
	}
	public Clima getClima () {
		return this.clima ;
	}
	public String getEstado () {
		return this.estado  ;
	}
	public int getCodigo_postal() {
		return this.codigo_postal;
	}
	
	
	/**Algunas funciones
	 * 
	 */
	
	public boolean agregarClima_extendido(clima_extendido c_e) {
		return this.pronostico_extendido.add(c_e);
	}
	public boolean eliminarClima_extendido(clima_extendido c_e) {
		return this.pronostico_extendido.remove(c_e);
	}
	
	public boolean editarClima_extendido(clima_extendido c_e_viejo,clima_extendido c_e_editado) {
		this.pronostico_extendido.remove(c_e_viejo);
		return this.pronostico_extendido.add(c_e_editado);
	}
	
	
	

	
	
	
}
