package Sale;

import Products.Product;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Integer orderNumber;
    private List<ProductInOrder> productsInOrder;
    private String estimatedDelivery;
    private LocalDateTime date;
    private Integer totalAmount;
    private Cart cart;


    public void createOrder(Integer orderNumber, List<Product> productsInCart, Cart carrito){
        this.setOrderNumber(orderNumber);
        this.productsInOrder = cart.prodInCartToProdInOrder();
        this.setEstimatedDelivery();
        this.setDate();
        this.setTotalAmount(carrito);
    }
    // ------ GETTERS ------ //
    public Integer getOrderNumber() {
        return orderNumber;
    }
    public List<ProductInOrder> getProductsInOrder() {
        return productsInOrder;
    }
    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    // ------ SETTERS ------ //
    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
    public void setProductsInOrder(List<ProductInOrder> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }
    public void setEstimatedDelivery() {
        this.estimatedDelivery = "5 dias habiles";
    }

    public void setDate() {
        this.date = LocalDateTime.now();
    }

    public void setProductPrice(Product product) {
        this.productPrice = product.getPrice();
    }

    public void setProductAmount(Cart carrito, Product product) {
        this.productAmount = carrito.amountOfAProduct(product);
    }

    public void setTotalAmount(Cart carrito){
        totalAmount = carrito.getTotalPrice();
    }
}
