import java.sql.*;

public class JDBCExample {
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

    static final String USER = "Helena";
    static final String PASSWORD = "Alyona";

    public void init(){
        Connection conn = null;
        Statement statement = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("Connecting to db...");

            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            System.out.println("Creating statement");
            statement = conn.createStatement();
            String sql = "SELECT * from TABLE(clients_operations.get_best_buyer(9)) ORDER BY SUM DESC";

            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt("cl_id") + "\t" + rs.getString("cli_name") +
                "\t" + rs.getInt("sum"));
            }
            rs.close();
            statement.close();
            conn.close();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }
}
