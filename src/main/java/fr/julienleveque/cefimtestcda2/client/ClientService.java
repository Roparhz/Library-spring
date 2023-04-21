package fr.julienleveque.cefimtestcda2.client;

import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    List<Client> listClient = new ArrayList<>(){{
        add(new Client("Julien", "Leveque", 1984, "test@gmail.fr"));
    }};

    public List<Client> getListClient(){
        return listClient;
    }

    public List<Client> getAll() {
        return listClient;
    }

    public Client getById(int id) {
        return listClient.get(id);
    }

    public Client saveClient(Client newClient)throws InstanceAlreadyExistsException {
        Optional<Client> client = findClient(newClient);
        if (client.isPresent()){
            throw new InstanceAlreadyExistsException(String.valueOf(listClient.indexOf(newClient)));
        }
        listClient.add(newClient);
        return newClient;
    }

    private Optional<Client> findClient(Client newClient) {
        return listClient.stream().filter(client -> client.equals(newClient)).findFirst();
    }

    public Client updateClient(int id, Client newClient) {
        listClient.set(id, newClient);
        return newClient;
    }

    public void deleteClient(int id) {
        listClient.remove(id);
    }
}
