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
//                session = factory.getCurrentSession();
//
//
//                session.beginTransaction();
//                Movie movie = session.get(Movie.class,3);
//                session.update(session);
//                session.getTransaction().commit();
            session = factory.getCurrentSession();

            session.beginTransaction();
            Movie movie = session.get(Movie.class,1);
            movie.setReview(14.1);
            session.update(movie);
            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
