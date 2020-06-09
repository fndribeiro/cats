package br.com.cadastrodepets.adotante.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.adotante.model.Adotante;
import br.com.cadastrodepets.adotante.repository.AdotanteRepository;

@Service
public class AdotanteService {

	@Autowired
	private AdotanteRepository repositorioAdotante;
	
	public Adotante criaAdotante(Adotante ado) {
		return repositorioAdotante.save(ado);
	}
	
}
