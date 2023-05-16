import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProductController {
    private ProductBLL pBLL;
    private final InterfataProduct interfataProduct;
    public ProductController(InterfataProduct interfataProduct)
    {
        this.interfataProduct=interfataProduct;
        pBLL=new ProductBLL(interfataProduct);
        interfataProduct.butonInserareListener(new butonInsert());
        interfataProduct.butonStergereListener(new butonStergere());
        interfataProduct.butonInapoiListener(new butonInapoi());
        interfataProduct.butonUpdateListener(new butonUpdate());
        interfataProduct.butonVizualizareListener(new butonVizualizare());
        interfataProduct.butonExitListener(new butonExit());
    }
    public class butonInsert implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.inserareProdus();
        }
    }
    public class butonStergere implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.stergereProdus();
        }
    }
    public class butonInapoi implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            InterfataPrincipala ip=new InterfataPrincipala();
            InterfataPrincipalaController ipc=new InterfataPrincipalaController(ip);
            ip.setVisible(true);
            interfataProduct.setVisible(false);
        }
    }
    public class butonUpdate implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.updateProdus();
        }
    }
    public class butonVizualizare implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            pBLL.vizualizareProduse();
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
