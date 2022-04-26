package Project1.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surName")
    private String surName;

    public Author() {

    }
    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH}, mappedBy = "author")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Author(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public void addMovieToAuthor(Movie movie){
        if(movies==null){
            movies = new ArrayList<>();
        }
        movies.add(movie);
        movie.setAuthor(this);
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
