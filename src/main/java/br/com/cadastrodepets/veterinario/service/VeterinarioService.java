package br.com.cadastrodepets.veterinario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.veterinario.model.Veterinario;
import br.com.cadastrodepets.veterinario.repository.VeterinarioRepository;

@Service
public class VeterinarioService {

	@Autowired
	private VeterinarioRepository repositorioVeterinario;
	
	public Veterinario criaVeterinario(Veterinario vet) {
		return repositorioVeterinario.save(vet);
	}
	
}
