package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InterfataPrincipala extends JFrame{
    private JFrame frame=new JFrame();
    private JPanel panel=new JPanel();
    JLabel titlu=new JLabel();
    private JButton client=new JButton();
    private JButton product=new JButton();
    private JButton order=new JButton();
    private JButton exit=new JButton();
    public void gestionareLabel()
    {
        titlu.setBounds(550, 110, 200, 30);
        titlu.setText("PAGINA PRINCIPALA");
        titlu.setFont(new Font("Serif", Font.ITALIC, 16));
        panel.add(titlu);
    }
    public InterfataPrincipala()
    {
        this.setTitle("WAREHOUSE");
        panel.setBackground(new Color(255, 255, 182));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        gestionareLabel();

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
    public void paginaClientListener(ActionListener e) {
        client.addActionListener(e);
    }
    public void paginaOrderListener(ActionListener e) {
        order.addActionListener(e);
    }
    public void paginaProductListener(ActionListener e) {
        product.addActionListener(e);
    }
}
