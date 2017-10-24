import entities.Clients;
import entities.People;
import entities.StateHoliday;
import entities.Store;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.query.Query;
import usertypes.Address;
import usertypes.Pname;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.IllegalFormatException;
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
        p.setIdNumber(new BigDecimal(133348));
        p.setPassword("Somestupidpassword");
        p.setPhone(new BigDecimal(4652656));

        session.save(p);
        //session.flush();
        //session.getTransaction().commit();
    }




    // TODO: fix this
    public void insertIntoClients(String pname, String lastName, String middleName,
                                  String mail, String s, String dateBirth, String dateRegistered,
                                  String password, BigDecimal idNumber, Integer apt,
                                  BigDecimal building, String street, String city, BigDecimal phone){

        // creating address for new client
        Address address = new Address();
        address.setAppartement(apt);
        address.setBuilding(building);
        address.setStreet(street);
        address.setCity(city);

        Query query = session.createQuery("?= CALL insert_into_clients(:pname, :last_name," +
                ":middle_name, :mail, :s, :date_birth, :date_regIN," +
                ":passwd, :id_num, :paddr, :ph)")
                .setParameter("pname", pname)
                .setParameter("last_name", lastName)
                .setParameter("middle_name", middleName)
                .setParameter("mail", mail)
                .setParameter("s", s)
                .setParameter("date_birth", dateBirth)
                .setParameter("date_regIN", dateRegistered)
                .setParameter("passwd", password)
                .setParameter("id_num", idNumber)
                .setParameter("paddr", address)
                .setParameter("ph", phone);
        query.executeUpdate();

    }

    // this works!
    public void addHoliday(String inpDate){
        StateHoliday holiday = new StateHoliday();
        java.util.Date date;
        try {
            date = fmt.parse(inpDate);
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
        holiday.setHoliday_date(date);
        session.save(holiday);
    }

}
