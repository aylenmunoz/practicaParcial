package FarmaStore;

import Conections.UserDAO;
import Products.CategoryName;
import Products.CompProduct;
import Sale.Orden;
import User.Administrator;
import Products.Product;
import User.User;
import User.Client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FarmaStore {

    private List<User> users;
    private static List<Product> products;
    private List<Orden> allOrdens;
    private Administrator admin = Administrator.obtenerInstancia();
    private static FarmaStore instance;

    public FarmaStore() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    }


    public static FarmaStore getInstance() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
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

    public void deleteProductFromStore(String name){
       Product pADelete = this.findProductByName(name);
       products.remove(pADelete);
        //todo sacarlo de DB
    }

    public void addClient(User client) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UserDAO.registerUser(client);
    }

    public void removeClient(String mail) {
        User uADelete = this.findUserWithMail(mail);
        users.remove(uADelete);
    }

    public List<Orden> getAllOrders() {
        return allOrdens;
    }

    public static List<Product> getProducts() {
        return products;
    }

    public boolean userExists(String mail) {
        User user = this.findUserWithMail(mail);
        return user != null;
    }
    public Client findUserWithMail(String mail){
        List<Client> lUserWithMail = (List<Client>) users.stream().filter(u -> u.getEmail() == mail);
        Client userWithMail = lUserWithMail.get(0);
        return userWithMail;
    }

    public Product findProductByName(String name){
        List <Product> p = products.stream().filter(pr->pr.getName() == name).collect(Collectors.toList());
        Product pr = p.get(0);
        return pr;

    }




    public Client register() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Client client = new Client();
        String mail;
        String pass;
        Scanner registerScan = new Scanner(System.in);
        System.out.println("Ingresa su email");
        mail = registerScan.nextLine();
        if (this.yaExisteUsuarioConEsteMail(mail)){
            System.out.println("Ya existe un usuario registrado con este mail");
            return null;
        } else {
            System.out.println("Ingrese la contrasenia para su cuenta");
            pass = registerScan.nextLine();
            client.newClient(mail, pass);
            System.out.println("Se creo su cuenta con exito");

            this.addClient(client);
            return client;
            //TODO data base
        }
    }

    public Client logIn() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        FarmaStore store = FarmaStore.getInstance();
        Scanner registerScan = new Scanner(System.in);
        System.out.println("Ingresa su email");
        String mail = registerScan.nextLine();
        System.out.println("Ingrese la contrasenia para su cuenta");
        String pass = registerScan.nextLine();
        if(store.userExists(pass)){ //todo buscar en DataBase
            Client client = findUserWithMail(mail);
            if (client.getPassword() == pass) {
                System.out.println("Ingresaste Correctamente");
                return client;
            } else {
                System.out.println("La contrasenia es incorrecta.");
                return null;
            }
        }else{
            System.out.println("El email no pertenece a una cuenta registrada.");
            return null;
        }

    }

    public boolean logInAsAnAdminstrator() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Administrator admin = Administrator.obtenerInstancia();
        Scanner registerScan = new Scanner(System.in);
        System.out.println("Ingresa su email");
        String mail = registerScan.nextLine();
        System.out.println("Ingrese la contrasenia para su cuenta");
        String pass = registerScan.nextLine();
        if (admin.getEmail() == mail && admin.getPassword() == pass){
            System.out.println("Los datos son correctos, puede ingresar al Menu de administrador");
            return true;
        } else {
            System.out.println("Los datos ingresados son incorrectos");
            return false;
        }

    }

    private boolean yaExisteUsuarioConEsteMail(String mail) {
        List<String> lEmails = users.stream().map(u -> u.getEmail()).collect(Collectors.toList());
        return lEmails.contains(mail);
    }





}

