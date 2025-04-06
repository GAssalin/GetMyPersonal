package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Profissional;
import br.com.getmypersonal.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade Profissional.
 */
@Service
public class ProfissionalService {

	@Autowired
    private ProfissionalRepository repository;

    /**
     * Lista todos os profissionais com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de profissionais
     */
    public Page<Profissional> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca um profissional pelo ID.
     * @param id identificador do profissional
     * @return Optional com o profissional, se encontrado
     */
    public Optional<Profissional> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria um novo profissional.
     * @param profissional objeto profissional a ser salvo
     * @return profissional salvo
     */
    public Profissional criar(Profissional profissional) {
        return repository.save(profissional);
    }

    /**
     * Atualiza os dados de um profissional existente.
     * @param id identificador do profissional a ser atualizado
     * @param atualizado objeto com os dados atualizados
     * @return Optional com o profissional atualizado, se encontrado
     */
    public Optional<Profissional> atualizar(Long id, Profissional atualizado) {
        return repository.findById(id).map(existente -> {
            atualizado.setId(id);
            return repository.save(atualizado);
        });
    }

    /**
     * Remove um profissional pelo ID.
     * @param id identificador do profissional
     * @return true se removido com sucesso, false se não encontrado
     */
    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
	
}
