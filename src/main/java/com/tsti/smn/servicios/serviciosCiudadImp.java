package com.tsti.smn.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.dao.dao_Ciudad;
import com.tsti.smn.entidades.Ciudad;

@Service
public class serviciosCiudadImp implements serviciosCiudad{
	
	@Autowired
	dao_Ciudad repo;
	
	
	//servicios de clima extendido
	
	
	@Override
	public List<Ciudad> getCiudades(){
		return repo.findAll();
	}
	
	@Override
	public void guardarCiudad(Ciudad c) {
		repo.save(c);
	}
	
	@Override
	public void eliminarCiudad(Ciudad c) {
		repo.delete(c);
	}
	
	@Override
	public void editarCiudad(Ciudad c_vieja,Ciudad c) {
		repo.delete(c_vieja);
		repo.save(c);
	}
	
	@Override
	public Ciudad getCiudad(int codigo_postal) {
		return repo.findById(codigo_postal);
	}

	
}
