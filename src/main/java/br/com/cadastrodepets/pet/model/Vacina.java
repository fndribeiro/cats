package br.com.cadastrodepets.pet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Vacina {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	private String nome;
	
	@ManyToOne(targetEntity = TipoPet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="tipoPet_id", nullable=false)
	private TipoPet tipoPet;

	public Vacina() {
	}

	public Vacina(long id, String nome, TipoPet tipoPet) {
		this.id = id;
		this.nome = nome;
		this.tipoPet = tipoPet;
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

	public TipoPet getTipoPet() {
		return tipoPet;
	}

	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
	}	
}
