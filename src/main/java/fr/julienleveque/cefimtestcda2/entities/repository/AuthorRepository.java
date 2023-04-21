package fr.julienleveque.cefimtestcda2.entities.repository;

import fr.julienleveque.cefimtestcda2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
