package fr.julienleveque.cefimtestcda2.entities.repository;

import fr.julienleveque.cefimtestcda2.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
