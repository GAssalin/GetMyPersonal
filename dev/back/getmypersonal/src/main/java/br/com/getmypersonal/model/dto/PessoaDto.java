package br.com.getmypersonal.model.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.getmypersonal.model.NivelDificuldade;
import br.com.getmypersonal.model.Sexo;
import lombok.Data;

@Data
public class PessoaDto {

    private Long id;
    private String nome;
    private String cpf;
    private Sexo sexo;
    private LocalDate dataNascimento;
    private List<ContatoDto> contatos;
    private NivelDificuldade dificuldade;
    
}
