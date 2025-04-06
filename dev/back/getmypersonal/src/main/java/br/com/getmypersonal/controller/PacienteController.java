package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Paciente;
import br.com.getmypersonal.service.PacienteService;
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
     * @param pageable parâmetros de página e ordenação
     * @return página de pacientes
     */
    @GetMapping
    public Page<Paciente> listarTodos(Pageable pageable) {
        return pacienteService.listarTodos(pageable);
    }

    /**
     * Busca um paciente pelo ID.
     * @param id identificador do paciente
     * @return ResponseEntity com o paciente encontrado ou 404 se não encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.buscarPorId(id);
        return paciente.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo paciente.
     * @param paciente objeto paciente a ser salvo
     * @return ResponseEntity com o paciente salvo
     */
    @PostMapping
    public ResponseEntity<Paciente> criar(@RequestBody Paciente paciente) {
        Paciente salvo = pacienteService.criar(paciente);
        return ResponseEntity.ok(salvo);
    }

    /**
     * Atualiza um paciente existente.
     * @param id identificador do paciente
     * @param pacienteAtualizado objeto com os dados atualizados
     * @return ResponseEntity com o paciente atualizado ou 404 se não encontrado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        Optional<Paciente> atualizado = pacienteService.atualizar(id, pacienteAtualizado);
        return atualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Remove um paciente pelo ID.
     * @param id identificador do paciente
     * @return ResponseEntity 204 se removido, 404 se não encontrado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = pacienteService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
