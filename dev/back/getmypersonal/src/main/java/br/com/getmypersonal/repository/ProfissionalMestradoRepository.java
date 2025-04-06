package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.ProfissionalMestrado;

@Repository
public interface ProfissionalMestradoRepository extends JpaRepository<ProfissionalMestrado, Long> {

}
