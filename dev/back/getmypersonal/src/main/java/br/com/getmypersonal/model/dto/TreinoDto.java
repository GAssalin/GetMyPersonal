package br.com.getmypersonal.model.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.getmypersonal.model.ObjetivoTreino;
import br.com.getmypersonal.model.TipoTreino;
import lombok.Data;

@Data
public class TreinoDto {

    private Long id;
    private String nome;
    private String descricao;
    private Integer duracao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private TipoTreino tipo;
    private TreinadorDto treinador;
    private PacienteDto aluno;
    private List<TreinoExercicioDto> exercicios;
    private ObjetivoTreino objetivo;
    private ConsultaDto consulta;
    
}
