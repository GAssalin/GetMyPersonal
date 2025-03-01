package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "anamnese_perguntas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnamnesePerguntas {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "tipo_anamnese", nullable = false, length = 20)
    private TipoAnamnese tipoAnamnese;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String pergunta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_resposta", nullable = false, length = 20)
    private TipoRespostaAnamnese tipoResposta;

    @Column(name = "opcoes_resposta", columnDefinition = "TEXT")
    private String opcoesResposta;

}
