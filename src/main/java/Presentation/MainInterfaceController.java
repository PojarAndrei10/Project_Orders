package Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterfaceController {
    private MainInterface mainInterface;
    public MainInterfaceController(MainInterface mainInterface)
    {
        this.mainInterface=mainInterface;
        mainInterface.clientsPageListener(new clientPage());
        mainInterface.ordersPageListener(new orderPage());
        mainInterface.productsPageListener(new productPage());
    }
    public class clientPage implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientInterface ic=new ClientInterface();
            ClientController ipc;
            ipc=new ClientController(ic);
            ic.setVisible(true);
        }
    }
    public class orderPage implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            OrderInterface io=new OrderInterface();
            OrderController oc;
            oc=new OrderController(io);
            io.setVisible(true);
        }
    }
    public class productPage implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            ProductInterface ip=new ProductInterface();
            ProductController pc;
            pc=new ProductController(ip);
            ip.setVisible(true);
        }
    }
}
