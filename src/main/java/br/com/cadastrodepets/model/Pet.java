package br.com.cadastrodepets.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pet {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(targetEntity = TipoPet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="tipoPet_id", nullable=false)
	private TipoPet tipoPet;

	public Pet() {
	}

	public Pet(long id, TipoPet tipoPet) {
		this.id = id;
		this.tipoPet = tipoPet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TipoPet getTipoPet() {
		return tipoPet;
	}

	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
	}
}
