package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getmypersonal.model.RestricaoAlimentar;
import org.springframework.stereotype.Repository;

@Repository
public interface RestricaoAlimentarRepository extends JpaRepository<RestricaoAlimentar, Long> {

}
