package com.tsti.smn.servicios;

import java.util.List;

import com.tsti.smn.entidades.Ciudad;

public interface serviciosCiudad {
	List<Ciudad>getCiudades();
	void guardarCiudad(Ciudad c);
	void eliminarCiudad(Ciudad c);
	void editarCiudad(Ciudad c_vieja,Ciudad c);
	Ciudad getCiudad(int codigo_postal);

}
