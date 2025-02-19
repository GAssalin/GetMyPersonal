package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avaliacao_neuromotores")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacaoNeuromotores extends Avaliacao {

    @Column(name = "forca_muscular")
    private Integer forcaMuscular; // Escala de 1 a 10

    @Column(name = "equilibrio")
    private Integer equilibrio; // Escala de 1 a 10

    @Column(name = "coordenacao_motora")
    private Integer coordenacaoMotora; // Escala de 1 a 10

    @Column(name = "flexibilidade")
    private Integer flexibilidade; // Escala de 1 a 10
}
