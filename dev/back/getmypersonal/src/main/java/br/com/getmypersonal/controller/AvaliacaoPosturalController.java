package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoPostural;
import br.com.getmypersonal.service.AvaliacaoPosturalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacoes-posturais")
public class AvaliacaoPosturalController {

    @Autowired
    private AvaliacaoPosturalService avaliacaoPosturalService;

    /**
     * Lista todas as avaliações posturais com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações posturais
     */
    @GetMapping
    public Page<AvaliacaoPostural> listarTodos(Pageable pageable) {
        return avaliacaoPosturalService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação postural pelo ID.
     * @param id identificador da avaliação postural
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoPostural> buscarPorId(@PathVariable Long id) {
        Optional<AvaliacaoPostural> avaliacao = avaliacaoPosturalService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação postural.
     * @param avaliacao objeto avaliação postural a ser salvo
     * @return ResponseEntity com a avaliação postural salva
     */
    @PostMapping
    public ResponseEntity<AvaliacaoPostural> criar(@RequestBody AvaliacaoPostural avaliacao) {
        AvaliacaoPostural salva = avaliacaoPosturalService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação postural existente.
     * @param id identificador da avaliação postural
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoPostural> atualizar(@PathVariable Long id, @RequestBody AvaliacaoPostural atualizada) {
        Optional<AvaliacaoPostural> resposta = avaliacaoPosturalService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação postural pelo ID.
     * @param id identificador da avaliação postural
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = avaliacaoPosturalService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
