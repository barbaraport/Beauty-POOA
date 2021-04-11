package org.fatec.l1.controller;

import java.util.List;

import org.fatec.l1.domain.Cliente;
import org.fatec.l1.domain.Consumido;
import org.fatec.l1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumidosRestController {
	@Autowired
	ClienteRepository cr;
	@GetMapping ("/modalId/{id}")
	public List<Consumido> consumidos (@PathVariable("id") Long id) {
		Cliente c = cr.getOne(id);
		return c.getConsumidos();
	}

}
