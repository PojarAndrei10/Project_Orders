import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class OrderBLL {
    private InterfataOrder interfataOrder;
    private OrderValidator orderValidator;
    private AbstractDAO<Orders> aDAO;
    private AbstractDAO<Products> productADAO;
    public OrderBLL(InterfataOrder interfataOrder) {

        this.interfataOrder=interfataOrder;
        orderValidator=new OrderValidator();
        aDAO=new AbstractDAO<>(Orders.class);
        productADAO=new AbstractDAO<>(Products.class);

    }
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
            }
            else
                JOptionPane.showMessageDialog(null,"Nu sunt destule " +
                        "produse in stoc !");
        }
        else   JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                "inserarea comenzii nu s-a facut !");
    }
    public void stergereComanda()
    {
        int a;
        a=interfataOrder.getIdTextField();
        int cop=a;
        aDAO.stergere(a);
    }
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

}
