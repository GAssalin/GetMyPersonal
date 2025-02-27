package br.com.getmypersonal.model.dto;

import lombok.Data;

@Data
public class ProfissionalMestradoDto {

    private Long id;
    private ProfissionalDto profissional;
    private MestradoDto mestrado;
	
}
