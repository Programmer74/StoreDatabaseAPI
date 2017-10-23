import entities.StateHoliday;
import entities.Store;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

public class Options {
    private Session session;

    public Options(Session session) { this.session = session; }

    public Options() { }

    

    public void printHolidays(){
        List holidays = session.createQuery("FROM StateHoliday").list();
        for (Iterator iterator = holidays.iterator(); iterator.hasNext(); ) {
            StateHoliday holiday = (StateHoliday) iterator.next();
            System.out.println(holiday.getHoliday_id() + "\t" + holiday.getHoliday_date() + "\t" + holiday.getHoliday_name());
        }
    }

    public void getBestClients(){
        //Object bestClients = session.createQuery("SELECT " +
        //      "clients_operations.get_best_buyer  ('9') FROM DUAL").list().get(0);
        /*for (Iterator iterator = bestClients.iterator(); iterator.hasNext(); ) {
            StateHoliday holiday = (StateHoliday) iterator.next();
            System.out.println(holiday.getHoliday_id() + "\t" + holiday.getHoliday_date() + "\t" + holiday.getHoliday_name());
        } */
        //System.out.println(bestClients);

        //testing
        Object sayHello = session.createQuery("SELECT say_greeting('Helena') from DUAL");
    }

    public void printAllStores(){
        List stores = session.createQuery("SELECT e FROM Store e").list();
        for (Iterator iterator = stores.iterator(); iterator.hasNext(); ) {
            Store store = (Store) iterator.next();
            System.out.println(store.getStoreId() + "\t" + store.getAddress());
        }
    }
}
