package com.tsti.smn.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class climaExtendidoRE {


	@GetMapping("/climaExtendidoRE")
	public String climaExtendidoView() 
	{
		return "climaExtendidoRE";
	}


}
