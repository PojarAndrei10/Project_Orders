public class Product {
    private int ID;
    private String nume;
    private float pret;
    private int produseInStoc;
    public Product(int ID, String nume, float pret, int produseInStoc) {
        this.ID = ID;
        this.nume = nume;
        this.pret = pret;
        this.produseInStoc = produseInStoc;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
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
