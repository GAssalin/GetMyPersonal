package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getmypersonal.model.Mestrado;
import org.springframework.stereotype.Repository;

@Repository
public interface MestradoRepository extends JpaRepository<Mestrado, Long> {

}
