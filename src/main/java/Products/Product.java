package Products;

public class Product {

    private String name;
    private Integer amountInStock;
    private Integer price;
    private String details;
    private CompProduct compProduct;
    private Integer minimumNeeded;
    private CategoryName categoryName;
    private Integer amountInCart;

    public void setCompProduct(CompProduct compProduct) {
        this.compProduct = compProduct;
    }

    public void replenishStock(){
        //TODO
    }





    //getter y setters
    public Integer getPrice() {
        return price;
    }
}
