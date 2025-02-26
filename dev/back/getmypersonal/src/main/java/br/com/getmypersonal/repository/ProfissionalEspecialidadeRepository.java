package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.ProfissionalEspecializacao;

@Repository
public interface ProfissionalEspecialidadeRepository extends JpaRepository<ProfissionalEspecializacao, Long> {
}