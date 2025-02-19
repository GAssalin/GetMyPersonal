package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Treino;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
}