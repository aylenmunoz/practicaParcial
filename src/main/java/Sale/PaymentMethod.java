package Sale;

import java.awt.*;

public enum PaymentMethod {
    CREDIT_CARD,
    DEBIT_CARD,
    CASH;

    public MethodStrategy selectMethod(PaymentMethod method) {
        MethodStrategy strategy = null;
        switch (method) {
            case CREDIT_CARD:
                strategy = new CreditCard();
                break;
            case DEBIT_CARD:
                strategy = new DebitCard();
                break;
            case CASH:
                strategy = new Cash();
                break;
        }
        return strategy;
    }

}
