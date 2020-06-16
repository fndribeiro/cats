package br.com.cadastrodepets.pet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.ong.model.Ong;
import br.com.cadastrodepets.ong.repository.OngRepository;
import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.model.RacaPet;
import br.com.cadastrodepets.pet.model.StatusPet;
import br.com.cadastrodepets.pet.model.TipoPet;
import br.com.cadastrodepets.pet.repository.PetRepository;
import br.com.cadastrodepets.pet.repository.RacaPetRepository;
import br.com.cadastrodepets.pet.repository.StatusPetRepository;
import br.com.cadastrodepets.pet.repository.TipoPetRepository;

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
	private LogStatusPetService logStatusPetService;

	public Pet criaPet(Pet pet) {

		Optional<TipoPet> tipoPet = repositorioTipoPet.findById(pet.getTipoPet().getId());
		pet.setTipoPet(tipoPet.get());

		Optional<RacaPet> racaPet = repositorioRacaPet.findById(pet.getRacaPet().getId());
		pet.setRacaPet(racaPet.get());

		Optional<StatusPet> statusPet = repositorioStatusPet.findById(pet.getStatusPet().getId());
		pet.setStatusPet(statusPet.get());

		Optional<Ong> ong = repositorioOng.findById(pet.getOng().getId());
		pet.setOng(ong.get());
		
		Pet savedPet = repositorioPet.save(pet);
		logStatusPetService.logStatusPet(savedPet);

		return savedPet;
	}

	public List<Pet> listaPetPorOng(Long id) {
		return repositorioPet.findAllByOngId(id);
	}

	public ResponseEntity<Pet> atualizaPet(long id, Pet pet) {

		return repositorioPet.findById(id).map(mapper -> {
			mapper.setAdotante(pet.getAdotante());
			mapper.setCastrado(pet.isCastrado());
			mapper.setNascimento(pet.getNascimento());
			mapper.setNome(pet.getNome());
			mapper.setRacaPet(pet.getRacaPet());
			mapper.setSexoPet(pet.getSexoPet());
			mapper.setTipoPet(pet.getTipoPet());
			mapper.setVeterinario(pet.getVeterinario());
			repositorioPet.save(mapper);
			return ResponseEntity.ok().body(mapper);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	public ResponseEntity<Pet> atualizaStatusPet(long id, long idStatus) {
		
		return repositorioPet.findById(id).map(mapper -> {
			Optional<StatusPet> statusPet = repositorioStatusPet.findById(idStatus);
			mapper.setStatusPet(statusPet.get());
			repositorioPet.save(mapper);
			logStatusPetService.logStatusPet(mapper);
			return ResponseEntity.ok().body(mapper);
		}).orElse(ResponseEntity.notFound().build());
	}
	
}
