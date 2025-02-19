package br.com.getmypersonal.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "paciente")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paciente extends Pessoa {

    @Column(length = 255)
    private String observacoes;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    @ManyToOne
    @JoinColumn(name = "profissional_responsavel_id", nullable = false)
    private Profissional profissionalResponsavel;
}
