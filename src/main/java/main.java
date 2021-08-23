import FarmaStore.FarmaStore;
import Products.Product;
import User.User;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class main {
    static FarmaStore store = FarmaStore.getInstance();

    public void main(String[] args) throws ParseException {
            Integer operacion = -1;
            while(operacion !=0){
                Scanner mainscan = new Scanner(System.in);
                System.out.println("Ingresa un numero segun la operacion que desea realizar \n " +
                        "0. Terminar \n " +
                        "1.Registrarse\n " +
                        "2.Iniciar Sesion\n" +
                        "3.Mirar nuestros productos\n ");
                operacion = mainscan.nextInt();
                switch (operacion){
                    case 0:{
                        System.out.println("Termino con exito");
                    }
                    break;
                    case 1:{
                        this.register();
                    }
                    break;
                    case 2:{
                        this.logIn();
                    }
                    break;
                    case 3: {
                        List<Product> allProducts = store.getProducts();
                        for (int i = 0; i < allProducts.size(); i++) {
                            System.out.println(allProducts.get(i).getName());
                        }
                    }
                    break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + operacion);
                    }
                }
            }
            public void register() {
                User user = new User();
                String mail;
                String pass;
                Scanner registerScan = new Scanner(System.in);
                System.out.println("Ingresa su email");
                mail = registerScan.nextLine();
                System.out.println("Ingrese la contrasenia para su cuenta");
                pass = registerScan.nextLine();
                user.newUser(mail, pass);
                System.out.println("Se creo su cuenta con exito");
            }
            public void logIn(){

            }
    }

