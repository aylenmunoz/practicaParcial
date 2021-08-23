package Products;

import User.Administrator;

public abstract class State{

    Product product;

    State(Product product){
        this.product = product;
    }

    public void replenishStock(Product product){}


}


