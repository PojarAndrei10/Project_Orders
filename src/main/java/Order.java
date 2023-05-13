public class Order {
    private int ID;
    private int clientID;
    private int productID;
    private int cantitate;

    public Order(int ID, int clientID, int productID, int cantitate) {
        this.ID = ID;
        this.clientID = clientID;
        this.productID = productID;
        this.cantitate = cantitate;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getClientID() {
        return clientID;
    }
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }
    public int getProductID() {
        return productID;
    }
    public void setProductID(int productID) {
        this.productID = productID;
    }
    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
