import entities.StateHoliday;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class StoreDatabaseAPI {
    public static void main(String[] args){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            Options options = new Options(session);
            options.printHolidays();

            //options.getBestClients();

            //Query query = session.createQuery("from TABLE(clients_operations.get_best_buyer(9)) ORDER BY SUM DESC");

            tx.commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
