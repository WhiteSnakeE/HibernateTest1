package Project1.entity;

import javax.persistence.*;


@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "review")
    private double review;
    @Column(name = "moviesPrice")
    private int moviesPrice;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH})
    @JoinColumn(name = "author_id")
    private Author author;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Movie() {
    }

    public Movie(String name, double review, int moviesPrice) {
        this.name = name;
        this.review = review;
        this.moviesPrice = moviesPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

    public int getMoviesPrice() {
        return moviesPrice;
    }

    public void setMoviesPrice(int moviesPrice) {
        this.moviesPrice = moviesPrice;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", review=" + review +
                ", moviesPrice=" + moviesPrice +
                '}';
    }
}
