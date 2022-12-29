package com.tsti.smn.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.dao.dao_Provincia;
import com.tsti.smn.entidades.Provincia;

@Service
public class serviciosProvinciaImp implements serviciosProvincia{
	
	@Autowired
	dao_Provincia repo;
		
	@Override
	public List<Provincia> getProvincias(){
		return repo.findAll();
	}
	
	@Override
	public void guardarProvincia(Provincia p) {
		repo.save(p);
	}
	@Override
	public void eliminarProvincia(Provincia p) {
		repo.delete(p);
	}
	
	@Override
	public void editarProvincia(Provincia p_vieja,Provincia p) {
		repo.delete(p);
		repo.save(p);
	}
	
}
