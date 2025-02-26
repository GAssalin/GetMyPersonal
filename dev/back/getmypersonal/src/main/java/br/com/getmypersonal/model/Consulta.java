package br.com.getmypersonal.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "profissional_id")
	private Profissional profissional;

	@ManyToOne
	@JoinColumn(name = "estudante_id")
	private Estudante estudante;

	@Column(name = "data_hora", nullable = false)
	private LocalDateTime dataHora;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@Builder.Default
	private StatusConsulta status = StatusConsulta.DISPONIVEL;

	@Column(columnDefinition = "TEXT")
	private String observacoes;

	@OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes;
	
	@OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treino> treinos;

}
