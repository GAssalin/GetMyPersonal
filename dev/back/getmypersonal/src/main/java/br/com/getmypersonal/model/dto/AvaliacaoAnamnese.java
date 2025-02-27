package br.com.getmypersonal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoAnamnese extends AvaliacaoDto {

    private String historicoSaude;
    private String doencasPreexistentes;
    private String usoMedicacoes;
    
}
