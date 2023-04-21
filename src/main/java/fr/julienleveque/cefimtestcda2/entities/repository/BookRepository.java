package fr.julienleveque.cefimtestcda2.entities.repository;

import fr.julienleveque.cefimtestcda2.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    @Query("SELECT b FROM Book b WHERE b.nbPages > ?1")
    List<Book> getBigBooks(Integer nbPages);
}
