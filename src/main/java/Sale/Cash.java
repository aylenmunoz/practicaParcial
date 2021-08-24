package Sale;

import User.User;

import java.io.IOException;

public class Cash implements MethodStrategy {

    public void charge(Orden orden, User client) throws IOException {
        System.out.println("Elegiste pagar en efectivo \n");
        orden.showOrder();
        System.out.println("Los detalles de la orden se le van a enviar al mail de su cuenta\n");
        orden.sendEmail(client);
        System.out.println("Debe pagarle a la moto en el momento de la entrega $" + orden.getTotalPrice());
    }
}
