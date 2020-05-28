package br.com.cadastrodepets.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.pet.model.RacaPet;

public interface RacaPetRepository extends JpaRepository<RacaPet, Long> {

}
