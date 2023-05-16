public class ClientValidator {
    public boolean validareNume(String nume)
    {
       return !nume.isEmpty() && nume.matches("[A-Za-z]+");
    }
    public boolean validarePrenume(String prenume)
    {
        return !prenume.isEmpty() && prenume.matches("[A-Za-z]+");
    }
    public boolean validareTelefon(String tel)
    {
        return tel.length()==10 && tel.matches("[0-9]+");
    }
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
