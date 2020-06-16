package br.com.cadastrodepets.vacina.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrodepets.pet.model.Pet;
import br.com.cadastrodepets.pet.model.TipoPet;
import br.com.cadastrodepets.pet.repository.PetRepository;
import br.com.cadastrodepets.pet.repository.TipoPetRepository;
import br.com.cadastrodepets.vacina.model.RelacaoVacinaPet;
import br.com.cadastrodepets.vacina.model.Vacina;
import br.com.cadastrodepets.vacina.repository.RelacaoVacinaPetRepository;
import br.com.cadastrodepets.vacina.repository.VacinaRepository;

@Service
public class VacinaService {

	@Autowired
	private VacinaRepository repositorioVacina;

	@Autowired
	private TipoPetRepository repositorioTipoPet;
	
	@Autowired
	private PetRepository repositorioPet;
	
	@Autowired
	private RelacaoVacinaPetRepository repositorioRelacaoVacinaPet;

	public Vacina criaVacina(Vacina vacina) {

		Optional<TipoPet> tipoPet = repositorioTipoPet.findById(vacina.getTipoPet().getId());
		vacina.setTipoPet(tipoPet.get());
		return repositorioVacina.save(vacina);
	}

	public RelacaoVacinaPet criaRelacaoVacinaPet(RelacaoVacinaPet vacinaPet) {

		Optional<Pet> pet = repositorioPet.findById(vacinaPet.getPet().getId());
		vacinaPet.setPet(pet.get());

		Optional<Vacina> vacina = repositorioVacina.findById(vacinaPet.getVacina().getId());
		vacinaPet.setVacina(vacina.get());

		vacinaPet.setTipoPet(pet.get().getTipoPet());

		return repositorioRelacaoVacinaPet.save(vacinaPet);
	}

	public List<Vacina> listaVacinaPorTipoPet(long id) {
		return repositorioVacina.findAllByTipoPetId(id);
	}
	
	public List<RelacaoVacinaPet> listaVacinaPorPet(long petId) {
		return repositorioRelacaoVacinaPet.findAllByPetId(petId);
	}

}
