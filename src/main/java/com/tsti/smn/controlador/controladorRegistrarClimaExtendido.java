package com.tsti.smn.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tsti.smn.entidades.Ciudad;
import com.tsti.smn.entidades.clima_extendido;
import com.tsti.smn.servicios.serviciosCiudad;
import com.tsti.smn.servicios.serviciosClima_extendidoImp;

@Controller
//@RequestMapping("registrarClimaExtendido")
public class controladorRegistrarClimaExtendido {
	
	@Autowired
	serviciosClima_extendidoImp s_climaExtendido;
	@Autowired
	serviciosCiudad sc ;
	
	@GetMapping("/registrarClimaExtendido")
	public String registrarClimaExtendidoView(Model model) {
		
		model.addAttribute("clima_extendido",new clima_extendido());
		model.addAttribute("ciudades", sc.getCiudades());

		return "registrarClimaExtendido";
	}
	
	
	
	@PostMapping("/climaExtendidoRegistrar")
	public String nuevoClimaExtendido(@ModelAttribute("clima_extendido") @Valid  clima_extendido clima_extendido, BindingResult result,Model modelo) {
		
		if(!result.hasErrors()) {
		   	Ciudad c = sc.getCiudad(clima_extendido.getCodigo_postal());
		   	clima_extendido.setCiudad(c);
		   	
		   	try {
		   		s_climaExtendido.guardarClimaExtendidoNuevo(clima_extendido);
		   		return "redirect:/climaExtendidoRE";   		
		   	}catch(Exception e) {
		   		ObjectError error = new ObjectError("globalError", e.getMessage());
		   		result.addError(error);
		   		modelo.addAttribute("ciudades", sc.getCiudades());
				modelo.addAttribute("clima_extendido",clima_extendido);
				return "registrarClimaExtendido";
		   	}
		   	
		}else {
			

			modelo.addAttribute("ciudades", sc.getCiudades());
			modelo.addAttribute("clima_extendido",clima_extendido);
			return "registrarClimaExtendido";
		} 
		
		
	}
 
	
	
	
}
