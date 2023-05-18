package BusinessLogic;

import DataAccess.AbstractDAO;
import Model.Products;
import Presentation.InterfataProduct;
import Validator.ProductValidator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductBLL {
    private InterfataProduct interfataProduct;
    private ProductValidator productValidator;
    private AbstractDAO<Products> aDAO;

    /**
     *
     * @param interfataProduct
     */
    public ProductBLL(InterfataProduct interfataProduct) {
        this.interfataProduct=interfataProduct;
        productValidator=new ProductValidator();
        aDAO=new AbstractDAO<>(Products.class);
    }

    /**
     * Inserarea unui nou produs daca sunt valide datele introduse sau atentionarea printr-un mesaj ca datele
     *   sunt invalide si inserarea nu poate avea loc
     */
    public void inserareProdus()
    {
        int id = interfataProduct.getIdTextField();
        String nume = interfataProduct.getNumeTextField();
        float pret = Float.parseFloat(interfataProduct.getPretTextField());
        int stoc = Integer.parseInt(interfataProduct.getStocTextField());
        Products produse=new Products(id,nume,pret,stoc);
        if(productValidator.validareProduse(produse).equals("Corect"))
            aDAO.inserare(produse);
        else JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                "inserarea produsului nu s-a facut !");
    }

    /**
     * Stergerea unui produs
     */
    public void stergereProdus()
    {
        int a;
        a=interfataProduct.getIdTextField();
        int cop=a;
        aDAO.stergere(a);
    }

    /**
     * Update-ul unui nou produs daca sunt valide datele modificate sau atentionarea printr-un mesaj ca datele modificate
     *      sunt invalide si update-ul nu poate avea loc
     */
    public void updateProdus()
    {
        int id = interfataProduct.getIdTextField();
        String nume = interfataProduct.getNumeTextField();
        float pret = Float.parseFloat(interfataProduct.getPretTextField());
        int stoc = Integer.parseInt(interfataProduct.getStocTextField());
        Products product=new Products(id,nume,pret,stoc);
        if(productValidator.validareProduse(product).equals("Corect"))
            aDAO.update(product);
        else JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                "update-ul comenzii nu s-a facut ");
    }

    /**
     * Vizualizarea tuturor produselor in tabelul din interfata
     */
    public void vizualizareProduse()
    {
        JScrollPane vizualizareProduseInterfata;
        vizualizareProduseInterfata=new JScrollPane();
        JTable table=new JTable();
        ArrayList<Products> produse;
        produse=aDAO.findAll();
        System.out.println(produse);
        System.out.println(" ");
        vizualizareProduseInterfata.setBounds(800,50,300,300);
        vizualizareProduseInterfata.setBackground(new Color(210,191,191));
        vizualizareProduseInterfata.setToolTipText("Tabel produse");
        table=aDAO.createTable(produse);
        table.setEnabled(true);
        table.setVisible(true);
        vizualizareProduseInterfata.setViewportView(table);
        interfataProduct.getContentPane().add(vizualizareProduseInterfata);
    }

    /**
     *
     * @param id
     * @return produsul cu id-ul id
     */
    public Products findProductById(int id) {
        Products p;
        p = aDAO.findById(id);
        if (p == null)
        {
            throw new NoSuchElementException("The product with id =" + id
                    + " was not found!");
        }
        return p;
    }

}
