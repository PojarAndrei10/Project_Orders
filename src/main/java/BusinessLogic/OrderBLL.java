package BusinessLogic;

import DataAccess.AbstractDAO;
import Model.Orders;
import Model.Products;
import Presentation.OrderInterface;
import Validator.OrderValidator;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderBLL {
    private OrderInterface orderInterface;
    private OrderValidator orderValidator;
    private AbstractDAO<Orders> aDAO;
    private AbstractDAO<Products> productADAO;
    /**
     *
     * @param orderInterface
     */
    public OrderBLL(OrderInterface orderInterface) {
        this.orderInterface=orderInterface;
        orderValidator=new OrderValidator();
        aDAO=new AbstractDAO<>(Orders.class);
        productADAO=new AbstractDAO<>(Products.class);
    }
    /**
     * Inserarea unei noi comenzi daca sunt valide datele introduse sau atentionarea printr-un mesaj ca datele
     *      sunt invalide si inserarea nu poate avea loc. Daca datele introduse sunt corecte,dar comandam un
     *      numar de produse mai mare decat produsele disponibile in stoc se va afisa un mesaj care sa ne
     *      atentioneze ca nu sunt destule produse in stoc
     */
    public void insertOrder()
    {
        int a;
        Products products;
        int id = orderInterface.getIdTextField();
        int clientID = Integer.parseInt(orderInterface.getClientIDTextField());
        int productID = Integer.parseInt(orderInterface.getProductIDTextField());
        int quantity = Integer.parseInt(orderInterface.getQuantityTextField());
        Orders o=new Orders(id,clientID,productID,quantity);
        if(orderValidator.orderValidation(o).equals("Corect"))
        {
            a=Integer.parseInt(orderInterface.getProductIDTextField());
            products=productADAO.findById(a);
            if (products.getProduseInStoc()>= Integer.parseInt(orderInterface.getQuantityTextField()) )
            {
               products.setProduseInStoc(products.getProduseInStoc()-o.getCantitate());
               productADAO.update(products);
               aDAO.insert(o);
               createBill(o,products);
            }
            else
                JOptionPane.showMessageDialog(null,"Nu sunt destule " +
                        "produse in stoc !");
        }
        else   JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                "inserarea comenzii nu s-a facut !");
    }
    /**
     * Stergerea unei comenzi
     */
    public void deleteOrder()
    {
        int a;
        a=orderInterface.getIdTextField();
        int cop=a;
        aDAO.delete(a);
    }
    /**
     * Vizualizarea tuturor comenzilor in tabelul din interfata
     */
    public void orderView()
    {
        JScrollPane viewOrderInTheInterface;
        viewOrderInTheInterface=new JScrollPane();
        JTable table=new JTable();
        ArrayList<Orders> comenzi;
        comenzi=aDAO.findAll();
        System.out.println(comenzi);
        System.out.println(" ");
        viewOrderInTheInterface.setBounds(800,50,300,300);
        viewOrderInTheInterface.setBackground(new Color(210,191,191));
        viewOrderInTheInterface.setToolTipText("Tabel comenzi");
        table=aDAO.createTable(comenzi);
        table.setEnabled(true);
        table.setVisible(true);
        viewOrderInTheInterface.setViewportView(table);
        orderInterface.getContentPane().add(viewOrderInTheInterface);
    }
    /**
     *
     * @param id
     * @return comanda cu id-ul id
     */
    public Orders findOrderById(int id) {
        Orders c;
        c = aDAO.findById(id);
        if (c == null)
        {
            throw new NoSuchElementException("The product with id =" +
                    id + " was not found!");
        }
        return c;
    }
    /**
     *
     * @param order
     * @param product
     * Creaza chitanta in care va aparea id-ul comenzii,numele produsului,cantitatea comandata si pretul care trebuie
     * sa il plateasca clientul
     */
    public void createBill(Orders order, Products product)
    {
        try{
            FileWriter fileWriter = new FileWriter("Bill.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("Id-ul comenzii:"+order.getId());
            bufferedWriter.newLine();
            bufferedWriter.write("Produsul comandat:"+product.getNume());
            bufferedWriter.newLine();
            bufferedWriter.write("Pretul unei bucati:"+product.getPret());
            bufferedWriter.newLine();
            bufferedWriter.write("Cantitatea comandata :"+order.getCantitate());
            bufferedWriter.newLine();
            bufferedWriter.write("Pretul total:"+order.getCantitate()*product.getPret());
            bufferedWriter.newLine();
            bufferedWriter.write("---------------------------------------------------");
            bufferedWriter.newLine();

            bufferedWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
