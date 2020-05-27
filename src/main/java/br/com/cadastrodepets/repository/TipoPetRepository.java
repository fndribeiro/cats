package br.com.cadastrodepets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.model.TipoPet;

public interface TipoPetRepository extends JpaRepository<TipoPet, Long> {

}
