package Model;

public class Clients {
    private int clientId;
    private String nume;
    private String prenume;
    private String telefon;

    public Clients(int clientId, String nume, String prenume, String numarTelefon)
    {
        this.clientId=clientId;
        this.nume=nume;
        this.prenume=prenume;
        this.telefon=numarTelefon;
    }
    //pentru constructorul din createobjects din abstractdao
    public Clients()
    {

    }
    public int getClientId() {

        return clientId;
    }
    public void setClientId(int clientID) {

        this.clientId = clientID;
    }
    public String getNume() {

        return nume;
    }
    public void setNume(String nume) {

        this.nume = nume;
    }

    public String getPrenume() {

        return prenume;
    }
    public void setPrenume(String prenume) {

        this.prenume = prenume;
    }
    public String getTelefon() {

        return telefon;
    }
    public void setTelefon(String numarTelefon) {

        this.telefon = numarTelefon;
    }
    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientId +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", numarTelefon='" + telefon + '\'' +
                '}';
    }
}
