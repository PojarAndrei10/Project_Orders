package Validator;

import Model.Orders;

public class OrderValidator {
    /**
     *
     * @param c
     * @return true daca cantitatea introdusa e valida(>0) sau false altfel
     */
    public boolean validareCantitate(int c)
    {
        return c > 0;
    }

    /**
     *
     * @param comanda
     * @return "Corect" daca datele introduse sunt corecte sau "Incorect" altfel
     */
    public String validareComenzi(Orders comanda)
    {
        if (validareCantitate(comanda.getCantitate())==false)
            return "Incorect";
        return "Corect";
    }
}
