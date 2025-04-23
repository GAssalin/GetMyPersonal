package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.AnamnesePerguntas;
import br.com.getmypersonal.service.AnamnesePerguntasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de perguntas de anamnese
     */
    @GetMapping
    @Operation(summary = "Listar perguntas de anamnese", description = "Retorna uma lista paginada de todas as perguntas cadastradas para anamnese.")
    public Page<AnamnesePerguntas> listarTodos(Pageable pageable) {
        return anamnesePerguntasService.listarTodos(pageable);
    }

    /**
     * Busca uma pergunta de anamnese pelo ID.
     *
     * @param id identificador da pergunta
     * @return ResponseEntity com a pergunta encontrada ou 404 se não encontrada
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar pergunta por ID", description = "Busca uma pergunta de anamnese pelo seu identificador.")
    public ResponseEntity<AnamnesePerguntas> buscarPorId(
            @Parameter(description = "ID da pergunta de anamnese") @PathVariable Long id) {
        Optional<AnamnesePerguntas> pergunta = anamnesePerguntasService.buscarPorId(id);
        return pergunta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova pergunta de anamnese.
     *
     * @param pergunta objeto pergunta a ser salva
     * @return ResponseEntity com a pergunta salva
     */
    @PostMapping
    @Operation(summary = "Criar nova pergunta", description = "Cria uma nova pergunta de anamnese com os dados informados no corpo da requisição.")
    public ResponseEntity<AnamnesePerguntas> criar(
            @RequestBody @Parameter(description = "Objeto contendo os dados da nova pergunta") AnamnesePerguntas pergunta) {
        AnamnesePerguntas salva = anamnesePerguntasService.criar(pergunta);
        return ResponseEntity.ok(salva);
    }

    /**
     * Atualiza uma pergunta de anamnese existente.
     *
     * @param id         identificador da pergunta
     * @param atualizada objeto com os dados atualizados
     * @return ResponseEntity com a pergunta atualizada ou 404 se não encontrada
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar pergunta existente", description = "Atualiza uma pergunta de anamnese com base no ID informado.")
    public ResponseEntity<AnamnesePerguntas> atualizar(
            @Parameter(description = "ID da pergunta a ser atualizada") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados da pergunta") AnamnesePerguntas atualizada) {
        Optional<AnamnesePerguntas> resposta = anamnesePerguntasService.atualizar(id, atualizada);
        return resposta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove uma pergunta de anamnese pelo ID.
     *
     * @param id identificador da pergunta
     * @return ResponseEntity 204 se removida, 404 se não encontrada
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover pergunta", description = "Remove uma pergunta de anamnese com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID da pergunta a ser removida") @PathVariable Long id) {
        boolean removida = anamnesePerguntasService.deletar(id);
        return removida ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
