import entities.Clients;
import entities.People;
import entities.StateHoliday;
import entities.Store;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import usertypes.Address;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Options {
    private Session session;
    // TODO: later move to another file
    public static final String GET_BEST_CLIENTS = "SELECT * from " +
            "TABLE(clients_operations.get_best_buyer(:month)) ORDER BY SUM DESC";
    public static final String GET_PRODUCT_INFO = "SELECT * from TABLE(products_operations.get_product_info(:prod_name_))";

    public Options(Session session) { this.session = session; }

    public Options() { }

    /**
     * prints all elements of the table
     * @param className - name of the mapped class
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public void printAllTable(String className) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException{
        /* using reflection to get class*/
        Class classTemp = Class.forName(className);
        Object tmp = classTemp.newInstance();

        List tmps = session.createQuery("SELECT i FROM " +
                className + " i").list();
        for (Iterator iterator = tmps.iterator(); iterator.hasNext(); ) {
            tmp = classTemp.cast(iterator.next());
            System.out.println(tmp);
        }
    }

    public void doNativeSQL(String sql){
        //SQLQuery query = session.createSQLQuery(GET_BEST_CLIENTS);
        SQLQuery query = session.createSQLQuery(GET_PRODUCT_INFO);

        //List<Object[]> rows = query.setParameter("month",9).list();
        List<Object[]> rows = query.setParameter("prod_name_","dress").list();

        /*for (Object[] row : rows){
            System.out.println(row[0] + " " + row[1] + " " + row[2]);
        } */

        for (Object[] row : rows){
            System.out.println(row[0] + " " + row[1] + " " + (BigDecimal)row[2] + " " + row[3] + row[4] + " " + row[5]);
        }
    }

}
