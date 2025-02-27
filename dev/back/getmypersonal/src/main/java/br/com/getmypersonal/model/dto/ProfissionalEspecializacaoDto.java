package br.com.getmypersonal.model.dto;

import lombok.Data;

@Data
public class ProfissionalEspecializacaoDto {

    private Long id;
    private ProfissionalDto profissional;
    private EspecializacaoDto especialidade;
    
}
