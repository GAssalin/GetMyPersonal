package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.TreinoExercicio;
import br.com.getmypersonal.service.TreinoExercicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/treinos-exercicios")
public class TreinoExercicioController {

    @Autowired
    private TreinoExercicioService treinoExercicioService;

    /**
     * Lista todos os vínculos entre treinos e exercícios com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de vínculos treino ↔ exercício
     */
    @GetMapping
    @Operation(summary = "Listar vínculos treino ↔ exercício", description = "Retorna uma lista paginada de todos os vínculos entre treinos e exercícios.")
    public Page<TreinoExercicio> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return treinoExercicioService.listarTodos(pageable);
    }

    /**
     * Busca um vínculo treino ↔ exercício pelo ID.
     *
     * @param id identificador do vínculo
     * @return ResponseEntity com o vínculo encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar vínculo por ID", description = "Busca um vínculo entre treino e exercício com base no identificador.")
    public ResponseEntity<TreinoExercicio> buscarPorId(
            @Parameter(description = "ID do vínculo treino ↔ exercício") @PathVariable Long id) {
        Optional<TreinoExercicio> treinoExercicio = treinoExercicioService.buscarPorId(id);
        return treinoExercicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo vínculo treino ↔ exercício.
     *
     * @param treinoExercicio objeto a ser salvo
     * @return ResponseEntity com o vínculo salvo
     */
    @PostMapping
    @Operation(summary = "Criar novo vínculo treino ↔ exercício", description = "Cria um novo vínculo entre um treino e um exercício com os dados fornecidos.")
    public ResponseEntity<TreinoExercicio> criar(
            @RequestBody @Parameter(description = "Dados do novo vínculo treino ↔ exercício") TreinoExercicio treinoExercicio) {
        TreinoExercicio salvo = treinoExercicioService.criar(treinoExercicio);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um vínculo treino ↔ exercício existente.
     *
     * @param id identificador do vínculo
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o vínculo atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar vínculo treino ↔ exercício", description = "Atualiza os dados de um vínculo entre treino e exercício com base no ID informado.")
    public ResponseEntity<TreinoExercicio> atualizar(
            @Parameter(description = "ID do vínculo treino ↔ exercício a ser atualizado") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados do vínculo") TreinoExercicio atualizado) {
        Optional<TreinoExercicio> atualizadoResp = treinoExercicioService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um vínculo treino ↔ exercício pelo ID.
     *
     * @param id identificador do vínculo
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover vínculo treino ↔ exercício", description = "Remove um vínculo entre treino e exercício com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do vínculo treino ↔ exercício a ser removido") @PathVariable Long id) {
        boolean removido = treinoExercicioService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
