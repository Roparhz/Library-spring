package fr.julienleveque.cefimtestcda2.book;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@SpringBootTest
@AutoConfigureMockMvc
// Penser à la mettre pour activer les validations par annotations
@Validated
public class ControllerTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllBookByApi() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/all");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(requestBuilder)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
        /*List<Book> books = Arrays.asList(objectMapper.readValue(contentAsString, Book[].class));
        List<Book> books2 = objectMapper.readValue(contentAsString, new TypeReference<>() {});

        assert books.contains(new Book("Le Seigneur des Anneaux", new Author("J.R.R.", "Tolkien", 1892), "Un livre",
                1000, "bon", "fantstique"));*/
    }


    @Test
    void testGetFirstBookByApi() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/show");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(requestBuilder)
                .andExpect(resultStatus);


    }

    @Test
    void testGetBookByIdByApi() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/book/1");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(requestBuilder)
                .andExpect(resultStatus);
    }

    @Test
    void testPostBook() throws Exception {
        Book book = new Book("Harry potter", new Author("J.K.", "Rowling", 1965), "Un livre", 1000, "bon", "fantstique");
        RequestBuilder request = MockMvcRequestBuilders.post("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void testPostBookFailed() throws Exception {
        fr.julienleveque.cefimtestcda2.entities.Book book = bookService.getAll().get(0);
        RequestBuilder request = MockMvcRequestBuilders.post("/api/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book));

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isConflict();
        String contentAsString = mockMvc.perform(request)
                .andExpect(resultStatus)
                .andReturn().getResponse().getContentAsString();

        Book newBook = objectMapper.readValue(contentAsString, Book.class);
        assert newBook.equals(book);
    }

    @Test
    void testPatchBook() throws Exception {
        int firstBookNbPages = bookService.getAll().get(0).getNbPages().intValue();
        Integer newNbPages = firstBookNbPages + 1;

        RequestBuilder request = MockMvcRequestBuilders.patch("/api/book/0/pages").contentType(MediaType.APPLICATION_JSON).content(newNbPages.toString());

        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request).andExpect(resultStatus);

        fr.julienleveque.cefimtestcda2.entities.Book newBook = bookService.getAll().get(0);
        assert !Objects.equals(newBook.getNbPages(), firstBookNbPages);
        assert newBook.getNbPages().equals(newNbPages);
    }

    @Test
    void testDeleteBook() throws Exception {
        int nbBooks = bookService.getAll().size();

        RequestBuilder request = MockMvcRequestBuilders.delete("/api/book/0");
        ResultMatcher resultStatus = MockMvcResultMatchers.status().isOk();
        mockMvc.perform(request).andExpect(resultStatus);

        List<fr.julienleveque.cefimtestcda2.entities.Book> listBooksAfterDelete = bookService.getAll();
        assert nbBooks - 1 == listBooksAfterDelete.size();
    }
}
