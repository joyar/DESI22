package com.tsti.smn.entidades;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;



@Entity
public class clima_extendido {
	
	
	
	//atributos 
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Ciudad ciudad;
	@Future(message = "Debe ingresar una fecha futura")
	@NotNull(message="Ingrese una fecha")
	private Date fecha;
	@NotNull
	@PositiveOrZero(message = "Debe ingresar una valor positivo o cero")
	@Max(100)
	
	private int probabilidad_lluvia;
	@NotNull
	@PositiveOrZero(message = "Debe ingresar una valor positivo o cero")
	private int cantidad_prevista;
	@NotNull
	private String descripcion_pronostico;
	@NotNull  
	private int codigo_postal;
	
	
	
	//constructores
	public clima_extendido() {};
	
	public clima_extendido(Ciudad ciudad, Date f, int p_ll, int c_p, String d_p) {
		this.cantidad_prevista=c_p;
		this.descripcion_pronostico=d_p;
		this.fecha = f;
		this.probabilidad_lluvia=p_ll;
		this.ciudad=ciudad;
	};
	
	
	//setters
	
	public void setCodigo_postal(int codigo_postal) {
		this.codigo_postal=codigo_postal;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setFecha(Date fecha) {
		this.fecha=fecha;
	}
	public void setProbabilidad_lluvia(int p_ll) {
		this.probabilidad_lluvia=p_ll;
	}
	
	public void setCantidad_prevista(int c_p) {
		this.cantidad_prevista=c_p;
	}
	public void setDescripcion_pronostico(String d_p) {
		this.descripcion_pronostico= d_p;
	}
	public void setCiudad(Ciudad c) {
		this.ciudad= c;
	}

	
	//getters
	public int getCodigo_postal() {
		return this.codigo_postal;
	}
	public int getId() {
		return this.id;
	}
	public Date getFecha() {
		return this.fecha;
	}
	public int getProbabilidad_lluvia() {
		return this.probabilidad_lluvia;
	}
	
	public int getCantidad_prevista() {
		return this.cantidad_prevista;
	}
	public String getDescripcion_pronostico() {
		return this.descripcion_pronostico;
		
	}
	public Ciudad getCiudad() {
		return this.ciudad;
		
	}

	
	
}
