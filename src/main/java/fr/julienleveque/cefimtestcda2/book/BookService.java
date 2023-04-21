package fr.julienleveque.cefimtestcda2.book;

import fr.julienleveque.cefimtestcda2.client.ClientService;
import fr.julienleveque.cefimtestcda2.entities.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BookRepository bookRepository;

    public BookService() {}

    private List<Book> listBook = new ArrayList<>(){{
        add(new Book("Le Seigneur des Anneaux", new Author("J.R.R.", "Tolkien", 1892), "Un livre", 1000, "bon",
                "fanstastique"));
        add(new Book("Le Seigneur des Anneaux 2", new Author("J.R.R.", "Tolkien", 1892), "Un livre", 1000,"bon",
                "fanstastique"));
        add(new Book("Le Seigneur des Anneaux 3", new Author("J.R.R.", "Tolkien", 1892), "Un livre", 1000,"bon",
                "fanstastique"));
    }};

    public String helloBook() {
        return "Hello Book";
    }

    public List<fr.julienleveque.cefimtestcda2.entities.Book> getAll(){
        return bookRepository.findAll();
    }

    public Book getFirst(){
        if (listBook.size() == 0) {
            return null;
        }
        return listBook.get(0);
    }

    public Book getById(int id){
        if (listBook.size() == 0) {
            return null;
        }
        return listBook.get(id);
    }

    public Book getByAuthor(Author author){
        if (listBook.size() == 0) {
            return null;
        }
        for (Book book : listBook) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public Book saveBook(Book newBook)throws InstanceAlreadyExistsException {
        Optional<Book> book = findBook(newBook);
        if (book.isPresent()){
            throw new InstanceAlreadyExistsException(String.valueOf(listBook.indexOf(newBook)));
        }
        listBook.add(newBook);
        return newBook;
    }
    public Optional<Book> findBook(Book book){
        return listBook.stream().filter(book::equals).findFirst();
    }

    public Book updateNbPages(int id, Integer newNbPages) {
        Book currentBook = listBook.get(id);
        currentBook.setNbPages(newNbPages);
        return currentBook;
    }

    public Book deleteBook(int id) {
        return listBook.remove(id);
    }

    public List<Book> getBooksByName(String name) {
        return listBook.stream().filter(book -> book.getTitle().contains(name)).toList();
    }
}
