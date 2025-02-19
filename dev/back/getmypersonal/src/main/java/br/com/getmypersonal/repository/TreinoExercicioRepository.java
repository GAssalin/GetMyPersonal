package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.TreinoExercicio;

@Repository
public interface TreinoExercicioRepository extends JpaRepository<TreinoExercicio, Long> {
}