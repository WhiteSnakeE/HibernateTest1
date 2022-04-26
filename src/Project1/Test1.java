package Project1;

import Project1.entity.Author;
import Project1.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Movie.class)
                .buildSessionFactory();
        Session session = null;
        try {


//            session = factory.getCurrentSession();
//            Author author = new Author("Jotaro","Kujo");
//            Movie movie1 = new Movie("Bleach",6.9,45);
//            Movie movie2 = new Movie("Naruto",7.9,70);
//            Movie movie3 = new Movie("One Piece",8.9,95);
//            author.addMovieToAuthor(movie1);
//            author.addMovieToAuthor(movie2);
//            author.addMovieToAuthor(movie3);
//            session.beginTransaction();
//            session.save(author);
//            session.getTransaction().commit();
//*****************************************************************************

//                session = factory.getCurrentSession();
//                session.beginTransaction();
//                Author author = session.get(Author.class,5);
//                session.delete(author);
//                session.getTransaction().commit();

//*****************************************************************************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Movie movie = session.get(Movie.class,1);
//            movie.setReview(14.1);
//            session.update(movie);
//            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
