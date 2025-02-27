package br.com.getmypersonal.model.dto;

import br.com.getmypersonal.model.TipoContato;
import lombok.Data;

@Data
public class ContatoDto {

    private Long id;
    private PessoaDto pessoa;
    private TipoContato tipo;
    private String valor;
    
}
