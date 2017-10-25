import entities.People;
import entities.Store;
import usertypes.Address;
import usertypes.Pname;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * class that gets data needed from user
 */
public class UserDataReader {
    private Scanner sc;

    // TODO: add validation

    /**
     * gets person's info from the user input
     * @return person
     */
    public People getPeopleParams(){
        final String ASK_USER_FNAME = "* Enter person's FIRST NAME";
        final String ASK_USER_LNAME = "* Enter person's LAST NAME";
        final String ASK_USER_MNAME = "* Enter person's MIDDLE NAME";
        final String ASK_USER_MAIL = "* Enter person's EMAIL";
        final String ASK_USER_SEX = "* Enter person's SEX";
        final String ASK_USER_DATEB = "* Enter person's DATE OF BIRTH (yyyy-MM-dd)";
        final String ASK_USER_DATEREG = "* Enter person's DATE OF REGISTRATION (yyyy-MM-dd)";
        final String ASK_USER_PASSWORD = "* Enter person's PASSWORD";
        final String ASK_USER_IDNUM = "* Enter person's ID NUMBER";
        final String ASK_USER_APPARTEMENT = "* Enter person's APARTMENT";
        final String ASK_USER_BUILDING = "* Enter person's BUILDING";
        final String ASK_USER_STREET = "* Enter person's STREET";
        final String ASK_USER_CITY = "* Enter person's CITY";
        final String ASK_USER_PHONE = "* Enter person's PHONE";

        String pname;
        String lastName;
        String middleName;
        String mail;
        String s;
        String dateBirth;
        String dateRegistered;
        String password;
        BigDecimal idNumber;
        BigDecimal apt;
        BigDecimal building;
        String street;
        String city;
        BigDecimal phone;

        // just for converting
        Date dateB = null;
        Date dateReg = null;

        sc = new Scanner(System.in);

        System.out.println(ASK_USER_FNAME);
        pname = sc.nextLine();

        System.out.println(ASK_USER_LNAME);
        lastName = sc.nextLine();

        System.out.println(ASK_USER_MNAME);
        middleName = sc.nextLine();

        System.out.println(ASK_USER_IDNUM);
        idNumber = new BigDecimal(sc.nextLine());

        System.out.println(ASK_USER_DATEB);
        dateBirth = sc.nextLine();

        System.out.println(ASK_USER_SEX);
        s = sc.nextLine();

        System.out.println(ASK_USER_PHONE);
        phone = new BigDecimal(sc.nextLine());

        System.out.println(ASK_USER_MAIL);
        mail = sc.nextLine();

        System.out.println(ASK_USER_PASSWORD);
        password = sc.nextLine();


        System.out.println(ASK_USER_APPARTEMENT);
        apt = new BigDecimal(sc.nextLine());

        System.out.println(ASK_USER_BUILDING);
        building = new BigDecimal(sc.nextLine());

        System.out.println(ASK_USER_STREET);
        street = sc.nextLine();

        System.out.println(ASK_USER_CITY);
        city = sc.nextLine();

        System.out.println(ASK_USER_DATEREG);
        dateRegistered = sc.nextLine();

        // creating people's address
        Address address = new Address();
        address.setAppartement(apt);
        address.setBuilding(building);
        address.setStreet(street);
        address.setCity(city);

        // creating person
        People p = new People();
        p.setPeopleName(new Pname(pname, lastName, middleName));

        // trying to cast input dates
        try {
            dateB = Options.fmt.parse(dateBirth);
            dateReg = Options.fmt.parse(dateRegistered);
        } catch (Exception ex) {
            System.err.println("Error casting dates");
        }

        p.setDateRegistered(dateReg);
        p.setDateOfBirth(dateB);
        p.setIdNumber(idNumber);
        p.setEmail(mail);
        p.setPassword(password);
        p.setAddress(address);
        p.setSex(s);
        p.setPhone(phone);


        return p;
    }


    // TODO: validation
    // works
    /**
     * gets store's parameters from user input
     * @return created Store object
     */
    public Address getStoreParams(){
        final String ASK_STORE_BUILDING = "* Enter store's BUILDING";
        final String ASK_STORE_STREET = "* Enter store's STREET";
        final String ASK_STORE_CITY = "* Enter store's CITY";

        BigDecimal building = null;
        String street = null;
        String city = null;

        sc = new Scanner(System.in);

        System.out.println(ASK_STORE_BUILDING);
        building = new BigDecimal(sc.nextLine());

        System.out.println(ASK_STORE_STREET);
        street = sc.nextLine();

        System.out.println(ASK_STORE_CITY);
        city = sc.nextLine();

        Address address = new Address();
        address.setBuilding(building);
        address.setStreet(street);
        address.setCity(city);

        return address;
    }
}
