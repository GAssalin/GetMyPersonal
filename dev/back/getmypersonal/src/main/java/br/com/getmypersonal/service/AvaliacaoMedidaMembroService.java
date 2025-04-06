package br.com.getmypersonal.service;

import br.com.getmypersonal.model.AvaliacaoMedidaMembro;
import br.com.getmypersonal.repository.AvaliacaoMedidaMembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade AvaliacaoMedidaMembro.
 */
@Service
public class AvaliacaoMedidaMembroService {

	@Autowired
    private AvaliacaoMedidaMembroRepository repository;

    /**
     * Lista todas as avaliações de medidas de membros com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de avaliações de medidas
     */
    public Page<AvaliacaoMedidaMembro> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca uma avaliação de medida de membro pelo ID.
     * @param id identificador da avaliação de medida
     * @return Optional com a avaliação de medida, se encontrada
     */
    public Optional<AvaliacaoMedidaMembro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria uma nova avaliação de medida de membro.
     * @param avaliacao objeto avaliação de medida a ser salva
     * @return avaliação de medida salva
     */
    public AvaliacaoMedidaMembro criar(AvaliacaoMedidaMembro avaliacao) {
        return repository.save(avaliacao);
    }

    /**
     * Atualiza os dados de uma avaliação de medida de membro existente.
     * @param id identificador da avaliação a ser atualizada
     * @param atualizada objeto com os dados atualizados
     * @return Optional com a avaliação de medida atualizada, se encontrada
     */
    public Optional<AvaliacaoMedidaMembro> atualizar(Long id, AvaliacaoMedidaMembro atualizada) {
        return repository.findById(id).map(existente -> {
            atualizada.setId(id);
            return repository.save(atualizada);
        });
    }

    /**
     * Remove uma avaliação de medida de membro pelo ID.
     * @param id identificador da avaliação de medida
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
