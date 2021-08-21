package FarmaStore;

import User.Administrator;
import User.Client;
import User.Subscriber;
import Products.Product;
import Products.Promotion;

import java.util.List;

public class FarmaStore {

    private List<Client> clients;
    private List<Product> products;
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

    public void addProduct(Product product){
        products.add(product);
    }

    public void addClient(Client client){
        clients.add(client);
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
