package Sale;

import FarmaStore.FarmaStore;
import Products.Product;
import User.Client;
import User.User;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    private List<Product> productsInCart;
    private Integer totalPrice;
    private MethodStrategy payMethod;
    static FarmaStore store = FarmaStore.getInstance();

    public void addToCart(Product product){
        productsInCart.add(product);
    }

    public void removeFromCart(Product product){
        productsInCart.remove(product);
    }

    public void charge(PaymentMethod method, User client) throws IOException {
        Orden newOrden = new Orden();
        newOrden.createOrder(this);
        MethodStrategy strategy = method.selectMethod(method);
        strategy.charge(newOrden, client);
        this.updateStockOfProds();
    }


    public void updateStockOfProds() {
        productsInCart.forEach(product -> product.updateAmount(amountOfAProduct(product)));
    }

    public Integer amountOfAProduct(Product product){
        List<Product> list = productsInCart.stream().filter(p -> ( p == product)).collect(Collectors.toList());
        return list.size();
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    //setters
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = productsInCart.stream().mapToInt(p -> p.getPrice()).sum();
    }
    //getters
    public Integer getTotalPrice(){
        return totalPrice;
    }
}

