import entities.Clients;
import entities.People;
import entities.StateHoliday;
import entities.Store;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import usertypes.Address;
import usertypes.Pname;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Options {
    private Session session;
    // TODO: later move to another file
    public static final String GET_BEST_CLIENTS = "SELECT * from " +
            "TABLE(clients_operations.get_best_buyer(:month)) ORDER BY SUM DESC";
    public static final String GET_PRODUCT_INFO = "SELECT * from TABLE(products_operations.get_product_info(:prod_name_))";

    public static SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

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
            InstantiationException, IllegalAccessException {
        Object field;

        List fields = session.createQuery("SELECT i FROM " +
                className + " i").list();
        for (Iterator iterator = fields.iterator(); iterator.hasNext(); ) {
            field = iterator.next();
            System.out.println(field);
        }
    }

    public void doNativeSQL(String sql){
        //SQLQuery query = session.createSQLQuery(GET_BEST_CLIENTS);
        SQLQuery query = session.createSQLQuery(GET_PRODUCT_INFO);

        //List<Object[]> rows = query.setParameter("month",9).list();
        List<Object[]> fields = query.setParameter("prod_name_","dress").list();

        /*for (Object[] row : rows){
            System.out.println(row[0] + " " + row[1] + " " + row[2]);
        } */

        for (Object[] field : fields){
            //System.out.println(row[0] + " " + row[1] + " " + (BigDecimal)row[2] + " " + row[3] + row[4] + " " + row[5]);
            System.out.printf(field + " ");
        }
    }

    public void addPeople(){
        //session.beginTransaction();
        People p = new People();
        p.setSex("f");
        p.setPeopleName(new Pname("Maria", "Tsvetkova", "Vladimirovna"));
        p.setEmail("tsvetochek123@gmail.com");
        java.util.Date date = null;
        try {
            date = fmt.parse("1999-07-13");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        p.setDateOfBirth(date);
        p.setIdNumber(133348);
        p.setPassword("Somestupidpassword");
        p.setPhone(new BigDecimal(4652656));

        session.save(p);
        //session.flush();
        //session.getTransaction().commit();
    }

}
