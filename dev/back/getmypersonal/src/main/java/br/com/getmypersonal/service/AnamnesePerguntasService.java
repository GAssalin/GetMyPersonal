package br.com.getmypersonal.service;

import br.com.getmypersonal.model.AnamnesePerguntas;
import br.com.getmypersonal.repository.AnamnesePerguntasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade AnamnesePerguntas.
 */
@Service
public class AnamnesePerguntasService {

    @Autowired
    private AnamnesePerguntasRepository repository;

    /**
     * Lista todas as perguntas de anamnese com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de perguntas de anamnese
     */
    public Page<AnamnesePerguntas> listarTodos(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Busca uma pergunta de anamnese pelo ID.
     * @param id identificador da pergunta
     * @return Optional com a pergunta, se encontrada
     */
    public Optional<AnamnesePerguntas> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Cria uma nova pergunta de anamnese.
     * @param pergunta objeto pergunta a ser salva
     * @return pergunta salva
     */
    public AnamnesePerguntas criar(AnamnesePerguntas pergunta) {
        return repository.save(pergunta);
    }

    /**
     * Atualiza uma pergunta de anamnese existente.
     * @param id identificador da pergunta
     * @param atualizada objeto com os dados atualizados
     * @return Optional com a pergunta atualizada, se encontrada
     */
    public Optional<AnamnesePerguntas> atualizar(Long id, AnamnesePerguntas atualizada) {
        return repository.findById(id).map(existente -> {
            atualizada.setId(id);
            return repository.save(atualizada);
        });
    }

    /**
     * Remove uma pergunta de anamnese pelo ID.
     * @param id identificador da pergunta
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
