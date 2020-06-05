package br.com.cadastrodepets.pet.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

@Entity
public class LogStatusPet {

	@Id
	@GeneratedValue
	private long id;
	
	@CreationTimestamp
	@NotNull
	private LocalDateTime dataRegistro;
	
	@ManyToOne(targetEntity = Pet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="pet_id", nullable=false)
	private Pet pet;
	
	@ManyToOne(targetEntity = StatusPet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="statusPet_id", nullable=false)
	private StatusPet statusPet;

	public LogStatusPet() {
	}

	public LogStatusPet(long id, LocalDateTime dataRegistro, Pet pet, StatusPet statusPet) {
		this.id = id;
		this.dataRegistro = dataRegistro;
		this.pet = pet;
		this.statusPet = statusPet;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public StatusPet getStatusPet() {
		return statusPet;
	}

	public void setStatusPet(StatusPet statusPet) {
		this.statusPet = statusPet;
	}	
}
