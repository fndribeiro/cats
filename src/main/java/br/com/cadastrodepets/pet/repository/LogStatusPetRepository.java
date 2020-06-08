package br.com.cadastrodepets.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.pet.model.LogStatusPet;

@Repository
public interface LogStatusPetRepository extends JpaRepository<LogStatusPet, Long> {

	@Query("FROM LogStatusPet l where l.pet.id = :petId")
	List<LogStatusPet> findAllByPetId(@Param("petId") Long id);
	
}
