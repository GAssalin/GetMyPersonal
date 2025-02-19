package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.AvaliacaoPostural;

@Repository
public interface AvaliacaoPosturalRepository extends JpaRepository<AvaliacaoPostural, Long> {
}