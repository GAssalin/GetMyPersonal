package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AvaliacaoMedidaMembro;
import br.com.getmypersonal.service.AvaliacaoMedidaMembroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações de medidas
     */
    @GetMapping
    @Operation(summary = "Listar avaliações de medidas de membros", description = "Retorna uma lista paginada com todas as avaliações de medidas dos membros.")
    public Page<AvaliacaoMedidaMembro> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return avaliacaoMedidaMembroService.listarTodos(pageable);
    }

    /**
     * Busca uma avaliação de medida de membro pelo ID.
     *
     * @param id identificador da avaliação
     * @return ResponseEntity com a avaliação encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar avaliação por ID", description = "Retorna os dados de uma avaliação de medida de membro com base no seu ID.")
    public ResponseEntity<AvaliacaoMedidaMembro> buscarPorId(
            @Parameter(description = "ID da avaliação de medida de membro") @PathVariable Long id) {
        Optional<AvaliacaoMedidaMembro> avaliacao = avaliacaoMedidaMembroService.buscarPorId(id);
        return avaliacao.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova avaliação de medida de membro.
     *
     * @param avaliacao objeto avaliação de medida a ser salvo
     * @return ResponseEntity com a avaliação salva
     */
    @PostMapping
    @Operation(summary = "Criar nova avaliação", description = "Cria uma nova avaliação de medida de membro com base nos dados informados.")
    public ResponseEntity<AvaliacaoMedidaMembro> criar(
            @RequestBody @Parameter(description = "Dados da nova avaliação de medida de membro") AvaliacaoMedidaMembro avaliacao) {
        AvaliacaoMedidaMembro salva = avaliacaoMedidaMembroService.criar(avaliacao);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma avaliação de medida de membro existente.
     *
     * @param id         identificador da avaliação
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a avaliação atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar avaliação existente", description = "Atualiza os dados de uma avaliação de medida de membro com base no ID informado.")
    public ResponseEntity<AvaliacaoMedidaMembro> atualizar(
            @Parameter(description = "ID da avaliação de medida de membro a ser atualizada") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados da avaliação") AvaliacaoMedidaMembro atualizada) {
        Optional<AvaliacaoMedidaMembro> resposta = avaliacaoMedidaMembroService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma avaliação de medida de membro pelo ID.
     *
     * @param id identificador da avaliação
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover avaliação", description = "Remove uma avaliação de medida de membro com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da avaliação de medida de membro a ser removida") @PathVariable Long id) {
        boolean removida = avaliacaoMedidaMembroService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
