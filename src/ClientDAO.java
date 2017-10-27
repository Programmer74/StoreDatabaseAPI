import entities.Client;
import entities.People;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import usertypes.Pname;

import java.math.BigDecimal;

public class ClientDAO {
    private /*static */ SessionFactory sessionFactory;

    public ClientDAO() {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void addClient() {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        //Integer newPeopleId = null;

        try {
            tx = session.beginTransaction();

            People p = new People();
            p.setPeopleName(new Pname("Adrianna", "Walsh", "Jennie"));
            p.setPhone(new BigDecimal(9009595));
            p.setIdNumber(new BigDecimal(123112));
            p.setEmail("adwalsh@yandex.ru");
            p.setPassword("adrianna47");

            session.saveOrUpdate(p);
            tx.commit();

            Client client = new Client();
            client.setPeople(p);

            session.saveOrUpdate(client);

            tx.commit();


        } catch (StaleStateException ex) {
            System.err.println("token was already used\n" + ex);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } catch (javax.persistence.OptimisticLockException exep) {
            //tx.commit();
            // TODO: fix this in a normal way
        } finally {
            session.close();
        }
    }
}
