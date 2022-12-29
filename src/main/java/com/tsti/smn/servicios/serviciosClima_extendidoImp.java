package com.tsti.smn.servicios;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.dao.dao_clima_extendido;
import com.tsti.smn.entidades.clima_extendido;

@Service
public class serviciosClima_extendidoImp implements serviciosClima_extendido{
	@Autowired
	dao_clima_extendido repo;
	
	@Override
	public List<clima_extendido> getPronosticoExtendido(){
		return repo.findAll();
	}
	
	@Override
	public clima_extendido getClimaExtendido(int id){
		return repo.findByIdClima(id);
	}
	
	
	
	//para guardar el cliente me aseguro que ademas de pasar el @Valid tambien supere la exception 
	@Override
	public void guardarClimaExtendidoNuevo(clima_extendido c_e) throws Exception{
		List<clima_extendido> climas = repo.findById( c_e.getCodigo_postal());
		boolean fecha_existente = false;
		
		for(int i=0;i<climas.size();i++) {
			if(climas.get(i).getFecha().equals(c_e.getFecha())) {fecha_existente = true; break;}
		}
		
		if(!fecha_existente) {
			repo.save(c_e);
			}
		else {
			throw new Exception("Ya existe un pronostico para la fecha y ciudad ingresados");
		}
	}
	
	
	@Override
	public void eliminarClimaExtendidoNuevo(int id){
		repo.deleteById(id);
	}
	
	@Override
	public void editarClimaExtendidoNuevo(clima_extendido c_e) throws Exception{
		List<clima_extendido> climas = repo.findById( c_e.getCodigo_postal());
		boolean fecha_existente = false;
		
		for(int i=0;i<climas.size();i++) {
			if(climas.get(i).getFecha().equals(c_e.getFecha())) {fecha_existente = true; break;}
		}
		
		if(!fecha_existente) {
			repo.save(c_e);
			}
		else {
			throw new Exception("Ya existe un pronostico para la fecha y ciudad ingresados");
		}
		
	}
	@Override
	public List<clima_extendido>getPronosticoExtendidoCiudad(int codigo_postal){
		Date actual = new java.sql.Date(new java.util.Date().getTime());;
		
		return repo.findByIdAndDate(codigo_postal,actual);
		
	}
	
}
