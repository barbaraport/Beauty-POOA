package org.fatec.l1.domain;

public class Cliente {
	private String nome;
	private String data_nascimento;
	private String genero;
	public String telefone;
	
	public Cliente(String nome, String data_nascimento, String genero, String telefone) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.genero = genero;
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

	
}
