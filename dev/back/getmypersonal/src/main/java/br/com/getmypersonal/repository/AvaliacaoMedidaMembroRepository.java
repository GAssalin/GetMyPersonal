package br.com.getmypersonal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.getmypersonal.model.AvaliacaoMedidaMembro;

@Repository
public interface AvaliacaoMedidaMembroRepository extends JpaRepository<AvaliacaoMedidaMembro, Long> {
}