package br.com.cadastrodepets.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.pet.model.VacinaPet;

@Repository
public interface VacinaPetRepository extends JpaRepository<VacinaPet, Long> {
	
}
