package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}