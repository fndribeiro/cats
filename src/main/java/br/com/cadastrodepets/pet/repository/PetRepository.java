package br.com.cadastrodepets.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.pet.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
	
	@Query("FROM Pet p where p.ong.id = :ongId")
	List<Pet> findAllByOngId(@Param("ongId") Long id);
	
}
