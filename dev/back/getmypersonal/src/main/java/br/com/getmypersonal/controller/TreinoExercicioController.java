package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.TreinoExercicio;
import br.com.getmypersonal.service.TreinoExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/treinos-exercicios")
public class TreinoExercicioController {

    @Autowired
    private TreinoExercicioService treinoExercicioService;

    /**
     * Lista todos os vínculos entre treinos e exercícios com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de vínculos treino ↔ exercício
     */
    @GetMapping
    public Page<TreinoExercicio> listarTodos(Pageable pageable) {
        return treinoExercicioService.listarTodos(pageable);
    }

    /**
     * Busca um vínculo treino ↔ exercício pelo ID.
     * @param id identificador do vínculo
     * @return ResponseEntity com o vínculo encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<TreinoExercicio> buscarPorId(@PathVariable Long id) {
        Optional<TreinoExercicio> treinoExercicio = treinoExercicioService.buscarPorId(id);
        return treinoExercicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo vínculo treino ↔ exercício.
     * @param treinoExercicio objeto a ser salvo
     * @return ResponseEntity com o vínculo salvo
     */
    @PostMapping
    public ResponseEntity<TreinoExercicio> criar(@RequestBody TreinoExercicio treinoExercicio) {
        TreinoExercicio salvo = treinoExercicioService.criar(treinoExercicio);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um vínculo treino ↔ exercício existente.
     * @param id identificador do vínculo
     * @param atualizado objeto com os dados atualizados
     * @return ResponseEntity com o vínculo atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<TreinoExercicio> atualizar(@PathVariable Long id, @RequestBody TreinoExercicio atualizado) {
        Optional<TreinoExercicio> atualizadoResp = treinoExercicioService.atualizar(id, atualizado);
        return atualizadoResp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um vínculo treino ↔ exercício pelo ID.
     * @param id identificador do vínculo
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = treinoExercicioService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
