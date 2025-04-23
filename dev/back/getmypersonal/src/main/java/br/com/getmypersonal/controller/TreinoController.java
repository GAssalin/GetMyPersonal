package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Treino;
import br.com.getmypersonal.service.TreinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    /**
     * Lista todos os treinos com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de treinos
     */
    @GetMapping
    @Operation(summary = "Listar treinos", description = "Retorna uma lista paginada com todos os treinos cadastrados.")
    public Page<Treino> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return treinoService.listarTodos(pageable);
    }

    /**
     * Busca um treino pelo ID.
     *
     * @param id identificador do treino
     * @return ResponseEntity com o treino encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar treino por ID", description = "Retorna os dados de um treino com base no seu identificador.")
    public ResponseEntity<Treino> buscarPorId(
            @Parameter(description = "ID do treino") @PathVariable Long id) {
        Optional<Treino> treino = treinoService.buscarPorId(id);
        return treino.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo treino.
     *
     * @param treino objeto treino a ser salvo
     * @return ResponseEntity com o treino salvo
     */
    @PostMapping
    @Operation(summary = "Criar novo treino", description = "Cria um novo treino com os dados fornecidos.")
    public ResponseEntity<Treino> criar(
            @RequestBody @Parameter(description = "Dados do novo treino") Treino treino) {
        Treino salvo = treinoService.criar(treino);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um treino existente.
     *
     * @param id identificador do treino
     * @param treinoAtualizado objeto com os dados atualizados
     * @return ResponseEntity com o treino atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar treino", description = "Atualiza os dados de um treino existente com base no ID informado.")
    public ResponseEntity<Treino> atualizar(
            @Parameter(description = "ID do treino a ser atualizado") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados do treino") Treino treinoAtualizado) {
        Optional<Treino> atualizado = treinoService.atualizar(id, treinoAtualizado);
        return atualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um treino pelo ID.
     *
     * @param id identificador do treino
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover treino", description = "Remove um treino com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do treino a ser removido") @PathVariable Long id) {
        boolean removido = treinoService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
