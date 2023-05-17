package Presentation;

import BusinessLogic.ClientBLL;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ClientController {
    private ClientBLL cBLL;
    private InterfataClient interfataClient;
    public ClientController(InterfataClient interfataClient)
    {
        cBLL=new ClientBLL(interfataClient);
        this.interfataClient=interfataClient;
        interfataClient.butonInserareListener(new butonInserare());
        interfataClient.butonStergereListener(new butonStergere());
        interfataClient.butonInapoiListener(new butonInapoi());
        interfataClient.butonUpdateListener(new butonUpdate());
        interfataClient.butonVizualizareListener(new butonVizualizare());
        interfataClient.butonExitListener(new butonExit());
    }
    public class butonInserare implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            cBLL.inserareClient();
        }
    }
    public class butonStergere implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            cBLL.stergereClient();
        }
    }
    public class butonInapoi implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
      InterfataPrincipala interfataPrincipala=new InterfataPrincipala();
      InterfataPrincipalaController interfataPrincipalaController;
      interfataPrincipalaController=new InterfataPrincipalaController(interfataPrincipala);
      interfataPrincipala.setVisible(true);
      interfataClient.setVisible(false);
        }
    }
    public class butonUpdate implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            cBLL.updateClient();
        }
    }
    public class butonVizualizare implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            cBLL.vizualizareClienti();
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
