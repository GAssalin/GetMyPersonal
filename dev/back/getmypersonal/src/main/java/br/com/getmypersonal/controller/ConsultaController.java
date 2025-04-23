package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Consulta;
import br.com.getmypersonal.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    /**
     * Lista todas as consultas com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de consultas
     */
    @GetMapping
    @Operation(summary = "Listar consultas", description = "Retorna uma lista paginada de todas as consultas registradas no sistema.")
    public Page<Consulta> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return consultaService.listarTodos(pageable);
    }

    /**
     * Busca uma consulta pelo ID.
     *
     * @param id identificador da consulta
     * @return ResponseEntity com a consulta encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar consulta por ID", description = "Busca os dados de uma consulta com base no seu identificador.")
    public ResponseEntity<Consulta> buscarPorId(
            @Parameter(description = "ID da consulta") @PathVariable Long id) {
        Optional<Consulta> consulta = consultaService.buscarPorId(id);
        return consulta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova consulta.
     *
     * @param consulta objeto consulta a ser salva
     * @return ResponseEntity com a consulta salva
     */
    @PostMapping
    @Operation(summary = "Criar nova consulta", description = "Registra uma nova consulta com os dados fornecidos.")
    public ResponseEntity<Consulta> criar(
            @RequestBody @Parameter(description = "Dados da nova consulta") Consulta consulta) {
        Consulta salva = consultaService.criar(consulta);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma consulta existente.
     *
     * @param id identificador da consulta
     * @param consultaAtualizada objeto com os dados atualizados
     * @return ResponseEntity com a consulta atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar consulta", description = "Atualiza os dados de uma consulta com base no ID informado.")
    public ResponseEntity<Consulta> atualizar(
            @Parameter(description = "ID da consulta a ser atualizada") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados da consulta") Consulta consultaAtualizada) {
        Optional<Consulta> atualizada = consultaService.atualizar(id, consultaAtualizada);
        return atualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma consulta pelo ID.
     *
     * @param id identificador da consulta
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover consulta", description = "Remove uma consulta existente com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da consulta a ser removida") @PathVariable Long id) {
        boolean removida = consultaService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
