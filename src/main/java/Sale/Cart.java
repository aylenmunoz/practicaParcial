package Sale;

import Products.Product;

import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    private List<Product> products;
    private PaymentMethod paymentMethod;
    private Integer totalAmount;

    public void addToCart(Product product){
        products.add(product);
    }

    public void removeFromCart(Product product){
        products.remove(product);
    }

    public void deleteProduct(){
        //TODO
    }

    public void charge(Integer totalAmount){
        //TODO
    }



    //setters
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = products.stream().mapToInt(p -> p.getPrice()).sum();
    }
}

