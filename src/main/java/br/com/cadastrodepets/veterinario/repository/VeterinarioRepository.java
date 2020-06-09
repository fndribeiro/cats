package br.com.cadastrodepets.veterinario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrodepets.veterinario.model.Veterinario;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

}
