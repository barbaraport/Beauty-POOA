package org.fatec.l1.controller;

import java.util.ArrayList;
import java.util.List;

import org.fatec.l1.domain.Cliente;
import org.fatec.l1.repository.ClienteRepository;
import org.fatec.l1.repository.ConsumidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelatorioRestController {
	
	@Autowired
	ClienteRepository clienteRepo;
	
	@Autowired
	ConsumidoRepository consumidoRepo;
	
	@GetMapping("/idadeClientes")
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
		
		idades.add(mediaTodos);
		idades.add(mediaM);
		idades.add(mediaH);
		
		return idades;
	}
	
	@GetMapping("/produtosConsumidos")
	public List<Object> servicosMaisConsumidos() {
		
		ArrayList<Object> consumidos_todos = consumidoRepo.findQtdConsumidos(Sort.by("quantidade_produto").descending());
		ArrayList<Object> consumidos_mulheres = consumidoRepo.findQtdConsumidosByGenero("F", Sort.by("quantidade_produto").descending());
		ArrayList<Object> consumidos_homens = consumidoRepo.findQtdConsumidosByGenero("M", Sort.by("quantidade_produto").descending());
		
		List<Object> lista = new ArrayList<>();
		lista.add(consumidos_todos.get(0));
		lista.add(consumidos_mulheres.get(0));
		lista.add(consumidos_homens.get(0));
		
		return lista;
	}
	
}
