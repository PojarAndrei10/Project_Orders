package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class OrderInterface extends JFrame{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel id = new JLabel();
    private JLabel clientID = new JLabel();
    private JLabel productID = new JLabel();
    private JLabel quantity = new JLabel();
    private JLabel phoneNumber = new JLabel();
    private TextField idTextField = new TextField();
    private TextField clientIDTextField = new TextField();
    private TextField productIDTextField = new TextField();
    private TextField quantityTextField = new TextField();

    private JButton insertButton = new JButton();
    private JButton deleteButton = new JButton();
    ///private JButton updateButton = new JButton();
    private JButton viewButton = new JButton();
    private JButton backButton = new JButton();
    private JButton exitButton=new JButton();

    public void labelManagement() {
        id.setBounds(40, 110, 200, 30);
        id.setText("Id comanda");
        id.setFont(new Font("Serif", Font.ITALIC, 16));

        clientID.setBounds(40, 150, 200, 30);
        clientID.setText("Id client");
        clientID.setFont(new Font("Serif", Font.ITALIC, 16));

        productID.setBounds(40, 190, 200, 30);
        productID.setText("Id produs");
        productID.setFont(new Font("Serif", Font.ITALIC, 16));

        quantity.setBounds(40, 230, 200, 30);
        quantity.setText("Cantitate dorita");
        quantity.setFont(new Font("Serif", Font.ITALIC, 16));

        panel.add(id);
        panel.add(clientID);
        panel.add(productID);
        panel.add(quantity);
    }
    public void textFieldManagement()
    {

        idTextField.setBounds(250, 110, 250, 30);
        panel.add(idTextField);

        clientIDTextField.setBounds(250, 150, 250, 30);
        panel.add(clientIDTextField);

        productIDTextField.setBounds(250,190,250,30);
        panel.add(productIDTextField);

        quantityTextField.setBounds(250,230,250,30);
        panel.add(quantityTextField);

    }
    public void buttonManagement()
    {
        backButton.setBounds(50, 280, 200, 50);
        backButton.setText("INAPOI");
        backButton.setBackground(new Color(72, 99, 182));
        panel.add(backButton);

        viewButton.setBounds(270, 280, 200, 50);
        viewButton.setText("Vizualizare comenzi");
        viewButton.setBackground(new Color(72, 99, 182));
        panel.add(viewButton);

        insertButton.setBounds(490, 280, 220, 50);
        insertButton.setText("Inserare comanda");
        insertButton.setBackground(new Color(72, 99, 182));
        panel.add(insertButton);

        deleteButton.setBounds(490, 350, 220, 50);
        deleteButton.setText("Stergere comanda");
        deleteButton.setBackground(new Color(72, 99, 182));
        panel.add(deleteButton);

        ///updateButton.setBounds(270, 350 , 200, 50);
       /// updateButton.setText("Update");
       /// updateButton.setBackground(new Color(72, 99, 182));
        ///panel.add(updateButton);

        exitButton.setBounds(1000,700,150,50);
        exitButton.setText("EXIT");
        exitButton.setBackground(new Color(72, 99, 182));
        panel.add(exitButton);
    }
    public OrderInterface() {
        this.setTitle("PAGINA PENTRU COMENZI");
        panel.setBackground(new Color(255, 255, 182));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labelManagement();
        textFieldManagement();
        buttonManagement();

        this.setContentPane(panel);
        this.setVisible(true);
    }

    public int getIdTextField() {
        return Integer.parseInt(idTextField.getText());
    }

    public String getClientIDTextField() {
        return clientIDTextField.getText().toString();
    }
    public String getProductIDTextField() {
        return productIDTextField.getText().toString();
    }
    public String getQuantityTextField() {
        return quantityTextField.getText().toString();
    }
    public void backButtonListener(ActionListener e) {
        backButton.addActionListener(e);
    }
    public void viewButtonListener(ActionListener e) {
        viewButton.addActionListener(e);
    }
    public void insertButtonListener(ActionListener e) {
        insertButton.addActionListener(e);
    }
    public void deleteButtonListener(ActionListener e) {
        deleteButton.addActionListener(e);
    }

    ///consideram ca nu facem modificari la comanda
   /// public void addUpdateListener(ActionListener e) {
       /// updateButton.addActionListener(e);
  ///  }
    public void exitButtonListener(ActionListener e) {exitButton.addActionListener(e);}

}
