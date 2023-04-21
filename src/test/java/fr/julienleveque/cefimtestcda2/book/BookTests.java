package fr.julienleveque.cefimtestcda2.book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookTests {
    @Autowired
    private BookService bookService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testHelloBook() {
        assert  bookService.helloBook().equals("Hello Book");
    }

    @Test
    void testGetAllBooks() {
        assert bookService.getAll().contains(new Book("Le Seigneur des Anneaux", new Author("J.R.R.", "Tolkien",
                1892), "Un livre", 1000, "bon", "fanstastique"));
    }



}
