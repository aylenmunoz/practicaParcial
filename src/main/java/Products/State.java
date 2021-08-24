package Products;

import User.Administrator;

import java.sql.SQLException;

public abstract class State{
    private Administrator admin = Administrator.obtenerInstancia();
    Product product;

    State(Product product) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.product = product;
    }

    public void replenishStock(Product product){}


}


