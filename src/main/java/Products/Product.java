package Products;

public class Product extends CompProduct{

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

    public void replenishStock(Integer amount) {
        setAmountInStock(amount);
        super.setState(this);
    }

    public void createProduct(String nameP, Integer amountInStock, Integer price, String details, Integer minimumNeeded/*, CategoryName catName*/){
        this.setName(nameP);
        this.setAmountInStock(amountInStock);
        this.setPrice(price);
        this.setDetails(details);
        this.setMinimumNeeded(minimumNeeded);
        //this.setCategoryName(catName);
        setState(this);


    }
    // ----- SETTERS ----- //

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(Integer price) {
        this.price = price;
    }

    private void setDetails(String details) {
        this.details = details;
    }

    private void setMinimumNeeded(Integer minimumNeeded) {
        this.minimumNeeded = minimumNeeded;
    }

    private void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public void setAmountInCart(Integer amountInCart) { this.amountInCart = amountInCart; }

    private void setAmountInStock(Integer amountStock) {
        this.amountInStock = amountStock;
    }


    // ----- GETTERS ----- //

    public String getName() {
        return name;
    }

    public Integer getAmountInStock() {
        return amountInStock;
    }

    public String getDetails() {
        return details;
    }

    public State getStateStock() {
        return stateStock;
    }

    public Integer getMinimumNeeded() {
        return minimumNeeded;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public Integer getPrice() { return price; }

    public Integer getAmountInCart() { return amountInCart;}
}
