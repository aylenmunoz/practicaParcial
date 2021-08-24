package Sale;

import User.User;

import java.io.IOException;

public interface MethodStrategy {

    public void charge(Orden orden, User client) throws IOException;

}
