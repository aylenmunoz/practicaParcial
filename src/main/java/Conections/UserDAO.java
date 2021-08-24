package Conections;

import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
/*
    public static boolean selectUserByEmail(String email) throws SQLException {
        Connection connection = ConnectionDB.initDb();
        String sql = "select * from User where email = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, email);
        ResultSet resultSet = stm.executeQuery();
        if (resultSet.next()) {
            User userMapper = new User(resultSet.getString("email"), "fakepass");
            System.out.println("respuesta de la db: " + userMapper.getEmail());
            return userMapper;
        }
        connection.close();
        return null;
    }
*/






}
