package fr.julienleveque.cefimtestcda2.client;

import fr.julienleveque.cefimtestcda2.book.Book;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

import java.util.List;
import java.util.Objects;

public class Client {
    @Pattern(regexp = "^[A-Za-zéèêëïîôöùûüç'-]+$", message = "Le prénom doit contenir uniquement des lettres et des caractères spéciaux (-',) et doit être non vide.")
    private String firstName;
    @Pattern(regexp = "^[A-Za-zéèêëïîôöùûüç'-]+$", message = "Le nom doit contenir uniquement des lettres et des caractères spéciaux (-',) et doit être non vide.")
    private String lastName;
    private Integer birthDate;
    @Email(message = "L'adresse e-mail doit être valide")
    private String email;
    private List<Book> books;

    public Client() {
    }

    public Client(String firstName, String lastName, int birthDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Book> getBooks() {
        return books;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(books, client.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, books);
    }
}
