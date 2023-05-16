public class Orders {
    private int id;
    private int clientId;
    private int productId;
    private int cantitate;

    public Orders(int Id, int clientID, int productID, int cantitate) {
        this.id = Id;
        this.clientId = clientID;
        this.productId = productID;
        this.cantitate = cantitate;
    }
    //pentru constructorul din createobjects din abstractdao
    public Orders()
    {

    }
    public int getId() {
        return id;
    }
    public void setId(int ID) {

        this.id = ID;
    }
    public int getClientId() {

        return clientId;
    }
    public void setClientId(int clientID) {

        this.clientId = clientID;
    }
    public int getProductId() {

        return productId;
    }
    public void setProductId(int productID) {

        this.productId = productID;
    }
    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
