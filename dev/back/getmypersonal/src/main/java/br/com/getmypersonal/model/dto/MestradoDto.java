package br.com.getmypersonal.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class MestradoDto {

    private Long id;
    private String nome;
    private String nomeInstituicao;
    private Integer anoConclusao;
    private List<ProfissionalMestradoDto> profissionais;
    private byte[] fotoCertificado;
	
}
