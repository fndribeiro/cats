package br.com.cadastrodepets.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.pet.model.StatusPet;

@Repository
public interface StatusPetRepository extends JpaRepository<StatusPet, Long> {
	
}
