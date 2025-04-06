package br.com.getmypersonal.service;

import br.com.getmypersonal.model.TreinoExercicio;
import br.com.getmypersonal.repository.TreinoExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade TreinoExercicio.
 */
@Service
public class TreinoExercicioService {

	@Autowired
    private TreinoExercicioRepository repository;

    /**
     * Lista todos os vínculos entre treinos e exercícios com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de vínculos treino ↔ exercício
     */
    public Page<TreinoExercicio> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca um vínculo treino ↔ exercício pelo ID.
     * @param id identificador do vínculo
     * @return Optional com o vínculo, se encontrado
     */
    public Optional<TreinoExercicio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria um novo vínculo treino ↔ exercício.
     * @param treinoExercicio objeto a ser salvo
     * @return vínculo salvo
     */
    public TreinoExercicio criar(TreinoExercicio treinoExercicio) {
        return repository.save(treinoExercicio);
    }

    /**
     * Atualiza os dados de um vínculo treino ↔ exercício existente.
     * @param id identificador do vínculo a ser atualizado
     * @param atualizado objeto com os dados atualizados
     * @return Optional com o vínculo atualizado, se encontrado
     */
    public Optional<TreinoExercicio> atualizar(Long id, TreinoExercicio atualizado) {
        return repository.findById(id).map(existente -> {
            atualizado.setId(id);
            return repository.save(atualizado);
        });
    }

    /**
     * Remove um vínculo treino ↔ exercício pelo ID.
     * @param id identificador do vínculo
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
