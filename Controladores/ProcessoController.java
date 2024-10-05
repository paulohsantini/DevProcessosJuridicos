import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {
    @Autowired
    private ProcessoService processoService;

    @PostMapping
    public ResponseEntity<Processo> createProcesso(@RequestBody Processo processo) {
        return new ResponseEntity<>(processoService.createProcesso(processo), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processo> updateProcesso(@PathVariable Long id, @RequestBody Processo processo) {
        return new ResponseEntity<>(processoService.updateProcesso(id, processo), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Processo>> getAllProcessos() {
        return new ResponseEntity<>(processoService.getAllProcessos(), HttpStatus.OK);
    }

    @PatchMapping("/{id}/archive")
    public ResponseEntity<Void> archiveProcesso(@PathVariable Long id) {
        processoService.archiveProcesso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
