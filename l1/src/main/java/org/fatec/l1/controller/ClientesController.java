package org.fatec.l1.controller;

import org.fatec.l1.domain.Cliente;
import org.fatec.l1.domain.Telefone;
import org.fatec.l1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientesController {
	
	@Autowired
	private ClienteRepository cr;
	
	@GetMapping("/cadastrar-clientes")
	public String cadastrarClientes() {
		return "cadastro";
	}
	
	@PostMapping("/cadastrar-clientes")
	public String cadastrarClientes(Cliente c, Telefone t) {
		c.getTelefones().add(t);
		cr.save(c);
		return "cadastro";
	}
	
    @GetMapping("/alterar/{id}")
    public ModelAndView alterar (@PathVariable("id") Long id) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("alterar");
    	Cliente c = cr.getOne(id);
    	mv.addObject("cliente", c);
    	return mv;
    }
    
    @PostMapping("/alterar")
    public ModelAndView alterar(Cliente c, Telefone t) {
    	ModelAndView mv = new ModelAndView();
    	cr.save(c);
    	mv.setViewName("redirect:/listar-clientes");
		return mv;
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable("id") long id) {
    	cr.deleteById(id);
    	return "redirect:/listar-clientes";
    }

}
