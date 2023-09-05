package Presentation;

import BusinessLogic.ProductBLL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProductController {
    private ProductBLL pBLL;
    private final ProductInterface productInterface;
    public ProductController(ProductInterface productInterface)
    {
        this.productInterface=productInterface;
        pBLL=new ProductBLL(productInterface);
        productInterface.insertButtonListener(new insertButton());
        productInterface.deleteButtonListener(new deleteButton());
        productInterface.backButtonListener(new backButton());
        productInterface.updateButtonListener(new updateButton());
        productInterface.viewButtonListener(new viewButton());
        productInterface.exitButtonListener(new exitButton());
    }
    public class insertButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.insertProduct();
        }
    }
    public class deleteButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.deleteProduct();
        }
    }
    public class backButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            MainInterface ip=new MainInterface();
            MainInterfaceController ipc=new MainInterfaceController(ip);
            ip.setVisible(true);
            productInterface.setVisible(false);
        }
    }
    public class updateButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.updateProduct();
        }
    }
    public class viewButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.productView();
        }
    }
    public class exitButton implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
