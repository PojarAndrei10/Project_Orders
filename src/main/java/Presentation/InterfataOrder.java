package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InterfataOrder extends JFrame{
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel id = new JLabel();
    private JLabel clientID = new JLabel();
    private JLabel productID = new JLabel();
    private JLabel cantitate = new JLabel();
    private JLabel numarTelefon = new JLabel();
    private TextField idTextField = new TextField();
    private TextField clientIDTextField = new TextField();
    private TextField productIDTextField = new TextField();
    private TextField cantitateTextField = new TextField();

    private JButton insertButton = new JButton();
    private JButton deleteButton = new JButton();
    ///private JButton updateButton = new JButton();
    private JButton vizualizareButton = new JButton();
    private JButton backButton = new JButton();
    private JButton exitButton=new JButton();

    public void gestionareLabel() {
        id.setBounds(40, 110, 200, 30);
        id.setText("Id comanda");
        id.setFont(new Font("Serif", Font.ITALIC, 16));

        clientID.setBounds(40, 150, 200, 30);
        clientID.setText("Id client");
        clientID.setFont(new Font("Serif", Font.ITALIC, 16));

        productID.setBounds(40, 190, 200, 30);
        productID.setText("Id produs");
        productID.setFont(new Font("Serif", Font.ITALIC, 16));

        cantitate.setBounds(40, 230, 200, 30);
        cantitate.setText("Cantitate dorita");
        cantitate.setFont(new Font("Serif", Font.ITALIC, 16));

        panel.add(id);
        panel.add(clientID);
        panel.add(productID);
        panel.add(cantitate);
    }
    public void gestionareTextField()
    {

        idTextField.setBounds(250, 110, 250, 30);
        panel.add(idTextField);

        clientIDTextField.setBounds(250, 150, 250, 30);
        panel.add(clientIDTextField);

        productIDTextField.setBounds(250,190,250,30);
        panel.add(productIDTextField);

        cantitateTextField.setBounds(250,230,250,30);
        panel.add(cantitateTextField);

    }
    public void gestionareButoane()
    {
        backButton.setBounds(50, 280, 200, 50);
        backButton.setText("INAPOI");
        backButton.setBackground(new Color(72, 99, 182));
        panel.add(backButton);

        vizualizareButton.setBounds(270, 280, 200, 50);
        vizualizareButton.setText("Vizualizare comenzi");
        vizualizareButton.setBackground(new Color(72, 99, 182));
        panel.add(vizualizareButton);

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
    public InterfataOrder() {
        this.setTitle("PAGINA PENTRU COMENZI");
        panel.setBackground(new Color(255, 255, 182));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        gestionareLabel();
        gestionareTextField();
        gestionareButoane();

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

    public String getCantitateTextField() {
        return cantitateTextField.getText().toString();
    }


    public void butonInapoiListener(ActionListener e) {
        backButton.addActionListener(e);
    }
    public void butonVizualizareListener(ActionListener e) {
        vizualizareButton.addActionListener(e);
    }
    public void butonInserareListener(ActionListener e) {
        insertButton.addActionListener(e);
    }
    public void butonStergereListener(ActionListener e) {
        deleteButton.addActionListener(e);
    }

    ///consideram ca nu facem modificari la comanda
   /// public void addUpdateListener(ActionListener e) {
       /// updateButton.addActionListener(e);
  ///  }
    public void butonExitListener(ActionListener e) {exitButton.addActionListener(e);}

}
