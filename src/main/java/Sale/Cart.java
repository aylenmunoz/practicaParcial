package Sale;

import FarmaStore.FarmaStore;
import Products.Product;
import Sale.ProductInOrder;
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

    public void charge(PaymentMethod method){
        Order newOrder = new Order();
        Integer amountOfOrders = store.getAllOrders().size();
        Integer orderNumber = amountOfOrders + 1;
        List<ProductInOrder> productsInOrder = productsInCart.stream().map(p -> p.)
        newOrder.createOrder(orderNumber, productsInCart, this);
        MethodStrategy strategy = method.selectMethod(method);
        strategy.charge(totalPrice, newOrder);
        this.updateStockOfProds();
    }

    public List<ProductInOrder> prodInCartToProdInOrder(){
        List<ProductInOrder> productsInOrder = null;
        for(Integer i = 0; i < productsInCart.size() ; i ++){
            Product product = productsInCart.get(i);
            ProductInOrder newPiO = new ProductInOrder();
            newPiO.createPinO(product, this);
            productsInOrder.add(newPiO);
        }
        return productsInOrder;

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

