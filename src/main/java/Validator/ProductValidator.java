package Validator;

import Model.Products;

public class ProductValidator {
    /**
     *
     * @param nume
     * @return true daca numele e valid sau false daca numele nu e valid
     */
    public boolean validareNume(String nume)
    {
        return !nume.isEmpty() && nume.matches("[A-Za-z]+");
    }

    /**
     *
     * @param pret
     * @return true daca pretul produsului e valid(>0) sau false altfel
     */
    public boolean validarePret(float pret)
    {
        return pret>0;
    }

    /**
     *
     * @param produsInStoc
     * @return true daca stocul produsului e valid(>0) sau false altfel
     */
    public boolean validareStoc(int produsInStoc)
    {
        return produsInStoc > 0;
    }

    /**
     *
     * @param product
     * @return "Corect" daca datele introduse sunt corecte sau "Incorect" altfel
     */
    public String validareProduse(Products product)
    {
        if (! validareNume(product.getNume()))
            return "Incorect";
        if (! validarePret(product.getPret()))
            return "Incorect";
        if (! validareStoc(product.getProduseInStoc()))
            return "Incorect";
        return "Corect";
    }
}
