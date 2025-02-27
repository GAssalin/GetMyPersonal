package br.com.getmypersonal.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AvaliacaoDto {

    private Long id;
    private PacienteDto paciente;
    private ProfissionalDto profissional;
    private EstudanteDto estudante;
    private LocalDate dataAvaliacao;
    private String observacoes;
    private ConsultaDto consulta;
    
}
