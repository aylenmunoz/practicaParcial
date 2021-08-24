package Sale;

import User.User;

import java.io.IOException;

public class DebitCard implements MethodStrategy{

    public void charge (Orden orden, User client) throws IOException {
        System.out.println("Elegiste pagar con tarjeta de Debito \n");
        orden.showOrder();
        System.out.println("Los detalles de la orden se le van a enviar al mail de su cuenta\n");
        orden.sendEmail(client);
    }
}
