package Sale;

import Products.Product;
import com.twilio.rest.api.v2010.account.call.Payment;

import java.util.List;

public class Cart {

    private List<Product> productsInCart;
    private Integer totalAmount;
    private MethodStrategy payMethod;

    public void addToCart(Product product){
        productsInCart.add(product);
    }

    public void removeFromCart(Product product){
        productsInCart.remove(product);
    }

    public void charge(PaymentMethod method){
        MethodStrategy strategy = method.selectMethod(method);
        strategy.charge(totalAmount);
        this.updateAmountsInProds();
        //TODO llamar a setSate cada vez q se compra el producto.
    }

    private void updateAmountsInProds() {
        Integer amountInCart = 9; //TODO HACER ESO
        productsInCart.forEach(product -> product.updateAmount(amountInCart));
    }


    //setters
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = productsInCart.stream().mapToInt(p -> p.getPrice()).sum();
    }
}

