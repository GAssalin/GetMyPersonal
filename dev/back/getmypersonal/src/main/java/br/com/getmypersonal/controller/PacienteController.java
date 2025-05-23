package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Paciente;
import br.com.getmypersonal.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    /**
     * Lista todos os pacientes com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de pacientes
     */
    @GetMapping
    @Operation(summary = "Listar pacientes", description = "Retorna uma lista paginada de todos os pacientes cadastrados.")
    public Page<Paciente> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return pacienteService.listarTodos(pageable);
    }

    /**
     * Busca um paciente pelo ID.
     *
     * @param id identificador do paciente
     * @return ResponseEntity com o paciente encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar paciente por ID", description = "Retorna os dados de um paciente com base no seu identificador.")
    public ResponseEntity<Paciente> buscarPorId(
            @Parameter(description = "ID do paciente") @PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        return paciente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo paciente.
     *
     * @param paciente objeto paciente a ser salvo
     * @return ResponseEntity com o paciente salvo
     */
    @PostMapping
    @Operation(summary = "Criar novo paciente", description = "Cria um novo paciente com os dados fornecidos.")
    public ResponseEntity<Paciente> criar(
            @RequestBody @Parameter(description = "Dados do novo paciente") Paciente paciente) {
        Paciente salvo = pacienteService.criar(paciente);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um paciente existente.
     *
     * @param id identificador do paciente
     * @param pacienteAtualizado objeto com os dados atualizados
     * @return ResponseEntity com o paciente atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualizar paciente", description = "Atualiza os dados de um paciente com base no ID informado.")
    public ResponseEntity<Paciente> atualizar(
            @Parameter(description = "ID do paciente a ser atualizado") @PathVariable Long id,
            @RequestBody @Parameter(description = "Dados atualizados do paciente") Paciente pacienteAtualizado) {
        Optional<Paciente> atualizado = pacienteService.atualizar(id, pacienteAtualizado);
        return atualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um paciente pelo ID.
     *
     * @param id identificador do paciente
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remover paciente", description = "Remove um paciente com base no ID informado.")
    public ResponseEntity<Void> deletar(
            @Parameter(description = "ID do paciente a ser removido") @PathVariable Long id) {
        boolean removido = pacienteService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
