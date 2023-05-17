package Validator;

import Model.Products;

public class ProductValidator {
    public boolean validareNume(String nume)
    {
        return !nume.isEmpty() && nume.matches("[A-Za-z]+");
    }
    public boolean validarePret(float pret)
    {
        return pret>0;
    }
    public boolean validareStoc(int produsInStoc)
    {
        return produsInStoc > 0;
    }
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
