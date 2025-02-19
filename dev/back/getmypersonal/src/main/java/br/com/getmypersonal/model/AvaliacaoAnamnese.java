package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "avaliacao_anamnese")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AvaliacaoAnamnese extends Avaliacao {

    @Column(name = "historico_saude", columnDefinition = "TEXT")
    private String historicoSaude;

    @Column(name = "doencas_preexistentes", columnDefinition = "TEXT")
    private String doencasPreexistentes;

    @Column(name = "uso_medicacoes", columnDefinition = "TEXT")
    private String usoMedicacoes;
}
