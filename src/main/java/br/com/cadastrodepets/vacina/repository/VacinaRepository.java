package br.com.cadastrodepets.vacina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.vacina.model.Vacina;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {

	@Query("FROM Vacina v where v.tipoPet.id = :tipoPetId")
	List<Vacina> findAllByTipoPetId(@Param("tipoPetId") Long id);
	
}
