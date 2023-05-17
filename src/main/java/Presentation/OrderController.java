package Presentation;

import BusinessLogic.OrderBLL;
import Presentation.InterfataPrincipala;
import Presentation.InterfataPrincipalaController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderController {
    private OrderBLL oBLL;
    private final InterfataOrder interfataOrder;

    public OrderController(InterfataOrder interfataOrder) {
        oBLL = new OrderBLL(interfataOrder);
        this.interfataOrder = new InterfataOrder();
        interfataOrder.butonInserareListener(new butonInserare());
        interfataOrder.butonStergereListener(new butonStergere());
        interfataOrder.butonInapoiListener(new butonInapoi());
        interfataOrder.butonVizualizareListener(new butonVizualizare());
        interfataOrder.butonExitListener(new butonExit());
    }
    public class butonInserare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oBLL.inserareComanda();
        }
    }
    public class butonStergere implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oBLL.stergereComanda();
        }
    }
    public class butonInapoi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            InterfataPrincipala ip = new InterfataPrincipala();
            InterfataPrincipalaController ipc = new InterfataPrincipalaController(ip);
            ip.setVisible(true);
            interfataOrder.setVisible(false);
        }
    }
    public class butonVizualizare implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oBLL.vizualizareComenzi();
        }
    }
    public class butonExit implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}

