package br.com.getmypersonal.service;

import br.com.getmypersonal.model.Paciente;
import br.com.getmypersonal.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Serviço responsável pela lógica de negócio da entidade Paciente.
 */
@Service
public class PacienteService {

	@Autowired
    private PacienteRepository pacienteRepository;

    /**
     * Lista todos os pacientes com suporte a paginação.
     * @param pageable parâmetros de página e ordenação
     * @return página de pacientes
     */
    public Page<Paciente> listarTodos(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    /**
     * Busca um paciente pelo ID.
     * @param id identificador do paciente
     * @return Optional com o paciente, se encontrado
     */
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    /**
     * Cria um novo paciente.
     * @param paciente objeto paciente a ser salvo
     * @return paciente salvo
     */
    public Paciente criar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    /**
     * Atualiza os dados de um paciente existente.
     * @param id identificador do paciente a ser atualizado
     * @param pacienteAtualizado objeto com os dados atualizados
     * @return Optional com o paciente atualizado, se encontrado
     */
    public Optional<Paciente> atualizar(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id).map(existente -> {
            pacienteAtualizado.setId(id);
            return pacienteRepository.save(pacienteAtualizado);
        });
    }

    /**
     * Remove um paciente pelo ID.
     * @param id identificador do paciente
     * @return true se removido com sucesso, false se não encontrado
     */
    public boolean deletar(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
	
}
