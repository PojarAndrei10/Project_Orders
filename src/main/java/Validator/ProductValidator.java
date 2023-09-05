package Validator;

import Model.Products;

public class ProductValidator {
    /**
     *
     * @param name
     * @return true daca numele e valid sau false daca numele nu e valid
     */
    public boolean nameValidation(String name)
    {
        return !name.isEmpty() && name.matches("[A-Za-z]+");
    }

    /**
     *
     * @param price
     * @return true daca pretul produsului e valid(>0) sau false altfel
     */
    public boolean priceValidation(float price)
    {
        return price>0;
    }

    /**
     *
     * @param productsInStock
     * @return true daca stocul produsului e valid(>0) sau false altfel
     */
    public boolean stockValidation(int productsInStock)
    {
        return productsInStock > 0;
    }
    /**
     *
     * @param product
     * @return "Corect" daca datele introduse sunt corecte sau "Incorect" altfel
     */
    public String productValidation(Products product)
    {
        if (! nameValidation(product.getNume()))
            return "Incorect";
        if (! priceValidation(product.getPret()))
            return "Incorect";
        if (! stockValidation(product.getProduseInStoc()))
            return "Incorect";
        return "Corect";
    }
}
