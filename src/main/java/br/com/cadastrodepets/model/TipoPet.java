package br.com.cadastrodepets.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class TipoPet {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String nome;

	public TipoPet() {
	}

	public TipoPet(Number id) {
		this.id = (Long) id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
