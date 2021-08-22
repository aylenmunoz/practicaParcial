package FarmaStore;

import Products.CategoryName;
import User.Administrator;
import User.Client;
import User.Subscriber;
import Products.Product;
import Products.Promotion;

import java.util.Arrays;
import java.util.List;

public class FarmaStore {

    private List<Client> users;
    private static List<Product> products;
    private List<Client> subscribers;
    private List<Promotion> promotions;
    private Administrator admin = Administrator.obtenerInstancia();
    private static FarmaStore instance;


    public static FarmaStore getInstance(){
        if (instance == null) {
            instance = new FarmaStore();
        }
        return instance;
    }

    public static List<Product> findProductsWithCategory(CategoryName category) {
        List<Product> prodsWithCatName = (List<Product>) products.stream().filter(product -> product.getCategoryName() == category);
        return prodsWithCatName;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void addClient(Client client){
        users.add(client);
    }

    public void addPromotion(Promotion promo){
        promotions.add(promo);
    }
    public void subscribe(Subscriber subscriber){
        //TODO
    }

    public void unsubscribe(Subscriber subscriber){
        //TODO

    }

    public void notifySubscribers(){
        //TODO
    }



}
