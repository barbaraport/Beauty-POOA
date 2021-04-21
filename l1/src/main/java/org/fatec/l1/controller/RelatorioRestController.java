package org.fatec.l1.controller;

import java.util.ArrayList;
import java.util.List;

import org.fatec.l1.domain.Cliente;
import org.fatec.l1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelatorioRestController {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@GetMapping("/idadeClientes")
	@ResponseBody
	public List<Object> calcularMediaClientes(){
		
		List<Object> idades = new ArrayList<>();
		
		int totalIdades = 0;
		Float mediaTodos = 0.0F;
		Float mediaH = 0.0F;
		Float mediaM = 0.0F;
		
		// todos os clientes -> idade média
		List<Cliente> clientes = clienteRepo.findAll();
		for (Cliente cliente : clientes) {
			int idade = cliente.getIdade();
			totalIdades += idade;
		}

		mediaTodos = (float) (totalIdades / clientes.size());
		totalIdades = 0;

		// mulheres -> idade média
		List<Cliente> clientesM = clienteRepo.findAllByGenero("F", null);
		for (Cliente cliente : clientesM) {
			int idade = cliente.getIdade();
			totalIdades += idade;
		}

		mediaM = (float) (totalIdades / clientesM.size());
		totalIdades = 0;

		// homens -> idade média
		List<Cliente> clientesH = clienteRepo.findAllByGenero("M", null);
		for (Cliente cliente : clientesH) {
			int idade = cliente.getIdade();
			totalIdades += idade;
		}

		mediaH = (float) (totalIdades / clientesH.size());

		System.out.println("Todos: " + mediaTodos);
		System.out.println("Mulheres: " + mediaM);
		System.out.println("Homens: " + mediaH);
		
		idades.add(mediaTodos);
		idades.add(mediaM);
		idades.add(mediaH);
		
		return idades;
	}
	
}
