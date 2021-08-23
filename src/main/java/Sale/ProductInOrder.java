package Sale;

import Products.Product;

public class ProductInOrder {
    String name;
    Integer amount;
    Integer price;

    public void createPinO(Product product, Cart carrito){
        //aca
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
