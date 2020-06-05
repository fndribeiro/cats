package br.com.cadastrodepets.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.adotante.model.Adotante;
import br.com.cadastrodepets.adotante.repository.AdotanteRepository;
import br.com.cadastrodepets.ong.model.Ong;
import br.com.cadastrodepets.ong.repository.OngRepository;
import br.com.cadastrodepets.pet.model.LogStatusPet;
import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.model.RacaPet;
import br.com.cadastrodepets.pet.model.StatusPet;
import br.com.cadastrodepets.pet.model.TipoPet;
import br.com.cadastrodepets.pet.repository.LogStatusPetRepository;
import br.com.cadastrodepets.pet.repository.PetRepository;
import br.com.cadastrodepets.pet.repository.RacaPetRepository;
import br.com.cadastrodepets.pet.repository.StatusPetRepository;
import br.com.cadastrodepets.pet.repository.TipoPetRepository;
import br.com.cadastrodepets.veterinario.model.Veterinario;
import br.com.cadastrodepets.veterinario.repository.VeterinarioRepository;

@Service
public class PetService {

	@Autowired
	private PetRepository repositorioPet;

	@Autowired
	private TipoPetRepository repositorioTipoPet;

	@Autowired
	private RacaPetRepository repositorioRacaPet;

	@Autowired
	private StatusPetRepository repositorioStatusPet;

	@Autowired
	private OngRepository repositorioOng;

	@Autowired
	private AdotanteRepository repositorioAdotante;

	@Autowired
	private VeterinarioRepository repositorioVeterinario;
	
	@Autowired
	private LogStatusPetRepository repositorioLogStatusPet;
	
	public LogStatusPet logStatusPet(Pet pet) {
		
		LogStatusPet logStatusPet = new LogStatusPet();
		logStatusPet.setPet(pet);
		logStatusPet.setStatusPet(pet.getStatusPet());
		
		return repositorioLogStatusPet.save(logStatusPet);
	}

	public Pet criaPet(Pet pet) {

		Optional<TipoPet> tipoPet = repositorioTipoPet.findById(pet.getTipoPet().getId());
		pet.setTipoPet(tipoPet.get());

		Optional<RacaPet> racaPet = repositorioRacaPet.findById(pet.getRacaPet().getId());
		pet.setRacaPet(racaPet.get());

		Optional<StatusPet> statusPet = repositorioStatusPet.findById(pet.getStatusPet().getId());
		pet.setStatusPet(statusPet.get());

		Optional<Ong> ong = repositorioOng.findById(pet.getOng().getId());
		pet.setOng(ong.get());

		Optional<Adotante> adotante = repositorioAdotante.findById(pet.getAdotante().getId());
		pet.setAdotante(adotante.get());

		Optional<Veterinario> veterinario = repositorioVeterinario.findById(pet.getVeterinario().getId());
		pet.setVeterinario(veterinario.get());
		
		logStatusPet(pet);

		return repositorioPet.save(pet);
	}
	
	public List<Pet> listaPetPorOng(Long id) {
		
		return repositorioPet.findAllByOngId(id);
	}
	
	public ResponseEntity<String> atualizaPet(long id, Pet pet) {
		
		return repositorioPet.findById(id).map(mapper -> {			
			mapper.setAdotante(pet.getAdotante());
			mapper.setCastrado(pet.isCastrado());
			mapper.setNascimento(pet.getNascimento());
			mapper.setNome(pet.getNome());
			mapper.setRacaPet(pet.getRacaPet());
			mapper.setSexoPet(pet.getSexoPet());
			mapper.setStatusPet(pet.getStatusPet());
			mapper.setTipoPet(pet.getTipoPet());
			mapper.setVeterinario(pet.getVeterinario());
			repositorioPet.save(mapper);
			logStatusPet(mapper);
			return ResponseEntity.ok().body("Pet atualizado!");
		}).orElse(ResponseEntity.notFound().build());
	}
}
