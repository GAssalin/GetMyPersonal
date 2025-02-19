package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}