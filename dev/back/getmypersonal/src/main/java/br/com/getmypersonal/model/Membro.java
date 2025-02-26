package br.com.getmypersonal.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "membro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membro {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;
    
    @OneToMany(mappedBy = "membro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvaliacaoMedidaMembro> avaliacoes;
	
}
