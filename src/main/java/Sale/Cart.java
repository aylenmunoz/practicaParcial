package Sale;

import Products.Product;

import java.util.List;

public class Cart {

    private List<Product> productsInCart;
    private PaymentMethod paymentMethod;
    private Integer totalAmount;

    public void addToCart(Product product){
        productsInCart.add(product);
    }

    public void removeFromCart(Product product){
        productsInCart.remove(product);
    }

    public void charge(Integer totalAmount){
        //TODO
        //TODO llamar a setSate cada vez q se compra el producto.
    }



    //setters
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = productsInCart.stream().mapToInt(p -> p.getPrice()).sum();
    }
}

