package br.com.getmypersonal.model.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProfissionalPacienteDto {

    private Long id;
    private ProfissionalDto profissional;
    private PacienteDto paciente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
