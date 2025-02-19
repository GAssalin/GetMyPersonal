package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.AvaliacaoAnamnese;

@Repository
public interface AvaliacaoAnamneseRepository extends JpaRepository<AvaliacaoAnamnese, Long> {
}