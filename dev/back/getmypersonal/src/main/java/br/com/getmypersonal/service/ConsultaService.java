package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Consulta;
import br.com.getmypersonal.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade Consulta.
 */
@Service
public class ConsultaService {

	@Autowired
    private ConsultaRepository consultaRepository;

    /**
     * Lista todas as consultas com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de consultas
     */
    public Page<Consulta> listarTodos(Pageable pageable) {
        return consultaRepository.findAll(pageable);
    }

    /**
     * Busca uma consulta pelo ID.
     * @param id identificador da consulta
     * @return Optional com a consulta, se encontrada
     */
    public Optional<Consulta> buscarPorId(Long id) {
        return consultaRepository.findById(id);
    }

    /**
     * Cria uma nova consulta.
     * @param consulta objeto consulta a ser salvo
     * @return consulta salva
     */
    public Consulta criar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    /**
     * Atualiza os dados de uma consulta existente.
     * @param id identificador da consulta a ser atualizada
     * @param consultaAtualizada objeto com os dados atualizados
     * @return Optional com a consulta atualizada, se encontrada
     */
    public Optional<Consulta> atualizar(Long id, Consulta consultaAtualizada) {
        return consultaRepository.findById(id).map(existente -> {
            consultaAtualizada.setId(id);
            return consultaRepository.save(consultaAtualizada);
        });
    }

    /**
     * Remove uma consulta pelo ID.
     * @param id identificador da consulta
     * @return true se removida com sucesso, false se não encontrada
     */
    public boolean deletar(Long id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
            return true;
        }
        return false;
    }
	
}
