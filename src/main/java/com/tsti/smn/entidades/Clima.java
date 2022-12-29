package com.tsti.smn.entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Clima {
	
	
	//atributos
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int id;
	private double temp_actual;
	private String estado_actual;
	private double humedad;
	private Date fecha_actual;
	
	
	//Constructores
	 
	public Clima(){};
	public Clima(double t_a, String e_a, double h, List<clima_extendido>p_e, Date f_a){
		this.temp_actual = t_a;
		this.estado_actual=e_a;
		this.humedad=h;
		this.fecha_actual=f_a;

	}
	
	
	
	//Getters
	 
	public double getTemp_actual() {
		return this.temp_actual;
	}
	
	public double getHumedad() {
		return this.humedad;
	}
	
	public String getEstado_actual() {
		return this.estado_actual;
	}
	public Date getFecha_actual() {
		return this.fecha_actual;
	}
	
	
	
	//Setters
	
	public void setTemp_actual(double t_a) {
		this.temp_actual = t_a;
	}
	
	public void setHumedad(double h) {
		this.humedad=h;
	}
	
	public void setEstado_actual(String e_a) {
		this.estado_actual=e_a;
	}
	public void setFecha_actual( Date f_a) {
		this.fecha_actual=f_a;
	}
		 

	
	
}
