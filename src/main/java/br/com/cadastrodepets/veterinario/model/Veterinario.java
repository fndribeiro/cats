package br.com.cadastrodepets.veterinario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import br.com.cadastrodepets.contato.model.Contato;

@Entity
public class Veterinario extends Contato {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true, nullable = false)
	@Pattern(regexp = "^([A-Z0-9]){6}$")
	private String crmv;
	
	@NotNull
	private String nome;	

	public Veterinario() {
	}

	public Veterinario(long id, String nome, String crmv) {
		this.id = id;
		this.nome = nome;
		this.crmv = crmv;
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

	public String getCrmv() {
		return crmv;
	}

	public void setCrmv(String crmv) {
		this.crmv = crmv;
	}
}
