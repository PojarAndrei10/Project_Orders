package BusinessLogic;

import DataAccess.AbstractDAO;
import Model.Products;
import Presentation.ProductInterface;
import Validator.ProductValidator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProductBLL {
    private ProductInterface productInterface;
    private ProductValidator productValidator;
    private AbstractDAO<Products> aDAO;

    /**
     *
     * @param productInterface
     */
    public ProductBLL(ProductInterface productInterface) {
        this.productInterface=productInterface;
        productValidator=new ProductValidator();
        aDAO=new AbstractDAO<>(Products.class);
    }
    /**
     * Inserarea unui nou produs daca sunt valide datele introduse sau atentionarea printr-un mesaj ca datele
     *   sunt invalide si inserarea nu poate avea loc
     */
    public void insertProduct()
    {
        int id = productInterface.getIdTextField();
        String lastName = productInterface.getNameTextField();
        float price = Float.parseFloat(productInterface.getPriceTextField());
        int stock = Integer.parseInt(productInterface.getStockTextField());
        Products products=new Products(id,lastName,price,stock);
        if(productValidator.productValidation(products).equals("Corect"))
            aDAO.insert(products);
        else JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                "inserarea produsului nu s-a facut !");
    }
    /**
     * Stergerea unui produs
     */
    public void deleteProduct()
    {
        int a;
        a=productInterface.getIdTextField();
        int cop=a;
        aDAO.delete(a);
    }
    /**
     * Update-ul unui nou produs daca sunt valide datele modificate sau atentionarea printr-un mesaj ca datele modificate
     *      sunt invalide si update-ul nu poate avea loc
     */
    public void updateProduct()
    {
        int id = productInterface.getIdTextField();
        String lastName = productInterface.getNameTextField();
        float price = Float.parseFloat(productInterface.getPriceTextField());
        int stock = Integer.parseInt(productInterface.getStockTextField());
        Products products=new Products(id,lastName,price,stock);
        if(productValidator.productValidation(products).equals("Corect"))
            aDAO.update(products);
        else JOptionPane.showMessageDialog(null,"Nu ati introdus date corecte," +
                "update-ul comenzii nu s-a facut ");
    }
    /**
     * Vizualizarea tuturor produselor in tabelul din interfata
     */
    public void productView()
    {
        JScrollPane viewProductInInterface;
        viewProductInInterface=new JScrollPane();
        JTable table=new JTable();
        ArrayList<Products> produse;
        produse=aDAO.findAll();
        System.out.println(produse);
        System.out.println(" ");
        viewProductInInterface.setBounds(800,50,300,300);
        viewProductInInterface.setBackground(new Color(210,191,191));
        viewProductInInterface.setToolTipText("Tabel produse");
        table=aDAO.createTable(produse);
        table.setEnabled(true);
        table.setVisible(true);
        viewProductInInterface.setViewportView(table);
        productInterface.getContentPane().add(viewProductInInterface);
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
