package br.com.getmypersonal.model.dto;

import lombok.Data;

@Data
public class RestricaoAlimentarDto {

    private Long id;
    private String descricao;
    private PacienteDto paciente;
    
}