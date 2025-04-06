package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AnamnesePerguntas;
import br.com.getmypersonal.service.AnamnesePerguntasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/anamnese-perguntas")
public class AnamnesePerguntasController {

    @Autowired
    private AnamnesePerguntasService anamnesePerguntasService;

    /**
     * Lista todas as perguntas de anamnese com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de perguntas de anamnese
     */
    @GetMapping
    public Page<AnamnesePerguntas> listarTodos(Pageable pageable) {
        return anamnesePerguntasService.listarTodos(pageable);
    }

    /**
     * Busca uma pergunta de anamnese pelo ID.
     * @param id identificador da pergunta
     * @return ResponseEntity com a pergunta encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<AnamnesePerguntas> buscarPorId(@PathVariable Long id) {
        Optional<AnamnesePerguntas> pergunta = anamnesePerguntasService.buscarPorId(id);
        return pergunta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova pergunta de anamnese.
     * @param pergunta objeto pergunta a ser salva
     * @return ResponseEntity com a pergunta salva
     */
    @PostMapping
    public ResponseEntity<AnamnesePerguntas> criar(@RequestBody AnamnesePerguntas pergunta) {
        AnamnesePerguntas salva = anamnesePerguntasService.criar(pergunta);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma pergunta de anamnese existente.
     * @param id identificador da pergunta
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a pergunta atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    public ResponseEntity<AnamnesePerguntas> atualizar(@PathVariable Long id, @RequestBody AnamnesePerguntas atualizada) {
        Optional<AnamnesePerguntas> resposta = anamnesePerguntasService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma pergunta de anamnese pelo ID.
     * @param id identificador da pergunta
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removida = anamnesePerguntasService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
