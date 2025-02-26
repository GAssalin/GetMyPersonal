package br.com.getmypersonal.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "especializacao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Especializacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nome;
    
    @Column(name = "nome_instituicao")
    private String nomeInstituicao;
    
    @Column(name = "ano_conclusao")
    private Integer anoConclusao;
    
    @OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfissionalEspecializacao> profissionais;
    
    @Lob
    @Column(name = "foto_certificado", nullable = false)
    private byte[] fotoCertificado;
    
}
