
public class Client {
    private int clientID;
    private String nume;
    private String prenume;
    private String numarTelefon;
    public Client(int ID,String nume,String prenume,String numarTelefon)
    {
        this.clientID=ID;
        this.nume=nume;
        this.prenume=prenume;
        this.numarTelefon=numarTelefon;
    }
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
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
    public String getNumarTelefon() {
        return numarTelefon;
    }
    public void setNumarTelefon(String numarTelefon) {
        this.numarTelefon = numarTelefon;
    }
    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", numarTelefon='" + numarTelefon + '\'' +
                '}';
    }
}
