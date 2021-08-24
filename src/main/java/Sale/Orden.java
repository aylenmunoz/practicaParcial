package Sale;

import API.emailAPI;
import FarmaStore.FarmaStore;
import Products.Product;
import User.User;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Orden {
    private Integer orderNumber = 0;
    private List<Product> productsInOrder;
    private String estimatedDelivery;
    private LocalDateTime date;
    private Integer totalPrice;
    private Cart cart;
    static FarmaStore store;

    static {
        try {
            store = FarmaStore.getInstance();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
    }


    public void createOrder(Cart carrito){
        this.setCart(carrito);
        this.setOrderNumber();
        this.setProductsInOrder(carrito.getProductsInCart());
        this.setEstimatedDelivery();
        this.setDate();
        this.setTotalPrice(carrito);
        store.addOrder(this);
        //INSERT order en DB
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

        System.out.println ("El total de la compra es: $" + totalPrice + "\n");

    }

    public String emailOrder(){
        String ordenNumber = "Su numero de orden es: " + this.getOrdenNumber().toString() + "\n";
        String productosEnOrden = this.prodsInOrdenString() + "\n";
        String precioTotal = "El costo total es: " + this.getTotalPrice().toString() + "\n";
        String cuerpo = ordenNumber + productosEnOrden + precioTotal;
        return cuerpo;
    }
    public String prodsInOrdenString(){
        String cuerpoProducto = null;
        for (int i=0; i < productsInOrder.size(); i++){
            String namep = "Producto: " + productsInOrder.get(i).getName()  + "\t";
            String pricep = "Precio unitario" + productsInOrder.get(i).getPrice().toString() + "\t";
            String amountInCart = "Cantidad: " + productsInOrder.get(i).timesImInACart(cart).toString() + "\n";
            cuerpoProducto = cuerpoProducto + namep + pricep + amountInCart;
        }
        return cuerpoProducto;
    }
    public void sendEmail(User client) throws IOException {
        emailAPI.emailSend(this, client);
    }

    // ------ GETTERS ------ //
    public Integer getOrdenNumber() {
        return orderNumber;
    }
    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }
    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }
    public Integer getTotalPrice(){ return totalPrice;}

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

    public void setTotalPrice(Cart carrito){
        totalPrice = carrito.getTotalPrice();
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
