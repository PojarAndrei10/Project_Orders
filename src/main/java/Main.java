import Presentation.MainInterface;
import Presentation.MainInterfaceController;

public class Main {
    public static void main(String[] args)
    {
        MainInterface mainInterface=new MainInterface();
        MainInterfaceController mainInterfaceController;
        mainInterfaceController=new MainInterfaceController(mainInterface);
        mainInterface.setVisible(true);
    }
}