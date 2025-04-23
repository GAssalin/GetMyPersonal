package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoPostural;
import br.com.getmypersonal.service.AvaliacaoPosturalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações posturais
     */
    @GetMapping
    @Operation(summary = "Listar avaliações posturais", description = "Retorna uma lista paginada com todas as avaliações posturais registradas.")
    public Page<AvaliacaoPostural> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return avaliacaoPosturalService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação postural pelo ID.
     *
     * @param id identificador da avaliação postural
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar avaliação postural por ID", description = "Retorna os dados de uma avaliação postural com base no seu identificador.")
    public ResponseEntity<AvaliacaoPostural> buscarPorId(
            @Parameter(description = "ID da avaliação postural") @PathVariable Long id) {
        Optional<AvaliacaoPostural> avaliacao = avaliacaoPosturalService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação postural.
     *
     * @param avaliacao objeto avaliação postural a ser salvo
     * @return ResponseEntity com a avaliação postural salva
     */
    @PostMapping
    @Operation(summary = "Criar nova avaliação postural", description = "Cria uma nova avaliação postural com base nos dados fornecidos.")
    public ResponseEntity<AvaliacaoPostural> criar(
            @RequestBody @Parameter(description = "Dados da nova avaliação postural") AvaliacaoPostural avaliacao) {
        AvaliacaoPostural salva = avaliacaoPosturalService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação postural existente.
     *
     * @param id         identificador da avaliação postural
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar avaliação postural", description = "Atualiza os dados de uma avaliação postural existente com base no ID informado.")
    public ResponseEntity<AvaliacaoPostural> atualizar(
            @Parameter(description = "ID da avaliação postural a ser atualizada") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados da avaliação postural") AvaliacaoPostural atualizada) {
        Optional<AvaliacaoPostural> resposta = avaliacaoPosturalService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação postural pelo ID.
     *
     * @param id identificador da avaliação postural
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover avaliação postural", description = "Remove uma avaliação postural com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da avaliação postural a ser removida") @PathVariable Long id) {
        boolean removida = avaliacaoPosturalService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
