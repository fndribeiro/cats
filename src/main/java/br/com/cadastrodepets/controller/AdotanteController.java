package br.com.cadastrodepets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.adotante.model.Adotante;
import br.com.cadastrodepets.adotante.service.AdotanteService;

@RestController
@RequestMapping(value = "/adotante")
public class AdotanteController {

	@Autowired
	private AdotanteService adotanteService;
	
	@PostMapping
	public Adotante criaAdotante(@Valid @RequestBody Adotante ado) {
		return adotanteService.criaAdotante(ado);
	}
	
	@PutMapping
	public ResponseEntity<Adotante> atualizaAdotante(@Valid @RequestParam long id, @RequestBody Adotante ado) {
		return adotanteService.atualizaAdotante(id, ado);
	}
	
}
