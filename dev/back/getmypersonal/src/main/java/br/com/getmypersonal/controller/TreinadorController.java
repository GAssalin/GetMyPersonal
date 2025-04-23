package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Treinador;
import br.com.getmypersonal.service.TreinadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/treinadores")
public class TreinadorController {

    @Autowired
    private TreinadorService treinadorService;

    /**
     * Lista todos os treinadores com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de treinadores
     */
    @GetMapping
    @Operation(summary = "Listar treinadores", description = "Retorna uma lista paginada de todos os treinadores cadastrados.")
    public Page<Treinador> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return treinadorService.listarTodos(pageable);
    }

    /**
     * Busca um treinador pelo ID.
     *
     * @param id identificador do treinador
     * @return ResponseEntity com o treinador encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar treinador por ID", description = "Retorna os dados de um treinador com base no seu identificador.")
    public ResponseEntity<Treinador> buscarPorId(
            @Parameter(description = "ID do treinador") @PathVariable Long id) {
        Optional<Treinador> treinador = treinadorService.buscarPorId(id);
        return treinador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo treinador.
     *
     * @param treinador objeto treinador a ser salvo
     * @return ResponseEntity com o treinador salvo
     */
    @PostMapping
    @Operation(summary = "Criar novo treinador", description = "Cria um novo treinador com os dados fornecidos.")
    public ResponseEntity<Treinador> criar(
            @RequestBody @Parameter(description = "Dados do novo treinador") Treinador treinador) {
        Treinador salvo = treinadorService.criar(treinador);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um treinador existente.
     *
     * @param id identificador do treinador
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o treinador atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar treinador", description = "Atualiza os dados de um treinador com base no ID informado.")
    public ResponseEntity<Treinador> atualizar(
            @Parameter(description = "ID do treinador a ser atualizado") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados do treinador") Treinador atualizado) {
        Optional<Treinador> atualizadoResp = treinadorService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um treinador pelo ID.
     *
     * @param id identificador do treinador
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover treinador", description = "Remove um treinador com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do treinador a ser removido") @PathVariable Long id) {
        boolean removido = treinadorService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
