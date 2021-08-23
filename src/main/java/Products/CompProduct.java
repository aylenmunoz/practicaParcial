package Products;

import Products.State;

public class CompProduct {
/*
    public State insufficient() {
        State insufficient = new State();
        return insufficient;
    }
    public State sufficient() {
        State sufficient = new State();
        return sufficient;
    }
*/
    protected State setState(Product product){
        if(product.getAmountInStock() <= product.getMinimumNeeded()){
            //product.setStateStock(insufficient());
        }else{
            //product.setStateStock(sufficient());
        }
        return product.getStateStock();
    }


}
