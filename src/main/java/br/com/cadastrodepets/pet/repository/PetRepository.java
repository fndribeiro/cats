package br.com.cadastrodepets.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.pet.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
