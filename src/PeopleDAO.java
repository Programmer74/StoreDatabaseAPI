import entities.People;
import entities.UserDataReader;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class PeopleDAO {
    private /*static */ SessionFactory sessionFactory;

    public PeopleDAO() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer addPeople() {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer newPeopleId = null;

        try {
            People p = new UserDataReader().getPeopleParams();
            System.out.println(" >>> " + p);

            tx = session.beginTransaction();

            /*People p1 = new People();
            p1.setPeopleName(p.getPeopleName());
            p1.setSex(p.getSex());
            p1.setEmail(p.getEmail());
            p1.setIdNumber(p.getIdNumber());
            p1.setDateRegistered(p.getDateRegistered());
            p1.setPhone(p.getPhone()); */

            //session.save(p1);
            session.saveOrUpdate(p);
            //session.persist(p1);
            //session.flush();

            tx.commit();
            //session.flush();
            //session.clear();
        /*} catch (StaleStateException ex) {
            System.err.println("token was already used\n" + ex);
            tx.commit(); */
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        /*} catch (javax.persistence.OptimisticLockException exep){
            //tx.commit();
            // TODO: fix this in a normal way */
        }finally {
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