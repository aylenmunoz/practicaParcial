package Sale;

public class Cash implements MethodStrategy {

    public void charge(Integer price, Order order) {
        System.out.println("Elegiste pagar en efectivo \n");
        System.out.println("Debe pagarle a la moto en el momento de la entrega $" + price);
        order.showOrder();
    }
}
