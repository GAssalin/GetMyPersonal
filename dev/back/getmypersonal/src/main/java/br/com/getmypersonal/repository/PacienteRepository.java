package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}