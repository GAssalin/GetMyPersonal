package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoMedidaMembro;
import br.com.getmypersonal.service.AvaliacaoMedidaMembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacoes-medidas")
public class AvaliacaoMedidaMembroController {

    @Autowired
    private AvaliacaoMedidaMembroService avaliacaoMedidaMembroService;

    /**
     * Lista todas as avaliações de medidas de membros com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações de medidas
     */
    @GetMapping
    public Page<AvaliacaoMedidaMembro> listarTodos(Pageable pageable) {
        return avaliacaoMedidaMembroService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação de medida de membro pelo ID.
     * @param id identificador da avaliação
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoMedidaMembro> buscarPorId(@PathVariable Long id) {
        Optional<AvaliacaoMedidaMembro> avaliacao = avaliacaoMedidaMembroService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação de medida de membro.
     * @param avaliacao objeto avaliação de medida a ser salvo
     * @return ResponseEntity com a avaliação salva
     */
    @PostMapping
    public ResponseEntity<AvaliacaoMedidaMembro> criar(@RequestBody AvaliacaoMedidaMembro avaliacao) {
        AvaliacaoMedidaMembro salva = avaliacaoMedidaMembroService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação de medida de membro existente.
     * @param id identificador da avaliação
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoMedidaMembro> atualizar(@PathVariable Long id, @RequestBody AvaliacaoMedidaMembro atualizada) {
        Optional<AvaliacaoMedidaMembro> resposta = avaliacaoMedidaMembroService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação de medida de membro pelo ID.
     * @param id identificador da avaliação
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = avaliacaoMedidaMembroService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
