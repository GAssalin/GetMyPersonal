package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
    
    @Lob
    @Column(name = "foto_frente", nullable = true)
    private byte[] fotoFrente;
    
    @Lob
    @Column(name = "foto_costa", nullable = true)
    private byte[] fotoCosta;
    
    @Lob
    @Column(name = "foto_lateral_direita", nullable = true)
    private byte[] fotoLateralDireita;
    
    @Lob
    @Column(name = "foto_lateral_esquerda", nullable = true)
    private byte[] fotoLateralEsquerda;
    
}
