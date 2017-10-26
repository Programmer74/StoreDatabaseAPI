import entities.People;
import entities.UserDataReader;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class PeopleDAO {
    private static SessionFactory sessionFactory;

    public PeopleDAO() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer addPeople(){
        People p = new UserDataReader().getPeopleParams();
        System.out.println(" >>> " + p);

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer newPeopleId = null;

        try {
            tx = session.beginTransaction();
            session.save(p);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return newPeopleId;
    }

    public void listPeople(){
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List people = session.createQuery("FROM People").list();

            for (Iterator iterator = people.iterator(); iterator.hasNext(); ) {
                People p = (People) iterator.next();
                System.out.println(p);
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
