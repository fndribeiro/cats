package br.com.cadastrodepets.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.service.PetService;

@RestController
@RequestMapping(value = "/pet")
public class PetController {

	@Autowired
	private PetService petService;
	
	@PostMapping
	public Pet novoPet(@RequestBody Pet pet) {	
		return petService.criaPet(pet);
	}
	
}
