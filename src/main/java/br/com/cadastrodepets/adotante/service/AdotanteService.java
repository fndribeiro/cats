package br.com.cadastrodepets.adotante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<Adotante> atualizaAdotante(long id, Adotante ado) {
		
		return repositorioAdotante.findById(id).map(mapper -> {
			mapper.setBairro(ado.getBairro());
			mapper.setCep(ado.getCep());
			mapper.setComplemento(ado.getComplemento());
			mapper.setCpf(ado.getCpf());
			mapper.setDataNascimento(ado.getDataNascimento());
			mapper.setEmail(ado.getEmail());
			mapper.setLocalidade(ado.getLocalidade());
			mapper.setLogradouro(ado.getLogradouro());
			mapper.setNome(ado.getNome());
			mapper.setNumero(ado.getNumero());
			mapper.setTelefone(ado.getTelefone());
			mapper.setTipoResidencia(ado.getTipoResidencia());
			mapper.setUf(ado.getUf());
			repositorioAdotante.save(mapper);
			return ResponseEntity.ok().body(mapper);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public List<Adotante> listaAdotante() {
		return repositorioAdotante.findAll();
	}
}
