package br.com.cadastrodepets.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.model.Pet;
import br.com.cadastrodepets.model.TipoPet;
import br.com.cadastrodepets.repository.PetRepository;
import br.com.cadastrodepets.repository.TipoPetRepository;

@RestController
@RequestMapping(value = "/pet")
public class PetController {

	@Autowired
	private PetRepository repositorioPet;
	
	@Autowired
	private TipoPetRepository repositorioTipoPet;
	
	@PostMapping(path = {"/novo"})
	public Pet novoPet(@RequestBody Pet pet) {		
		
		Optional<TipoPet> tipoPet = repositorioTipoPet.findById(pet.getTipoPet().getId());		
		pet.setTipoPet(tipoPet.get());
		
		return repositorioPet.save(pet);		
	}
	
}
