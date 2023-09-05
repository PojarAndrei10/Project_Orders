package Validator;

import Model.Clients;
public class ClientValidator {
    /**
     *
     * @param lastName
     * @return true daca numele e valid sau false daca numele nu e valid
     */
    public boolean lastNameValidation(String lastName)
    {
       return !lastName.isEmpty() && lastName.matches("[A-Za-z]+");
    }

    /**
     *
     * @param firstName
     * @return true daca prenumele e valid sau false daca prenumele nu e valid
     */
    public boolean firstNameValidation(String firstName)
    {
        return !firstName.isEmpty() && firstName.matches("[A-Za-z]+");
    }

    /**
     *
     * @param phone
     * @return true daca numarul de telefon e valid sau false daca numarul de telefon nu e valid
     */
    public boolean phoneValidation(String phone)
    {
        return phone.length()==10 && phone.matches("[0-9]+");
    }

    /**
     *
     * @param c
     * @return "Corect" daca datele introduse sunt corecte sau "Incorect" altfel
     */
    public String clientValidation(Clients c)
    {
        if (lastNameValidation(c.getNume())==false)
            return "Incorect";
        if (firstNameValidation(c.getPrenume())==false)
            return "Incorect";
        if (phoneValidation(c.getTelefon())==false)
            return "Incorect";
        return "Corect";
    }
}
