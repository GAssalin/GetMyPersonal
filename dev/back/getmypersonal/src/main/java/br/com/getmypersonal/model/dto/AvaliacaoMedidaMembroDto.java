package br.com.getmypersonal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoMedidaMembroDto extends AvaliacaoDto {

	private MembroDto membro;
    private Double circunferencia;
    private Double comprimento; // Medida opcional em centímetros
    
}
