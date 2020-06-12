package br.com.cadastrodepets.pet.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class VacinaPet {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(targetEntity = Pet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="pet_id", nullable=false)
	private Pet pet;
	
	@ManyToOne(targetEntity = Vacina.class, cascade = CascadeType.ALL)
	@JoinColumn(name="vacina_id", nullable=false)
	private Vacina vacina;
	
	@NotNull
	private LocalDate data;
	
	@NotNull
	private LocalDate vencimento;
	
	@ManyToOne(targetEntity = TipoPet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="tipoPet_id", nullable=false)
	private TipoPet tipoPet;

	public VacinaPet() {
	}

	public VacinaPet(long id, Pet pet, Vacina vacina, LocalDate data, LocalDate vencimento, TipoPet tipoPet) {
		this.id = id;
		this.pet = pet;
		this.vacina = vacina;
		this.data = data;
		this.vencimento = vencimento;
		this.tipoPet = tipoPet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public TipoPet getTipoPet() {
		return tipoPet;
	}

	public void setTipoPet(TipoPet tipoPet) {
		this.tipoPet = tipoPet;
	}	
}
