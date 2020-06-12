package br.com.cadastrodepets.pet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.pet.model.TipoPet;
import br.com.cadastrodepets.pet.model.Vacina;
import br.com.cadastrodepets.pet.repository.TipoPetRepository;
import br.com.cadastrodepets.pet.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository repositorioVacina;
	
	@Autowired
	private TipoPetRepository repositorioTipoPet;
	
	public Vacina criaVacina(Vacina vacina) {
		
		Optional<TipoPet> tipoPet = repositorioTipoPet.findById(vacina.getTipoPet().getId());
		vacina.setTipoPet(tipoPet.get());		
		return repositorioVacina.save(vacina);
	}
	
}
