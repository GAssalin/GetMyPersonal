package br.com.getmypersonal.model.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDto extends PessoaDto {

    private String observacoes;
    private LocalDate dataCadastro;
    private ProfissionalDto profissionalResponsavel;
    private List<AlergiaDto> alergias;
    private List<RestricaoAlimentarDto> restricoes;
    
}
