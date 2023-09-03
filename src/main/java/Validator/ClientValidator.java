package Validator;

import Model.Clients;
public class ClientValidator {
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
     * @param prenume
     * @return true daca prenumele e valid sau false daca prenumele nu e valid
     */
    public boolean validarePrenume(String prenume)
    {
        return !prenume.isEmpty() && prenume.matches("[A-Za-z]+");
    }

    /**
     *
     * @param tel
     * @return true daca numarul de telefon e valid sau false daca numarul de telefon nu e valid
     */
    public boolean validareTelefon(String tel)
    {
        return tel.length()==10 && tel.matches("[0-9]+");
    }

    /**
     *
     * @param c
     * @return "Corect" daca datele introduse sunt corecte sau "Incorect" altfel
     */
    public String validareClient(Clients c)
    {
        if (validareNume(c.getNume())==false)
            return "Incorect";
        if (validarePrenume(c.getPrenume())==false)
            return "Incorect";
        if (validareTelefon(c.getTelefon())==false)
            return "Incorect";
        return "Corect";
    }
}
