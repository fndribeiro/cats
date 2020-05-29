package br.com.cadastrodepets.ong.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.ong.model.Ong;

public interface OngRepository extends JpaRepository<Ong, Long> {

}
