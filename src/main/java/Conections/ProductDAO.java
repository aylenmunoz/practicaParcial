package Conections;

import Products.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static void createProduct(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection connection = ConnectionDB.initDb();

        String sql = "INSERT INTO Product (name, price,  details, amountInStock, minimunNeeded) values (?, ?, ?, ?, ?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, product.getName());
        stm.setInt(2, product.getPrice());
        stm.setString(3, product.getDetails());
        stm.setInt(4, product.getAmountInStock());
        stm.setInt(5, product.getMinimumNeeded());
        stm.executeUpdate();
        connection.close();
    }

    public static boolean deleteProduct(String name) {
        Integer productId = getProductIdFromName(name);


        String consulta = "DELETE FROM product WHERE id = " + productId + ";";

        try {
            Connection conn = ConnectionDB.initDb();

            // Ejecuci�n
            PreparedStatement stm = (PreparedStatement) conn.createStatement();
            // execute the preparedstatement
            stm.execute();
            return true;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("Error en Delete");
            return false;
        }
    }

    public static Integer getProductIdFromName(String name){
        Integer productId;
        try {

            // generacion de query
            String consulta = "SELECT * FROM products WHERE email = "+ name +";";

            // Conexi�n
            Connection conn = ConnectionDB.initDb();

            // Ejecuci�n
            PreparedStatement stm = (PreparedStatement) conn.createStatement();
            ResultSet rs = stm.executeQuery(consulta);

            // Recorrer y usar cada l�nea retornada
            List<Product> users = new ArrayList<>();

            boolean haySiguiente = true;

            while (haySiguiente && rs.getString(1) != name) {
                haySiguiente = rs.next();
            }
            productId = rs.getInt(0);
            return productId;

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("Error en Select");
            return null;
        }
    }
}
