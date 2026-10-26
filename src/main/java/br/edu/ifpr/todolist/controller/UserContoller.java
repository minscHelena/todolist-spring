import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tarefas")
public class UserController {

    @GetMapping("/cadastrar")
    @PreAuthorize("hasRole('USER','ADMIN')") 
    public String cadastrarTarefa()
    {   redirect 
        return HttpStatus;
    }

    @GetMapping("/listar")
    @PreAuthorize("hasRole('USER','ADMIN')")
    public String listarTarefa()
    {
        return HttpStatus;
    }

    @GetMapping("/buscarPorId")
    @PreAuthorize("hasRole('USER','ADMIN')")
    public String buscarTarefaPorId()
    {
        return HttpStatus;
    }

    @GetMapping("/excluir")
    @PreAuthorize("hasRole('ADMIN')") 
    public String excluirTarefa()
    {
        return HttpStatus;
    }
 
}