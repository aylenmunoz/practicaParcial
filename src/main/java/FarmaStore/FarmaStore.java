package FarmaStore;

import Products.CategoryName;
import Products.CompProduct;
import User.Administrator;
import User.Client;
import Products.Product;
import User.User;

import java.util.List;

public class FarmaStore {

    private List<User> users;
    private static List<Product> products;
    private List<Client> subscribers;
    private Administrator admin = Administrator.obtenerInstancia();
    private static FarmaStore instance;


    public static FarmaStore getInstance(){
        if (instance == null) {
            instance = new FarmaStore();
        }
        return instance;
    }

    public static List<CompProduct> findProductsWithCategory(CategoryName category) {
        List<CompProduct> prodsWithCatName = (List<CompProduct>) products.stream().filter(product -> product.getCategoryName() == category);
        return prodsWithCatName;
    }

    public void addProductToStore(Product product){
        products.add(product);
    }

    public void deleteProductFromStore(Product product){
        products.remove(product);
        //todo sacarlo de DB
    }

    public void addClient(User client){
        users.add(client);
        //todo agregarlo en DB
    }



    public void removeClient(User user) {
        users.remove(user);
    }
}
