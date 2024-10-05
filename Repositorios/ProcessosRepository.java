import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
    List<Processo> findByStatus(StatusProcesso status);
    List<Processo> findByDataAbertura(LocalDate dataAbertura);
    List<Processo> findByPartesCpfCnpj(String cpfCnpj);
}
