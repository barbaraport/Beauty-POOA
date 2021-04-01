package org.fatec.l1.controller;

import java.util.List;

import org.fatec.l1.domain.Servicos;
import org.fatec.l1.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServicosController {

	@Autowired
	ServicoRepository sr;
	
	@GetMapping(value = "/produtos-e-servicos")
	public ModelAndView produtosServicos() {
		List<Servicos> servicos = sr.findAll();
		ModelAndView mv = new ModelAndView("servicos");
		mv.addObject("produtos", servicos);
		return mv;
	}
	
    @PostMapping("/alterar-servico")
    public ModelAndView alterar(Servicos s) {
    	ModelAndView mv = new ModelAndView();
    	sr.save(s);
    	mv.setViewName("redirect:/produtos-e-servicos");
		return mv;
    }
	
	@GetMapping(value = "/alterar-servico/{id}")
	public ModelAndView alterarServico(@PathVariable("id") Long id) {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("alterar-servico");
    	Servicos s = sr.getOne(id);
    	mv.addObject("servico", s);
    	return mv;
	}
	
    @GetMapping("/excluir-servico/{id}")
    public String excluirServico(@PathVariable("id") long id) {
    	sr.deleteById(id);
    	return "redirect:/produtos-e-servicos";
    }
	
}
