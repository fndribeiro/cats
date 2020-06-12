package br.com.cadastrodepets.controller;

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

import br.com.cadastrodepets.pet.model.LogStatusPet;
import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.model.VacinaPet;
import br.com.cadastrodepets.pet.service.LogStatusPetService;
import br.com.cadastrodepets.pet.service.PetService;
import br.com.cadastrodepets.pet.service.VacinaPetService;

@RestController
@RequestMapping(value = "/pet")
public class PetController {

	@Autowired
	private PetService petService;
	
	@Autowired
	private LogStatusPetService logStatusPetService;
	
	@Autowired
	private VacinaPetService vacinaPetService;
	
	@PostMapping
	public Pet criaPet(@RequestBody Pet pet) {
		return petService.criaPet(pet);
	}
	
	@GetMapping
	public List<Pet> listaPetPorOng(@RequestParam long ongId) {		
		return petService.listaPetPorOng(ongId);
	}
	
	@PutMapping
	public ResponseEntity<Pet> atualizaPet(@RequestParam long id, @RequestBody Pet pet) {
		return petService.atualizaPet(id, pet);
	}
	
	@PutMapping(path = "/status")
	public ResponseEntity<Pet> atualizaStatusPet(@RequestParam long id, @RequestParam long idStatus) throws InstantiationException, IllegalAccessException {
		return petService.atualizaStatusPet(id, idStatus);
	}
	
	@GetMapping(path = "/log")
	public List<LogStatusPet> listaLogPorPet(@RequestParam long petId) {
		return logStatusPetService.listaLogPorPet(petId);
	}
	
	@PostMapping(path = "/vacina")
	public VacinaPet criaVacinaPet(@RequestBody VacinaPet vacinaPet) {
		return vacinaPetService.criaVacinaPet(vacinaPet);
	}
	
}
