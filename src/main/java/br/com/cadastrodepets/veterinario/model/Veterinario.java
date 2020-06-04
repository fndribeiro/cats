package br.com.cadastrodepets.veterinario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Veterinario {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nome;

	public Veterinario() {
	}

	public Veterinario(long id, String nome) {
		this.id = id;
		this.nome = nome;
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
}
