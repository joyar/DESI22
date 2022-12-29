package com.tsti.smn.controlador;


import java.sql.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.entidades.clima_extendido;
import com.tsti.smn.servicios.serviciosCiudad;
import com.tsti.smn.servicios.serviciosClima_extendidoImp;



@Controller
public class ClimaConsultarController {
	
	@Autowired
	serviciosClima_extendidoImp s_climaExtendido;
	@Autowired
	serviciosCiudad sc ;

	@GetMapping("/climaConsultar")
	public String climaConsultarView(Model modelo, @ModelAttribute("clima_extendido") clima_extendido ciudadSeleccionada) {
		clima_extendido clima1 = new clima_extendido();
		modelo.addAttribute(clima1);
		modelo.addAttribute("ciudades", sc.getCiudades());
		modelo.addAttribute("climas_extendidos", s_climaExtendido.getPronosticoExtendidoCiudad(ciudadSeleccionada.getCodigo_postal()));
		return ("climaConsultar");	
		
	}
	
	@GetMapping("climaConsultar/detail/{id}")
	public String climaConsultarDetail(@PathVariable("id") int id, Model modelo) {
		clima_extendido clima2 = new clima_extendido();
		modelo.addAttribute(clima2);
		//modelo.addAttribute("ciudades", sc.getCiudad(codigo_postal));
		modelo.addAttribute("climas_extendidos", s_climaExtendido.getClimaExtendido(id));
		return "climaConsultarDetalle";
	}
	
	
	
	
	
	
}



















