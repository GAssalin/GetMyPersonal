package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Exercicio;

@Repository
public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
}