package br.com.cadastrodepets.ong.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Ong {

	@Id
	private long id;
	
	@NotNull
	private String nome;

	public Ong() {
	}

	public Ong(long id, String nome) {
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
