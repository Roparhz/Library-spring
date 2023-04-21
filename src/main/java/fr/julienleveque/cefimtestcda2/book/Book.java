package fr.julienleveque.cefimtestcda2.book;

import java.util.Objects;

public class Book {
    private String title;
    private Author author;
    private String description;
    private Integer nbPages;
    private String state;
    private String gender;

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Book(String title, Author author, String description, Integer nbPages, String state, String gender) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.nbPages = nbPages;
        this.state = state;
        this.gender = gender;
    }

    public Book() {
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String s) {
        this.title = s;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author) &&
                description.equals(book.description) &&
                Objects.equals(nbPages, book.nbPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, description, nbPages);
    }

    public Object getAuthor() {
        return author;
    }
}
