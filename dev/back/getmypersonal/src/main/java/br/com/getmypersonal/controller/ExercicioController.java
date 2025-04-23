package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Exercicio;
import br.com.getmypersonal.service.ExercicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioService exercicioService;

    /**
     * Lista todos os exercícios com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de exercícios
     */
    @GetMapping
    @Operation(summary = "Listar exercícios", description = "Retorna uma lista paginada de todos os exercícios cadastrados.")
    public Page<Exercicio> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return exercicioService.listarTodos(pageable);
    }

    /**
     * Busca um exercício pelo ID.
     *
     * @param id identificador do exercício
     * @return ResponseEntity com o exercício encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar exercício por ID", description = "Retorna os dados de um exercício com base no seu identificador.")
    public ResponseEntity<Exercicio> buscarPorId(
            @Parameter(description = "ID do exercício") @PathVariable Long id) {
        Optional<Exercicio> exercicio = exercicioService.buscarPorId(id);
        return exercicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo exercício.
     *
     * @param exercicio objeto exercício a ser salvo
     * @return ResponseEntity com o exercício salvo
     */
    @PostMapping
    @Operation(summary = "Criar novo exercício", description = "Cria um novo exercício com os dados fornecidos.")
    public ResponseEntity<Exercicio> criar(
            @RequestBody @Parameter(description = "Dados do novo exercício") Exercicio exercicio) {
        Exercicio salvo = exercicioService.criar(exercicio);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um exercício existente.
     *
     * @param id identificador do exercício
     * @param exercicioAtualizado objeto com os dados atualizados
     * @return ResponseEntity com o exercício atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar exercício", description = "Atualiza os dados de um exercício com base no ID informado.")
    public ResponseEntity<Exercicio> atualizar(
            @Parameter(description = "ID do exercício a ser atualizado") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados do exercício") Exercicio exercicioAtualizado) {
        Optional<Exercicio> atualizado = exercicioService.atualizar(id, exercicioAtualizado);
        return atualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um exercício pelo ID.
     *
     * @param id identificador do exercício
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover exercício", description = "Remove um exercício com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do exercício a ser removido") @PathVariable Long id) {
        boolean removido = exercicioService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
