package fr.julienleveque.cefimtestcda2.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "nb_pages")
    private Integer nbPages;

    @Column(name = "state")
    private String state;

    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "author_id", updatable = false, insertable = false)
    private Author author;

    @OneToMany (targetEntity = Review.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id", updatable = false, insertable = false)
    private List<Review> review;

    @OneToMany (targetEntity = Reservation.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", updatable = false, insertable = false)
    private List<Reservation> reservation;

    @ManyToMany
    @JoinTable(
            name = "reservation",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id")
    )
    private List<Client> clients;

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public Book () {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }
}
