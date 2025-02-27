package br.com.getmypersonal.model.dto;

import lombok.Data;

@Data
public class EnderecoDto {

    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private PessoaDto pessoa;
    
}
