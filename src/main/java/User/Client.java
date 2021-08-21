package User;

import Products.Product;
import Sale.Cart;

import java.util.List;

public class Client extends User {

    private String name;
    private String surname;
    private List<Cart> previousPurchases;
    private Cart cart;
    private String billingAddress;
    private String deliveryAddress;

    public void buy(){
        // TODO
    }

    public void addToCart(Product product){
        cart.addToCart(product);

    }

    public void removeFromCart(Product product){
        cart.removeFromCart(product);
    }

    public void deleteAccount(){

    }


}
