package Connection;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
public class ConnectionF {
    private static final Logger LOGGER = Logger.getLogger(ConnectionF.class.getName());
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/warehouse";
    private static final String USER = "root";
    private static final String PASS = "10pojarandrei#";
    private static ConnectionF singleInstance = new ConnectionF();
    private ConnectionF() {
        try {
            Class.forName(DRIVER);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    private Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DBURL, USER, PASS);
        }
        catch (SQLException e)
        {
            LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
            e.printStackTrace();
        }
        return connection;
    }
    public static Connection getConnection()
    {
        return singleInstance.createConnection();
    }
    public static void close(Connection c) {
        if (c != null) {
            try {
                c.close();
            }
            catch (SQLException e)
            {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
            }
        }
    }
    public static void close(Statement s) {
        if (s != null) {
            try {
                s.close();
            }
            catch (SQLException e)
            {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
            }
        }
    }
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e)
            {
                LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
            }
        }
    }
}
