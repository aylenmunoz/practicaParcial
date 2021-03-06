package User;

import Conections.ProductDAO;
import Products.Category;
import Products.CategoryName;
import Products.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Administrator extends User{
    private String name;
    private static Administrator instancia;



    public void addProduct() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
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
        ProductDAO.createProduct(newProduct);
        store.addProductToStore(newProduct); //No lo sacamos ya que no desarrollamos la funcion de getProductsFrom DB y elegimos mantener esta lista
        Category.updateCategory(enumCat);
    }

    public void setCategoryOrder(){
        Scanner entradaEscaner = new Scanner (System.in);
        System.out.println ("Introduzca 1 para ordenar las categorias, 0 para salir");
        int comando = entradaEscaner.nextInt();
        while(comando == 1) {

            System.out.println("Introduzca la Categoria Padre de la Lista de Categorias, en mayuscula y con '_' en lugar de espacio");
            String supra = entradaEscaner.nextLine();
            CategoryName supraCat = CategoryName.valueOf(supra);

            System.out.println("Introduzca la Categoria Hijo de la Lista de Categorias, en mayuscula y con '_' en lugar de espacio");
            String sub = entradaEscaner.nextLine();
            CategoryName subCat = CategoryName.valueOf(sub);

            Category.putCategoryInSuperCategory(supraCat, subCat);

            System.out.println ("Introduzca 1 para seguir ordenando las categorias, o 0 para salir");
           comando = entradaEscaner.nextInt();
        }
        System.out.println ("Se Salio del menu de ordenar Categorias");
    }

    public void deleteProduct(){
        Scanner mainscan = new Scanner(System.in);
        System.out.println("Ingresar el nombre del producto a eliminar \n ");
        String prod = mainscan.nextLine();
        ProductDAO.deleteProduct(prod);
        store.deleteProductFromStore(prod);
    }

    public void deleteUser(String mail){
        store.removeClient(mail);
    }

      public void replenishStock(String name){
          Product p = store.findProductByName(name);
          Integer amount = p.amountNeeded();
          p.replenishStock(amount);
    }

    public static Administrator obtenerInstancia() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (instancia == null) {
            instancia = new Administrator();
            store.addClient(instancia);
        }
        return instancia;
    }
}
