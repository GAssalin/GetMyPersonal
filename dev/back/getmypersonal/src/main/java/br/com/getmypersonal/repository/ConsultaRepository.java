package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}