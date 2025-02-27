package br.com.getmypersonal.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.getmypersonal.model.StatusConsulta;
import lombok.Data;

@Data
public class ConsultaDto {

	private Long id;
	private PacienteDto paciente;
	private ProfissionalDto profissional;
	private EstudanteDto estudante;
	private LocalDateTime dataHora;
	private StatusConsulta status;
	private String observacoes;
    private List<AvaliacaoDto> avaliacoes;
    private List<TreinoDto> treinos;

}
