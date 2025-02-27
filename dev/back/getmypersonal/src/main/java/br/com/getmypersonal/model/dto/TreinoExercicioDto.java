package br.com.getmypersonal.model.dto;

import lombok.Data;

@Data
public class TreinoExercicioDto {

    private Long id;
    private TreinoDto treino;
    private ExercicioDto exercicio;
    private Integer series;
    private Integer repeticoes;
    private Double carga;
    
}