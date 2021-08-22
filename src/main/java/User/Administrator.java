package User;

import Products.Category;
import Products.CategoryName;
import Products.Product;
import FarmaStore.FarmaStore;

import java.util.Scanner;

public class Administrator extends User{
    private String name;
    private static Administrator instancia;
    FarmaStore store = FarmaStore.getInstance();


    public void addProduct(){
        Product newProduct = new Product();

        Scanner entradaEscaner = new Scanner (System.in);

        String nameP;
        Integer amountInStock;
        Integer price;
        String details;
        Integer minimumNeeded;
        String catName;

        System.out.println ("Por favor introduzca el nombre del producto");
        nameP = entradaEscaner.nextLine();
        System.out.println ("Por favor introduzca la  cantidad en stock del producto");
        amountInStock = entradaEscaner.nextInt();
        System.out.println ("Por favor introduzca el precio del producto");
        price = entradaEscaner.nextInt();
        System.out.println ("Por favor introduzca los detalles del producto");
        details = entradaEscaner.nextLine();
        System.out.println ("Por favor introduzca la cantidad minima necesaria del producto");
        minimumNeeded = entradaEscaner.nextInt();
        System.out.println ("Por favor introduzca la categoria  del producto");
        catName = entradaEscaner.nextLine();
        CategoryName enumCat = CategoryName.valueOf(catName);

        newProduct.createProduct(nameP, amountInStock, price,details,minimumNeeded, enumCat);
        store.addProduct(newProduct);
    }

    public void deleteProduct(Product product){
        //TODO
    }

    public void addToCategory(){
        //TODO
    }

    public void removeFromCategory(){
       //TODO
    }
    public void deleteUser(User user){
        //TODO eliminar de DataBase
    }

    public void createPromotion(){
        //TODO
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
