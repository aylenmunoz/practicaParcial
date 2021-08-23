package Sale;

public class Cash implements MethodStrategy{

    public void charge (Integer price, Order order){
        System.out.println("Elegiste pagar en efectivo \n");
        System.out.println("Debe pagarle a la moto en el momento de la entrega $" + price);
        System.out.println("Su numero de orden es: #" + order.getOrderNumber() + " y su tiempo estimado de delivery es " + order.getEstimatedDelivery() + "\n" );
    }
}
