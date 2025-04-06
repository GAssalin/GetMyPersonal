package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoAnamnese;
import br.com.getmypersonal.service.AvaliacaoAnamneseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacoes-anamnese")
public class AvaliacaoAnamneseController {

    @Autowired
    private AvaliacaoAnamneseService avaliacaoAnamneseService;

    /**
     * Lista todas as avaliações de anamnese com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações de anamnese
     */
    @GetMapping
    public Page<AvaliacaoAnamnese> listarTodos(Pageable pageable) {
        return avaliacaoAnamneseService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação de anamnese pelo ID.
     * @param id identificador da avaliação de anamnese
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoAnamnese> buscarPorId(@PathVariable Long id) {
        Optional<AvaliacaoAnamnese> avaliacao = avaliacaoAnamneseService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação de anamnese.
     * @param avaliacao objeto avaliação de anamnese a ser salvo
     * @return ResponseEntity com a avaliação de anamnese salva
     */
    @PostMapping
    public ResponseEntity<AvaliacaoAnamnese> criar(@RequestBody AvaliacaoAnamnese avaliacao) {
        AvaliacaoAnamnese salva = avaliacaoAnamneseService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação de anamnese existente.
     * @param id identificador da avaliação de anamnese
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoAnamnese> atualizar(@PathVariable Long id, @RequestBody AvaliacaoAnamnese atualizada) {
        Optional<AvaliacaoAnamnese> resposta = avaliacaoAnamneseService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação de anamnese pelo ID.
     * @param id identificador da avaliação de anamnese
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = avaliacaoAnamneseService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
