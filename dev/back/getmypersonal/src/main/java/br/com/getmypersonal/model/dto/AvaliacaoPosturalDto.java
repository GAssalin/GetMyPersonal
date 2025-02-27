package br.com.getmypersonal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoPosturalDto extends AvaliacaoDto {

    private String observacao;
    private byte[] fotoFrente;
    private byte[] fotoCosta;
    private byte[] fotoLateralDireita;
    private byte[] fotoLateralEsquerda;
    
}
