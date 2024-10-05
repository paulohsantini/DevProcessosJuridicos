import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Acao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // petição, audiência, sentença
    private LocalDate dataRegistro;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "processo_id")
    private Processo processo;

    // Getters e Setters
}
