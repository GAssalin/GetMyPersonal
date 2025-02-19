package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.AvaliacaoNeuromotores;

@Repository
public interface AvaliacaoNeuromotoresRepository extends JpaRepository<AvaliacaoNeuromotores, Long> {
}