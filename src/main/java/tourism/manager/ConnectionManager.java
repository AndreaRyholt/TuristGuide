package tourism.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static Connection connection;

    private ConnectionManager() {
        // default constructor - kan ikke instantieres
    }

    public static Connection getConnection(String db_url, String username, String pw) {
        if(connection!=null) return connection;

        try {
            connection = DriverManager.getConnection(db_url, username, pw);
        }
        catch (SQLException e) {
            System.out.println("No connnection to database...");
            e.printStackTrace();
        }
        return connection;
    }
}
