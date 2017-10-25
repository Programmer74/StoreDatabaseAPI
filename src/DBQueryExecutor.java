//import entities.StateHoliday;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class DBQueryExecutor {

    public static void main(String[] args){


        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx;
        try {
            tx = session.beginTransaction();
            Options options = new Options(session);
            //options.printHolidays(); // this works - great!
            //options.printAllStores(); // this works too - great!
            //System.out.println("*******************************");
            //options.printAllPeople();
            //options.printAllClients();
            //options.addPeople();
            //options.printAllTable("entities.People");// this IS WORKING

            //options.doNativeSQL(null);

            //options.getBestClients();

            //Query query = session.createQuery("from TABLE(clients_operations.get_best_buyer(9)) ORDER BY SUM DESC");

            /*options.insertIntoClients("Mary", "Jenkins", "Elizabeth",
                    "maryjen@gmail.com", "f", "12-12-1990",
                    "10-09-2017", "maryjen123", new BigDecimal(132435),
                    0, new BigDecimal(0), null, null, new BigDecimal(4676767)); */
            //options.addHoliday();

            options.addCLient("Mary", "Jenkins", "Elizabeth",
                    "maryjen@gmail.com", "f", "12-12-1990",
                    "10-09-2017", "maryjen123", new BigDecimal(132435),
                    0, new BigDecimal(0), null, null, new BigDecimal(4676767));
            tx.commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }
        HibernateUtil.shutdown();

        //JDBCExample example = new JDBCExample();
        //example.init();
    }
}
