package Products;

public class Sufficient extends State {
    Sufficient(Product product) {
        super(product);
    }

    @Override
    public void replenishStock(Product product){
        //no hace nada
    }
}
