package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainInterface extends JFrame{
    private JFrame frame=new JFrame();
    private JPanel panel=new JPanel();
    JLabel title=new JLabel();
    private JButton client=new JButton();
    private JButton product=new JButton();
    private JButton order=new JButton();
    private JButton exit=new JButton();
    public void labelManagement()
    {
        title.setBounds(550, 110, 200, 30);
        title.setText("PAGINA PRINCIPALA");
        title.setFont(new Font("Serif", Font.ITALIC, 16));
        panel.add(title);
    }
    public MainInterface()
    {
        this.setTitle("WAREHOUSE");
        panel.setBackground(new Color(255, 255, 182));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labelManagement();

        client.setText("Client");
        client.setBounds(100,50,100,50);
        product.setText("Produse");
        product.setBounds(100,150,100,50);
        order.setText("Comenzi");
        order.setBounds(100,250,100,50);
        exit.setText("Exit");
        exit.setBounds(100,350,100,50);
        exit.addActionListener(e ->  {

            System.exit(0);
        });

        panel.add(client);
        panel.add(product);
        panel.add(order);
        panel.add(exit);
    }
    public void clientsPageListener(ActionListener e) {
        client.addActionListener(e);
    }
    public void ordersPageListener(ActionListener e) {
        order.addActionListener(e);
    }
    public void productsPageListener(ActionListener e) {
        product.addActionListener(e);
    }
}
