package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalDoutorado extends JpaRepository<ProfissionalDoutorado, Long> {

}
