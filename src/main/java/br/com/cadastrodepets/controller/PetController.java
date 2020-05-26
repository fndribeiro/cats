package br.com.cadastrodepets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.model.Pet;
import br.com.cadastrodepets.repository.PetRepository;

@RestController
@RequestMapping(value = "/pet")
public class PetController {

	@Autowired
	private PetRepository repositorio;
	
	@PostMapping
	@RequestMapping(value = "/novo")
	public Pet novoPet(@RequestBody Pet pet) {		
		return repositorio.save(pet);		
	}
	
}
