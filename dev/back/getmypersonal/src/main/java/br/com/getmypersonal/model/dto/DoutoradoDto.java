package br.com.getmypersonal.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class DoutoradoDto {

    private Long id;
    private String nome;
    private String nomeInstituicao;
    private Integer anoConclusao;
    private List<ProfissionalDoutoradoDto> profissionais;
    private byte[] fotoCertificado;
	
}
