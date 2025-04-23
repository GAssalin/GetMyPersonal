package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Estudante;
import br.com.getmypersonal.service.EstudanteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    /**
     * Lista todos os estudantes com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de estudantes
     */
    @GetMapping
    @Operation(summary = "Listar estudantes", description = "Retorna uma lista paginada de todos os estudantes cadastrados.")
    public Page<Estudante> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return estudanteService.listarTodos(pageable);
    }

    /**
     * Busca um estudante pelo ID.
     *
     * @param id identificador do estudante
     * @return ResponseEntity com o estudante encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar estudante por ID", description = "Retorna os dados de um estudante com base no seu identificador.")
    public ResponseEntity<Estudante> buscarPorId(
            @Parameter(description = "ID do estudante") @PathVariable Long id) {
        Optional<Estudante> estudante = estudanteService.buscarPorId(id);
        return estudante.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo estudante.
     *
     * @param estudante objeto estudante a ser salvo
     * @return ResponseEntity com o estudante salvo
     */
    @PostMapping
    @Operation(summary = "Criar novo estudante", description = "Cria um novo estudante com os dados fornecidos.")
    public ResponseEntity<Estudante> criar(
            @RequestBody @Parameter(description = "Dados do novo estudante") Estudante estudante) {
        Estudante salvo = estudanteService.criar(estudante);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um estudante existente.
     *
     * @param id         identificador do estudante
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o estudante atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar estudante", description = "Atualiza os dados de um estudante com base no ID informado.")
    public ResponseEntity<Estudante> atualizar(
            @Parameter(description = "ID do estudante a ser atualizado") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados do estudante") Estudante atualizado) {
        Optional<Estudante> atualizadoResp = estudanteService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um estudante pelo ID.
     *
     * @param id identificador do estudante
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover estudante", description = "Remove um estudante existente com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do estudante a ser removido") @PathVariable Long id) {
        boolean removido = estudanteService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
