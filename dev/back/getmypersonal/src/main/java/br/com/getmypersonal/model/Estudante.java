package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudante")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estudante extends Pessoa {

    @Column(nullable = false, length = 50)
    private String instituicaoEnsino;

    @Column(nullable = false, length = 50)
    private String curso;
}
