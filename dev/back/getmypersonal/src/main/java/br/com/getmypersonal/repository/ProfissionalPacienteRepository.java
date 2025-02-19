package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.ProfissionalPaciente;

@Repository
public interface ProfissionalPacienteRepository extends JpaRepository<ProfissionalPaciente, Long> {
}