package br.com.cadastrodepets.pet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class RacaPet {

	@Id
	private long id;
	
	@NotNull
	private String nome;

	public RacaPet() {
	}

	public RacaPet(long id, String nome) {
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
