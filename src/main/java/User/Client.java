package User;

import Products.Product;
import Sale.Cart;
import Sale.MethodStrategy;
import Sale.Order;
import Sale.PaymentMethod;

import java.util.List;
import java.util.Scanner;

public class Client extends User {

    private String name;
    private String surname;
    private List<Order> previousPurchases;
    private Cart cart;
    private String billingAddress;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;

    public void buy(){
        if(cart.getProductsInCart().size() == 0){
            System.out.println("No puede iniciar la compra de un carrito vacio");
        }else{
            cart.charge(this.paymentMethod);
        }
    }

    public void addToCart(Product product){
        cart.addToCart(product);

    }

    public void addOrder(Order order){
        previousPurchases.add(order);
    }
    public void removeFromCart(Product product){
        cart.removeFromCart(product);
    }

    public void deleteAccount(){

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
