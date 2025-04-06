package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Estudante;
import br.com.getmypersonal.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade Estudante.
 */
@Service
public class EstudanteService {

	@Autowired
    private EstudanteRepository repository;

    /**
     * Lista todos os estudantes com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de estudantes
     */
    public Page<Estudante> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca um estudante pelo ID.
     * @param id identificador do estudante
     * @return Optional com o estudante, se encontrado
     */
    public Optional<Estudante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria um novo estudante.
     * @param estudante objeto estudante a ser salvo
     * @return estudante salvo
     */
    public Estudante criar(Estudante estudante) {
        return repository.save(estudante);
    }

    /**
     * Atualiza os dados de um estudante existente.
     * @param id identificador do estudante a ser atualizado
     * @param atualizado objeto com os dados atualizados
     * @return Optional com o estudante atualizado, se encontrado
     */
    public Optional<Estudante> atualizar(Long id, Estudante atualizado) {
        return repository.findById(id).map(existente -> {
            atualizado.setId(id);
            return repository.save(atualizado);
        });
    }

    /**
     * Remove um estudante pelo ID.
     * @param id identificador do estudante
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
