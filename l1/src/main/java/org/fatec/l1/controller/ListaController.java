package org.fatec.l1.controller;

import java.util.List;

import org.fatec.l1.domain.Cliente;
import org.fatec.l1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("**/listar-clientes-filtro")
	public ModelAndView listarClientesFiltro(@RequestParam("genero") String genero, @RequestParam("ordem") String ordem) {
		ModelAndView mv = new ModelAndView("lista");
		
		// se tem genero e esta em ordem alfabetica
		if (genero.equals("M") || genero.equals("F") && ordem.equals("a")) {
			mv.addObject("clientes", cr.findAllByGenero(genero, Sort.by("nome").ascending()));
		}
		// se tem genero mas esta em ordem padrao
		else if (genero.equals("M") || genero.equals("F") && ordem.equals("p")) {
			mv.addObject("clientes", cr.findAllByGenero(genero, null));
		}
		// se nao tem genero mas esta em ordem alfabetica
		else if (ordem.equals("a") && genero.equals("T")) {
			mv.addObject("clientes", cr.findAllOrderByNome(Sort.by("nome").ascending()));
		}
		// se nao tem genero e nem ordem alfabetica
		else {
			mv.addObject("clientes", cr.findAll());
		}
		return mv;
	}
	
}
