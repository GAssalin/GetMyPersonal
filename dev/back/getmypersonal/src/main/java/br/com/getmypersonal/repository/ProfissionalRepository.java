package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
}