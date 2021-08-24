package Products;

import java.util.List;
import FarmaStore.FarmaStore;

public class Category extends CompProduct {

    private List<CompProduct> productsInCategory;
    private CategoryName catName;

    public static void updateCategory(CategoryName category){
        List<CompProduct> prodsWithCat = FarmaStore.findProductsWithCategory(category);
        Category categoriaConNombre = obtainCatFromList(category);
        categoriaConNombre.productsInCategory = prodsWithCat; //la igualo sin un if xq es lo mismo
    }

    private static Category obtainCatFromList(CategoryName cat){
        List<CompProduct> theCatInListType = FarmaStore.findProductsWithCategory(cat);
        Category categoryBuscada = (Category) theCatInListType.get(0);
        return categoryBuscada;
    }

    public static void putCategoryInSuperCategory(CategoryName supra, CategoryName sub){
        Category supraCat = obtainCatFromList(supra);
        Category subCat = obtainCatFromList(sub);
        supraCat.productsInCategory.add(subCat);
    }

    public void setCatName(CategoryName catName) {
        this.catName = catName;
    }
}
