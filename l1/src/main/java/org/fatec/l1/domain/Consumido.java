package org.fatec.l1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Consumido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String produto;
	
//	@ManyToOne
//	private Cliente cliente;

//	public Cliente getId_Cliente() {
//		return cliente;
//	}
//
//	public void setId_Cliente(Cliente cliente) {
//		this.cliente = cliente;
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

}
