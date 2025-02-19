package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avaliacao_postural")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacaoPostural extends Avaliacao {

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;
}
