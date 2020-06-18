package br.com.cadastrodepets.endereco.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Endereco {
	
	@Size(min = 8, max = 8)
	private String cep;
	
	private String logradouro;
	
	private int numero;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	@Enumerated(EnumType.STRING)
	private UnidadeFederativaEnum uf;

	public Endereco() {
	}

	public Endereco(String cep, String logradouro, int numero, String complemento, String bairro, String localidade,
			UnidadeFederativaEnum uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public UnidadeFederativaEnum getUnidadeFederativa() {
		return uf;
	}

	public void setUnidadeFederativa(UnidadeFederativaEnum uf) {
		this.uf = uf;
	}
}
