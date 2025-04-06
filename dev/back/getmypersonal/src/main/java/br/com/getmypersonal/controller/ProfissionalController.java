package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Profissional;
import br.com.getmypersonal.service.ProfissionalService;
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
     * @param pageable parâmetros de página e ordenação
     * @return página de profissionais
     */
    @GetMapping
    public Page<Profissional> listarTodos(Pageable pageable) {
        return profissionalService.listarTodos(pageable);
    }

    /**
     * Busca um profissional pelo ID.
     * @param id identificador do profissional
     * @return ResponseEntity com o profissional encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Profissional> buscarPorId(@PathVariable Long id) {
        Optional<Profissional> profissional = profissionalService.buscarPorId(id);
        return profissional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo profissional.
     * @param profissional objeto profissional a ser salvo
     * @return ResponseEntity com o profissional salvo
     */
    @PostMapping
    public ResponseEntity<Profissional> criar(@RequestBody Profissional profissional) {
        Profissional salvo = profissionalService.criar(profissional);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um profissional existente.
     * @param id identificador do profissional
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o profissional atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Profissional> atualizar(@PathVariable Long id, @RequestBody Profissional atualizado) {
        Optional<Profissional> atualizadoResp = profissionalService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um profissional pelo ID.
     * @param id identificador do profissional
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = profissionalService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
