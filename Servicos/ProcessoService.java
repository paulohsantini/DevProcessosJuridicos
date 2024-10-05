import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessoService {
    @Autowired
    private ProcessoRepository processoRepository;

    public Processo createProcesso(Processo processo) {
        return processoRepository.save(processo);
    }

    public Processo updateProcesso(Long id, Processo processoDetails) {
        Processo processo = processoRepository.findById(id).orElseThrow(() -> new RuntimeException("Processo não encontrado"));
        // Atualizar campos
        return processoRepository.save(processo);
    }

    public List<Processo> getAllProcessos() {
        return processoRepository.findAll();
    }

    public void archiveProcesso(Long id) {
        Processo processo = processoRepository.findById(id).orElseThrow(() -> new RuntimeException("Processo não encontrado"));
        processo.setStatus(StatusProcesso.ARQUIVADO);
        processoRepository.save(processo);
    }

    // Outros métodos para consulta por status e CPF/CNPJ
}
