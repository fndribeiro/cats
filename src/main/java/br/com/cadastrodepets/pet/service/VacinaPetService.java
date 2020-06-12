package br.com.cadastrodepets.pet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.model.Vacina;
import br.com.cadastrodepets.pet.model.VacinaPet;
import br.com.cadastrodepets.pet.repository.PetRepository;
import br.com.cadastrodepets.pet.repository.VacinaPetRepository;
import br.com.cadastrodepets.pet.repository.VacinaRepository;

@Service
public class VacinaPetService {

	@Autowired
	private VacinaPetRepository repositorioVacinaPet;
	
	@Autowired
	private PetRepository repositorioPet;
	
	@Autowired
	private VacinaRepository repositorioVacina;
	
	public VacinaPet criaVacinaPet(VacinaPet vacinaPet) {
		
		Optional<Pet> pet = repositorioPet.findById(vacinaPet.getPet().getId());
		vacinaPet.setPet(pet.get());
		
		Optional<Vacina> vacina = repositorioVacina.findById(vacinaPet.getVacina().getId());
		vacinaPet.setVacina(vacina.get());
		
		vacinaPet.setTipoPet(pet.get().getTipoPet());
		
		return repositorioVacinaPet.save(vacinaPet);
	}
	
}
