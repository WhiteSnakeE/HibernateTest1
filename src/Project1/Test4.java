package Project1;

import Project1.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Company.class)
                .addAnnotatedClass(Actors.class)
                .addAnnotatedClass(Director.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();

            Company company1 = new Company("Microsoft",1999,"USA");
            Director directo1 = new Director("Joske","OK");
            session.beginTransaction();
            session.save(company1);
            session.save(directo1);
            Director director = session.get(Director.class,2);
            session.delete(director);

            session.getTransaction().commit();
        }
        finally {
            session.close();
            factory.close();
        }
    }
}
