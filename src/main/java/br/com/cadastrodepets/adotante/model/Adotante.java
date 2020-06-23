package br.com.cadastrodepets.adotante.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

import br.com.cadastrodepets.contato.model.Contato;
import br.com.cadastrodepets.contato.model.TipoResidenciaEnum;

@Entity
public class Adotante extends Contato {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(unique=true, nullable = false)
	@Pattern(regexp = "^[0-9]{11}$")
	private String cpf;
	
	@NotNull
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private TipoResidenciaEnum tipoResidencia;
	
	@NotNull
	private LocalDate dataNascimento;
	
	public Adotante() {
	}

	public Adotante(long id, String cpf, String nome,
			TipoResidenciaEnum tipoResidencia, LocalDate dataNascimento) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.tipoResidencia = tipoResidencia;
		this.dataNascimento = dataNascimento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoResidenciaEnum getTipoResidencia() {
		return tipoResidencia;
	}

	public void setTipoResidencia(TipoResidenciaEnum tipoResidencia) {
		this.tipoResidencia = tipoResidencia;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
