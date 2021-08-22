package Products;

import java.util.List;
import FarmaStore.FarmaStore;

public class Category extends CompProduct {

    private List<Product> productInCategory;
    private CategoryName catname;

    public void updateCategory(CategoryName category){
        List<Product> prodsWithCat = FarmaStore.findProductsWithCategory(category);
        //como obtengo la lista de productos de la categoria de X nombre
        //if()
    }

    public void removeFromCategory(Product product){
        //TODO
    }

    public void setCatname(CategoryName catname) {
        this.catname = catname;
    }
}
