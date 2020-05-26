package br.com.cadastrodepets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
