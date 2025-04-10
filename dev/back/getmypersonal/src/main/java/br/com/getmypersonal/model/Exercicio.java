package br.com.getmypersonal.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GrupoMuscular grupoMuscular;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelDificuldade dificuldade;
    
    @OneToMany(mappedBy = "exercicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreinoExercicio> treinos;
    
}