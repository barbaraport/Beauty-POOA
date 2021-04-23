package org.fatec.l1.repository;

import java.util.ArrayList;

import org.fatec.l1.domain.Consumido;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsumidoRepository extends JpaRepository<Consumido, Long>{

	@Query("SELECT produto, COUNT(produto) AS quantidade_produto FROM Consumido c GROUP BY produto")
	ArrayList<Object> findQtdConsumidos(Sort sort);
	
	@Query(value = "SELECT con.produto, COUNT(con.produto) AS quantidade_produto FROM consumido AS con INNER JOIN cliente AS cli ON cli.id=con.id_cliente WHERE cli.genero=?1 GROUP BY con.produto ORDER BY ?#{#sort}", nativeQuery = true)
	ArrayList<Object> findQtdConsumidosByGenero(String genero, Sort sort);

}
