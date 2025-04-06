package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getmypersonal.model.Doutorado;
import org.springframework.stereotype.Repository;

@Repository
public interface DoutoradoRepository extends JpaRepository<Doutorado, Long> {

}
