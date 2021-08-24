package Products;

import User.Administrator;

public abstract class State{
    private Administrator admin = Administrator.obtenerInstancia();
    Product product;

    State(Product product){
        this.product = product;
    }

    public void replenishStock(Product product){}


}


