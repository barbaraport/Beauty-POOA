package org.fatec.l1.repository;

import java.util.List;

import org.fatec.l1.domain.Cliente;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Query("SELECT c FROM Cliente c WHERE c.genero = ?1")
	List<Cliente> findAllByGenero(String genero, Sort sort);
	
	@Query("SELECT c FROM Cliente c")
	List<Cliente> findAllOrderByNome(Sort sort);
}
