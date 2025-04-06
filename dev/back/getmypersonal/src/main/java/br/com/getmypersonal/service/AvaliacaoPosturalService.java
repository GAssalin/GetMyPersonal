package br.com.getmypersonal.service;

import br.com.getmypersonal.model.AvaliacaoPostural;
import br.com.getmypersonal.repository.AvaliacaoPosturalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade AvaliacaoPostural.
 */
@Service
public class AvaliacaoPosturalService {

	@Autowired
    private AvaliacaoPosturalRepository repository;

    /**
     * Lista todas as avaliações posturais com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações posturais
     */
    public Page<AvaliacaoPostural> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca uma avaliação postural pelo ID.
     * @param id identificador da avaliação postural
     * @return Optional com a avaliação postural, se encontrada
     */
    public Optional<AvaliacaoPostural> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria uma nova avaliação postural.
     * @param avaliacao objeto avaliação postural a ser salva
     * @return avaliação postural salva
     */
    public AvaliacaoPostural criar(AvaliacaoPostural avaliacao) {
        return repository.save(avaliacao);
    }

    /**
     * Atualiza os dados de uma avaliação postural existente.
     * @param id identificador da avaliação a ser atualizada
     * @param atualizada objeto com os dados atualizados
     * @return Optional com a avaliação postural atualizada, se encontrada
     */
    public Optional<AvaliacaoPostural> atualizar(Long id, AvaliacaoPostural atualizada) {
        return repository.findById(id).map(existente -> {
            atualizada.setId(id);
            return repository.save(atualizada);
        });
    }

    /**
     * Remove uma avaliação postural pelo ID.
     * @param id identificador da avaliação postural
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
