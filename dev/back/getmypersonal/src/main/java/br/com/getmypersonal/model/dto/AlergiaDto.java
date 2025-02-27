package br.com.getmypersonal.model.dto;

import lombok.Data;

@Data
public class AlergiaDto {

    private Long id;
    private String nome;
    private PacienteDto paciente;
    
}