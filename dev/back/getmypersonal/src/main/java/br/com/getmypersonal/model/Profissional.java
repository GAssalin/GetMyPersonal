package br.com.getmypersonal.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfissionalEspecializacao> especialidades;
    
    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfissionalMestrado> mestrados;
    
    @OneToMany(mappedBy = "profissional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfissionalDoutorado> doutorados;
    
    @Column(name = "ano_conclusao")
    private Integer anoConclusao;
    
    @Lob
    @Column(name = "foto_diploma", nullable = false)
    private byte[] diploma;

}
