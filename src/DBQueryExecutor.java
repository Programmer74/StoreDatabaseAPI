//import entities.StateHoliday;
import entities.People;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class DBQueryExecutor {

    public static void main(String[] args){
        //testPeople(); // TODO: fix
        //testPicture(); // seems to work
        testStore();


        //JDBCExample example = new JDBCExample();
        //example.init();
    }

    private static void testPeople(){
        PeopleDAO peopleDAO = new PeopleDAO();

        System.out.println("TESTING PEOPLE");

        // adding new people
        //System.out.println("New id " + peopleDAO.addPeople());
        peopleDAO.addPeople();

        // printing all people
        peopleDAO.listPeople();
    }

    /**
     * test for inserting into store
     */
    private static void testStore() {
        StoreDAO storeDAO = new StoreDAO();

        System.out.println("TESTING STORE");

        storeDAO.addStore(); // works
    }

    private static void testPicture() {
        PictureDAO pictureDAO = new PictureDAO();
        pictureDAO.addPicture(); // works
    }
}
