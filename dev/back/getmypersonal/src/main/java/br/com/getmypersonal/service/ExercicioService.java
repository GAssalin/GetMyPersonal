package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Exercicio;
import br.com.getmypersonal.repository.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade Exercicio.
 */
@Service
public class ExercicioService {

	@Autowired
    private ExercicioRepository repository;

    /**
     * Lista todos os exercícios com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de exercícios
     */
    public Page<Exercicio> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca um exercício pelo ID.
     * @param id identificador do exercício
     * @return Optional com o exercício, se encontrado
     */
    public Optional<Exercicio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria um novo exercício.
     * @param exercicio objeto exercício a ser salvo
     * @return exercício salvo
     */
    public Exercicio criar(Exercicio exercicio) {
        return repository.save(exercicio);
    }

    /**
     * Atualiza os dados de um exercício existente.
     * @param id identificador do exercício a ser atualizado
     * @param atualizado objeto com os dados atualizados
     * @return Optional com o exercício atualizado, se encontrado
     */
    public Optional<Exercicio> atualizar(Long id, Exercicio atualizado) {
        return repository.findById(id).map(existente -> {
            atualizado.setId(id);
            return repository.save(atualizado);
        });
    }

    /**
     * Remove um exercício pelo ID.
     * @param id identificador do exercício
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
