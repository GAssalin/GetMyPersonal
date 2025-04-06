package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Pessoa;
import br.com.getmypersonal.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela leitura genérica da entidade Pessoa.
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    /**
     * Lista todas as pessoas do sistema (pacientes, profissionais e estudantes) com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de pessoas
     */
    public Page<Pessoa> listarTodos(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }
    
}
