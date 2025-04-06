package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.ProfissionalDoutorado;

@Repository
public interface ProfissionalDoutoradoRepository extends JpaRepository<ProfissionalDoutorado, Long> {

}
