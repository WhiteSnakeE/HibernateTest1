package Project1;

import Project1.entity.Actors;
import Project1.entity.Author;
import Project1.entity.Company;
import Project1.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Actors.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

            Actors actor1 = new Actors("Vlad","Kharchenko");
            Actors actor2 = new Actors("Vlad","Lavrinenko");
            Actors actor3 = new Actors("Ivan","Kovalenko");


            session.beginTransaction();
            Movie movie1 = session.get(Movie.class,5);
            Actors actors = session.get(Actors.class,1);
            movie1.addActorToMovie(actors);
            session.save(movie1);
            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
