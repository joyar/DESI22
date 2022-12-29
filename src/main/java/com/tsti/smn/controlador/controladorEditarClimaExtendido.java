package com.tsti.smn.controlador;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.entidades.Ciudad;
import com.tsti.smn.entidades.clima_extendido;
import com.tsti.smn.servicios.serviciosCiudad;
import com.tsti.smn.servicios.serviciosClima_extendidoImp;

@Controller
public class controladorEditarClimaExtendido {
	@Autowired
	serviciosClima_extendidoImp s_climaExtendido;
	@Autowired
	serviciosCiudad sc ;
	
	@GetMapping("/editarClimaExtendido")
	public String editarClimaExtendidoView(Model model) {
		
		model.addAttribute("clima_extendido",new clima_extendido());
		model.addAttribute("ciudades", sc.getCiudades());
		

		return "editarClimaExtendido";
	}
	
	

	@GetMapping("/editarClimaExtendido/edit/{id}")
	public String edicion(@PathVariable("id") int id,Model model) {
		
		model.addAttribute("ciudades", sc.getCiudades());
		
		clima_extendido clima_viejo = s_climaExtendido.getClimaExtendido(id);
		model.addAttribute("clima_extendido",clima_viejo);
		
		 return "edicionClimaExtendido";
	}
	
	
	
	
	
	@GetMapping("/climaExtendidoEditar")
	public String nuevoClimaExtendido(@ModelAttribute("clima_extendido") clima_extendido ciudadSeleccionada,Model model, @RequestParam String action){
		
		model.addAttribute("clima_extendido",new clima_extendido());
		model.addAttribute("ciudades", sc.getCiudades());
		
		
		if(action.equals("seleccionar")) {
			model.addAttribute("ciudades", sc.getCiudades());
			model.addAttribute("climas_extendidos", s_climaExtendido.getPronosticoExtendidoCiudad(ciudadSeleccionada.getCodigo_postal()));
			return "editarClimaExtendido";
		}else {
			if(action.equals("editar")) {
				
				model.addAttribute("clima_extendido", s_climaExtendido.getClimaExtendido(ciudadSeleccionada.getId()));
				return "redirect:/editarClimaExtendido/edit/{id}";
			}
		}
		
		return "/";
	}
	
	
	
	@PostMapping("/agregarClimaModificado")
	public String modifClimaExtendido(@ModelAttribute("clima_extendido") @Valid  clima_extendido clima_extendido,BindingResult result,Model modelo) 
	{
			
			if(!result.hasErrors()) {
				Ciudad c = sc.getCiudad(clima_extendido.getCodigo_postal());
			   	clima_extendido.setCiudad(c);
			   	
				try {
					s_climaExtendido.editarClimaExtendidoNuevo(clima_extendido);
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
				return "edicionClimaExtendido";
				
			}
			
	}
	
	
	
	
	
}



















