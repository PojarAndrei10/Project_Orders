package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductInterface extends JFrame {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel id = new JLabel();
    private JLabel name= new JLabel();
    private JLabel price = new JLabel();
    private JLabel stock = new JLabel();
    private TextField idTextField = new TextField();
    private TextField nameTextField = new TextField();
    private TextField priceTextField = new TextField();
    private TextField stockTextField = new TextField();

    private JButton insertButton = new JButton();
    private JButton deleteButton = new JButton();
    private JButton updateButton = new JButton();
    private JButton viewButton = new JButton();
    private JButton backButton = new JButton();
    private JButton exitButton=new JButton();

    public void labelManagement() {
        id.setBounds(40, 110, 200, 30);
        id.setText("Id");
        id.setFont(new Font("Serif", Font.ITALIC, 16));

        name.setBounds(40, 150, 200, 30);
        name.setText("Nume produs");
        name.setFont(new Font("Serif", Font.ITALIC, 16));

        price.setBounds(40, 190, 200, 30);
        price.setText("Pret produs");
        price.setFont(new Font("Serif", Font.ITALIC, 16));

        stock.setBounds(40, 230, 200, 30);
        stock.setText("Produse in stoc");
        stock.setFont(new Font("Serif", Font.ITALIC, 16));

        panel.add(id);
        panel.add(name);
        panel.add(price);
        panel.add(stock);
    }
    public void textFieldManagement()
    {
        idTextField.setBounds(250, 110, 250, 30);
        panel.add(idTextField);

        nameTextField.setBounds(250, 150, 250, 30);
        panel.add(nameTextField);

        priceTextField.setBounds(250,190,250,30);
        panel.add(priceTextField);

        stockTextField.setBounds(250,230,250,30);
        panel.add(stockTextField);

    }
    public void buttonManagement()
    {
        backButton.setBounds(50, 280, 200, 50);
        backButton.setText("INAPOI");
        backButton.setBackground(new Color(72, 99, 182));
        panel.add(backButton);

        viewButton.setBounds(270, 280, 200, 50);
        viewButton.setText("Vizualizare produse");
        viewButton.setBackground(new Color(72, 99, 182));
        panel.add(viewButton);

        insertButton.setBounds(490, 280, 220, 50);
        insertButton.setText("Inserare produs");
        insertButton.setBackground(new Color(72, 99, 182));
        panel.add(insertButton);

        deleteButton.setBounds(490, 350, 220, 50);
        deleteButton.setText("Stergere produs");
        deleteButton.setBackground(new Color(72, 99, 182));
        panel.add(deleteButton);

        updateButton.setBounds(270, 350 , 200, 50);
        updateButton.setText("Update");
        updateButton.setBackground(new Color(72, 99, 182));
        panel.add(updateButton);

        exitButton.setBounds(1000,700,150,50);
        exitButton.setText("EXIT");
        exitButton.setBackground(new Color(72, 99, 182));
        panel.add(exitButton);
    }
    public ProductInterface() {
        this.setTitle("PAGINA PENTRU PRODUSE");
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
    public String getNameTextField() {
        return nameTextField.getText().toString();
    }
    public String getPriceTextField() {
        return priceTextField.getText().toString();
    }
    public String getStockTextField() {
        return stockTextField.getText().toString();
    }
    public void exitButtonListener(ActionListener e) {exitButton.addActionListener(e);}

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
    public void updateButtonListener(ActionListener e) {
        updateButton.addActionListener(e);
    }
}
