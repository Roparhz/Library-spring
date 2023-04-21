package fr.julienleveque.cefimtestcda2.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/book/author")
public class AuthorController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Author> getAllAuthors() {
        return null;
    }

    @GetMapping("/show")
    public Author getAuthor() {
        return null;
    }
}
