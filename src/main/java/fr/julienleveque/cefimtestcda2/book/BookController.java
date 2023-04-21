package fr.julienleveque.cefimtestcda2.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@RestController
@RequestMapping("/api/book")
// Penser à la mettre pour activer les validations par annotations
@Validated
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<fr.julienleveque.cefimtestcda2.entities.Book> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/show")
    public Book getFirstBook() {
        return bookService.getFirst();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getById(id);
    }

    @GetMapping("/name")
    public List<Book> getBooksByName(@RequestParam String name){
        return bookService.getBooksByName(name);
    }

    @PostMapping("")
    public ResponseEntity<Book> saveBook(@RequestBody Book newBook){
        try {
            return ResponseEntity.ok(bookService.saveBook(newBook));
        } catch (InstanceAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(bookService.findBook(newBook).get());
        }
    }

    @PatchMapping("/{id}/pages")
    public Book updateNbPages(@PathVariable int id,
                              @RequestBody
                              @Min(value = 0, message = "Le nombre de pages doit être positif")
                              @Pattern(regexp = "\\d+", message = "Le nombre de pages doit être un entier positif")
                              Integer newNbPages){
        return bookService.updateNbPages(id, newNbPages);
    }

    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable int id){
        return bookService.deleteBook(id);
    }
}
