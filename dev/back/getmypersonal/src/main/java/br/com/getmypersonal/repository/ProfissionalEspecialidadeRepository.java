package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.ProfissionalEspecialidade;

@Repository
public interface ProfissionalEspecialidadeRepository extends JpaRepository<ProfissionalEspecialidade, Long> {
}