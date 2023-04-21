package fr.julienleveque.cefimtestcda2.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "review")
public class Review {

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "note")
    private Integer note;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Book books;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Review () {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
