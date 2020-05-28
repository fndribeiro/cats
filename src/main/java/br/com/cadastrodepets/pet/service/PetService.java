package br.com.cadastrodepets.pet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Pet criaPet(Pet pet) {
		
		Optional<TipoPet> tipoPet = repositorioTipoPet.findById(pet.getTipoPet().getId());		
		pet.setTipoPet(tipoPet.get());
		
		Optional<RacaPet> racaPet = repositorioRacaPet.findById(pet.getRacaPet().getId());
		pet.setRacaPet(racaPet.get());
		
		Optional<StatusPet> statusPet = repositorioStatusPet.findById(pet.getStatusPet().getId());
		pet.setStatusPet(statusPet.get());
		
		return repositorioPet.save(pet);
	}
	
}
