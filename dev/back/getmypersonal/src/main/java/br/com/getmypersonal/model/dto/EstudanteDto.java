package br.com.getmypersonal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstudanteDto extends PessoaDto {

    private String instituicaoEnsino;
    private String curso;
}
