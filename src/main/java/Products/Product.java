package Products;

public class Product {

    private String name;
    private Integer amountInStock;
    private Integer price;
    private String details;
    private State StateStock;
    private Integer minimumNeeded;
    private PackType productType;
    private Integer amountInCart;

    public void setStateStock(State stateStock) {
        StateStock = stateStock;
    }

    public void replenishStock(){
        //TODO
    }

}
