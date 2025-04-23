package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Profissional;
import br.com.getmypersonal.service.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    /**
     * Lista todos os profissionais com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de profissionais
     */
    @GetMapping
    @Operation(summary = "Listar profissionais", description = "Retorna uma lista paginada de todos os profissionais cadastrados.")
    public Page<Profissional> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return profissionalService.listarTodos(pageable);
    }

    /**
     * Busca um profissional pelo ID.
     *
     * @param id identificador do profissional
     * @return ResponseEntity com o profissional encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar profissional por ID", description = "Retorna os dados de um profissional com base no seu identificador.")
    public ResponseEntity<Profissional> buscarPorId(
            @Parameter(description = "ID do profissional") @PathVariable Long id) {
        Optional<Profissional> profissional = profissionalService.buscarPorId(id);
        return profissional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo profissional.
     *
     * @param profissional objeto profissional a ser salvo
     * @return ResponseEntity com o profissional salvo
     */
    @PostMapping
    @Operation(summary = "Criar novo profissional", description = "Cria um novo profissional com os dados fornecidos.")
    public ResponseEntity<Profissional> criar(
            @RequestBody @Parameter(description = "Dados do novo profissional") Profissional profissional) {
        Profissional salvo = profissionalService.criar(profissional);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um profissional existente.
     *
     * @param id identificador do profissional
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o profissional atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar profissional", description = "Atualiza os dados de um profissional com base no ID informado.")
    public ResponseEntity<Profissional> atualizar(
            @Parameter(description = "ID do profissional a ser atualizado") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados do profissional") Profissional atualizado) {
        Optional<Profissional> atualizadoResp = profissionalService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um profissional pelo ID.
     *
     * @param id identificador do profissional
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover profissional", description = "Remove um profissional com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do profissional a ser removido") @PathVariable Long id) {
        boolean removido = profissionalService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
