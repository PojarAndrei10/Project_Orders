import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InterfataProduct extends JFrame {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel id = new JLabel();
    private JLabel nume= new JLabel();
    private JLabel pret = new JLabel();
    private JLabel stoc = new JLabel();
    private TextField idTextField = new TextField();
    private TextField numeTextField = new TextField();
    private TextField pretTextField = new TextField();
    private TextField stocTextField = new TextField();

    private JButton insertButton = new JButton();
    private JButton deleteButton = new JButton();
    private JButton updateButton = new JButton();
    private JButton vizualizareButton = new JButton();
    private JButton backButton = new JButton();
    private JButton exitButton=new JButton();

    public void gestionareLabel() {
        id.setBounds(40, 110, 200, 30);
        id.setText("Id");
        id.setFont(new Font("Serif", Font.ITALIC, 16));

        nume.setBounds(40, 150, 200, 30);
        nume.setText("Nume produs");
        nume.setFont(new Font("Serif", Font.ITALIC, 16));

        pret.setBounds(40, 190, 200, 30);
        pret.setText("Pret produs");
        pret.setFont(new Font("Serif", Font.ITALIC, 16));

        stoc.setBounds(40, 230, 200, 30);
        stoc.setText("Produse in stoc");
        stoc.setFont(new Font("Serif", Font.ITALIC, 16));

        panel.add(id);
        panel.add(nume);
        panel.add(pret);
        panel.add(stoc);
    }
    public void gestionareTextField()
    {
        idTextField.setBounds(250, 110, 250, 30);
        panel.add(idTextField);

        numeTextField.setBounds(250, 150, 250, 30);
        panel.add(numeTextField);

        pretTextField.setBounds(250,190,250,30);
        panel.add(pretTextField);

        stocTextField.setBounds(250,230,250,30);
        panel.add(stocTextField);

    }
    public void gestionareButoane()
    {
        backButton.setBounds(50, 280, 200, 50);
        backButton.setText("INAPOI");
        backButton.setBackground(new Color(72, 99, 182));
        panel.add(backButton);

        vizualizareButton.setBounds(270, 280, 200, 50);
        vizualizareButton.setText("Vizualizare produse");
        vizualizareButton.setBackground(new Color(72, 99, 182));
        panel.add(vizualizareButton);

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
    public InterfataProduct() {
        this.setTitle("PAGINA PENTRU PRODUSE");
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
    public String getPretTextField() {
        return pretTextField.getText().toString();
    }
    public String getStocTextField() {
        return stocTextField.getText().toString();
    }
    public void butonExitListener(ActionListener e) {exitButton.addActionListener(e);}

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
    public void butonUpdateListener(ActionListener e) {
        updateButton.addActionListener(e);
    }
}
