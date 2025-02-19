package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "profissional")
@NoArgsConstructor
@AllArgsConstructor
public abstract class Profissional extends Pessoa {

    @Column(nullable = false, length = 50)
    private String registroProfissional;

    @Column(nullable = false, length = 100)
    private String especialidade;
}
