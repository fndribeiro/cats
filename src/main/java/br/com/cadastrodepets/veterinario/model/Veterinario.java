package br.com.cadastrodepets.veterinario.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Veterinario {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;

	public Veterinario() {
	}

	public Veterinario(long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
