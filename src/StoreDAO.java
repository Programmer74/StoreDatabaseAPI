import entities.Store;
import entities.UserDataReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import usertypes.Address;

import java.util.List;

public class StoreDAO {

    private static SessionFactory sessionFactory;

    public StoreDAO() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * procedure for inserting a store in DB
     */
    public void addStore() {
        Session session = null;

        session = sessionFactory.openSession();

        Transaction tx = null;

        try {
            Address storeAddress = new UserDataReader().getStoreParams();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Store");
            List<Store> list = query.list();

            for (Store item : list) {
                if ((item.getStoreAddress().getStreet().equalsIgnoreCase(storeAddress.getStreet()))
                        && (item.getStoreAddress().getBuilding().equals(storeAddress.getBuilding()))
                        && (item.getStoreAddress().getCity().equalsIgnoreCase(storeAddress.getCity()))) {
                    System.err.println(">> Store already exists in DB");
                    return; // TODO: handle this
                }
            }

            Store store = new Store();
            store.setAddress(storeAddress);

            session.flush();
            session.save(store);
            session.flush();
            //session.evict(store);
            //session.persist(store);

            tx.commit();
        } catch (Throwable ex) {
            if (tx != null) tx.rollback();
            System.out.println(" ERROR " + ex);
        } finally {
            session.close();
        }
    }
}
