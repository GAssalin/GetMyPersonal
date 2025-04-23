package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoAnamnese;
import br.com.getmypersonal.service.AvaliacaoAnamneseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações de anamnese
     */
    @GetMapping
    @Operation(summary = "Listar avaliações de anamnese", description = "Retorna uma lista paginada de todas as avaliações de anamnese registradas.")
    public Page<AvaliacaoAnamnese> listarTodos(Pageable pageable) {
        return avaliacaoAnamneseService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação de anamnese pelo ID.
     *
     * @param id identificador da avaliação de anamnese
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar avaliação por ID", description = "Busca uma avaliação de anamnese com base no identificador fornecido.")
    public ResponseEntity<AvaliacaoAnamnese> buscarPorId(
            @Parameter(description = "ID da avaliação de anamnese") @PathVariable Long id) {
        Optional<AvaliacaoAnamnese> avaliacao = avaliacaoAnamneseService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação de anamnese.
     *
     * @param avaliacao objeto avaliação de anamnese a ser salvo
     * @return ResponseEntity com a avaliação de anamnese salva
     */
    @PostMapping
    @Operation(summary = "Criar nova avaliação", description = "Cria uma nova avaliação de anamnese com base nos dados informados.")
    public ResponseEntity<AvaliacaoAnamnese> criar(
            @RequestBody @Parameter(description = "Dados da nova avaliação de anamnese") AvaliacaoAnamnese avaliacao) {
        AvaliacaoAnamnese salva = avaliacaoAnamneseService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação de anamnese existente.
     *
     * @param id         identificador da avaliação de anamnese
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar avaliação", description = "Atualiza os dados de uma avaliação de anamnese existente.")
    public ResponseEntity<AvaliacaoAnamnese> atualizar(
            @Parameter(description = "ID da avaliação de anamnese a ser atualizada") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados da avaliação de anamnese") AvaliacaoAnamnese atualizada) {
        Optional<AvaliacaoAnamnese> resposta = avaliacaoAnamneseService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação de anamnese pelo ID.
     *
     * @param id identificador da avaliação de anamnese
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover avaliação", description = "Remove uma avaliação de anamnese com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da avaliação de anamnese a ser removida") @PathVariable Long id) {
        boolean removida = avaliacaoAnamneseService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
