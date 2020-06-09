package br.com.cadastrodepets.veterinario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.veterinario.model.Veterinario;
import br.com.cadastrodepets.veterinario.service.VeterinarioService;

@RestController
@RequestMapping(value = "/veterinario")
public class VeterinarioController {

	@Autowired
	private VeterinarioService vetService;
	
	@PostMapping
	public Veterinario criaVeterinario(@RequestBody Veterinario vet) {
		return vetService.criaVeterinario(vet);
	}
	
}
