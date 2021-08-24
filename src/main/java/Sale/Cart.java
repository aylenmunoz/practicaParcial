package Sale;

import FarmaStore.FarmaStore;
import Products.Product;
import User.Client;
import User.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    private List<Product> productsInCart;
    private Integer totalPrice;
    private PaymentMethod payMethod;
    static FarmaStore store;

    static {
        try {
            store = FarmaStore.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

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
        this.totalPrice = productsInCart.stream().mapToInt(Product::getPrice).sum();
    }
    //getters
    public Integer getTotalPrice(){
        return totalPrice;
    }
}

