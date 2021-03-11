package org.fatec.l1.controller;

import java.util.List;
import org.fatec.l1.domain.Cliente;
import org.fatec.l1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListaController {

	@Autowired
	private ClienteRepository cr;
	
	@GetMapping("/listar-clientes")
	public ModelAndView listarClientes() {
		List<Cliente> clientes = cr.findAll();
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("clientes", clientes);
		return mv;
	}
	

}
