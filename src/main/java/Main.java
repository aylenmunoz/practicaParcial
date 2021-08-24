import FarmaStore.FarmaStore;
import Products.Product;
import User.Client;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        FarmaStore store = FarmaStore.getInstance();
        List<Product> allProducts = store.getProducts();
        Client client = null;
            Scanner scanLog = new Scanner(System.in);
            Integer op = null;
            System.out.println("Ingresa un numero segun la operacion que desea realizar \n " +
                "0. Terminar \n " +
                "1.Registrarse\n " +
                "2.Iniciar Sesion\n");
                op= scanLog.nextInt();
            switch(op){
                case 0:
                    System.out.println("Termino con exito");
                    break;
                case 1:
                    client = store.register();
                    
                    break;
                case 2:
                    client = store.logIn();
                    break;
            }
            if(op != 0) {
                int operacion = -1;
                while (operacion != 0) {
                    Scanner mainscan = new Scanner(System.in);
                    System.out.println("Ingresa un numero segun la operacion que desea realizar \n " +
                            "0. Terminar \n " +
                            "1.Mirar nuestros productos\n " +
                            "2.Agregar producto al carrito");
                    operacion = mainscan.nextInt();
                    switch (operacion) {
                        case 0:
                            System.out.println("Termino con exito");
                            break;
                        case 1:
                            for (Product allProduct : allProducts) {
                                System.out.println(allProduct.getName());
                            }
                            break;
                        case 2:
                            Scanner compraScan = new Scanner(System.in);
                            System.out.println("Cuantos productos desea comprar?");
                            int cant = compraScan.nextInt();
                            for (int i = 0; i < cant; i++) {
                                System.out.println("Ingresar el nombre del producto");
                                String nombre = compraScan.nextLine();
                                List<Product> lProd = (List<Product>) allProducts.stream().filter(p -> p.getName() == nombre);
                                Product prod = lProd.get(0);
                                assert client != null;
                                client.addToCart(prod);
                            }
                            System.out.println("Se agregaron los productos al carrito, si desea comprar ingrese 1, sino 2");
                            int desicion = compraScan.nextInt();
                            if (desicion == 1) {
                                assert client != null;
                                client.buy();
                            } else {
                                System.out.println("Se guardo el carrito para mas tarde");
                            }
                        default:
                            throw new IllegalStateException("Unexpected value: " + operacion);
                    }
                }
            }else{
                System.out.println("Se salio del sistema");
            }
            }

    }

