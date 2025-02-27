package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.getmypersonal.model.Alergia;

public interface AlergiaRepository extends JpaRepository<Alergia, Long> {

}
