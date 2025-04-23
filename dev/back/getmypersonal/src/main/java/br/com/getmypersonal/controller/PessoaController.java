package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Pessoa;
import br.com.getmypersonal.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    /**
     * Lista todas as pessoas do sistema (pacientes, profissionais e estudantes) com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página de pessoas
     */
    @GetMapping
    @Operation(summary = "Listar pessoas", description = "Retorna uma lista paginada de todas as pessoas cadastradas no sistema, incluindo pacientes, profissionais e estudantes.")
    public Page<Pessoa> listarTodos(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return pessoaService.listarTodos(pageable);
    }
}
