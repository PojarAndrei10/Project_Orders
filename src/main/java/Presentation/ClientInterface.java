package Presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ClientInterface extends JFrame {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel id = new JLabel();
    private JLabel lastName = new JLabel();
    private JLabel firstName = new JLabel();
    private JLabel phoneNumber = new JLabel();
    private TextField idTextField = new TextField();
    private TextField lastNameTextField = new TextField();
    private TextField firstNameTextField = new TextField();
    private TextField phoneTextField = new TextField();
    private JButton insertButton = new JButton();
    private JButton deleteButton = new JButton();
    private JButton updateButton = new JButton();
    private JButton viewButton = new JButton();
    private JButton backButton = new JButton();
    private JButton exitButton=new JButton();

    public void labelManagement() {
        id.setBounds(40, 110, 200, 30);
        id.setText("Id-ul clientului:");
        id.setFont(new Font("Serif", Font.ITALIC, 16));

        lastName.setBounds(40, 150, 200, 30);
        lastName.setText("Nume client");
        lastName.setFont(new Font("Serif", Font.ITALIC, 16));

        firstName.setBounds(40, 190, 200, 30);
        firstName.setText("Prenume client");
        firstName.setFont(new Font("Serif", Font.ITALIC, 16));

        phoneNumber.setBounds(40, 230, 200, 30);
        phoneNumber.setText("Numar telefon");
        phoneNumber.setFont(new Font("Serif", Font.ITALIC, 16));

        panel.add(id);
        panel.add(lastName);
        panel.add(firstName);
        panel.add(phoneNumber);
    }
    public void textFieldManagement()
    {

            idTextField.setBounds(250, 110, 250, 30);
        panel.add(idTextField);

            lastNameTextField.setBounds(250, 150, 250, 30);
        panel.add(lastNameTextField);

            firstNameTextField.setBounds(250,190,250,30);
        panel.add(firstNameTextField);

            phoneTextField.setBounds(250,230,250,30);
        panel.add(phoneTextField);

        }
        public void buttonManagement()
        {
            backButton.setBounds(50, 280, 200, 50);
            backButton.setText("INAPOI");
            backButton.setBackground(new Color(72, 99, 182));
            panel.add(backButton);

            viewButton.setBounds(270, 280, 200, 50);
            viewButton.setText("Vizualizare clienti");
            viewButton.setBackground(new Color(72, 99, 182));

            panel.add(viewButton);

            insertButton.setBounds(490, 280, 220, 50);
            insertButton.setText("Inserare client");
            insertButton.setBackground(new Color(72, 99, 182));
            panel.add(insertButton);

            deleteButton.setBounds(490, 350, 220, 50);
            deleteButton.setText("Stergere client");
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
        public ClientInterface() {
        this.setTitle("PAGINA PENTRU CLIENTI");
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
    public String getLastNameTextField() {
        return lastNameTextField.getText().toString();
    }
    public String getFirstNameTextField() {
        return firstNameTextField.getText().toString();
    }
    public String getPhoneTextField() {
        return phoneTextField.getText().toString();
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
    public void updateButtonListener(ActionListener e) {
        updateButton.addActionListener(e);
    }
    public void exitButtonListener(ActionListener e) {exitButton.addActionListener(e);}
}

