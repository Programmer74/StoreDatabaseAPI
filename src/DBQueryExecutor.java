import entities.Client;

public class DBQueryExecutor {

    public static void main(String[] args){
        //testPeople(); // TODO: fix
        //testClient();

        //testPicture(); // seems to work
        testStore(); // hopefully works


        //JDBCExample example = new JDBCExample();
        //example.init();
    }

    /**
     * TODO: fix batch Exception
     */
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

    private static void testClient(){
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.addClient();
    }
}
