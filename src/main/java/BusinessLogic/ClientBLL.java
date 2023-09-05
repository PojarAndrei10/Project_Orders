package BusinessLogic;

import DataAccess.AbstractDAO;
import Model.Clients;
import Presentation.ClientInterface;
import Validator.ClientValidator;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.NoSuchElementException;
public class ClientBLL {
    private ClientInterface clientInterface;
    private ClientValidator clientValidator;
    private AbstractDAO<Clients> aDAO;
    /**
     *
     * @param clientInterface
     */
    public ClientBLL(ClientInterface clientInterface) {
        this.clientInterface=clientInterface;
        clientValidator=new ClientValidator();
        aDAO=new AbstractDAO<>(Clients.class);
    }
    /**
     * Inserarea unui nou client daca sunt valide datele introduse sau atentionarea printr-un mesaj ca datele
     * sunt invalide si inserarea nu poate avea loc
     */
    public void insertClient()
    {
        int id = clientInterface.getIdTextField();
        String lastName = clientInterface.getLastNameTextField();
        String firstName = clientInterface.getFirstNameTextField();
        String phone = clientInterface.getPhoneTextField();
        Clients clients;
        clients=new Clients(id,lastName,firstName,phone);
        if (clientValidator.clientValidation(clients).equals("Corect"))
        {
            aDAO.insert(clients);
        }
        else
            JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                    "inserarea clientului nu s-a facut !");
    }
    /**
     * Stergerea unui client
     */
    public void deleteClient()
    {
        int a;
        a=clientInterface.getIdTextField();
        int cop=a;
        aDAO.delete(a);
    }
    /**
     * Update-ul unui nou client daca sunt valide datele modificate sau atentionarea printr-un mesaj ca datele modificate
     *       sunt invalide si update-ul nu poate avea loc
     */
    public void updateClient()
    {
        int id = clientInterface.getIdTextField();
        String lastName = clientInterface.getLastNameTextField();
        String firstName = clientInterface.getFirstNameTextField();
        String phone = clientInterface.getPhoneTextField();
        Clients clients;
        clients=new Clients(id,lastName,firstName,phone);
        if (clientValidator.clientValidation(clients).equals("Corect"))
        {
            aDAO.update(clients);
        }
        else
            JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                    "update-ul clientului nu s-a facut !");
    }
    /**
     * Vizualizarea tuturor clientilor in tabelul din interfata
     */
    public void clientView()
    {
        JScrollPane viewClientsInTheInterface;
        viewClientsInTheInterface=new JScrollPane();
        JTable table=new JTable();
        ArrayList<Clients> clients;
        clients=aDAO.findAll();
        System.out.println(clients);
        System.out.println(" ");
        viewClientsInTheInterface.setBounds(800,50,300,300);
        viewClientsInTheInterface.setBackground(new Color(210,191,191));
        viewClientsInTheInterface.setToolTipText("Tabel clienti");
        table=aDAO.createTable(clients);
        table.setEnabled(true);
        table.setVisible(true);
        viewClientsInTheInterface.setViewportView(table);
        clientInterface.getContentPane().add(viewClientsInTheInterface);
    }
    /**
     *
     * @param id
     * @return clientul cu id-ul id
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
