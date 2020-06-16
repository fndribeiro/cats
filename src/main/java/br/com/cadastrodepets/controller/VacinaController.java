package br.com.cadastrodepets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrodepets.vacina.model.Vacina;
import br.com.cadastrodepets.vacina.service.VacinaService;

@RestController
@RequestMapping(value = "/vacina")
public class VacinaController {

	@Autowired
	private VacinaService vacinaService;
	
	@PostMapping
	public Vacina criaVacina(@RequestBody Vacina vacina) {
		return vacinaService.criaVacina(vacina);
	}
	
	@GetMapping
	public List<Vacina> listaVacinaPorTipoPet(@RequestParam long tipoPetId) {
		return vacinaService.listaVacinaPorTipoPet(tipoPetId);
	}
	
}
