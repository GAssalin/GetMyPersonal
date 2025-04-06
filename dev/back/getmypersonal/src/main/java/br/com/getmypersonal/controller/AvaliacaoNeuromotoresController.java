package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoNeuromotores;
import br.com.getmypersonal.service.AvaliacaoNeuromotoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacoes-neuromotoras")
public class AvaliacaoNeuromotoresController {

    @Autowired
    private AvaliacaoNeuromotoresService avaliacaoNeuromotoresService;

    /**
     * Lista todas as avaliações neuromotoras com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações neuromotoras
     */
    @GetMapping
    public Page<AvaliacaoNeuromotores> listarTodos(Pageable pageable) {
        return avaliacaoNeuromotoresService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação neuromotora pelo ID.
     * @param id identificador da avaliação neuromotora
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoNeuromotores> buscarPorId(@PathVariable Long id) {
        Optional<AvaliacaoNeuromotores> avaliacao = avaliacaoNeuromotoresService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação neuromotora.
     * @param avaliacao objeto avaliação neuromotora a ser salvo
     * @return ResponseEntity com a avaliação neuromotora salva
     */
    @PostMapping
    public ResponseEntity<AvaliacaoNeuromotores> criar(@RequestBody AvaliacaoNeuromotores avaliacao) {
        AvaliacaoNeuromotores salva = avaliacaoNeuromotoresService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação neuromotora existente.
     * @param id identificador da avaliação neuromotora
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoNeuromotores> atualizar(@PathVariable Long id, @RequestBody AvaliacaoNeuromotores atualizada) {
        Optional<AvaliacaoNeuromotores> resposta = avaliacaoNeuromotoresService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação neuromotora pelo ID.
     * @param id identificador da avaliação neuromotora
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = avaliacaoNeuromotoresService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
