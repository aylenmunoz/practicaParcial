package Sale;

public class DebitCard implements MethodStrategy{

    public void charge (Integer price, Order order){
        System.out.println("Elegiste pagar en efectivo \n");
        order.showOrder();
    }
}
