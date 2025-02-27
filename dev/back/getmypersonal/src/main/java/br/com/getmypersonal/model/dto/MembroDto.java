package br.com.getmypersonal.model.dto;

import java.util.List;

import lombok.Data;

@Data
public class MembroDto {

    private Long id;
    private String nome;
    private List<AvaliacaoMedidaMembroDto> avaliacoes;
	
}
