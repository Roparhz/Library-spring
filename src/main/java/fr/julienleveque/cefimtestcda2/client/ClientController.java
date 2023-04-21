package fr.julienleveque.cefimtestcda2.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@RestController
@RequestMapping("/api/client")
// Penser à la mettre pour activer les validations par annotations
@Validated
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientService.getById(id);
    }

    @PostMapping("")
    public Client saveClient(@RequestBody Client newClient) throws InstanceAlreadyExistsException {
        return clientService.saveClient(newClient);
    }

    @PatchMapping("/{id}")
    public Client updateClient(@PathVariable int id,
                               @RequestBody Client newClient){
        return clientService.updateClient(id, newClient);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable int id){
        clientService.deleteClient(id);
    }


}
