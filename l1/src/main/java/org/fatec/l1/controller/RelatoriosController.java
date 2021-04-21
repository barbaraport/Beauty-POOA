package org.fatec.l1.controller;

import java.util.List;

import org.fatec.l1.domain.Cliente;
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
		
		int totalIdades = 0;
		Float mediaTodos = 0.0F;
		Float mediaH = 0.0F;
		Float mediaM = 0.0F;
		
		ModelAndView mv = new ModelAndView("relatorios");
		
		//todos os clientes -> idade média
		List<Cliente> clientes = clienteRepo.findAll();
		for (Cliente cliente : clientes) {
			int idade = cliente.getIdade();
			totalIdades += idade;
		}
		
		mediaTodos = (float) (totalIdades/clientes.size());
		totalIdades = 0;
		
		// mulheres -> idade média
		List<Cliente> clientesM = clienteRepo.findAllByGenero("F", null);
		for (Cliente cliente : clientesM) {
			int idade = cliente.getIdade();
			totalIdades += idade;
		}
		
		mediaM = (float) (totalIdades/clientesM.size());
		totalIdades = 0;
		
		// homens -> idade média
		List<Cliente> clientesH = clienteRepo.findAllByGenero("M", null);
		for (Cliente cliente : clientesH) {
			int idade = cliente.getIdade();
			totalIdades += idade;
		}
		
		mediaH = (float) (totalIdades/clientesH.size());
		
		System.out.println("Todos: " + mediaTodos);
		System.out.println("Mulheres: " + mediaM);
		System.out.println("Homens: " + mediaH);
				
		return mv;
		
	}
}
