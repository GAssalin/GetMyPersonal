package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Avaliacao;
import br.com.getmypersonal.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela leitura genérica de avaliações (superclasse).
 */
@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    /**
     * Lista todas as avaliações de qualquer tipo com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página com avaliações
     */
    public Page<Avaliacao> listarTodas(Pageable pageable) {
        return avaliacaoRepository.findAll(pageable);
    }
    
}
