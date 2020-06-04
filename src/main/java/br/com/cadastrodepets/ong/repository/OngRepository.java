package br.com.cadastrodepets.ong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.ong.model.Ong;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long> {

}
