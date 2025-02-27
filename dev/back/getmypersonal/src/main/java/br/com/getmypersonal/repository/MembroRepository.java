package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getmypersonal.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Long> {

}
