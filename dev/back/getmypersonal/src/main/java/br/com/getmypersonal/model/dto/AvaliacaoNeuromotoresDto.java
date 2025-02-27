package br.com.getmypersonal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoNeuromotoresDto extends AvaliacaoDto {

    private Integer forcaMuscular;
    private Integer equilibrio;
    private Integer coordenacaoMotora;
    private Integer flexibilidade;
}
