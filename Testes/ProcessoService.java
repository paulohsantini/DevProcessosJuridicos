// Exemplo de teste unitário
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class ProcessoServiceTest {

    @Mock
    private ProcessoRepository processoRepository;

    @InjectMocks
    private ProcessoService processoService;

    public ProcessoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProcesso() {
        Processo processo = new Processo();
        processo.setNumeroProcesso("123456789");

        when(processoRepository.save(processo)).thenReturn(processo);

        Processo createdProcesso = processoService.createProcesso(processo);

        assertNotNull(createdProcesso);
        assertEquals("123456789", createdProcesso.getNumeroProcesso());
    }

    @Test
    public void testUpdateProcesso() {
        Processo processo = new Processo();
        processo.setNumeroProcesso("123456789");
        when(processoRepository.findById(1L)).thenReturn(Optional.of(processo));

        Processo updatedProcesso = processoService.updateProcesso(1L, processo);
        assertEquals("123456789", updatedProcesso.getNumeroProcesso());
    }
}
