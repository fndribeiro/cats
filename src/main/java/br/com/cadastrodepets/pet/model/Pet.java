package br.com.cadastrodepets.pet.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import br.com.cadastrodepets.adotante.model.Adotante;
import br.com.cadastrodepets.ong.model.Ong;
import br.com.cadastrodepets.veterinario.model.Veterinario;

@Entity
public class Pet {
	
	@Id
	@GeneratedValue
	private long id;
	
	@ManyToOne(targetEntity = TipoPet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="tipoPet_id", nullable=false)
	private TipoPet tipoPet;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private SexoPet sexoPet;
	
	@NotNull
	private String nome;
	
	@ManyToOne(targetEntity = RacaPet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="racaPet_id", nullable=false)
	private RacaPet racaPet;
	
	@NotNull
	private boolean castrado;
	
	@ManyToOne(targetEntity = StatusPet.class, cascade = CascadeType.ALL)
	@JoinColumn(name="statusPet_id", nullable=false)
	private StatusPet statusPet;
	
	@NotNull
	private LocalDate nascimento;
	
	@ManyToOne(targetEntity = Ong.class, cascade = CascadeType.ALL)
	@JoinColumn(name="ong_id", nullable=false)
	private Ong ong;
	
	@ManyToOne(targetEntity = Adotante.class, cascade = CascadeType.ALL)
	@JoinColumn(name="adotante_id", nullable=true)
	private Adotante adotante;
	
	@ManyToOne(targetEntity = Veterinario.class, cascade = CascadeType.ALL)
	@JoinColumn(name="veterinario_id", nullable=true)
	private Veterinario veterinario;

	public Pet() {
	}

	public Pet(long id, TipoPet tipoPet, SexoPet sexoPet, String nome, RacaPet racaPet, boolean castrado,
			StatusPet statusPet, LocalDate nascimento, Ong ong, Adotante adotante, Veterinario veterinario) {
		this.id = id;
		this.tipoPet = tipoPet;
		this.sexoPet = sexoPet;
		this.nome = nome;
		this.racaPet = racaPet;
		this.castrado = castrado;
		this.statusPet = statusPet;
		this.nascimento = nascimento;
		this.ong = ong;
		this.adotante = adotante;
		this.veterinario = veterinario;
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

	public SexoPet getSexoPet() {
		return sexoPet;
	}

	public void setSexoPet(SexoPet sexoPet) {
		this.sexoPet = sexoPet;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RacaPet getRacaPet() {
		return racaPet;
	}

	public void setRacaPet(RacaPet racaPet) {
		this.racaPet = racaPet;
	}

	public boolean isCastrado() {
		return castrado;
	}

	public void setCastrado(boolean castrado) {
		this.castrado = castrado;
	}

	public StatusPet getStatusPet() {
		return statusPet;
	}

	public void setStatusPet(StatusPet statusPet) {
		this.statusPet = statusPet;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public Ong getOng() {
		return ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public Adotante getAdotante() {
		return adotante;
	}

	public void setAdotante(Adotante adotante) {
		this.adotante = adotante;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}	
}
