package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Treino;
import br.com.getmypersonal.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade Treino.
 */
@Service
public class TreinoService {

	@Autowired
    private TreinoRepository treinoRepository;

    /**
     * Lista todos os treinos com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de treinos
     */
    public Page<Treino> listarTodos(Pageable pageable) {
        return treinoRepository.findAll(pageable);
    }

    /**
     * Busca um treino pelo ID.
     * @param id identificador do treino
     * @return Optional com o treino, se encontrado
     */
    public Optional<Treino> buscarPorId(Long id) {
        return treinoRepository.findById(id);
    }

    /**
     * Cria um novo treino.
     * @param treino objeto treino a ser salvo
     * @return treino salvo
     */
    public Treino criar(Treino treino) {
        return treinoRepository.save(treino);
    }

    /**
     * Atualiza os dados de um treino existente.
     * @param id identificador do treino a ser atualizado
     * @param treinoAtualizado objeto com os dados atualizados
     * @return Optional com o treino atualizado, se encontrado
     */
    public Optional<Treino> atualizar(Long id, Treino treinoAtualizado) {
        return treinoRepository.findById(id).map(existente -> {
            treinoAtualizado.setId(id);
            return treinoRepository.save(treinoAtualizado);
        });
    }

    /**
     * Remove um treino pelo ID.
     * @param id identificador do treino
     * @return true se removido com sucesso, false se não encontrado
     */
    public boolean deletar(Long id) {
        if (treinoRepository.existsById(id)) {
            treinoRepository.deleteById(id);
            return true;
        }
        return false;
    }
	
}
