package BusinessLogic;

import DataAccess.AbstractDAO;
import Model.Clients;
import Presentation.InterfataClient;
import Validator.ClientValidator;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.NoSuchElementException;
public class ClientBLL {
    private InterfataClient interfataClient;
    private ClientValidator clientValidator;
    private AbstractDAO<Clients> aDAO;
    public ClientBLL(InterfataClient interfataClient) {
        this.interfataClient=interfataClient;
        clientValidator=new ClientValidator();
        aDAO=new AbstractDAO<>(Clients.class);
    }
    public void inserareClient()
    {
        int id = interfataClient.getIdTextField();
        String nume = interfataClient.getNumeTextField();
        String prenume = interfataClient.getPrenumeTextField();
        String telefon = interfataClient.getTelefonTextField();
        Clients c;
        c=new Clients(id,nume,prenume,telefon);
        if (clientValidator.validareClient(c).equals("Corect"))
        {
            aDAO.inserare(c);
        }
        else
            JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                    "inserarea clientului nu s-a facut !");
    }
    public void stergereClient()
    {
        int a;
        a=interfataClient.getIdTextField();
        int cop=a;
        aDAO.stergere(a);
    }
    public void updateClient()
    {
        int id = interfataClient.getIdTextField();
        String nume = interfataClient.getNumeTextField();
        String prenume = interfataClient.getPrenumeTextField();
        String telefon = interfataClient.getTelefonTextField();
        Clients c;
        c=new Clients(id,nume,prenume,telefon);
        if (clientValidator.validareClient(c).equals("Corect"))
        {
            aDAO.update(c);
        }
        else
            JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                    "update-ul clientului nu s-a facut !");
    }
    public void vizualizareClienti()
    {
        JScrollPane vizualizareClientiInterfata;
        vizualizareClientiInterfata=new JScrollPane();
        JTable table=new JTable();
        ArrayList<Clients> clienti;
        clienti=aDAO.findAll();
        System.out.println(clienti);
        System.out.println(" ");
        vizualizareClientiInterfata.setBounds(800,50,300,300);
        vizualizareClientiInterfata.setBackground(new Color(210,191,191));
        vizualizareClientiInterfata.setToolTipText("Tabel clienti");
        table=aDAO.createTable(clienti);
        table.setEnabled(true);
        table.setVisible(true);
        vizualizareClientiInterfata.setViewportView(table);
        interfataClient.getContentPane().add(vizualizareClientiInterfata);
    }

    /**
     * JE E POJI
     * @param id
     * @return clientul cu id-ul respectiv
     */
    public Clients findClientById(int id) {
        Clients c;
        c = aDAO.findById(id);
        if (c == null)
        {
            throw new NoSuchElementException("The client with id =" +
                    id + " was not found!");
        }
        return c;
    }
}
