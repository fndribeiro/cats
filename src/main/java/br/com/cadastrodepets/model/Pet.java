package br.com.cadastrodepets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.cadastrodepets.auxiliary.TipoPetEnum;

@Entity
@Table
public class Pet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/*
	 * @Column(name="id-tipo-pet", nullable=false)
	 * 
	 * @Enumerated(EnumType.ORDINAL) private TipoPetEnum tipoPet;
	 */
	
	public Pet() {
	}	

	public Pet(long id, TipoPetEnum tipoPet) {
		this.id = id;
		/* this.tipoPet = tipoPet; */
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*
	 * public TipoPetEnum getTipoPet() { return tipoPet; }
	 */

	/*
	 * public void setTipoPet(TipoPetEnum tipoPet) { this.tipoPet = tipoPet; }
	 */
}
