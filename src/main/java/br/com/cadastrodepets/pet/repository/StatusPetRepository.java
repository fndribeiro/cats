package br.com.cadastrodepets.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.pet.model.StatusPet;

public interface StatusPetRepository extends JpaRepository<StatusPet, Long> {

}
