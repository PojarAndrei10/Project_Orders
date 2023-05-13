import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InterfataPrincipala extends JFrame{
    private JFrame frame=new JFrame();
    private JPanel panel=new JPanel();
    private JButton client=new JButton();
    private JButton product=new JButton();
    private JButton order=new JButton();
    public InterfataPrincipala()
    {
        panel.setBackground(new Color(255, 255, 182));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        client.setText("Client");
        client.setBounds(100,50,100,50);
        product.setText("Product");
        product.setBounds(100,150,100,50);
        order.setText("Order");
        order.setBounds(100,250,100,50);

        panel.add(client);
        panel.add(product);
        panel.add(order);
    }
    public void addClientListener(ActionListener e) {
        client.addActionListener(e);
    }
    public void addOrderListener(ActionListener e) {
        order.addActionListener(e);
    }
    public void addProductListener(ActionListener e) {
        product.addActionListener(e);
    }
}
