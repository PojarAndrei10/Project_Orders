package Model;

public class Products {
    private int Id;
    private String nume;
    private float pret;
    private int produseInStoc;

    public Products(int Id, String nume, float pret, int produseInStoc) {
        this.Id = Id;
        this.nume = nume;
        this.pret = pret;
        this.produseInStoc = produseInStoc;
    }
    //pentru constructorul din createobjects din abstractdao
    public Products()
    {

    }
    public int getId() {

        return Id;
    }
    public void setId(int ID) {

        this.Id = ID;
    }
    public String getNume() {

        return nume;
    }
    public void setNume(String nume) {

        this.nume = nume;
    }
    public float getPret() {

        return pret;
    }
    public void setPret(float pret) {

        this.pret = pret;
    }
    public int getProduseInStoc() {

        return produseInStoc;
    }
    public void setProduseInStoc(int produseInStoc) {
        this.produseInStoc = produseInStoc;
    }
}
