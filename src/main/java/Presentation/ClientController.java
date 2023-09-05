package Presentation;

import BusinessLogic.ClientBLL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ClientController {
    private ClientBLL cBLL;
    private ClientInterface clientInterface;
    public ClientController(ClientInterface clientInterface)
    {
        cBLL=new ClientBLL(clientInterface);
        this.clientInterface=clientInterface;
        clientInterface.insertButtonListener(new insertButton());
        clientInterface.deleteButtonListener(new deleteButton());
        clientInterface.backButtonListener(new backButton());
        clientInterface.updateButtonListener(new updateButton());
        clientInterface.viewButtonListener(new viewButton());
        clientInterface.exitButtonListener(new exitButton());
    }
    public class insertButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            cBLL.insertClient();
        }
    }
    public class deleteButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            cBLL.deleteClient();
        }
    }
    public class backButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
      MainInterface mainInterface=new MainInterface();
      MainInterfaceController mainInterfaceController;
            mainInterfaceController=new MainInterfaceController(mainInterface);
            mainInterface.setVisible(true);
      clientInterface.setVisible(false);
        }
    }
    public class updateButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            cBLL.updateClient();
        }
    }
    public class viewButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            cBLL.clientView();
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
