package Sale;

import FarmaStore.FarmaStore;
import Products.Product;
import com.twilio.rest.api.v2010.account.call.Payment;

import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    private List<Product> productsInCart;
    private Integer totalAmount;
    private MethodStrategy payMethod;
    static FarmaStore store = FarmaStore.getInstance();

    public void addToCart(Product product){
        productsInCart.add(product);
    }

    public void removeFromCart(Product product){
        productsInCart.remove(product);
    }

    public void charge(PaymentMethod method){
        Order newOrder = new Order();
        Integer amountOfOrders = store.getAllOrders().size();
        Integer orderNumber = amountOfOrders + 1;

        newOrder.createOrder(orderNumber, productsInCart);
        MethodStrategy strategy = method.selectMethod(method);
        strategy.charge(totalAmount, newOrder);
        this.updateAmountsInProds();
    }

    private void updateAmountsInProds() {
        productsInCart.forEach(product -> product.updateAmount(amountOfAProduct(product.getName())));
    }

    private Integer amountOfAProduct(String nameProduct){
        List<Product> list = productsInCart.stream().filter(product -> ( product.getName() == nameProduct)).collect(Collectors.toList());
        return list.size();
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    //setters
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = productsInCart.stream().mapToInt(p -> p.getPrice()).sum();
    }
}

