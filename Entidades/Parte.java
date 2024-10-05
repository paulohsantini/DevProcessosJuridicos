import javax.persistence.*;

@Entity
public class Parte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private String cpfCnpj;
    private String tipo; // autor, réu, advogado
    private String email;
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "processo_id")
    private Processo processo;

    // Getters e Setters
}
