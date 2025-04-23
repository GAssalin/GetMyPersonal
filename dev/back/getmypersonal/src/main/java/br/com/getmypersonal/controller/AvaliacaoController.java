package br.com.getmypersonal.controller;

import br.com.getmypersonal.model.Avaliacao;
import br.com.getmypersonal.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    /**
     * Lista todas as avaliações do sistema (anamnese, postural, neuromotoras etc.) com suporte a paginação.
     *
     * @param pageable parâmetros de página e ordenação
     * @return página com todas as avaliações
     */
    @GetMapping
    @Operation(summary = "Listar todas as avaliações", description = "Retorna uma lista paginada de todas as avaliações do sistema, incluindo anamnese, postural, neuromotoras, entre outras.")
    public Page<Avaliacao> listarTodas(
            @Parameter(description = "Parâmetros de paginação e ordenação") Pageable pageable) {
        return avaliacaoService.listarTodas(pageable);
    }
    
}
