import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    public Connection connectingToDataBase(String dbname, String user, String password){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+ dbname, user, password);
            if (conn != null){
                System.out.println("Connection is established successfully!");
            }
            else {
                System.out.println("Connection Failed!");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("An unknown error occurred!\nPlease try again later!");
        }
        return conn;
    }
}
