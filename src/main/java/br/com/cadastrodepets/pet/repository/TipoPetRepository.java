package br.com.cadastrodepets.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.pet.model.TipoPet;

public interface TipoPetRepository extends JpaRepository<TipoPet, Long> {

}
