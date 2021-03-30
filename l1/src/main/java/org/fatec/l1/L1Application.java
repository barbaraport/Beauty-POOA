package org.fatec.l1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.fatec.l1.domain.Servicos;
import org.fatec.l1.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class L1Application {
	
	@Autowired 
    ServicoRepository sRepository;

	public static void main(String[] args) {
		SpringApplication.run(L1Application.class, args);
	}
	
	@EventListener(ContextRefreshedEvent.class)
	public void cadastrarAlgunsServicos() {
		
		if(sRepository.findAll().isEmpty()) {
			
			Map<String, Float> servicos = new HashMap<String, Float>();
			servicos.put("Manicure", 39.99F);
			servicos.put("Pedicure", 39.99F);
			servicos.put("Design de sobrancelhas", 29.99F);
			servicos.put("Corte de cabelo", 24.99F);
			servicos.put("Modelagem e corte de barba", 34.99F);
			servicos.put("Pintura de cabelo", 9.99F);
			servicos.put("Remoção de rugas", 2999.99F);
			servicos.put("Remoção de manchas", 499.99F);
			servicos.put("Aplicação de botox", 1799.99F);
			servicos.put("Tratamento para emagrecimento", 1099.99F);
			servicos.put("Redução de medidas", 159.99F);
			servicos.put("Tratamento para quedas de cabelo", 89.99F);
			
			servicos.forEach ((k, v) -> {
				Servicos servico = new Servicos(k , v);
				sRepository.save(servico);
			});

		};
	}

}
