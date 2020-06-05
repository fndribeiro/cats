package br.com.cadastrodepets.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.pet.model.LogStatusPet;

@Repository
public interface LogStatusPetRepository extends JpaRepository<LogStatusPet, Long> {

}
