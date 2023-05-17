package Presentation;

import Presentation.ClientController;
import Presentation.InterfataClient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfataPrincipalaController {
    private InterfataPrincipala interfataPrincipala;
    public InterfataPrincipalaController(InterfataPrincipala interfataPrincipala)
    {
        this.interfataPrincipala=interfataPrincipala;
        interfataPrincipala.paginaClientListener(new clientPage());
        interfataPrincipala.paginaOrderListener(new orderPage());
        interfataPrincipala.paginaProductListener(new productPage());
    }
    public class clientPage implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfataClient ic=new InterfataClient();
            ClientController ipc;
            ipc=new ClientController(ic);
            ic.setVisible(true);
        }
    }
    public class orderPage implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfataOrder io=new InterfataOrder();
            OrderController oc;
            oc=new OrderController(io);
            io.setVisible(true);
        }
    }
    public class productPage implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfataProduct ip=new InterfataProduct();
            ProductController pc;
            pc=new ProductController(ip);
            ip.setVisible(true);
        }
    }
}
