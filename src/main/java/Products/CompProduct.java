package Products;

import Products.State;

public class CompProduct {

    protected State setState(Product product){
        if(product.getAmountInStock() <= product.getMinimumNeeded()){
            //product.setStateStock(insufficient());
        }else{
            //product.setStateStock(sufficient());
        }
        return product.getStateStock();
    }


}
