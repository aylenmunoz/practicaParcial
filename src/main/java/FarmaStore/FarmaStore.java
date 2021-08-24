package FarmaStore;

import Products.CategoryName;
import Products.CompProduct;
import Sale.Orden;
import User.Administrator;
import Products.Product;
import User.User;
import User.Client;

import java.util.List;
import java.util.Scanner;

public class FarmaStore {

    private List<User> users;
    private static List<Product> products;
     private List<Orden> allOrdens;
    private Administrator admin = Administrator.obtenerInstancia();
    private static FarmaStore instance;


    public static FarmaStore getInstance(){
        if (instance == null) {
            instance = new FarmaStore();
        }
        return instance;
    }

    public void addOrder(Orden orden){
        allOrdens.add(orden);
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

    public List<Orden> getAllOrders() {
        return allOrdens;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public boolean userExists(String pass) {
        User user = this.findUserWith(pass);
        return user != null;
    }
    public User findUserWith(String password){
        List<User> lUserWithPass = (List<User>) users.stream().filter(u -> u.getPassword() == password);
        User userWithPass = lUserWithPass.get(0);
        return userWithPass;
    }
    public Client register() {
        Client client = new Client();
        String mail;
        String pass;
        Scanner registerScan = new Scanner(System.in);
        System.out.println("Ingresa su email");
        mail = registerScan.nextLine();
        System.out.println("Ingrese la contrasenia para su cuenta");
        pass = registerScan.nextLine();
        client.newClient(mail, pass);
        System.out.println("Se creo su cuenta con exito");

        this.addClient(client);
        return client;
        //TODO data base
    }
    public Client logIn(){
        FarmaStore store = FarmaStore.getInstance();
        Scanner registerScan = new Scanner(System.in);
        System.out.println("Ingresa su email");
        String mail = registerScan.nextLine();
        System.out.println("Ingrese la contrasenia para su cuenta");
        String pass = registerScan.nextLine();
        if(store.userExists(pass)){ //todo buscar en DataBase
            System.out.println("Ingresaste Correctamente");
            Client client = null; //todo agarrar de DB
            return client;
        }else{
            System.out.println("Datos incorrectos");
            return null;
        }

    }
}

