package org.fatec.l1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {
	
	@GetMapping("/clientes")
	public String clientes() {
		return "clientes";
	}

}
