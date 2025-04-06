package br.com.getmypersonal.service;

import br.com.getmypersonal.model.AvaliacaoNeuromotores;
import br.com.getmypersonal.repository.AvaliacaoNeuromotoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade AvaliacaoNeuromotores.
 */
@Service
public class AvaliacaoNeuromotoresService {

	@Autowired
    private AvaliacaoNeuromotoresRepository repository;

    /**
     * Lista todas as avaliações neuromotoras com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações neuromotoras
     */
    public Page<AvaliacaoNeuromotores> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca uma avaliação neuromotora pelo ID.
     * @param id identificador da avaliação neuromotora
     * @return Optional com a avaliação neuromotora, se encontrada
     */
    public Optional<AvaliacaoNeuromotores> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria uma nova avaliação neuromotora.
     * @param avaliacao objeto avaliação neuromotora a ser salva
     * @return avaliação neuromotora salva
     */
    public AvaliacaoNeuromotores criar(AvaliacaoNeuromotores avaliacao) {
        return repository.save(avaliacao);
    }

    /**
     * Atualiza os dados de uma avaliação neuromotora existente.
     * @param id identificador da avaliação a ser atualizada
     * @param atualizada objeto com os dados atualizados
     * @return Optional com a avaliação neuromotora atualizada, se encontrada
     */
    public Optional<AvaliacaoNeuromotores> atualizar(Long id, AvaliacaoNeuromotores atualizada) {
        return repository.findById(id).map(existente -> {
            atualizada.setId(id);
            return repository.save(atualizada);
        });
    }

    /**
     * Remove uma avaliação neuromotora pelo ID.
     * @param id identificador da avaliação neuromotora
     * @return true se removida com sucesso, false se não encontrada
     */
    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
	
}
