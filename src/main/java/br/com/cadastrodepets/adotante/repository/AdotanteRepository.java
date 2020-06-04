package br.com.cadastrodepets.adotante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.adotante.model.Adotante;

@Repository
public interface AdotanteRepository extends JpaRepository<Adotante, Long> {

}
