package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Exercicio;
import br.com.getmypersonal.service.ExercicioService;
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
     * @param pageable parâmetros de página e ordenação
     * @return página de exercícios
     */
    @GetMapping
    public Page<Exercicio> listarTodos(Pageable pageable) {
        return exercicioService.listarTodos(pageable);
    }

    /**
     * Busca um exercício pelo ID.
     * @param id identificador do exercício
     * @return ResponseEntity com o exercício encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> buscarPorId(@PathVariable Long id) {
        Optional<Exercicio> exercicio = exercicioService.buscarPorId(id);
        return exercicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo exercício.
     * @param exercicio objeto exercício a ser salvo
     * @return ResponseEntity com o exercício salvo
     */
    @PostMapping
    public ResponseEntity<Exercicio> criar(@RequestBody Exercicio exercicio) {
        Exercicio salvo = exercicioService.criar(exercicio);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um exercício existente.
     * @param id identificador do exercício
     * @param exercicioAtualizado objeto com os dados atualizados
     * @return ResponseEntity com o exercício atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> atualizar(@PathVariable Long id, @RequestBody Exercicio exercicioAtualizado) {
        Optional<Exercicio> atualizado = exercicioService.atualizar(id, exercicioAtualizado);
        return atualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um exercício pelo ID.
     * @param id identificador do exercício
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = exercicioService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
