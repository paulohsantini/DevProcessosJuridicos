import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numeroProcesso;
    
    private LocalDate dataAbertura;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusProcesso status;

    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
    private List<Parte> partes;

    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)
    private List<Acao> acoes;

    // Getters e Setters
}
