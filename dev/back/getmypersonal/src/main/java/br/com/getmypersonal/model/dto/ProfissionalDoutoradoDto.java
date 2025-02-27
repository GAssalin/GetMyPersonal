package br.com.getmypersonal.model.dto;

import lombok.Data;

@Data
public class ProfissionalDoutoradoDto {

    private Long id;
    private ProfissionalDto profissional;
    private DoutoradoDto doutorado;
	
}
