package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Consulta;
import br.com.getmypersonal.service.ConsultaService;
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
     * @param pageable parâmetros de página e ordenação
     * @return página de consultas
     */
    @GetMapping
    public Page<Consulta> listarTodos(Pageable pageable) {
        return consultaService.listarTodos(pageable);
    }

    /**
     * Busca uma consulta pelo ID.
     * @param id identificador da consulta
     * @return ResponseEntity com a consulta encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable Long id) {
        Optional<Consulta> consulta = consultaService.buscarPorId(id);
        return consulta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova consulta.
     * @param consulta objeto consulta a ser salva
     * @return ResponseEntity com a consulta salva
     */
    @PostMapping
    public ResponseEntity<Consulta> criar(@RequestBody Consulta consulta) {
        Consulta salva = consultaService.criar(consulta);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma consulta existente.
     * @param id identificador da consulta
     * @param consultaAtualizada objeto com os dados atualizados
     * @return ResponseEntity com a consulta atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Consulta> atualizar(@PathVariable Long id, @RequestBody Consulta consultaAtualizada) {
        Optional<Consulta> atualizada = consultaService.atualizar(id, consultaAtualizada);
        return atualizada.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma consulta pelo ID.
     * @param id identificador da consulta
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = consultaService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
