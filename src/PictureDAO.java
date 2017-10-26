import entities.Picture;
import entities.UserDataReader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PictureDAO {
    private /*static*/ SessionFactory sessionFactory;

    public PictureDAO() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * procedure for inserting a store in DB
     */
    public void addPicture() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Picture pic = new UserDataReader().getPictureParams(null);
            if (pic.getPicture().length != 0)
                session.save(pic);


            tx.commit();
        } catch (Throwable ex) {
            System.err.println("ERROR\n" + ex);
        }
    }


}
