import entities.Store;
import entities.UserDataReader;
import org.hibernate.SessionFactory;
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

    public void addStore() {
        Address storeAddress = new UserDataReader().getStoreParams();
        Query query = session.createQuery("from Store");
        List<Store> list = query.list();

        for (Store item : list) {
            if ((item.getStoreAddress().getStreet().equalsIgnoreCase(storeAddress.getStreet()))
                    && (item.getStoreAddress().getBuilding().equals(storeAddress.getBuilding()))
                    && (item.getStoreAddress().getCity().equalsIgnoreCase(storeAddress.getCity()))) {
                System.err.println(">> Sore already exists in DB");
                return; // TODO: handle this
            }
        }

        Store store = new Store();
        store.setAddress(storeAddress);
        session.save(store);
    }
}
