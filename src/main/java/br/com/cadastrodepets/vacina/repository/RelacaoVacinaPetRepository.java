package br.com.cadastrodepets.vacina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.vacina.model.RelacaoVacinaPet;

@Repository
public interface RelacaoVacinaPetRepository extends JpaRepository<RelacaoVacinaPet, Long> {
	
	@Query("FROM RelacaoVacinaPet r where r.pet.id = :petId")
	List<RelacaoVacinaPet> findAllByPetId(@Param("petId") Long id);
	
}
