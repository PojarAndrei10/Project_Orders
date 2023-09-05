package Presentation;

import BusinessLogic.OrderBLL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderController {
    private OrderBLL oBLL;
    private final OrderInterface orderInterface;

    public OrderController(OrderInterface orderInterface) {
        oBLL = new OrderBLL(orderInterface);
        this.orderInterface = new OrderInterface();
        orderInterface.insertButtonListener(new insertButton());
        orderInterface.deleteButtonListener(new deleteButton());
        orderInterface.backButtonListener(new backButton());
        orderInterface.viewButtonListener(new viewButton());
        orderInterface.exitButtonListener(new exitButton());
    }
    public class insertButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oBLL.insertOrder();
        }
    }
    public class deleteButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oBLL.deleteOrder();
        }
    }
    public class backButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            MainInterface ip = new MainInterface();
            MainInterfaceController ipc = new MainInterfaceController(ip);
            ip.setVisible(true);
            orderInterface.setVisible(false);
        }
    }
    public class viewButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oBLL.orderView();
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

