package Sale;

import FarmaStore.FarmaStore;
import Products.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Order {
    private Integer orderNumber = 0;
    private List<Product> productsInOrder;
    private String estimatedDelivery;
    private LocalDateTime date;
    private Integer totalAmount;
    private Cart cart;
    static FarmaStore store = FarmaStore.getInstance();


    public void createOrder(Cart carrito){
        this.setCart(carrito);
        this.setOrderNumber();
        this.setProductsInOrder(carrito.getProductsInCart());
        this.setEstimatedDelivery();
        this.setDate();
        this.setTotalAmount(carrito);
        store.addOrder(this);
    }

    public void showOrder(){

        System.out.println ("El numero de orden es: " + orderNumber + "\n");

        for (int i=0; i < productsInOrder.size(); i++){
            String namep = productsInOrder.get(i).getName();
            System.out.println ("El nombre del producto es: " + namep + "\n");

            Integer pricep = productsInOrder.get(i).getPrice();
            System.out.println ("El precio del producto es: " + pricep + "\n");

            Integer amountInCart = productsInOrder.get(i).timesImInACart(cart);
            System.out.println ("La cantidad de veces que llevo el producto es: " + amountInCart + "\n");

        }
    }
    // ------ GETTERS ------ //
    public Integer getOrderNumber() {
        return orderNumber;
    }
    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }
    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    // ------ SETTERS ------ //
    public void setOrderNumber() {
        Integer amountOfOrders = store.getAllOrders().size();
        Integer orderNumber = amountOfOrders + 1;
    }
    public void setProductsInOrder(List<Product> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }
    public void setEstimatedDelivery() {
        this.estimatedDelivery = "5 dias habiles";
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public void setTotalAmount(Cart carrito){
        totalAmount = carrito.getTotalPrice();
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
