package org.fatec.l1.domain;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "nome")
	private String nome;
	@Column(nullable = false)
	private String data_nascimento;
	@Column(nullable = false)
	private String genero;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idCliente")
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idCliente")
	private List<Consumido> consumidos = new ArrayList<Consumido>();
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public List<Consumido> getConsumidos() {
		return consumidos;
	}

	public void setConsumidos(List<Consumido> consumidos) {
		this.consumidos = consumidos;
	}
	
	public int getIdade() {
	    LocalDate dataAtual = LocalDate.now();
	    LocalDate nascimento = LocalDate.parse(this.data_nascimento.replaceAll("-", "/"), DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	    Period periodo = Period.between(nascimento, dataAtual);
	    return periodo.getYears();
	}

}
