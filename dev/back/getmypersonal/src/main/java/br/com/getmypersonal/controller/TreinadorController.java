package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Treinador;
import br.com.getmypersonal.service.TreinadorService;
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
     * @param pageable parâmetros de página e ordenação
     * @return página de treinadores
     */
    @GetMapping
    public Page<Treinador> listarTodos(Pageable pageable) {
        return treinadorService.listarTodos(pageable);
    }

    /**
     * Busca um treinador pelo ID.
     * @param id identificador do treinador
     * @return ResponseEntity com o treinador encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Treinador> buscarPorId(@PathVariable Long id) {
        Optional<Treinador> treinador = treinadorService.buscarPorId(id);
        return treinador.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo treinador.
     * @param treinador objeto treinador a ser salvo
     * @return ResponseEntity com o treinador salvo
     */
    @PostMapping
    public ResponseEntity<Treinador> criar(@RequestBody Treinador treinador) {
        Treinador salvo = treinadorService.criar(treinador);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um treinador existente.
     * @param id identificador do treinador
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o treinador atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Treinador> atualizar(@PathVariable Long id, @RequestBody Treinador atualizado) {
        Optional<Treinador> atualizadoResp = treinadorService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um treinador pelo ID.
     * @param id identificador do treinador
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = treinadorService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
