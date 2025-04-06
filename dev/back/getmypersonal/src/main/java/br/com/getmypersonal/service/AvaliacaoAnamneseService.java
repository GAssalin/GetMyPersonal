package br.com.getmypersonal.service;

import br.com.getmypersonal.model.AvaliacaoAnamnese;
import br.com.getmypersonal.repository.AvaliacaoAnamneseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade AvaliacaoAnamnese.
 */
@Service
public class AvaliacaoAnamneseService {

	@Autowired
    private AvaliacaoAnamneseRepository repository;

    /**
     * Lista todas as avaliações de anamnese com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações de anamnese
     */
    public Page<AvaliacaoAnamnese> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca uma avaliação de anamnese pelo ID.
     * @param id identificador da avaliação de anamnese
     * @return Optional com a avaliação de anamnese, se encontrada
     */
    public Optional<AvaliacaoAnamnese> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria uma nova avaliação de anamnese.
     * @param avaliacao objeto avaliação de anamnese a ser salva
     * @return avaliação de anamnese salva
     */
    public AvaliacaoAnamnese criar(AvaliacaoAnamnese avaliacao) {
        return repository.save(avaliacao);
    }

    /**
     * Atualiza os dados de uma avaliação de anamnese existente.
     * @param id identificador da avaliação a ser atualizada
     * @param atualizada objeto com os dados atualizados
     * @return Optional com a avaliação de anamnese atualizada, se encontrada
     */
    public Optional<AvaliacaoAnamnese> atualizar(Long id, AvaliacaoAnamnese atualizada) {
        return repository.findById(id).map(existente -> {
            atualizada.setId(id);
            return repository.save(atualizada);
        });
    }

    /**
     * Remove uma avaliação de anamnese pelo ID.
     * @param id identificador da avaliação de anamnese
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
