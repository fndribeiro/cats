package br.com.cadastrodepets.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.veterinario.model.Veterinario;
import br.com.cadastrodepets.veterinario.service.VeterinarioService;

@RestController
@RequestMapping(value = "/veterinario")
public class VeterinarioController {

	@Autowired
	private VeterinarioService vetService;
	
	@PostMapping
	public Veterinario criaVeterinario(@Valid @RequestBody Veterinario vet) {
		return vetService.criaVeterinario(vet);
	}
	
	@GetMapping
	public List<Veterinario> listaVeterinario() {
		return vetService.listaVeterinario();
	}
	
	@PutMapping
	public ResponseEntity<Veterinario> atualizaVeterinario(@Valid @RequestParam long id, @RequestBody Veterinario vet) {
		return vetService.atualizaVeterinario(id, vet);
	}
}
