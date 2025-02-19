package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Treinador;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Long> {
}