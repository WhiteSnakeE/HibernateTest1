package Project1.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinTable(
            name = "actors_movie"
            ,joinColumns = @JoinColumn(name = "id_movie")
            ,inverseJoinColumns = @JoinColumn(name = "id_actors")
    )

    private List<Actors> actors;
    public Company getCompany() {
        return company;
    }
    public void addActorToMovie(Actors actor){
        if(actors==null){
            actors = new ArrayList<>();
        }
        actors.add(actor);
    }
    public List<Actors> getActors() {
        return actors;
    }

    public void setActors(List<Actors> actors) {
        this.actors = actors;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

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
