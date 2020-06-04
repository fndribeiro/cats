package br.com.cadastrodepets.veterinario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastrodepets.veterinario.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

}
