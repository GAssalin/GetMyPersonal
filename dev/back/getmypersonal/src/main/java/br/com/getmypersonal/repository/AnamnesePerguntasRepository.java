package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getmypersonal.model.AnamnesePerguntas;
import org.springframework.stereotype.Repository;

@Repository
public interface AnamnesePerguntasRepository extends JpaRepository<AnamnesePerguntas, Long> {

}
