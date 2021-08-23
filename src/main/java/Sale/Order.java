package Sale;

import Products.Product;

import java.util.List;

public class Order {
    private Integer orderNumber;
    private List<Product> productsInOrder;
    private String estimatedDelivery;

    public void createOrder(Integer orderNumber, List<Product> productsInCart){
        this.setOrderNumber(orderNumber);
        this.setProductsInOrder(productsInCart);
        this.setEstimatedDelivery();
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }

    public void setProductsInOrder(List<Product> productsInOrder) {
        this.productsInOrder = productsInOrder;
    }

    public String getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery() {
        this.estimatedDelivery = "5 dias habiles";
    }
}
