package Validator;

import Model.Orders;

public class OrderValidator {
    public boolean validareCantitate(int c)
    {
        return c > 0;
    }
    public String validareComenzi(Orders comanda)
    {
        if (validareCantitate(comanda.getCantitate())==false)
            return "Incorect";
        return "Corect";
    }
}
