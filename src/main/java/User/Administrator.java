package User;

import Products.Product;
import FarmaStore.FarmaStore;

public class Administrator extends User{
    private String name;
    private static Administrator instancia;
    FarmaStore store = FarmaStore.getInstance();


    public void addProduct(){
        Product newProduct = new Product();
        //todo recibir por pantalla todos los atributos del producto
        //newProduct.createProduct(String nameP, Integer amountInStock, Integer price, String details, Integer minimumNeeded, CategoryName catName);
        store.addProduct(newProduct);
    }

    public void deleteProduct(Product product){

    }

    public void addToCategory(){

    }

    public void removeFromCategory(){

    }
    public void deleteUser(User user){
        //TODO eliminar de DataBase
    }
    public void replenishStock(Product product, Integer amount){
        product.replenishStock(amount);
    }

    public static Administrator obtenerInstancia(){
        if (instancia == null) {
            instancia = new Administrator();
        }
        return instancia;
    }
}
