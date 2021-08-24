package Products;

import User.Administrator;

import java.sql.SQLException;

public class Insufficient extends State{
    private Administrator admin = Administrator.obtenerInstancia();

    Insufficient(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super(product);
        product.setTengoSuficiente(false);
    }

    @Override
    public void replenishStock(Product product){
        admin.replenishStock(product);
    }
}
