package br.com.cadastrodepets.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.service.PetService;

@RestController
@RequestMapping(value = "/pet")
public class PetController {

	@Autowired
	private PetService petService;
	
	@PostMapping
	public Pet criaPet(@RequestBody Pet pet) {
		return petService.criaPet(pet);
	}
	
	@GetMapping
	public List<Pet> listaPetPorOng(@RequestParam long ongId) {		
		return petService.listaPetPorOng(ongId);
	}
	
	@PutMapping
	public ResponseEntity<String> atualizaPet(@RequestParam long id, @RequestBody Pet pet) {
		return petService.atualizaPet(id, pet);
	}
	
}
