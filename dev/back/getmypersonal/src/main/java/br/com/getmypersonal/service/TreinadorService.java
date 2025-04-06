package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Treinador;
import br.com.getmypersonal.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade Treinador.
 */
@Service
public class TreinadorService {

	@Autowired
    private TreinadorRepository repository;

    /**
     * Lista todos os treinadores com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de treinadores
     */
    public Page<Treinador> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca um treinador pelo ID.
     * @param id identificador do treinador
     * @return Optional com o treinador, se encontrado
     */
    public Optional<Treinador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria um novo treinador.
     * @param treinador objeto treinador a ser salvo
     * @return treinador salvo
     */
    public Treinador criar(Treinador treinador) {
        return repository.save(treinador);
    }

    /**
     * Atualiza os dados de um treinador existente.
     * @param id identificador do treinador a ser atualizado
     * @param atualizado objeto com os dados atualizados
     * @return Optional com o treinador atualizado, se encontrado
     */
    public Optional<Treinador> atualizar(Long id, Treinador atualizado) {
        return repository.findById(id).map(existente -> {
            atualizado.setId(id);
            return repository.save(atualizado);
        });
    }

    /**
     * Remove um treinador pelo ID.
     * @param id identificador do treinador
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
