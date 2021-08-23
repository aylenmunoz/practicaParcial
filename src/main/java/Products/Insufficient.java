package Products;

import User.Administrator;

public class Insufficient extends State{
    private Administrator admin = Administrator.obtenerInstancia();

    Insufficient(Product product) {
        super(product);
        product.setTengoSuficiente(false);
    }

    @Override
    public void replenishStock(Product product){
        admin.replenishStock(product);
    }
}
