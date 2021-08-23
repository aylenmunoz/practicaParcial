package Sale;

public class CreditCard implements MethodStrategy{

    public void charge (Integer price, Order order){
        System.out.println("Elegiste pagar con tarjeta de crédito\n");
        order.showOrder();


    }
}
