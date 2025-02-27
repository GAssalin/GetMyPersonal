package br.com.getmypersonal.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class EspecializacaoDto {

    private Long id;
    private String nome;
    private String nomeInstituicao;
    private Integer anoConclusao;
    private List<ProfissionalEspecializacaoDto> profissionais;
    private byte[] fotoCertificado;
    
}
