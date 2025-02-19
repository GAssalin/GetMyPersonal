package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avaliacao_medida_membro")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacaoMedidaMembro extends Avaliacao {

    @Column(name = "membro", nullable = false, length = 50)
    private String membro;

    @Column(name = "circunferencia", nullable = false)
    private Double circunferencia; // Medida em centímetros

    @Column(name = "comprimento")
    private Double comprimento; // Medida opcional em centímetros
}
