package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Estudante;
import br.com.getmypersonal.service.EstudanteService;
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
     * @param pageable parâmetros de página e ordenação
     * @return página de estudantes
     */
    @GetMapping
    public Page<Estudante> listarTodos(Pageable pageable) {
        return estudanteService.listarTodos(pageable);
    }

    /**
     * Busca um estudante pelo ID.
     * @param id identificador do estudante
     * @return ResponseEntity com o estudante encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarPorId(@PathVariable Long id) {
        Optional<Estudante> estudante = estudanteService.buscarPorId(id);
        return estudante.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo estudante.
     * @param estudante objeto estudante a ser salvo
     * @return ResponseEntity com o estudante salvo
     */
    @PostMapping
    public ResponseEntity<Estudante> criar(@RequestBody Estudante estudante) {
        Estudante salvo = estudanteService.criar(estudante);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um estudante existente.
     * @param id identificador do estudante
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o estudante atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizar(@PathVariable Long id, @RequestBody Estudante atualizado) {
        Optional<Estudante> atualizadoResp = estudanteService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um estudante pelo ID.
     * @param id identificador do estudante
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = estudanteService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
