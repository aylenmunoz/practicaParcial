package Products;

public class Product {

    private String name;
    private Integer amountInStock;
    private Integer price;
    private String details;
    private State stateStock;
    private Integer minimumNeeded;
    private CategoryName categoryName;
    private Integer amountInCart;

    public void setStateStock(State stateStock) {
        this.stateStock = stateStock;
    }

    public void replenishStock(){
        //TODO
    }





    //getter y setters
    public Integer getPrice() {
        return price;
    }
}
