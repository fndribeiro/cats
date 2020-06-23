package br.com.cadastrodepets.veterinario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public List<Veterinario> listaVeterinario() {
		return repositorioVeterinario.findAll();
	}
	
	public ResponseEntity<Veterinario> atualizaVeterinario(long id, Veterinario vet) {
		
		return repositorioVeterinario.findById(id).map(mapper -> {
			mapper.setBairro(vet.getBairro());
			mapper.setCep(vet.getCep());
			mapper.setComplemento(vet.getComplemento());
			mapper.setCrmv(vet.getCrmv());
			mapper.setEmail(vet.getEmail());
			mapper.setLocalidade(vet.getLocalidade());
			mapper.setLogradouro(vet.getLogradouro());
			mapper.setNome(vet.getNome());
			mapper.setNumero(vet.getNumero());
			mapper.setTelefone(vet.getTelefone());
			mapper.setUf(vet.getUf());
			repositorioVeterinario.save(mapper);
			return ResponseEntity.ok().body(mapper);
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
