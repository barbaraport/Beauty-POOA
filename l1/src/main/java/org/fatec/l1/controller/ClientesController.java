package org.fatec.l1.controller;

import java.util.List;

import org.fatec.l1.domain.Cliente;
import org.fatec.l1.domain.Consumido;
import org.fatec.l1.domain.Servicos;
import org.fatec.l1.domain.Telefone;
import org.fatec.l1.repository.ClienteRepository;
import org.fatec.l1.repository.ConsumidoRepository;
import org.fatec.l1.repository.ServicoRepository;
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
	
	@Autowired
	private ServicoRepository sr;
	
	@Autowired
	private ConsumidoRepository cp;
	
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
    public ModelAndView alterar(Cliente c, Telefone T) {
    	ModelAndView mv = new ModelAndView();
    	cr.save(c);
    	mv.setViewName("redirect:/listar-clientes");
		return mv;
    }
    
    @GetMapping("/adicionar-produto/{id}")
    public ModelAndView addp (@PathVariable("id") Long id) {
    	List<Servicos> servicos = sr.findAll();
    	List<Consumido> consumidos = cp.findAll();
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("adicionar-produto");
    	Cliente c = cr.getOne(id);
    	mv.addObject("cliente", c);
    	mv.addObject("servicos", servicos);
    	mv.addObject("consumidos", consumidos);
    	return mv;
    }
    
    @PostMapping("/adicionar-produto")
    public String adicionarProduto(Long id, String produto) {
    	Cliente c = cr.getOne(id);
    	Consumido p = new Consumido();
    	p.setProduto(produto);
    	c.getConsumidos().add(p);
    	cr.save(c);
//		c.getConsumidos().add(p);
//		cr.save(c);
    	System.out.println(id);
    	System.out.println(produto);
		return "redirect:/listar-clientes";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluirCliente(@PathVariable("id") long id) {
    	cr.deleteById(id);
    	return "redirect:/listar-clientes";
    }

}
