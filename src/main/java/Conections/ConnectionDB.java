package Conections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    public static Connection initDb() throws SQLException {
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/script.sql";
            String username = "root";
            String password = "elef";/* cambiar*/
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            return connection;
        } catch (Error error) {
            System.out.println(error);
        }
        return null;
    }
}
