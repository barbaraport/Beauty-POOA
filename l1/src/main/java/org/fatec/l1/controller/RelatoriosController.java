package org.fatec.l1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatoriosController {

	
	@GetMapping(value = "/relatorios")
	public String exibirPaginaRelatorios() {
		return "relatorios";
	}
}
