package org.fatec.l1.controller;

import org.fatec.l1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatoriosController {

	@Autowired
	ClienteRepository clienteRepo;

	@GetMapping(value = "/relatorios")
	public ModelAndView paginaRelatorios() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("relatorios");
		return mv;

	}

}
