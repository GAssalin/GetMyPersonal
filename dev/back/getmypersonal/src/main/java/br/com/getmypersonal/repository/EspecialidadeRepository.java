package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Especialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
}