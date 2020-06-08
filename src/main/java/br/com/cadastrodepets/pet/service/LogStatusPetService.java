package br.com.cadastrodepets.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.pet.model.LogStatusPet;
import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.repository.LogStatusPetRepository;

@Service
public class LogStatusPetService {

	@Autowired
	private LogStatusPetRepository repositorioLogStatusPet;
	
	public LogStatusPet logStatusPet(Pet pet) {

		LogStatusPet logStatusPet = new LogStatusPet();
		logStatusPet.setPet(pet);
		logStatusPet.setStatusPet(pet.getStatusPet());

		return repositorioLogStatusPet.save(logStatusPet);
	}
	
	public List<LogStatusPet> listaLogPorPet(Long id) {		
		return repositorioLogStatusPet.findAllByPetId(id);
	}
	
	
	
}
