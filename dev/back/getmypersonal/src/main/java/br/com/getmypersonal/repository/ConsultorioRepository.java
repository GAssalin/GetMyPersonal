package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Consultorio;

@Repository
public interface ConsultorioRepository extends JpaRepository<Consultorio, Long> {
}