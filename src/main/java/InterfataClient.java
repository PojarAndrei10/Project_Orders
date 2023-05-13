import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InterfataClient extends JFrame {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel id = new JLabel();
    private JLabel nume = new JLabel();
    private JLabel prenume = new JLabel();
    private JLabel numarTelefon = new JLabel();
    private TextField idTextField = new TextField();
    private TextField numeTextField = new TextField();
    private TextField prenumeTextField = new TextField();
    private TextField telefonTextField = new TextField();
    private JButton insertButton = new JButton();
    private JButton deleteButton = new JButton();
    private JButton updateButton = new JButton();
    private JButton vizualizareButton = new JButton();
    private JButton backButton = new JButton();

    public void gestionareLabel() {
        id.setBounds(40, 110, 200, 30);
        id.setText("Id-ul clientului:");
        id.setFont(new Font("Serif", Font.ITALIC, 16));

        nume.setBounds(40, 150, 200, 30);
        nume.setText("Nume client");
        nume.setFont(new Font("Serif", Font.ITALIC, 16));

        prenume.setBounds(40, 190, 200, 30);
        prenume.setText("Prenume client");
        prenume.setFont(new Font("Serif", Font.ITALIC, 16));

        numarTelefon.setBounds(40, 230, 200, 30);
        numarTelefon.setText("Numar telefon");
        numarTelefon.setFont(new Font("Serif", Font.ITALIC, 16));

        panel.add(id);
        panel.add(nume);
        panel.add(prenume);
        panel.add(numarTelefon);
    }
    public void gestionareTextField()
    {

            idTextField.setBounds(140, 110, 250, 30);
        panel.add(idTextField);

            numeTextField.setBounds(140, 150, 250, 30);
        panel.add(numeTextField);

            prenumeTextField.setBounds(140,190,250,30);
        panel.add(prenumeTextField);

            telefonTextField.setBounds(140,230,250,30);
        panel.add(telefonTextField);

        }
        public void gestionareButoane()
        {
            backButton.setBounds(50, 280, 200, 50);
            backButton.setText("INAPOI");
            backButton.setBackground(new Color(72, 99, 182));
            panel.add(backButton);

            vizualizareButton.setBounds(270, 280, 200, 50);
            vizualizareButton.setText("Vizualizare");
            vizualizareButton.setBackground(new Color(72, 99, 182));
            panel.add(vizualizareButton);

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
        }
        public InterfataClient() {
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
    public String getNumeTextField() {
        return numeTextField.getText().toString();
    }
    public String getPrenumeTextField() {
        return prenumeTextField.getText().toString();
    }
    public String getTelefonTextField() {
        return telefonTextField.getText().toString();
    }

    public void addBackListener(ActionListener e) {
        backButton.addActionListener(e);
    }
    public void addShowAllListener(ActionListener e) {
        vizualizareButton.addActionListener(e);
    }
    public void addInsertListener(ActionListener e) {
        insertButton.addActionListener(e);
    }
    public void addDeleteListener(ActionListener e) {
        deleteButton.addActionListener(e);
    }
    public void addUpdateListener(ActionListener e) {
        updateButton.addActionListener(e);
    }
}

