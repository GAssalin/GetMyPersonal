package br.com.getmypersonal.model.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfissionalDto extends PessoaDto {

    private String registroProfissional;
    private List<ProfissionalEspecializacaoDto> especialidades;
    private List<ProfissionalMestradoDto> mestrados;
    private List<ProfissionalDoutoradoDto> doutorados;
    private Integer anoConclusao;
    private byte[] diploma;

}
