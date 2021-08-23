package Sale;

public class CreditCard implements MethodStrategy{

    public void charge (Integer price, Order order){

        System.out.println("Su numero de orden es: #" + order.getOrderNumber() + " y su tiempo estimado de delivery es " + order.getEstimatedDelivery() + "\n" );

    }
}
