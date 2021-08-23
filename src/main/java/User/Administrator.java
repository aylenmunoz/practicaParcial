package User;

import Products.Category;
import Products.CategoryName;
import Products.Product;
import FarmaStore.FarmaStore;

import java.util.Scanner;

public class Administrator extends User{
    private String name;
    private static Administrator instancia;



    public void addProduct(){
        Product newProduct = new Product();

        Scanner entradaEscaner = new Scanner (System.in);

        System.out.println ("Por favor introduzca el nombre del producto");
        String nameP = entradaEscaner.nextLine();
        System.out.println ("Por favor introduzca la  cantidad en stock del producto");
        Integer amountInStock = entradaEscaner.nextInt();
        System.out.println ("Por favor introduzca el precio del producto");
        Integer price = entradaEscaner.nextInt();
        System.out.println ("Por favor introduzca los detalles del producto");
        String details = entradaEscaner.nextLine();
        System.out.println ("Por favor introduzca la cantidad minima necesaria del producto");
        Integer minimumNeeded = entradaEscaner.nextInt();
        System.out.println ("Por favor introduzca la categoria  del producto");
        String catName = entradaEscaner.nextLine();
        CategoryName enumCat = CategoryName.valueOf(catName);

        newProduct.createProduct(nameP, amountInStock, price,details,minimumNeeded, enumCat);
        store.addProductToStore(newProduct);
        Category.updateCategory(enumCat);
    }
    //TODO esto se llama del main!!

    public void setCategoryOrder(){
        Scanner entradaEscaner = new Scanner (System.in);
        System.out.println ("Introduzca 1 para ordenar las categorias, 0 para salir");
        Integer comando = entradaEscaner.nextInt();
        while(comando == 1) {

            System.out.println("Introduzca la Categoria Padre de la Lista de Categorias, en mayuscula y con '_' en lugar de espacio");
            String supra = entradaEscaner.nextLine();
            CategoryName supraCat = CategoryName.valueOf(supra);

            System.out.println("Introduzca la Categoria Hijo de la Lista de Categorias, en mayuscula y con '_' en lugar de espacio");
            String sub = entradaEscaner.nextLine();
            CategoryName subCat = CategoryName.valueOf(sub);

            Category.putCategoryInSuperCategory(supraCat, subCat);

            this.setCategoryOrder(); //es recursiva
        }
        System.out.println ("Se Salio del menu de ordenar Categorias");
    }

    public void deleteProduct(Product product){
        store.deleteProductFromStore(product);
    }

    public void deleteUser(User user){
        store.removeClient(user);
        //TODO eliminar de DataBase
    }

      public void replenishStock(Product product){
        Integer amount = product.amountNeeded();
        product.replenishStock(amount);
    }

    public static Administrator obtenerInstancia(){
        if (instancia == null) {
            instancia = new Administrator();
            store.addClient(instancia);
        }
        return instancia;
    }
}
