package br.com.getmypersonal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "treinador")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Treinador extends Profissional {

    @Column(nullable = false, length = 20, unique = true)
    private String cref; // Registro do Conselho Regional de Educação Física
}