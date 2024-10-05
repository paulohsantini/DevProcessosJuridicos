//Exemplo de Teste de Integração
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ProcessoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateProcesso() throws Exception {
        Processo processo = new Processo();
        processo.setNumeroProcesso("123456789");

        mockMvc.perform(post("/api/processos")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(processo)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAllProcessos() throws Exception {
        mockMvc.perform(get("/api/processos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
