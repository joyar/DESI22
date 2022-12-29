package com.tsti.smn.servicios;

import java.util.List;

import com.tsti.smn.entidades.Provincia;


public interface serviciosProvincia {
	List<Provincia> getProvincias();
	void guardarProvincia(Provincia p);
	void eliminarProvincia(Provincia p);
	void editarProvincia(Provincia p_vieja,Provincia p);
}
