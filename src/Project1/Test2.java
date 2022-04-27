package Project1;

import Project1.entity.Author;
import Project1.entity.Company;
import Project1.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Author.class)
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Company.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
//            Author author = new Author("Jotaro","Kujo");
//            Author author2 = new Author("Aizen","Sosuke");
//            Company company1 = new Company("Microsoft",2013,"USA");
//            Company company2 = new Company("Sony",2017,"Japan");
//            Movie movie1 = new Movie("Bleach",6.9,45);
//            Movie movie2 = new Movie("Naruto",7.9,70);
//            Movie movie3 = new Movie("One Piece",8.9,95);
//            Movie movie4 = new Movie("Jojo",12,10);
              Movie movie5 = new Movie("AOT",10,240);


            session.beginTransaction();
            movie5.setCompany(session.get(Company.class,4));
            movie5.setAuthor(session.get(Author.class,7));
            session.save(movie5);
            session.getTransaction().commit();
//**********************************************************************************
//            session = factory.getCurrentSession();
//
//
//            session.beginTransaction();
//            session.delete(session.get(Author.class,1));
//            session.delete(session.get(Author.class,2));
//            session.delete(session.get(Author.class,5));
//
//            session.getTransaction().commit();

        }
        finally {
            session.close();
            factory.close();
        }
    }
}
