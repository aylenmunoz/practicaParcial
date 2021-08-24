package User;

import Products.Product;
import Sale.Cart;
import Sale.MethodStrategy;
import Sale.Orden;
import Sale.PaymentMethod;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Client extends User {

    private String name;
    private String surname;
    private List<Orden> previousPurchases;
    private Cart cart;
    private String billingAddress;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;

    public void buy() throws IOException {
        if(cart.getProductsInCart().size() == 0){
            System.out.println("No puede iniciar la compra de un carrito vacio");
        }else{
            cart.charge(this.paymentMethod, this);
        }
    }

    public void newClient(String mail, String pass){
        this.setEmail(mail);
        this.setPassword(pass);
    }

    public void addToCart(Product product){
        cart.addToCart(product);

    }

    public void addOrder(Orden orden){
        previousPurchases.add(orden);
    }
    public void removeFromCart(Product product){
        cart.removeFromCart(product);
    }

    public void deleteAccount(){
        store.removeClient(this.getEmail());
    }

    public void setPaymentMethod(MethodStrategy paymentMethod) {
        Scanner entradaEscaner = new Scanner (System.in);
        PaymentMethod p1 = PaymentMethod.CREDIT_CARD;
        PaymentMethod p2 = PaymentMethod.DEBIT_CARD;
        PaymentMethod p3 = PaymentMethod.CASH;

        System.out.println("Metodos de Pago:\n"+ p1 + "\n" + p2 + "\n" + p3 + "\n");
        System.out.println("Introuduza su metodo de pago, en mayusculas con '_' en lugar de espacios");
        String method = entradaEscaner.nextLine();
        PaymentMethod enumMethod = PaymentMethod.valueOf(method);

        this.paymentMethod = enumMethod;
    }
}
