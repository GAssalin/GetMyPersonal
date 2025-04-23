package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoNeuromotores;
import br.com.getmypersonal.service.AvaliacaoNeuromotoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações neuromotoras
     */
    @GetMapping
    @Operation(summary = "Listar avaliações neuromotoras", description = "Retorna uma lista paginada com todas as avaliações neuromotoras registradas.")
    public Page<AvaliacaoNeuromotores> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return avaliacaoNeuromotoresService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação neuromotora pelo ID.
     *
     * @param id identificador da avaliação neuromotora
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar avaliação neuromotora por ID", description = "Retorna os dados de uma avaliação neuromotora com base no seu identificador.")
    public ResponseEntity<AvaliacaoNeuromotores> buscarPorId(
            @Parameter(description = "ID da avaliação neuromotora") @PathVariable Long id) {
        Optional<AvaliacaoNeuromotores> avaliacao = avaliacaoNeuromotoresService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação neuromotora.
     *
     * @param avaliacao objeto avaliação neuromotora a ser salvo
     * @return ResponseEntity com a avaliação neuromotora salva
     */
    @PostMapping
    @Operation(summary = "Criar nova avaliação neuromotora", description = "Cria uma nova avaliação neuromotora com base nos dados fornecidos.")
    public ResponseEntity<AvaliacaoNeuromotores> criar(
            @RequestBody @Parameter(description = "Dados da nova avaliação neuromotora") AvaliacaoNeuromotores avaliacao) {
        AvaliacaoNeuromotores salva = avaliacaoNeuromotoresService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação neuromotora existente.
     *
     * @param id         identificador da avaliação neuromotora
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar avaliação neuromotora", description = "Atualiza os dados de uma avaliação neuromotora existente com base no ID informado.")
    public ResponseEntity<AvaliacaoNeuromotores> atualizar(
            @Parameter(description = "ID da avaliação neuromotora a ser atualizada") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados da avaliação") AvaliacaoNeuromotores atualizada) {
        Optional<AvaliacaoNeuromotores> resposta = avaliacaoNeuromotoresService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação neuromotora pelo ID.
     *
     * @param id identificador da avaliação neuromotora
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover avaliação neuromotora", description = "Remove uma avaliação neuromotora com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da avaliação neuromotora a ser removida") @PathVariable Long id) {
        boolean removida = avaliacaoNeuromotoresService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
