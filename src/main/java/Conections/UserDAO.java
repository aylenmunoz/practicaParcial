package Conections;

import User.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import User.User;

public class UserDAO {

    public static void registerUser(User user) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection connection = ConnectionDB.initDb();
        String sql = "INSERT INTO User (email,password) values (?, ?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, user.getEmail());
        stm.setString(2, user.getPassword());
        stm.executeUpdate();
        connection.close();
    }

    public static List<User> selectUsers() {
        try {
            // generacion de query
            String consulta = "SELECT * FROM users";

            // Conexi�n
            Connection conn = ConnectionDB.initDb();

            // Ejecuci�n
            PreparedStatement stm = (PreparedStatement) conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            // Recorrer y usar cada l�nea retornada
            List<User> users = new ArrayList<>();

            while (rs.next()) {
                User user = new User();

                // get email
                String email = rs.getString("email");
               //get pass
                String pass = rs.getString("password");
                user.setEmail(email);
                user.setPassword(pass);
                users.add(user);
            }
            return users;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }

    public static void deleteUser(String email) {
        Integer userId = getUserIDByMail(email);
        String consulta = "DELETE FROM user WHERE id = " + userId + ";";

        try {
            Connection conn = ConnectionDB.initDb();

            // Ejecuci�n
            PreparedStatement stm = (PreparedStatement) conn.createStatement();
            // execute the preparedstatement
            stm.execute();

        } catch (SQLException ex) {

            // handle any errors
            System.out.println("Error en Delete");
        }

    }

    public static Integer getUserIDByMail(String mail){
        Integer userId;
        try {

            // generacion de query
            String consulta = "SELECT * FROM users WHERE email = "+ mail +";";

            // Conexi�n
            Connection conn = ConnectionDB.initDb();

            // Ejecuci�n
            PreparedStatement stm = (PreparedStatement) conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            // Recorrer y usar cada l�nea retornada
            List<User> users = new ArrayList<>();

            boolean haySiguiente = true;

            while (haySiguiente && rs.getString(1) != mail) {
                haySiguiente = rs.next();
            }
            userId = rs.getInt(0);
            return userId;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }

    public static boolean getUserByMail(String mail){
        try {

            // generacion de query
            String consulta = "SELECT * FROM user WHERE email = "+ mail +";";

            // Conexi�n
            Connection conn = ConnectionDB.initDb();

            // Ejecuci�n
            PreparedStatement stm = (PreparedStatement) conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            // Recorrer y usar cada l�nea retornada
            List<User> users = new ArrayList<>();
            boolean encontrado = false;
            while(rs.next()) {
                if (rs.getString(1) != mail) {
                    encontrado = false;
                } else if (rs.getString(1) == mail) {
                    encontrado =  true;
                } else if (rs.next() != true) {
                    encontrado = false;
                }
            }
            return encontrado;
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("Error en Select");
            return false;
        }
    }
}
