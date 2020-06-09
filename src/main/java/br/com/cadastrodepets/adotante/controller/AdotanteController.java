package br.com.cadastrodepets.adotante.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.adotante.model.Adotante;
import br.com.cadastrodepets.adotante.service.AdotanteService;

@RestController
@RequestMapping(value = "/adotante")
public class AdotanteController {

	@Autowired
	private AdotanteService adotanteService;
	
	@PostMapping
	public Adotante criaAdotante(@RequestBody Adotante ado) {
		return adotanteService.criaAdotante(ado);
	}
	
}
