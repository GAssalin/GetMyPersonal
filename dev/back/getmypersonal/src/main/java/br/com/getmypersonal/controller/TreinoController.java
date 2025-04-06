package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Treino;
import br.com.getmypersonal.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private TreinoService treinoService;

    /**
     * Lista todos os treinos com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de treinos
     */
    @GetMapping
    public Page<Treino> listarTodos(Pageable pageable) {
        return treinoService.listarTodos(pageable);
    }

    /**
     * Busca um treino pelo ID.
     * @param id identificador do treino
     * @return ResponseEntity com o treino encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Treino> buscarPorId(@PathVariable Long id) {
        Optional<Treino> treino = treinoService.buscarPorId(id);
        return treino.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo treino.
     * @param treino objeto treino a ser salvo
     * @return ResponseEntity com o treino salvo
     */
    @PostMapping
    public ResponseEntity<Treino> criar(@RequestBody Treino treino) {
        Treino salvo = treinoService.criar(treino);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um treino existente.
     * @param id identificador do treino
     * @param treinoAtualizado objeto com os dados atualizados
     * @return ResponseEntity com o treino atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Treino> atualizar(@PathVariable Long id, @RequestBody Treino treinoAtualizado) {
        Optional<Treino> atualizado = treinoService.atualizar(id, treinoAtualizado);
        return atualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um treino pelo ID.
     * @param id identificador do treino
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = treinoService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
