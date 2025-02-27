package br.com.getmypersonal.model.dto;

import java.util.List;

import br.com.getmypersonal.model.GrupoMuscular;
import br.com.getmypersonal.model.NivelDificuldade;
import lombok.Data;

@Data
public class ExercicioDto {

    private Long id;
    private String nome;
    private String descricao;
    private GrupoMuscular grupoMuscular;
    private NivelDificuldade dificuldade;
    private List<TreinoExercicioDto> treinos;
    
}