package BusinessLogic;

import DataAccess.AbstractDAO;
import Model.Clients;
import Model.Orders;
import Model.Products;
import Presentation.InterfataClient;
import Presentation.InterfataOrder;
import Validator.OrderValidator;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderBLL {
    private InterfataOrder interfataOrder;
    private OrderValidator orderValidator;
    private AbstractDAO<Orders> aDAO;
    private AbstractDAO<Products> productADAO;

    /**
     *
     * @param interfataOrder
     */
    public OrderBLL(InterfataOrder interfataOrder) {

        this.interfataOrder=interfataOrder;
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
    public void inserareComanda()
    {
        int a;
        Products products;
        int id = interfataOrder.getIdTextField();
        int clientID = Integer.parseInt(interfataOrder.getClientIDTextField());
        int productID = Integer.parseInt(interfataOrder.getProductIDTextField());
        int cantitate = Integer.parseInt(interfataOrder.getCantitateTextField());
        Orders o=new Orders(id,clientID,productID,cantitate);
        if(orderValidator.validareComenzi(o).equals("Corect"))
        {
            a=Integer.parseInt(interfataOrder.getProductIDTextField());
            products=productADAO.findById(a);
            if (products.getProduseInStoc()>= Integer.parseInt(interfataOrder.getCantitateTextField()) )
            {
               products.setProduseInStoc(products.getProduseInStoc()-o.getCantitate());
               productADAO.update(products);
               aDAO.inserare(o);
               //Creare chitantei
               creareBill(o,products);
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
    public void stergereComanda()
    {
        int a;
        a=interfataOrder.getIdTextField();
        int cop=a;
        aDAO.stergere(a);
    }

    /**
     * Vizualizarea tuturor comenzilor in tabelul din interfata
     */
    public void vizualizareComenzi()
    {
        JScrollPane vizualizareComenziInterfata;
        vizualizareComenziInterfata=new JScrollPane();
        JTable table=new JTable();
        ArrayList<Orders> comenzi;
        comenzi=aDAO.findAll();
        System.out.println(comenzi);
        System.out.println(" ");
        vizualizareComenziInterfata.setBounds(800,50,300,300);
        vizualizareComenziInterfata.setBackground(new Color(210,191,191));
        vizualizareComenziInterfata.setToolTipText("Tabel comenzi");
        table=aDAO.createTable(comenzi);
        table.setEnabled(true);
        table.setVisible(true);
        vizualizareComenziInterfata.setViewportView(table);
        interfataOrder.getContentPane().add(vizualizareComenziInterfata);
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
    public void creareBill(Orders order, Products product)
    {
        try{
            FileWriter fileWriter = new FileWriter("Chitanta.txt", true);
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
